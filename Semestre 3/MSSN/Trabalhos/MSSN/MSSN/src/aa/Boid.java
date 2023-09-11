package aa;

import java.util.ArrayList;
import java.util.List;

import physicsArnaldo.Body;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;
import utils.SubPlot;

public class Boid extends Body{

	private SubPlot plt;
	private double[] window;
	
	private PShape shape;
	public DNA dna;
	protected Eye eye;
	private List<Behavior> behaviors;
	protected float phiWander;
	private float sumWeights;
	
	protected Boid(PVector pos, float mass, float radius, int color, PApplet p, SubPlot plt) {
		super(pos, new PVector(), mass, radius, color);
		
		dna = new DNA();
		behaviors = new ArrayList<Behavior>();
		
		this.plt = plt;
		window = plt.getWindow();
		
		setShape(p, plt);
	}

	public void setEye(Eye eye)
	{
		this.eye = eye;
	}
	
	public Eye getEye()
	{
		return eye;
	}
	
	public void setShape(PApplet p, SubPlot plt, float radius, int color)
	{
		this.radius = radius;
		this.color = color;
		
		setShape(p, plt);
	}
	
	public void setShape(PApplet p, SubPlot plt)
	{
		float rr[] = plt.getDimInPixel(radius, radius);
		shape = p.createShape();
		
		shape.beginShape();
		shape.noStroke();
		shape.fill(color);
		shape.vertex(-rr[0], rr[0]/2);
		shape.vertex(rr[0], 0);
		shape.vertex(-rr[0], -rr[0]/2);
		shape.vertex(-rr[0]/2, 0);
		shape.endShape(PConstants.CLOSE);
	}
	
	private void updateSumWeights()
	{
		sumWeights = 0;
		
		for(Behavior behavior : behaviors)
		{
			sumWeights += behavior.getWeight();
		}
	}
	
	public void addBehavior(Behavior behavior)
	{
		behaviors.add(behavior);
		updateSumWeights();
	}
	
	public void removeBehavior(Behavior behavior)
	{
		if(behaviors.contains(behavior))
		{
			behaviors.remove(behavior);
		}
		
		updateSumWeights();
	}
	
	public void applyBehavior(int i, float dt)
	{
		if(eye != null)
		{
			eye.look();			
		}
		
		Behavior behavior = behaviors.get(i);
		PVector vd = behavior.getDesiredVelocity(this);
		move(dt, vd);
	}
	
	public void applyBehaviors(float dt)
	{
		if(eye != null)
		{
			eye.look();			
		}
		
		PVector vd = new PVector();
		
		for(Behavior behaviour : behaviors)
		{
			PVector vdd = behaviour.getDesiredVelocity(this);
			vdd.mult(behaviour.getWeight() / sumWeights);
			vd.add(vdd);
		}
		
		move(dt, vd);
	}
	
	private void move(float dt, PVector vd)
	{
		vd.normalize().mult(dna.maxSpeed);
		PVector fs = PVector.sub(vd, vel);
		applyForce(fs.limit(dna.maxForce));
		super.move(dt);
		
		if(pos.x < window[0])
		{
			pos.x += window[1] - window[0];
		}
		
		if(pos.y < window[2])
		{
			pos.y += window[3] - window[2];
		}
		
		if(pos.x >= window[1])
		{
			pos.x -= window[1] - window[0];
		}
		
		if(pos.y >= window[3])
		{
			pos.y -= window[3] - window[2];
		}
	}
	
	@Override
	public void display(PApplet p, SubPlot plt)
	{
		p.pushMatrix();
		float[] pp = plt.getPixelCoord(pos.x, pos.y);
		p.translate(pp[0], pp[1]);
		p.rotate(-vel.heading());
		p.shape(shape);
		p.popMatrix();
	}
	
	//Fabio Edit
	public void setColor(int color)
	{
		this.color = color;
	}
}
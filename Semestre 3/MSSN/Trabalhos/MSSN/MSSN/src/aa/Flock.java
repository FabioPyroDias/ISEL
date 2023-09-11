package aa;

import java.util.ArrayList;
import java.util.List;

import physicsArnaldo.Body;
import processing.core.PApplet;
import processing.core.PVector;
import utils.SubPlot;

public class Flock {
	private List<Boid> boids;
	
	public Flock(int nBoids, float mass, float radius, int color, float[]sacWeights, PApplet p, SubPlot plt)
	{
		double[] ww = plt.getWindow();
		boids = new ArrayList<Boid>();
		
		for(int i = 0; i < nBoids; i++)
		{		
			float x = p.random((float) ww[0], (float) ww[1]);
			float y = p.random((float) ww[2], (float) ww[3]);
			
			Boid b = new Boid(new PVector(x, y), mass, radius, color, p, plt);
			
			b.addBehavior(new Separate(sacWeights[0]));
			b.addBehavior(new Align(sacWeights[1]));
			b.addBehavior(new Cohesion(sacWeights[2]));
			
			boids.add(b);
		}
		
		List<Body> bodies = boidList2BodyList(boids);
		
		for(Boid b : boids)
		{
			b.setEye(new Eye(b, bodies));
		}
	}
	
	private List<Body> boidList2BodyList(List<Boid> boids)
	{
		List<Body> bodies = new ArrayList<Body>();
		
		for(Boid b : boids)
		{
			bodies.add(b);
		}
		
		return bodies;
	}
	
	public void applyBehavior(float dt)
	{
		for(Boid b : boids)
		{
			b.applyBehaviors(dt);
		}
	}
	
	public Boid getBoid(int index)
	{
		return boids.get(index);
	}
	
	public void display(PApplet p, SubPlot plt)
	{
		for(Boid b : boids)
		{
			b.display(p, plt);
		}
	}
}

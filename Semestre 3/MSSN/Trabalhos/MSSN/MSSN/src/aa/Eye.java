package aa;

import java.util.ArrayList;
import java.util.List;

import physicsArnaldo.Body;
import processing.core.PApplet;
import processing.core.PVector;
import utils.SubPlot;

public class Eye {
	private List<Body> allTrackingBodies;
	private List<Body> farSight;
	private List<Body> nearSight;	

	private Boid me;
	protected Body target;
	
	public Eye(Boid me, List<Body> allTrackingBodies)
	{
		this.me = me;
		this.allTrackingBodies = allTrackingBodies;
		target = allTrackingBodies.get(0);
	}
	
	public List<Body> getFarSight()
	{
		return farSight;
	}
	
	public List<Body> getNearSight()
	{
		return nearSight;
	}
	
	public void look()
	{
		farSight = new ArrayList<Body>();
		nearSight = new ArrayList<Body>();
		
		for(Body b : allTrackingBodies)
		{
			if(farSight(b.getPos()))
			{
				farSight.add(b);
			}
			
			if(nearSight(b.getPos()))
			{
				nearSight.add(b);
			}
		}
	}
	
	private boolean inSight(PVector t, float maxDistance, float maxAngle)
	{
		PVector r = PVector.sub(t, me.getPos());
		float d = r.mag();
		float angle = PVector.angleBetween(r,  me.getVel());
		
		return ((d > 0) && (d < maxDistance) && (angle < maxAngle));
	}
	
	private boolean farSight(PVector t)
	{
		return inSight(t, me.dna.visionDistance, me.dna.visionAngle);
	}
	
	private boolean nearSight(PVector t)
	{
		return inSight(t, me.dna.visionSafeDistance, (float) Math.PI);
	}
	
	public void display(PApplet p, SubPlot plt)
	{
		p.pushStyle();
		p.pushMatrix();
		
		float[] pp = plt.getPixelCoord(me.getPos().x, me.getPos().y);
		p.translate(pp[0], pp[1]);
		p.rotate(-me.getVel().heading());
		
		p.noFill();
		p.stroke(255, 0, 0);
		p.strokeWeight(3);
		
		float[] dd1 = plt.getDimInPixel(me.dna.visionDistance, me.dna.visionDistance);
		float[] dd2 = plt.getDimInPixel(me.dna.visionSafeDistance, me.dna.visionSafeDistance);
		p.rotate(me.dna.visionAngle);
		p.line(0, 0, dd1[0], 0);
		p.rotate(-2 * me.dna.visionAngle);
		p.line(0, 0, dd1[0], 0);
		p.rotate(me.dna.visionAngle);
		p.arc(0, 0, 2 * dd1[0], 2 * dd1[0], -me.dna.visionAngle, me.dna.visionAngle);
		p.stroke(255, 0, 255);
		p.circle(0, 0, 2 * dd2[1]);
		p.popMatrix();
		p.popStyle();
	}
}
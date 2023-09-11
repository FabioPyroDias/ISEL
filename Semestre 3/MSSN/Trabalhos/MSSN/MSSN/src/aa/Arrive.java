package aa;

import processing.core.PVector;

public class Arrive extends Behavior {

	public Arrive(float weight) {
		super(weight);
	}

	@Override
	public PVector getDesiredVelocity(Boid me) {
		PVector vd = PVector.sub(me.eye.target.getPos(), me.getPos());
		float dist = vd.mag();
		float R = me.dna.radiusArrive;
		
		if(dist < R)
		{
			vd.mult(dist/R);
		}
		
		return vd;
	}
}
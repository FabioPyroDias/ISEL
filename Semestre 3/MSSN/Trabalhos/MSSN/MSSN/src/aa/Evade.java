package aa;

import physicsArnaldo.Body;
import processing.core.PVector;

public class Evade extends Behavior{

	public Evade(float weight) {
		super(weight);
	}

	@Override
	public PVector getDesiredVelocity(Boid me) {
		Body bodyTarget = me.eye.target;
		PVector d = bodyTarget.getVel().copy().mult(me.dna.deltaPursuit);
		PVector target = PVector.add(bodyTarget.getPos(), d);
		PVector vd =  PVector.sub(target, me.getPos());
		return vd.mult(-1);
	}
}
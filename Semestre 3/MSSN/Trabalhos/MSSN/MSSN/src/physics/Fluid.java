package physics;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Fluid {

	private float density;
	
	protected Fluid(float density) {
		this.density = density;
	}
	
	public PVector drag(Body body) {
		float area = PApplet.pow(body.radius, 2.0f) * PApplet.PI;
		float mag = body.velocity.mag();
		return PVector.mult(body.velocity, -0.5f * density * area * mag);
	}
	
}

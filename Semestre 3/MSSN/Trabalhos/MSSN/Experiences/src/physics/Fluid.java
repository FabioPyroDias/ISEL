package physics;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Fluid {

	private float density;
	
	protected Fluid(float density)
	{
		this.density = density;
	}
	
	public PVector drag(Mover m)
	{
		float area = PApplet.pow(m.radius, 2.0f) * PApplet.PI;
		float mag = m.vel.mag();
		return PVector.mult(m.vel, -0.5f * density * area * mag);
	}
	
}

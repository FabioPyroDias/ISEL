package physics;

import processing.core.PVector;

public abstract class Mover {
	protected PVector pos;
	protected PVector vel;
	protected PVector acc;
	protected float mass;
	protected float radius;

	protected Mover(PVector pos, PVector vel, float mass, float radius)
	{
		this.pos = pos.copy();
		this.vel = vel;
		this.mass = mass;
		this.radius = radius;
		acc = new PVector();
	}
	
	public void applyForce(PVector force)
	{
		acc.add(PVector.div(force, mass));
	}
	
	public void move(float dt)
	{
		vel.add(acc.mult(dt));
		pos.add(PVector.mult(vel, dt));
		
		acc.mult(0);
	}
	
	public void setPos(PVector pos)
	{
		this.pos = pos;
	}
	
	public PVector getPos()
	{
		return pos;
	}
	
	public void setVel(PVector vel)
	{
		this.vel = vel;
	}
	
	public PVector getVel()
	{
		return vel;
	}
}
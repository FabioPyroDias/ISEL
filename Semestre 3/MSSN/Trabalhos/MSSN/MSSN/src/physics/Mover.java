package physics;

import processing.core.PVector;

public abstract class Mover {

	protected PVector position;
	protected PVector velocity;
	protected PVector accelaration;
	protected float mass;
	private static double G = 6.67e-11;
	
	protected Mover(PVector position, PVector velocity, float mass) {
		this.position = position.copy();
		this.velocity = velocity;
		this.mass = mass;
		this.accelaration = new PVector();
	}
	
	public void applyForce(PVector force) {
		accelaration.add(PVector.div(force, mass));
	}
	
	public PVector attraction(Mover m) {
		
		PVector r = PVector.sub(position, m.position);
		float dist  = r.mag();
		float strength = (float) (G * mass * m.mass / Math.pow(dist, 2));
		
		return r.normalize().mult(strength);
	}
	
	
	public void move(float dt) {
		velocity.add(accelaration.mult(dt));
		position.add(PVector.mult(velocity, dt));
		accelaration.mult(0);
	}
	
	public void setPosition(PVector position) {
		this.position = position;
	}
	
	public PVector getPosition() {
		return this.position;
	}
	
	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}
	
	public PVector getVelocity() {
		return this.velocity;
	}
	
	
	
}

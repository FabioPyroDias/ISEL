package physics;

import processing.core.PApplet;
import processing.core.PVector;

public class RigidBody {
	
	public enum ControlType {
		POSITION,
		VELOCITY,
		FORCE
	}

	private PVector pos;
	private PVector vel;
	private PVector acc;
	private float mass;
	
	public RigidBody(float mass) {
		
		pos = new PVector();
		vel = new PVector();
		acc = new PVector();
		this.mass = mass;		
		
	}
	
	public void SetPosition(PVector pos) {
		this.pos = pos;
	}
	
	public void SetVelocity(PVector vel) {
		this.vel = vel;
	}
	
	public void ApplyForce(PVector force) {
		this.acc = PVector.div(force, mass);
	}
	
	public void move(float dt, ControlType controlType) {
		
		switch (controlType) {
		case POSITION: 
			break;
		case VELOCITY:
			pos.add(PVector.mult(vel, dt));
			break;
		case FORCE:
			pos.add(PVector.mult(vel, dt));
			vel.add(PVector.mult(acc, dt));
			break;
		}

		
	}
	
	public void Display(PApplet p) {
		p.circle(pos.x, pos.y, 30);
	}
	
}

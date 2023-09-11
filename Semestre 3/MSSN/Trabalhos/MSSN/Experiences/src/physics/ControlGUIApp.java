package physics;

import physics.RigidBody.ControlType;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;

public class ControlGUIApp implements IProcessingApp{

	private RigidBody rb;
	private MotionControl mc;
	
	private float mass = 1f;
	
	private ControlType ct = ControlType.POSITION;
	
	@Override
	public void setup(PApplet parent) {
		rb = new RigidBody(mass);
		mc = new MotionControl(ct, rb);
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.background(255);
		parent.translate(parent.width/2, parent.height/2);
		
		rb.move(dt, ct);
		
		rb.display(parent);
		mc.display(parent);
	}

	@Override
	public void keyPressed(PApplet parent) {
		
		switch(parent.key)
		{
			case 'p':
				ct = ControlType.POSITION;
				break;
			case 'v':
				ct = ControlType.VELOCITY;
				break;
			case 'f':
				ct = ControlType.FORCE;
				break;
		}
		
		rb = new RigidBody(mass);
		mc = new MotionControl(ct, rb);
	}

	@Override
	public void mousePressed(PApplet parent) {
		float x = parent.mouseX - parent.width/2;
		float y = parent.mouseY - parent.height/2;
		
		mc.setVector(new PVector(x, y));
	}
	
}

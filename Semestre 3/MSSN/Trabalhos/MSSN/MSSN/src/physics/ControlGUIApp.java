package physics;

import physics.RigidBody.ControlType;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;

public class ControlGUIApp implements IProcessingApp {
	
	private RigidBody rb;
	private MotionControl mc;
	private float mass = 1;
	private ControlType ct = ControlType.POSITION;

	@Override
	public void setup(PApplet parent) {
		
		rb = new RigidBody(mass);
		mc = new MotionControl(ct, rb);
		
	}

	@Override
	public void draw(PApplet parent, float dt) {
		
		// Clear Canvas
		parent.background(255);
		
		// Translação
		parent.translate(parent.width / 2, parent.height / 2);
		
		rb.move(dt, ct);
		rb.Display(parent);
		mc.Display(parent);
		
	}

	@Override
	public void keyPressed(PApplet parent) {
		
		if(parent.key == 'p') {
			ct = ControlType.POSITION;
		}
		if(parent.key == 'v') {
			ct = ControlType.VELOCITY;
		}
		if(parent.key == 'f') {
			ct = ControlType.FORCE;
		}
		
		rb = new RigidBody(mass);
		mc = new MotionControl(ct, rb);
		
		System.out.println("Control Type Set: " + ct.toString());
		
	}

	@Override
	public void mousePressed(PApplet parent) {
			
		float x = parent.mouseX - parent.width / 2;
		float y = parent.mouseY - parent.height / 2;
		
		mc.SetVector(new PVector(x, y));
	}

}

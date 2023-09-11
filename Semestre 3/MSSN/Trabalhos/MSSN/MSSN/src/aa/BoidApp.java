package aa;

import java.util.ArrayList;
import java.util.List;

import physicsArnaldo.Body;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;
import utils.SubPlot;

public class BoidApp implements IProcessingApp {
	
	private double[] window = {-10, 10, -10, 10};
	private float[] viewport = {0, 0, 1, 1};
	private SubPlot plt;
	
	private Boid b;
	private Body target;
	private List<Body> allTrackingBodies;
	private int index = 2;
	
	@Override
	public void setup(PApplet parent) {
		plt = new SubPlot(window, viewport, parent.width, parent.height);
		
		b = new Boid(new PVector(0, 0), 1, 0.5f, parent.color(0), parent, plt);
		b.addBehavior(new Seek(1f));
		b.addBehavior(new Flee(1f));
		b.addBehavior(new Wander(1f));
		
		target = new Body(new PVector(), new PVector(), 1f, 0.2f, parent.color(255, 0, 0));
		allTrackingBodies = new ArrayList<Body>();
		allTrackingBodies.add(target);
		
		Eye eye = new Eye(b, allTrackingBodies);
		b.setEye(eye);
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.background(255);
		
		b.applyBehavior(index, dt);
		
		b.display(parent, plt);
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(PApplet parent) {
		double[] ww = plt.getWorldCoord(parent.mouseX, parent.mouseY);
		target.setPos(new PVector((float) ww[0], (float) ww[1]));
	}
}

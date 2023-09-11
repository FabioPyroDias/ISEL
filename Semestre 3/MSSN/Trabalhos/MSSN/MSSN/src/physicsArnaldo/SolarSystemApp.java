package physicsArnaldo;

import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;
import utils.SubPlot;

public class SolarSystemApp implements IProcessingApp{

	private float sunMass = 1.989e30f;
	private float earthMass = 5.97e24f;
	private float distEarthSun = 1.496e11f;
	private float earthSpeed = 3e4f;
	
	private float[] viewport = {0.2f, 0.2f, 0.6f, 0.6f};
	private double[] window = {-1.2 * distEarthSun, 1.2 * distEarthSun, -1.2 * distEarthSun, 1.2 * distEarthSun};
	
	private SubPlot plt;
	private Body sun, earth;
	
	private float speedUp = 60 * 60 * 24 * 30;
	
	@Override
	public void setup(PApplet parent) {
		plt = new SubPlot(window, viewport, parent.width, parent.height);
		sun = new Body(new PVector(), new PVector(), sunMass, distEarthSun/10, parent.color(255, 128, 0));
		earth = new Body(new PVector(0, distEarthSun), new PVector(earthSpeed, 0), earthMass, distEarthSun/20, parent.color(0, 180, 120));	
	}

	@Override
	public void draw(PApplet parent, float dt) {
		float[] pp = plt.getBoundingBox();
		
		parent.fill(255, 16);
		parent.rect(pp[0], pp[1], pp[2], pp[3]);
		
		sun.display(parent, plt);
		
		PVector f = sun.attraction(earth);
		
		earth.applyForce(f);
		earth.move(dt * speedUp);
		
		earth.display(parent, plt);
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

}

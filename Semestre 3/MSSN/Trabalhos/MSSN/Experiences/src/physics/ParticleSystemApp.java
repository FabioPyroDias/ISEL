package physics;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;
import utils.SubPlot;

public class ParticleSystemApp implements IProcessingApp{

	private List<ParticleSystem> pss;
	
	private double[] window = {-10, 10, -10, 10};
	private float[] viewport = {0, 0, 1, 1};
	private SubPlot plt;
	
	@Override
	public void setup(PApplet parent) {
		plt = new SubPlot(window, viewport, parent.width, parent.height);
	
		pss = new ArrayList<ParticleSystem>();
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.background(255);
		
		for(ParticleSystem ps : pss)
		{
			ps.applyForce(new PVector(0, -1));
		}
		
		for(ParticleSystem ps : pss)
		{
			ps.move(dt);
			ps.display(parent, plt);
		}
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(PApplet parent) {
		
		double[] ww = plt.getWorldCoord(parent.mouseX, parent.mouseY);
		
		int cor = parent.color(parent.random(255), parent.random(255), parent.random(255));
		float vx = parent.random(4, 10);
		float vy = parent.random(4, 10);
		float lifespan = parent.random(1, 3);
		
		ParticleSystem ps = new ParticleSystem(new PVector((float)ww[0], (float)ww[1]), new PVector(), 1f, 0.2f, cor, lifespan, new PVector(vx, vy));
		pss.add(ps);
	}

}

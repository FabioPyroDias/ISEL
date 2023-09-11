package particleSystem;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;
import tools.SubPlot;

public class ParticleSystemApp implements IProcessingApp {

	private List<ParticleSystem> l_particleSystem;
	private double[] window = {-10, 10, -10, 10};
	private float[] viewport = {0, 0, 1, 1};
	private SubPlot splt;

	
	@Override
	public void setup(PApplet parent) {
		splt = new SubPlot(window, viewport, parent.width, parent.height);
		//particleSystem = new ParticleSystem(new PVector(), new PVector(), 1f, .2f, parent.color(255,0,0), 1f, new PVector(-15, 5));
		
		l_particleSystem = new ArrayList<ParticleSystem>();
		
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.background(255);
		
		for (ParticleSystem ps : l_particleSystem) {
			ps.applyForce(new PVector(0, -1));
		}
		
		for (ParticleSystem ps : l_particleSystem) {
			ps.move(dt);
			ps.display(parent, splt);
		}
		//particleSystem.move(dt);
		//particleSystem.display(parent, splt);
		
	}

	@Override
	public void keyPressed(PApplet parent) {
		

	}

	@Override
	public void mousePressed(PApplet parent) {
		double[] ww = splt.getWorldCoord(parent.mouseX, parent.mouseY);
		
		int color = parent.color(parent.random(255), parent.random(255), parent.random(255));
		float vx = parent.random(4, 10);
		float vy = parent.random(0, 4);
		float lifeSpan = parent.random(1, 3);
		
		ParticleSystem particleSystem = new ParticleSystem(new PVector((float)ww[0], (float)ww[1]), new PVector(), 1f, .2f, color, lifeSpan, new PVector(vx, vy));
		l_particleSystem.add(particleSystem);
		
	}

}

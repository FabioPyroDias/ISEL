package physicsArnaldo;

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
	
	private float[] velParams = {PApplet.radians(90), PApplet.radians(20), 1, 3};
	private float[] lifetimeParams = {3, 5};
	private float[] radiusParams = {0.1f, 0.2f};
	private float flow = 50;
	
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
			ps.applyForce(new PVector(0, 0));
		}
		
		for(ParticleSystem ps : pss)
		{
			ps.move(dt);
			ps.display(parent, plt);
		}
		
		velParams[0] = PApplet.map(parent.mouseX, 0, parent.width, PApplet.radians(0), PApplet.radians(360));
		for (ParticleSystem ps : pss)
		{
			PSControl psc = ps.getPSControl();
			psc.setVelParams(velParams);
		}
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(PApplet parent) {
		
		double[] ww = plt.getWorldCoord(parent.mouseX, parent.mouseY);
		
		int color = parent.color(parent.random(255), parent.random(255), parent.random(255));
		
		PSControl psc = new PSControl(velParams, lifetimeParams, radiusParams, flow, color);
		ParticleSystem ps = new ParticleSystem(new PVector((float)ww[0], (float)ww[1]), new PVector(), 1f, 0.2f, psc);
		pss.add(ps);
	}

}

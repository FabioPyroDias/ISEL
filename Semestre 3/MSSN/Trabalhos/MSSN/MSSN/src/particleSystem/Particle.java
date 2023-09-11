package particleSystem;

import physics.Body;
import processing.core.PApplet;
import processing.core.PVector;
import tools.SubPlot;

public class Particle extends Body {

	private float lifeSpan;
	private float timer;
	
	protected Particle(PVector pos, PVector vel, float radius, int color, float lifespan) {
		super(pos, vel, 0f, radius, color);
		this.lifeSpan = lifespan;
		timer = 0;
	}
	
	@Override
	public void move(float dt) {
		super.move(dt);
		timer += dt;
	}
	
	public boolean isDead() {
		return timer > lifeSpan;
	}
	
	@Override
	public void display(PApplet p, SubPlot plt) {
		p.pushStyle();
		
		float alpha = PApplet.map(timer, 0, lifeSpan, 255, 0);
		p.fill(color, alpha);
		
		float[] pp = plt.getPixelCoord(position.x, position.y);
		float[] r = plt.getDimInPixel(radius, radius);
		
		p.noStroke();
		p.circle(pp[0], pp[1], 2*r[0]);
		
		p.popStyle();
	}
	
}

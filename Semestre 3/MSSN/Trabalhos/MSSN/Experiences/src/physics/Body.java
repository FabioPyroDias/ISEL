package physics;

import processing.core.PApplet;
import processing.core.PVector;
import utils.SubPlot;

public class Body extends Mover {

	protected int color;
	protected float radius;
	
	public Body(PVector pos, PVector vel, float mass, float radius, int color) {
		super(pos, vel, mass, 0);
		this.color = color;
		this.radius = radius;
	}
	
	public Body(PVector pos) {
		super(pos, new PVector(), 0f, 0f);
	}
	
	public void display(PApplet p, SubPlot plt) {
		p.pushStyle();
		
		float[] px = plt.getPixelCoord(pos.x, pos.y); //pixéis
		float[] r = plt.getDimInPixel(radius, radius);
		
		p.noStroke();
		p.fill(color);
		p.ellipse(px[0], px[1], 2*r[0], 2*r[0]);
		
		p.popStyle();
	}

	public int getColor() {
		return color;
	}
}
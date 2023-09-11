package physics;

import processing.core.PApplet;
import tools.SubPlot;

public class Water extends Fluid {

	private float waterHeight;
	private int color;
	
	
	public Water(float waterHeight, int color) {
		super(1000.0f);
		this.waterHeight = waterHeight;
		this.color = color;
	}
	
	public boolean isInside(Mover m) {
		return (m.getPosition().y <= waterHeight);
	}
	
	public void display(PApplet p, SubPlot splt) {
		p.pushStyle();
		p.noStroke();
		p.fill(color);
		float[] pp = splt.getBox(0, 0,  splt.getWindow()[1], waterHeight);
		p.rect(pp[0], pp[1], pp[2], pp[3]);
		p.popStyle();
	}
	
}

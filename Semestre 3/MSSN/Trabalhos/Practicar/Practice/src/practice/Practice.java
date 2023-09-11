package practice;

import processing.core.PApplet;

public class Practice extends PApplet {

	public void settings() {
		size(400, 400);
	}
	
	public void setup() {
		ellipse(224, 184, 220, 220);
	}
	
	public static void main(String[] args) {
		PApplet.main(Practice.class);

	}
}

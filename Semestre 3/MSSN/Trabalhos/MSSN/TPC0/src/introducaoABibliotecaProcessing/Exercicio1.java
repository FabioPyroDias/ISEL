package introducaoABibliotecaProcessing;

import processing.core.PApplet;

public class Exercicio1 extends PApplet {

	public void settings() {
		size(1100, 600);
	}
	
	public void setup() {
		CreateVolkswagenLogo(width/2, height/2, 200, 200);
	}

	public static void main(String[] args) {
		PApplet.main(Exercicio1.class);
	}
	
	private void CreateVolkswagenLogo(int xCoordinate, int yCoordinate, int width, int height) {
		
		// Responsive \\
		/*
		strokeWeight(8);
		stroke(0);
		fill(255);
		ellipse(xCoordinate, yCoordinate, width, height);
		
		noStroke();
		fill(0);
		ellipse(xCoordinate, yCoordinate, 5*width/7, 5*height/7);
		*/
		
		// Forced \\
		
		//Outside White Circle
		strokeWeight(8);
		stroke(0);
		fill(255);
		ellipse(this.width/2, this.height/2, 200, 200);
		
		//Inside Black Circle
		noStroke();
		fill(0);
		ellipse(this.width/2, this.height/2, 130, 130);
	
		//White V Shape
		stroke(255);
		fill(255);
		textSize(100);
		textAlign(CENTER);
		text("V", this.width/2, this.height/2);	
	
		//White W Shape
		stroke(255);
		fill(255);
		textSize(172);
		textAlign(CENTER);
		text("W", this.width/2, this.height/2 + 130/2);
	}
}
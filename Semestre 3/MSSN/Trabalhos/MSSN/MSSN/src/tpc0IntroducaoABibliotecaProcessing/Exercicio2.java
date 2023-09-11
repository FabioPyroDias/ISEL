package tpc0IntroducaoABibliotecaProcessing;

import processing.core.PApplet;
import setup.IProcessingApp;

public class Exercicio2 implements IProcessingApp{

	private void DrawTwoThirds(PApplet parent) {
		parent.stroke(0);
		parent.strokeWeight(8);
		
		parent.line(0, 0, parent.width, 0);
		parent.line(0, parent.height, parent.width, parent.height);
		parent.line(0, 0, 0, parent.height);
		parent.line(parent.width, 0, parent.width, parent.height);
		
		parent.line(0, parent.height/3, parent.width, parent.height/3);
		parent.line(0, 2*parent.height/3, parent.width, 2*parent.height/3);
		parent.line(parent.width/3, 0, parent.width/3, parent.height);
		parent.line(2*parent.width/3, 0, 2*parent.width/3, parent.height);
	}
	
	@Override
	public void setup(PApplet parent) {
		parent.background(255);
		
		System.out.println("Centro primeiro quadrado -> x: " + ((parent.width/3 + 0) / 2) + " y: " + ((parent.height/3 + 0) / 2));
		System.out.println("Centro segundo quadrado -> x: " + ((2*parent.width/3 + parent.width/3) / 2) + " y: " + ((parent.height/3 + 0) / 2));
		System.out.println("Centro terceiro quadrado -> x: " + ((parent.width + 2*parent.width/3) / 2) + " y: " + ((parent.height/3 + 0) / 2));
	
		System.out.println("Centro quarto quadrado -> x: " + ((parent.width/3 + 0) / 2) + " y: " + ((2*parent.height/3 + parent.height/3) / 2));
		System.out.println("Centro quinto quadrado -> x: " + ((2*parent.width/3 + parent.width/3) / 2) + " y: " + ((2*parent.height/3 + parent.height/3) / 2));
		System.out.println("Centro sexto quadrado -> x: " + ((parent.width + 2*parent.width/3) / 2) + " y: " + ((2*parent.height/3 + parent.height/3) / 2));
	
		System.out.println("Centro sétimo quadrado -> x: " + ((parent.width/3 + 0) / 2) + " y: " + ((2*parent.height/3 + parent.height) / 2));
		System.out.println("Centro oitavo quadrado -> x: " + ((2*parent.width/3 + parent.width/3) / 2) + " y: " + ((2*parent.height/3 + parent.height) / 2));
		System.out.println("Centro nono quadrado -> x: " + ((parent.width + 2*parent.width/3) / 2) + " y: " + ((2*parent.height/3 + parent.height) / 2));
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.background(255);
		DrawTwoThirds(parent);
		
		parent.ellipse(100, 66, 30, 30);
		parent.ellipse(300, 66, 30, 30);
		parent.ellipse(500, 66, 30, 30);

		parent.ellipse(100, 199, 30, 30);
		parent.ellipse(300, 199, 30, 30);
		parent.ellipse(500, 199, 30, 30);

		parent.ellipse(100, 333, 30, 30);
		parent.ellipse(300, 333, 30, 30);
		parent.ellipse(500, 333, 30, 30);
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

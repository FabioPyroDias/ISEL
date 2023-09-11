package tpc0IntroducaoABibliotecaProcessing;

import processing.core.PApplet;
import processing.core.PFont;
import setup.IProcessingApp;

public class Exercicio1 implements IProcessingApp{
	
	private boolean hasStarted;
	
	private int initialPositionX, initialPositionY;
	
	private int directionX, directionY;
	
	private float randomStepX, randomStepY;
	
	private float initialTime;

	private void CreateVolkswagenLogo(PApplet parent, int xCoordinate, int yCoordinate, int xDirection, int yDirection, float xRandomStep, float yRandomStep, float initialTime) {		
		parent.background(255);
		
		//Outside White Circle
		parent.strokeWeight(8);
		parent.stroke(0);
		parent.fill(255);
		parent.ellipse(xCoordinate + (parent.millis() - initialTime) * xDirection * xRandomStep, yCoordinate + (parent.millis() - initialTime) * yDirection * yRandomStep , 200, 200);
		
		//Inside Black Circle
		parent.noStroke();
		parent.fill(0);
		parent.ellipse(xCoordinate + (parent.millis() - initialTime) * xDirection * xRandomStep, yCoordinate + (parent.millis() - initialTime) * yDirection * yRandomStep , 130, 130);
	
		//White V Shape
		parent.stroke(255);
		parent.fill(255);
		parent.textSize(110);
		parent.textAlign(parent.CENTER);
		parent.text("V", xCoordinate + (parent.millis() - initialTime) * xDirection * xRandomStep, yCoordinate  + (parent.millis() - initialTime) * yDirection * yRandomStep  - 15);	
	
		//White W Shape
		parent.stroke(255);
		parent.fill(255);
		parent.textSize(142);
		parent.textAlign(parent.CENTER);
		parent.text("W", xCoordinate + (parent.millis() - initialTime) * xDirection * xRandomStep, yCoordinate  + (parent.millis() - initialTime) * yDirection * yRandomStep + 130/2 + 15);
		
	}

	@Override
	public void setup(PApplet parent) {
		parent.background(255);	
		hasStarted = false;
	}

	@Override
	public void draw(PApplet parent, float dt) {
		if(parent.mousePressed) {
			initialPositionX = parent.mouseX; 
			initialPositionY = parent.mouseY;
			directionX = ((int) parent.random(0, 1.1f) == 0 ) ? -1 : 1;
			directionY = ((int) parent.random(0, 1.1f) == 0 ) ? -1 : 1;
			randomStepX = parent.random(.01f, 0.1f);
			randomStepY = parent.random(.01f, 0.1f);
			initialTime = parent.millis();
			
			hasStarted = true;
		}
		
		if(hasStarted) {
			CreateVolkswagenLogo(parent, initialPositionX, initialPositionY, directionX, directionY, randomStepX, randomStepY, initialTime);
		}
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
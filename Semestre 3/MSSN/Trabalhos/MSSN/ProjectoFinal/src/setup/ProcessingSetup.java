package setup;

import game.GameApp;
import processing.core.PApplet;

public class ProcessingSetup extends PApplet{

	private static IProcessingApp processingApp;
	private float lastUpdateTime;
	
	@Override
	public void settings() {
		size(800, 600);
	}
	
	@Override
	public void setup() {
		processingApp.setup(this);
		lastUpdateTime = 0;
	}

	@Override
	public void draw() {
		float now = millis();
		float dt = (float) ((now - lastUpdateTime) / 1000.);
		lastUpdateTime = now;
		processingApp.draw(this, dt);
	}

	@Override
	public void keyPressed() {
		processingApp.keyPressed(this);
	}

	@Override
	public void mousePressed() {
		processingApp.mousePressed(this);
	}
	
	public static void main(String[] args) {
		processingApp = new GameApp();
		PApplet.main(ProcessingSetup.class);
	}
}

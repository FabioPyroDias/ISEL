package physicsArnaldo;

import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;
import utils.SubPlot;

public class FallingBodyApp implements IProcessingApp{

	public static final float dimY = 15; 		//m
	public static final float dimX = 20; 		//m
	public static final float g = -9.8f; 		//m/s^2
	public static final float mass = 80;  		//Kg
	public static final float radius = 0.5f; 	//m
	
	private final double window[] = {0, dimX, 0, dimY};
	private float viewport[] = {0, 0, 1f, 1f};
	private SubPlot plt;
	private Body ball;
	private Water water;
	private Air air;
	private float speedUp = 0.5f;
	private float timer;
	
	
	@Override
	public void setup(PApplet parent) {
		plt = new SubPlot(window, viewport, parent.width, parent.height);
		ball = new Body(new PVector(0, 12), new PVector(8, 6), mass, radius, parent.color(255, 255, 0));
		water = new Water(4, parent.color(0, 255, 255));
		air = new Air();
		timer = 0.0f;
	}

	@Override
	public void draw(PApplet parent, float dt) {
		PVector f = new PVector(0, mass * g);
		ball.applyForce(f);
		
		if(water.isInside(ball))
		{
			f = water.drag(ball);
		}
		else
		{
			f = air.drag(ball);
		}
		
		ball.applyForce(f);
		ball.move(speedUp * dt);
		
		water.display(parent, plt);
		ball.display(parent, plt);
		
		timer += speedUp * dt;
		
		if(ball.pos.y < 0)
		{
			parent.noLoop();
			System.out.println(timer);
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
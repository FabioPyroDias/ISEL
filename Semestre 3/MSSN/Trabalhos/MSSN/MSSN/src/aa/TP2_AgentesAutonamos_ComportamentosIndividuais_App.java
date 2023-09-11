package aa;

import java.util.ArrayList;
import java.util.List;

import physicsArnaldo.Body;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;
import utils.SubPlot;

public class TP2_AgentesAutonamos_ComportamentosIndividuais_App implements IProcessingApp {

	//SubPlot
	private SubPlot plt;
	private double[] window = {-10, 10, -10, 10};
	private float[] viewport = {0, 0, 1, 1};
	
	//Threat
	private List<Body> threats = new ArrayList<Body>();
	private int numberOfThreats = 20;
	private float timeUntilThreatsPositionChange = 5;
	private float threatsPositionChangeTimer;
	
	//Prey
	private Boid prey;
	private float[] wanderSpeed = new float[] {3, 5};
	private float[] fleeSpeed = new float[] {6, 8};
	private int activeBehaviourIndex;

	private float[] fleeDuration = new float[] {0.25f, 0.4f};
	private float currentFleeDuration;
	private float fleeTimer;
	
	@Override
	public void setup(PApplet parent) {
		plt = new SubPlot(window, viewport, parent.width, parent.height);
		
		for(int threatIndex = 0; threatIndex < numberOfThreats; threatIndex++)
		{
			Body threat = new Body(new PVector(DNA.random(-10,  10), DNA.random(-10,  10)), new PVector(), 1, 0.3f, parent.color(255, 0, 0));
			threats.add(threat);
		}
		
		prey = new Boid(new PVector(), 0.5f, 0.5f, parent.color(0, 255, 0), parent, plt);
		prey.addBehavior(new Wander(1));
		prey.addBehavior(new Flee(1));
		activeBehaviourIndex = 0;
		
		List<Body> allTrackingBodies = new ArrayList<Body>();
		
		for(Body threat : threats)
		{
			allTrackingBodies.add(threat);			
		}
		
		prey.setEye(new Eye(prey, allTrackingBodies));
		
		threatsPositionChangeTimer = timeUntilThreatsPositionChange;
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.background(220);
		
		if(activeBehaviourIndex == 1)
		{
			fleeTimer -= dt;
			
			if(fleeTimer <= 0)
			{
				activeBehaviourIndex = 0;
				
				//Not working
				prey.setColor(parent.color(0, 255, 0));
				
				prey.dna.maxSpeed = DNA.random(wanderSpeed[0], wanderSpeed[1]);
			}
		}
		
		prey.applyBehavior(activeBehaviourIndex, dt);
		
		if(prey.eye.getNearSight().size() > 0)
		{
			currentFleeDuration = DNA.random(fleeDuration[0], fleeDuration[1]);
			fleeTimer = currentFleeDuration;
			activeBehaviourIndex = 1;
			
			//Not working
			prey.setColor(parent.color(123, 24, 199));
			
			prey.dna.maxSpeed = DNA.random(fleeSpeed[0], fleeSpeed[1]);
		}

		prey.display(parent, plt);

		for(Body threat : threats)
		{
			threat.display(parent, plt);			
		}
		
		
		threatsPositionChangeTimer -= dt;
	
		if(threatsPositionChangeTimer <= 0)
		{
			threats.clear();
			
			for(int threatIndex = 0; threatIndex < numberOfThreats; threatIndex++)
			{
				Body threat = new Body(new PVector(DNA.random(-10,  10), DNA.random(-10,  10)), new PVector(), 1, 0.3f, parent.color(255, 0, 0));
				threats.add(threat);
			}
			
			prey.setEye(new Eye(prey, threats));
			
			threatsPositionChangeTimer = timeUntilThreatsPositionChange;
		}
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(PApplet parent) {
		
	}
	
}
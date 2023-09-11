package dla;

import java.util.ArrayList;
import java.util.List;

import dla.Walker.State;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;

public class DLA implements IProcessingApp{

	private List<Walker> walkers;
	private int MAX_ACTIVE_NUM_WALKERS = 20;
	private int NUM_WALKERS = 1000;
	private int NUM_STEPS_PER_FRAME = 100;
	
	//Game Control Variables
	private boolean isRunning;
	
	@Override
	public void setup(PApplet parent) {
		parent.background(128);
		
		walkers = new ArrayList<Walker>();
		
		Walker w = new Walker(parent, new PVector(parent.width/2, parent.height/2));
		walkers.add(w);
		
		
		for(int walker = 0; walker < MAX_ACTIVE_NUM_WALKERS; walker++)
		{
			w = new Walker(parent);
			walkers.add(w);
		}
	}

	@Override
	public void draw(PApplet parent, float dt) {
		
		if(isRunning)
		{
			parent.background(128);
			
			for(int step = 0; step < NUM_STEPS_PER_FRAME; step++)
			{
				for(Walker w : walkers)
				{
					if(w.GetState() == State.WANDER)
					{
						w.Wander(parent);					
						w.UpdateState(parent, walkers);
					}
				}
			}
			
			for(Walker w : walkers)
			{
				w.Display(parent);
			}
	
			if(walkers.size() < NUM_WALKERS) {
				
				if(walkers.size() + MAX_ACTIVE_NUM_WALKERS < NUM_WALKERS)
				{
					for(int toBeSpawned = Walker.GetNumWanderingWalkers(); toBeSpawned < MAX_ACTIVE_NUM_WALKERS; toBeSpawned++)
					{
						Walker w = new Walker(parent);
						walkers.add(w);
					}
				}
				else 
				{
					for(int toBeSpawned = walkers.size(); toBeSpawned < NUM_WALKERS; toBeSpawned++)
					{
						Walker w = new Walker(parent);
						walkers.add(w);
					}
				}
			}
		
			System.out.println("Stopped = " + Walker.GetNumStoppedWalkers() + " | Wandering = " + Walker.GetNumWanderingWalkers());
		}
	}

	@Override
	public void keyPressed(PApplet parent) {
		switch(parent.key)
		{
			case ' ':
				if(!isRunning)
				{
					isRunning = true;
				}
				else
				{
					isRunning = false;
				}
				break;
				
			default:
				break;
		}
	}

	@Override
	public void mousePressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

}

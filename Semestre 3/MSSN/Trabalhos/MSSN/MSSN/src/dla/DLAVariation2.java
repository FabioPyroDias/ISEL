package dla;

import java.util.ArrayList;
import java.util.List;

import dla.WalkerVariation2.State;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;

public class DLAVariation2 implements IProcessingApp{

	private List<WalkerVariation2> walkers;
	private int MAX_ACTIVE_NUM_WALKERS = 20;
	private int NUM_WALKERS = 2000;
	private int NUM_STEPS_PER_FRAME = 100;
	
	//Game Control Variables
	private boolean isRunning;
	
	@Override
	public void setup(PApplet parent) {
		parent.background(0);
		
		walkers = new ArrayList<WalkerVariation2>();
		
		WalkerVariation2 w = new WalkerVariation2(parent, new PVector(parent.width/2, parent.height/2));
		walkers.add(w);
		
		
		for(int walker = 0; walker < MAX_ACTIVE_NUM_WALKERS; walker++)
		{
			w = new WalkerVariation2(parent);
			walkers.add(w);
		}
	}

	@Override
	public void draw(PApplet parent, float dt) {
		
		if(isRunning)
		{
			parent.background(0);
			
			for(int step = 0; step < NUM_STEPS_PER_FRAME; step++)
			{
				for(WalkerVariation2 w : walkers)
				{
					if(w.GetState() == State.WANDER)
					{
						w.Wander(parent);					
						w.UpdateState(parent, walkers);
					}
				}
			}
			
			for(WalkerVariation2 w : walkers)
			{
				w.Display(parent);
			}
	
			if(walkers.size() < NUM_WALKERS) {
				
				if(walkers.size() + MAX_ACTIVE_NUM_WALKERS < NUM_WALKERS)
				{
					for(int toBeSpawned = WalkerVariation2.GetNumWanderingWalkers(); toBeSpawned < MAX_ACTIVE_NUM_WALKERS; toBeSpawned++)
					{
						WalkerVariation2 w = new WalkerVariation2(parent);
						walkers.add(w);
					}
				}
				else 
				{
					for(int toBeSpawned = walkers.size(); toBeSpawned < NUM_WALKERS; toBeSpawned++)
					{
						WalkerVariation2 w = new WalkerVariation2(parent);
						walkers.add(w);
					}
				}
			}
	
			System.out.println("Stopped = " + WalkerVariation2.GetNumStoppedWalkers() + " | Wandering = " + WalkerVariation2.GetNumWanderingWalkers());
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

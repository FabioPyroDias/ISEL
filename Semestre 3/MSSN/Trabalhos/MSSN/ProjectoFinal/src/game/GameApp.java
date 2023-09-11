package game;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;

import dla.Center;
import dla.Walker;
import dla.Walker.WalkerState;
import processing.core.PApplet;
import setup.IProcessingApp;

public class GameApp implements IProcessingApp
{
	private Center center;
	
	private List<Walker> walkers;
	private int maxWalkers;
	private int insideCenter;
	
	private int stepsPerFrame = 100;
	
	public enum State
	{
		TOGETHER,
		SPREAD
	}
	
	private State currentState;
	
	private float timeBetweenStates;
	private float betweenStatesTimer;
		
	private enum SliderState
	{
		UP,
		DOWN
	}
	
	private SliderState currentSliderState = SliderState.DOWN;
	private boolean canSliderMove = true;
	private float sliderYPos = 400;

	
	@Override
	public void setup(PApplet parent) {
		
		parent.background(180);
		
		currentState = State.TOGETHER;
		
		walkers = new ArrayList<Walker>();
		maxWalkers = 40;
		insideCenter = maxWalkers;
		
		center = new Center(parent.width / 2, parent.height / 2);
		center.SetRadius(insideCenter);
		
		for(int walker = 0; walker < maxWalkers; walker++)
		{
			Walker w = new Walker(parent);
			w.SetCenter(center);
			walkers.add(w);
		}
		
		timeBetweenStates = 1f;
		betweenStatesTimer = timeBetweenStates;
	}

	@Override
	public void draw(PApplet parent, float dt) {
		
		parent.background(240);
		
		if(betweenStatesTimer > 0)
		{
			betweenStatesTimer -= dt;
		}
		
		//System.out.println("Walkers: " + walkers.size() + " | Pos: " + walkers.get(0).pos + " | State: " + walkers.get(0).GetWalkerState());
		
		for(int step = 0; step < stepsPerFrame; step++)
		{
			//Update Walkers Positions.
			for(Walker walker : walkers)
			{
				//System.out.println(walker.toString() + " | " + walker.GetWalkerState());
				
				if(walker.GetWalkerState() == WalkerState.WALKING)
				{
					
					walker.Wander(parent);
					walker.UpdateState(parent, walkers);
				}
			}
		}
		
		center.UpdateRadius(walkers);
		
		for(Walker walker : walkers)
		{
			walker.Display(parent);
		}
		
		center.Display(parent);
		
		Slider(parent);
		if(canSliderMove)
		{
			if(currentSliderState == SliderState.UP)
			{
				sliderYPos -= dt * stepsPerFrame;
			}
			else
			{
				sliderYPos += dt * stepsPerFrame;
			}
		}
	}

	@Override
	public void keyPressed(PApplet parent) {
	
	}
	
	@Override
	public void mousePressed(PApplet parent) {
		if(parent.mouseButton == parent.LEFT)
		{
			if(betweenStatesTimer >= 0)
			{
				return;
			}
			
			if(currentState == State.SPREAD)
			{
				return;
			}
			
			currentState = State.SPREAD;
			betweenStatesTimer = timeBetweenStates;
			canSliderMove = false;
			
			SetWalkerStats();
			
			for(Walker walker : walkers)
			{
				walker.SetOuterDirection(parent);
			}
			
		}
		else if(parent.mouseButton == parent.RIGHT)
		{
			if(betweenStatesTimer >= 0)
			{
				return;
			}

			if(currentState == State.TOGETHER)
			{
				return;
			}
			
			currentState = State.TOGETHER;
			betweenStatesTimer = timeBetweenStates;
			canSliderMove = true;
			
			for(Walker walker : walkers)
			{
				walker.SetInwardDirection(parent);
			}
		}
	}
	
	private void Slider(PApplet app)
	{
		app.pushStyle();
		
		app.noFill();
		app.stroke(220, 220, 220, 130);
		app.strokeWeight(5);
		app.rect(650, 400, 125, 175);
		
		app.noStroke();
		
		app.fill(255, 0, 0, 130);
		app.rect(650, 400, 125, 35);
		
		app.fill(180, 128, 0, 130);
		app.rect(650, 435, 125, 35);
		
		app.fill(0, 255, 0, 130);
		app.rect(650, 470, 125, 35);
		
		app.fill(180, 128, 0, 130);
		app.rect(650, 505, 125, 35);

		app.fill(255, 0, 0, 130);
		app.rect(650, 540, 125, 35);
		
		app.stroke(255, 255, 255, 160);
		app.line(650, sliderYPos, 775, sliderYPos);
		
		if(sliderYPos >= 575)
		{
			currentSliderState = SliderState.UP;
		}
		else if(sliderYPos <= 400)
		{
			currentSliderState = SliderState.DOWN;
		}
		
		app.popStyle();
	}
	
	private void SetWalkerStats()
	{
		if((sliderYPos >= 400 && sliderYPos < 435) || (sliderYPos > 540 && sliderYPos <= 575))
		{
			for(Walker walker : walkers)
			{
				walker.SetSpeed(0.35f);
				walker.SetStepLerp(0.00002f);
			}
		}
		else if((sliderYPos >= 435 && sliderYPos < 470) || (sliderYPos > 505 && sliderYPos <= 540))
		{
			for(Walker walker : walkers)
			{
				walker.SetSpeed(0.20f);
				walker.SetStepLerp(0.000035f);
			}
		}
		else
		{
			for(Walker walker : walkers)
			{
				walker.SetSpeed(0.05f);
				walker.SetStepLerp(0.00005f);
			}
		}
	}
}

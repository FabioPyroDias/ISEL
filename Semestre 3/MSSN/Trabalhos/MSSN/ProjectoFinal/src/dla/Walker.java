package dla;

import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public class Walker {

	private Center center;
	
	public enum WalkerState {
		WALKING,
		STOPPED
	}
	
	public PVector pos;
	private PVector direction;	
	
	private WalkerState currentState;
	
	private boolean isToStopAtCenter;
	private int color;
	private float radius = 4;
	private float movementSpeed = 0.25f;
	private float stepLerp = 0.00002f;
	private float centerThreshold = 0.25f;
	
	public Walker(PApplet app)
	{
		pos = new PVector(app.width/2, app.height/2);
		
		isToStopAtCenter = true;
		currentState = WalkerState.STOPPED;
	}

	public void Wander(PApplet app)
	{
		PVector step = PVector.random2D();
		pos.add(step.mult(movementSpeed));
		
		pos.lerp(direction, stepLerp);
		
		pos.x = PApplet.constrain(pos.x, 0, app.width);
		pos.y = PApplet.constrain(pos.y, 0, app.height);
	}
	
	public void UpdateState(PApplet app, List<Walker> walkers)
	{
		if(currentState == WalkerState.STOPPED)
		{
			return;
		}
		
		for(Walker w : walkers)
		{
			if(w != this)
			{
				if(w.GetWalkerState() == WalkerState.STOPPED)
				{
					if(!isToStopAtCenter)
					{
						float dist = PVector.dist(pos, w.pos);
						
						if(dist < 2*radius)
						{
							currentState = WalkerState.STOPPED;
							break;
						}
					}
				}
			}
		}
		
		if(currentState != WalkerState.STOPPED)
		{
			if(isToStopAtCenter)
			{
				if((pos.x >= (app.width / 2) - centerThreshold) && (pos.x <= (app.width / 2) + centerThreshold) && (pos.y >= (app.height / 2) - centerThreshold) && (pos.y <= (app.height / 2) + centerThreshold))
				{
					currentState = WalkerState.STOPPED;
					pos = new PVector(app.width / 2, app.height / 2);
				}
			}
			else
			{
				float distToLeft = Math.abs(pos.x - 0);
				float distToRight = Math.abs(pos.x - app.width);
				float distToTop = Math.abs(pos.y - 0);
				float distToBot = Math.abs(pos.y - app.height);
				
				if(distToLeft <= radius || distToRight <= radius || distToTop <= radius || distToBot <= radius)
				{
					currentState = WalkerState.STOPPED;
				}
			}
		}
	}

	public void SetOuterDirection(PApplet app)
	{
		float dirAngle = app.random(0f,  360f);
		direction = new PVector(PApplet.cos(dirAngle) * app.width * 1.5f, PApplet.sin(dirAngle) * app.height * 1.5f);
		
		isToStopAtCenter = false;
		currentState = WalkerState.WALKING;
	}
	
	public void SetInwardDirection(PApplet app)
	{
		direction = new PVector(app.width / 2, app.height / 2);
	
		isToStopAtCenter = true;
		currentState = WalkerState.WALKING;
	}
	
	public void SetSize(float radius)
	{
		this.radius = radius;
	}
	
	public void SetSpeed(float movementSpeed)
	{
		this.movementSpeed = movementSpeed;
	}
	
	public void SetStepLerp(float stepLerp)
	{
		this.stepLerp = stepLerp;
	}
	
	public void SetCenterThreshold(float centerThreshold)
	{
		this.centerThreshold = Math.max(radius, centerThreshold);
	}
	
	public void SetCenter(Center center)
	{
		this.center = center;
	}
	
	public PVector GetPos()
	{
		return pos;
	}

	public WalkerState GetWalkerState()
	{
		return currentState;
	}
	
	public void Display(PApplet app)
	{
		app.fill(0);
		app.circle(pos.x, pos.y, 2*radius);
	}
}
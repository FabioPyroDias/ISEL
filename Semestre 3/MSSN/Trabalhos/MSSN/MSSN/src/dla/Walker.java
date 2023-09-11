package dla;

import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public class Walker {

	public enum State {
		STOPPED,
		WANDER
	}
	
	private PVector pos;
	private State state;
	private int color;
	private float radius;
	private float maxRadius = 4;
	private static int num_wandering_walkers = 0;
	private static int num_stopped_walkers = 0;
	
	public Walker(PApplet app)
	{
		//pos = new PVector(app.random(app.width), app.random(app.height));
		pos = new PVector(app.width/2, app.height/2);
		PVector r = PVector.random2D();
		r.mult(app.width/2 + 250);
		pos.add(r);
		
		radius = (maxRadius) - ((GetNumStoppedWalkers() / 1000f) * (maxRadius - 2));
		
		SetState(app, State.WANDER);
	}
	
	public Walker(PApplet app, PVector pos)
	{
		this.pos = pos;
		radius = maxRadius;
		
		SetState(app, State.STOPPED);
	}
	
	public State GetState()
	{
		return state;
	}
	
	public void SetState(PApplet app, State state)
	{
		this.state = state;
		if(state == State.STOPPED)
		{
			color = app.color(0);
			num_stopped_walkers++;
		}
		else
		{
			color = app.color(255);
			num_wandering_walkers++;
		}
	}
	
	public static int GetNumWanderingWalkers()
	{
		return num_wandering_walkers;
	}
	
	public static int GetNumStoppedWalkers()
	{
		return num_stopped_walkers;
	}
	
	public void UpdateState(PApplet app, List<Walker> walkers)
	{
		if(state == State.STOPPED)
		{
			return;
		}
		
		for(Walker w : walkers)
		{
			if(w == this)
			{
				return;
			}
			
			if(w.GetState() == State.STOPPED)
			{
				float dist = PVector.dist(pos, w.pos);
				
				if(dist < 2*radius)
				{
					SetState(app, State.STOPPED);
					num_wandering_walkers--;
					break;
				}
			}
		}
	}
	
	public void Wander(PApplet app)
	{
		PVector step = PVector.random2D();
		pos.add(step);
		
		pos.lerp(new PVector(app.width/2, app.height/2), 0.002f);
		
		pos.x = PApplet.constrain(pos.x, 0, app.width);
		pos.y = PApplet.constrain(pos.y, 0, app.height);
	}
	
	public void Display(PApplet app)
	{
		app.fill(color);
		app.circle(pos.x, pos.y, 2*radius);
	}
}
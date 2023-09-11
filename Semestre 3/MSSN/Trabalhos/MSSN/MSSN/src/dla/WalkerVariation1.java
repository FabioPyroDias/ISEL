package dla;

import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public class WalkerVariation1 {

	public enum State {
		STOPPED,
		WANDER
	}
	
	private PVector pos;
	private PVector size;
	private boolean isRoot;
	
	private State state;
	private int color;
	private float radius;
	private float maxRadius = 4;
	private static int num_wandering_walkers = 0;
	private static int num_stopped_walkers = 0;
	
	public WalkerVariation1(PApplet app)
	{
		//pos = new PVector(app.random(app.width), app.random(app.height));
		pos = new PVector(app.width/2, -600);
		PVector r = PVector.random2D();
		r.mult(app.width/2);
		pos.add(r);
		
		radius = (maxRadius) - ((GetNumStoppedWalkers() / 1000f) * (maxRadius - (maxRadius - 1)));
		
		isRoot = false;
		
		SetState(app, State.WANDER);
	}
	
	public WalkerVariation1(PApplet app, PVector pos, PVector size)
	{
		this.pos = pos;
		this.size = size;
		isRoot = true;
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
			color = app.color(255);
			num_stopped_walkers++;
		}
		else
		{
			color = app.color(128);
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
	
	public boolean GetIsRoot()
	{
		return isRoot;
	}
	
	public void UpdateState(PApplet app, List<WalkerVariation1> walkers)
	{
		if(state == State.STOPPED)
		{
			return;
		}
		
		for(WalkerVariation1 w : walkers)
		{
			if(w == this)
			{
				return;
			}
			
			if(w.GetState() == State.STOPPED)
			{				
				if(!w.GetIsRoot())
				{
					float dist = PVector.dist(pos, w.pos);
					
					if(dist < 2*radius)
					{
						SetState(app, State.STOPPED);
						num_wandering_walkers--;
						break;
					}
				}
				else
				{
					float dist = Math.abs(pos.y - w.pos.y);
					
					if(dist < 7)
					{
						SetState(app, State.STOPPED);
						num_wandering_walkers--;
						break;
					}
				}
			}
		}
	}
	
	public void Wander(PApplet app)
	{
		PVector step = PVector.random2D();
		pos.add(step);
		
		//O X neste PVector tem de ser o width por inteiro e não o centro do width
		pos.lerp(new PVector(app.random(10f, app.width - 10), app.height), 0.0002f);
		
		pos.x = PApplet.constrain(pos.x, 0, app.width);
		pos.y = PApplet.constrain(pos.y, 0, app.height);
	}
	
	public void Display(PApplet app)
	{
		if(isRoot)
		{
			app.stroke(80);
			app.strokeWeight(5);
			app.line(pos.x, pos.y, size.x, size.y);
		}
		else
		{
			if(state == State.STOPPED) 
			{
				app.stroke(80);
			}
			else
			{
				app.noStroke();
			}
		}
		
		app.strokeWeight(1);
		app.fill(color);
		app.circle(pos.x, pos.y, 2*radius);
	}
}
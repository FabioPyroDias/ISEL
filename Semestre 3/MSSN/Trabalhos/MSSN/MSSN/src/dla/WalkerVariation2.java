package dla;

import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public class WalkerVariation2 {

	public enum State {
		STOPPED,
		WANDER
	}
	
	private PVector pos;
	private PVector direction;
	private boolean isRoot;
	
	private State state;
	private int color;
	private float radius;
	private float maxRadius = 4;
	private static int num_wandering_walkers = 0;
	private static int num_stopped_walkers = 0;
	
	public WalkerVariation2(PApplet app)
	{
		//pos = new PVector(app.random(app.width), app.random(app.height));
		pos = new PVector(app.width/2, app.width/2);
		PVector r = PVector.random2D();
		r.mult(50);
		pos.add(r);
		
		isRoot = false;
		
		float dirAngle = app.random(0f,  360f);
		direction = new PVector(PApplet.cos(dirAngle) * app.width * 1.5f, PApplet.sin(dirAngle) * app.height * 1.5f);
		
		radius = (maxRadius) - ((PApplet.min(GetNumStoppedWalkers() / 1500f, 1) * (maxRadius - 2f)));
		
		SetState(app, State.WANDER);
	}
	
	public WalkerVariation2(PApplet app, PVector pos)
	{
		this.pos = pos;
		this.radius = (app.width / 2) - (5 * maxRadius);
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
			color = app.color(color = app.lerpColor(app.color(255, 0, 0), app.color(98, 132, 255), (GetNumStoppedWalkers() + GetNumWanderingWalkers()) / 2000f));
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
	
	public void UpdateState(PApplet app, List<WalkerVariation2> walkers)
	{
		if(state == State.STOPPED)
		{
			return;
		}
		
		for(WalkerVariation2 w : walkers)
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
					//Para comparar esta distância e assim, possuir a posicao do Walker (não root)
					//comparar a distância ao centro do ecrã e saber se se encontra no radius do
					//Walker (root)
					float dist = PVector.dist(pos, new PVector(app.width / 2, app.height / 2));
					
					if(dist > (w.radius - radius) - 2)
					{
						SetState(app, State.STOPPED);
						num_wandering_walkers--;
					}
				}
			}
		}
	}
	
	public void Wander(PApplet app)
	{
		PVector step = PVector.random2D();
		pos.add(step);
		
		pos.lerp(direction, 0.0002f);
		
		pos.x = PApplet.constrain(pos.x, 0, app.width);
		pos.y = PApplet.constrain(pos.y, 0, app.height);
	}
	
	public void Display(PApplet app)
	{
		if(isRoot)
		{
			app.noFill();
			app.stroke(255);
			app.noStroke();
			app.circle(pos.x, pos.y, 2*radius);
		}
		else
		{
			app.strokeWeight(1);
			app.fill(color);
			app.circle(pos.x, pos.y, 2*radius);
		}
	}
}
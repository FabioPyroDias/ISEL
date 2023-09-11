package dla;

import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public class Center {
	
	private PVector pos;
	
	private float radius;
	private boolean isMaximumSize;
	
	public Center(float x, float y)
	{
		this.pos = new PVector(x, y);
	}
	
	public void SetRadius(int numberOfWalkers)
	{
		radius = 60 * (numberOfWalkers / 40f);
	}

	public void UpdateRadius(List<Walker> walkers)
	{
		int howManyInside = 0;
		
		for(Walker walker : walkers)
		{	
			if(Math.abs(PVector.dist(walker.GetPos(), pos)) <= Math.max(2, radius/2))
			{
				howManyInside += 1;		
			}
		}
		
		SetRadius(howManyInside);
		
		for(Walker walker : walkers)
		{
			walker.SetCenterThreshold(radius / 2);
		}		
	}

	public void Display(PApplet app)
	{
		app.pushStyle();
		
		app.noStroke();
		app.fill(16);
		app.circle(app.width / 2, app.height / 2, radius);
		
		app.popStyle();
	}
}
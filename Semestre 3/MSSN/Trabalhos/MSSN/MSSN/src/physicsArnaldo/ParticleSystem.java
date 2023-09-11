package physicsArnaldo;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;
import utils.SubPlot;

public class ParticleSystem extends Body{

	private List<Particle> particles;
	
	private PSControl psc;
	
	protected ParticleSystem(PVector pos, PVector vel, float mass, float radius, PSControl psc) {
		super(pos, vel, mass, radius, 0);
		this.psc = psc;
		
		this.particles = new ArrayList<Particle>();		
	}
	
	public PSControl getPSControl()
	{
		return psc;
	}
	
	@Override
	public void move(float dt)
	{
		super.move(dt);
		addParticles(dt);
		
		for(int i = particles.size() - 1; i >= 0; i--)
		{
			if(particles.get(i).isDead())
			{
				particles.remove(i);
			}
		}
	}
	
	private void addParticles(float dt)
	{
		float particlesPerFrame = psc.getFlow() * dt;
		int n = (int) particlesPerFrame;
		float f = particlesPerFrame - n;
		
		for(int i = 0; i < n; i++)
		{
			addOneParticle();
		}
		
		if(Math.random() < f)
		{
			addOneParticle();
		}
	}
	
	private void addOneParticle()
	{
		Particle particle = new Particle(pos, psc.getRndVel(), psc.getRndRadius(), psc.getColor(), psc.getRndLifetime());
		particles.add(particle);
	}
	
	@Override
	public void display(PApplet p, SubPlot plt)
	{
		for(Particle particle: particles)
		{
			particle.display(p, plt);
		}
	}
}

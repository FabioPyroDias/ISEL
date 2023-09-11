package particleSystem;

import java.util.ArrayList;
import java.util.List;

import physics.Body;
import processing.core.PApplet;
import processing.core.PVector;
import tools.SubPlot;

public class ParticleSystem extends Body {

	private List<Particle> l_particles;
	private float lifeSpan;
	private PVector particleSpeed;
	
	public ParticleSystem(PVector position, PVector velocity, float mass, float radius, int color, float lifeSpan, PVector particleSpeed) {
		super(position, velocity, mass, radius, color);
		this.lifeSpan = lifeSpan;
		this.particleSpeed = particleSpeed;
		this.l_particles = new ArrayList<Particle>();
	}

	@Override
	public void move(float dt) {
		super.move(dt);
		addParticle();
		
		for (int i = l_particles.size() - 1; i >= 0 ; i--) {
			Particle p = l_particles.get(i);
			p.move(dt);
			if(p.isDead()) {
				l_particles.remove(i);
			}
		}
		
	}
	
	private void addParticle() {
		
		float vx = (float)(particleSpeed.x*(Math.random() - 0.5));
		float vy = (float)(particleSpeed.y*(Math.random() - 0.5));
		
		Particle nParticle = new Particle(position, new PVector(vx, vy), radius, color, lifeSpan);
		l_particles.add(nParticle);
	}	
	
	@Override
	public void display(PApplet p, SubPlot splt) {
		
		for (Particle partcile : l_particles) {
			partcile.display(p, splt);
		}
		
	}
	
	
}

package physics;

import java.util.*;

import particleSystem.ParticleSystem;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;
import tools.SubPlot;

public class SolarSystem implements IProcessingApp {

	// Solar Systam Planets Mass
	private float sunMass = 1.989e30f;
	private float mercuryMass = 0.330e24f;
	private float venusMass = 4.87e24f;
	private float earthMass = 5.972e24f;
	private float marsMass = 0.642e24f;
	private float jupiterMass = 1898e24f;
	private float saturnMass = 568e24f;
	private float uranusMass = 86.8e24f;
	private float neptuneMass = 102e24f;
	private float plutoMass = 0.0130e24f;
	
	// Solar System Moons Mass
	private float moonMass = 7.34e18f;
	
	// Solar System Planets Distance (Reference Sun)
	private float distanceMercurySun = 0.579e11f;
	private float distanceVenusSun = 1.082e11f;
	private float distanceEarthSun = 1.496e11f;
	private float distanceMarsSun = 2.279e11f;
	private float distanceJupiterSun = 7.786e11f;
	private float distanceStaurnSun = 14.335e11f;
	private float distanceUranusSun = 28.725e11f;
	private float distanceNeptuneSun = 44.951e11f;
	private float distancePlutoSun = 59.064e11f;
	
	// Planets Oribal Velocity
	private float mercurySpeed = 47.4e3f;
	private float venusSpeed = 35e3f;
	private float earthSpeed = 29.8e3f;
	private float marsSpeed = 24.1e3f;
	private float jupiterSpeed = 13.1e3f;
	private float saturnSpeed = 9.7e3f;
	private float uranusSpeed = 6.8e3f;
	private float neptuneSpeed = 5.4e3f;
	private float plutoSpeed = 4.7e3f;
	
	
	private float[] viewport = {0.2f, 0.2f, .6f, .6f};
	private double[] window = {-1.2*distanceJupiterSun, 1.2*distanceJupiterSun, -1.2*distanceJupiterSun, 1.2*distanceJupiterSun};
	
	private SubPlot plt;
	private Body sun, mercury, venus, earth, mars, jupiter;
	
	private List<ParticleSystem> l_particleSystem;

	private float speedUp = 60 * 60 * 24 * 30;
	
	@Override
	public void setup(PApplet parent) {
		
		plt = new SubPlot(window, viewport, parent.width, parent.height);
		
		// Inicialize Celestial Bodies
		initializeSolarSystem(parent);
		// Inicialization of Particle System
		l_particleSystem = new ArrayList<ParticleSystem>();
		initializePs(parent);
		
	}
	
	private void initializePs(PApplet parent) {
		int color = parent.color(parent.random(255), parent.random(255), parent.random(255));
		float vx = parent.random(4, 10);
		float vy = parent.random(0, 4);
		float lifeSpan = parent.random(1, 3);
		
		ParticleSystem particleSystem = new ParticleSystem(new PVector(), new PVector(), 1f, .2f, color, lifeSpan, new PVector(vx, vy));
		l_particleSystem.add(particleSystem);
		
	}
	
	private void initializeSolarSystem(PApplet parent) {
		sun = new Body(new PVector(), new PVector(), sunMass, distanceEarthSun/10, parent.color(255, 128,0));
		mercury = new Body(new PVector(0, distanceMercurySun),new PVector(mercurySpeed, 0), mercuryMass, distanceMercurySun / 20, parent.color(255,0,0));
		venus = new Body(new PVector(0, distanceVenusSun),new PVector(venusSpeed, 0), venusMass, distanceVenusSun / 20, parent.color(255,0,0));
		earth = new Body(new PVector(0, distanceEarthSun), new PVector(earthSpeed, 0), earthMass, distanceEarthSun/20, parent.color(0, 180,120));
		mars = new Body(new PVector(0, distanceMarsSun), new PVector(marsSpeed, 0), marsMass, distanceMarsSun/20, parent.color(255, 0, 20));
		jupiter = new Body(new PVector(0, distanceJupiterSun), new PVector(jupiterSpeed, 0), jupiterMass, distanceJupiterSun/20, parent.color(255, 0, 20));
	}

	@Override
	public void draw(PApplet parent, float dt) {
		
		float[] pp = plt.getBoundingBox();
		parent.fill(255, 16);
		parent.rect(pp[0], pp[1], pp[2], pp[3]);
		
		sun.display(parent, plt);
		
		PVector sunMercuryAttraction = sun.attraction(mercury);
		PVector sunVenusAttraction = sun.attraction(venus);
		PVector sunEarthAttraction = sun.attraction(earth);
		PVector sunMarsAttraction = sun.attraction(mars);
		PVector sunJupiterAttraction = sun.attraction(jupiter);
		mercury.applyForce(sunMercuryAttraction);
		venus.applyForce(sunVenusAttraction);
		earth.applyForce(sunEarthAttraction);
		mars.applyForce(sunMarsAttraction);
		jupiter.applyForce(sunJupiterAttraction);
	
		mercury.move(dt * speedUp);
		venus.move(dt * speedUp);
		earth.move(dt * speedUp);
		mars.move(dt * speedUp);
		jupiter.move(dt * speedUp);
		
		mercury.display(parent, plt);
		venus.display(parent, plt);
		earth.display(parent, plt);
		mars.display(parent, plt);
		jupiter.display(parent, plt);
		
		for(ParticleSystem ps : l_particleSystem) {
			ps.applyForce(new PVector(0, -1));
		}
		
		for (ParticleSystem ps : l_particleSystem) {
			ps.move(dt);
			ps.display(parent, plt);
		}
		
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	
	
}

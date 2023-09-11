package setup;

import aa.BoidApp;
import aa.FlockTestApp;
import aa.ReynoldsTestApp;
import aa.TP2_AgentesAutonamos_ComportamentosIndividuais_App;
import ca.JogoDaVida;
import ca.TestCA;
import codigoAulas.Grelha;
import dla.DLA;
import dla.DLAVariation1;
import dla.DLAVariation2;
import gameOfLife.GameOfLifeDisplay;
import physics.SolarSystem;
import physicsArnaldo.ControlGUIApp;
import physicsArnaldo.FallingBodyApp;
import particleSystem.ParticleSystemApp;
import processing.core.PApplet;
import tpc0IntroducaoABibliotecaProcessing.Exercicio1;
import tpc0IntroducaoABibliotecaProcessing.Exercicio2;

public class ProcessingSetup extends PApplet{

	private static IProcessingApp processingApp;
	private float lastUpdateTime;
	
	@Override
	public void settings() {
		size(800, 600);
	}
	
	@Override
	public void setup() {
		processingApp.setup(this);
		lastUpdateTime = 0;
	}

	@Override
	public void draw() {
		float now = millis();
		float dt = (float) ((now - lastUpdateTime) / 1000.);
		lastUpdateTime = now;
		processingApp.draw(this, dt);
	}

	@Override
	public void keyPressed() {
		processingApp.keyPressed(this);
	}

	@Override
	public void mousePressed() {
		processingApp.mousePressed(this);
	}
	
	public static void main(String[] args) {
		//processingApp = new GameOfLifeDisplay();
		//processingApp = new DLA();
		//processingApp = new DLAVariation1();
		//processingApp = new DLAVariation2();
		
		//processingApp = new ControlGUIApp(); 
		//processingApp = new SolarSystemApp(); 
		//processingApp = new ParticleSystemApp();
		//processingApp = new FallingBodyApp();
		//processingApp = new BoidApp();
		//processingApp = new FlockTestApp();
		//processingApp = new ReynoldsTestApp();
		
		//Todos os exercícios estão a partir daqui
		//processingApp = new SolarSystem();
		//processingApp = new ParticleSystemApp();
		//processingApp = new TP2_AgentesAutonamos_ComportamentosIndividuais_App();
		PApplet.main(ProcessingSetup.class);
	}
}

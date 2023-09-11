package ca;

import java.security.Key;

import processing.core.PApplet;
import processing.event.KeyEvent;
import setup.IProcessingApp;
import setup.ProcessingSetup;

public class JogoDaVida implements IProcessingApp{

	MyCellularAutomata ca;
	MyCellularAutomataMajorityRule cb;

	private int nRows = 30;
	private int nCols = 30;
	private int nStates = 2;
	private int radiusNeighbours = 1;
	
	//Game Control Variables
	private boolean isRunning;
	
	private float updateTime = 0.95f;
	private float timeWhenUpdated = 0;
	private float currentTime = 0;
	
	
	@Override
	public void setup(PApplet parent) {
		//Isto serve para evitar que o utilizador insira um n�mero de linhas e de colunas menor que 20.
		//20 � o n�mero que considero ideal para este projecto.
		if(nRows <= 20)
		{
			nRows = 20;
		}
		
		if(nCols <= 20)
		{
			nCols = 20;
		}
		
		ca = new MyCellularAutomata(parent, nRows, nCols, nStates, radiusNeighbours);
		cb = new MyCellularAutomataMajorityRule(parent, nRows, nCols, nStates, radiusNeighbours);
		
		System.out.println("|||| Instru��es ||||");
		System.out.println("Activar e Desactivar as c�lulas � efectuado com o lado esquerdo do rato");
		System.out.println("Existem alguns padr�es pr�-definidos que pode aceder com os n�meros de 1 a 4");
		System.out.println("1 - Blinker | 2 - Major Blinker");
		System.out.println("3 - Heart   | 4 - Flower");
		System.out.println("Para come�ar as itera��es, pressionar barra de espa�os");
		System.out.println("Se quiser parar ou resumir as itera��es, pressionar barra de espa�os novamente");	
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.background(128);
		parent.noStroke();
		
		currentTime = dt;
		
		if(isRunning)
		{
			if(currentTime - timeWhenUpdated >= updateTime)
			{
				timeWhenUpdated = currentTime;
				ca.SetNextState();
			}
		}
		
		ca.Display(parent);
	}

	@Override
	public void keyPressed(PApplet parent) {
		switch(parent.key)
		{
			case ' ':
				if(!isRunning)
				{
					isRunning = true;
					timeWhenUpdated = currentTime;
				}
				else
				{
					isRunning = false;
				}
				break;
				
			case 'r':
				isRunning = false;
				ca.RestartCells();
				break;
				
			case '1':
				if(!isRunning) 
				{
					ca.RestartCells();
					ca.SetBlinker(nRows, nCols);
				}
				break;
				
			case '2':
				if(!isRunning)
				{
					ca.RestartCells();
					ca.SetMajorBlinker(nRows, nCols);
				}
				break;
				
			case '3':
				if(!isRunning)
				{
					ca.RestartCells();
					ca.SetHeart(nRows, nCols);
				}
				break;
				
			case '4':
				if(!isRunning)
				{
					ca.RestartCells();
					ca.SetFlower(nRows, nCols);
				}
				break;
			
			case 'q':
				if(!isRunning)
				{
					ca.RestartCells();
					ca.SetNextMode();
				}
				break;
				
			default:
				break;
		}
	}

	@Override
	public void mousePressed(PApplet parent) {
		
		if(!isRunning)
		{
			MyCell cell = ca.PixelTooCell(parent.mouseX, parent.mouseY);

			if(cell.GetState() == 0)
			{
				cell.SetState(1);
			}
			else
			{
				cell.SetState(0);
			}
			
			ca.SetNextState(cell);
		}
	}
}
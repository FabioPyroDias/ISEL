package codigoAulas;

import processing.core.PApplet;
import setup.IProcessingApp;
import setup.ProcessingSetup;

public class Grelha implements IProcessingApp{

	private AulasCelula[] grelha;

	private boolean hasStarted;
	
	private float betweenInteractionsTimeDuration;
	
	private float timerBetweenInteractions;
	
	private float timeWhenKeyWasPressed;
	
	private int GetRules(int estadoLeft, int estadoCurrent, int estadoDireita)
	{
		
		if(estadoLeft == 0 && estadoCurrent == 0 && estadoDireita == 0)
		{
			return 0;
		}
		else if(estadoLeft == 0 && estadoCurrent == 0 && estadoDireita == 1) 
		{
			return 1;
		}
		else if(estadoLeft == 0 && estadoCurrent == 1 && estadoDireita == 0)
		{
			return 1;
		}
		else if(estadoLeft == 0 && estadoCurrent == 1 && estadoDireita == 1)
		{
			return 1;
		}
		else if(estadoLeft == 1 && estadoCurrent == 0 && estadoCurrent == 0)
		{
			return 1;
		}
		else if(estadoLeft == 1 && estadoCurrent == 0 && estadoDireita == 1)
		{
			return 0;
		}
		else if(estadoLeft == 1 && estadoCurrent == 1 && estadoDireita == 0)
		{
			return 0;
		}
		else 
		{
			return 0;
		}
	}

	private void CreateGrelha(int size)
	{		
		if(size == 1) {
			return;
		}
		
		grelha = new AulasCelula[size];
		
		for(int slot = 1; slot < size - 1; slot++) {
			grelha[slot] = new AulasCelula();
		}
	}
	
	private void DrawCelularAutomata(PApplet parent) {
		for(int slot = 0; slot < grelha.length; slot++)
		{
			if(slot == 0 || slot == grelha.length - 1)
			{
				parent.fill(128);
			}
			else if(grelha[slot] != null)
			{
				if(grelha[slot].GetEstado() == 0) 
				{
					parent.fill(255);
				}
				else 
				{
					parent.fill(0);
				}	
			}
			
			parent.rect(20 + slot*50, 20, 50, 100);
		}
	}
	
	private void NextState()
	{
		AulasCelula[] novaGrelha = new AulasCelula[10];
		
		for(int slot = 1; slot < novaGrelha.length - 1; slot++) {
			novaGrelha[slot] = new AulasCelula();
		}
		
		for(int slot = 1; slot < novaGrelha.length - 1; slot++) {
				if(slot == 1) {
					novaGrelha[slot].SetEstado(GetRules(1, grelha[slot].GetEstado(), grelha[slot+1].GetEstado()));
				}
				else if(slot == novaGrelha.length - 2)
				{
					novaGrelha[slot].SetEstado(GetRules(grelha[slot-1].GetEstado(), grelha[slot].GetEstado(), 1));
				}
				else
				{
					novaGrelha[slot].SetEstado(GetRules(grelha[slot-1].GetEstado(), grelha[slot].GetEstado(), grelha[slot+1].GetEstado()));
				}
		}
		
		grelha = novaGrelha;
	}
	
	private void ForceActivateCell(int size) {
		grelha[size/2].SetEstado(1);
	}
	
	@Override
	public void setup(PApplet parent) {
		//Flag a indicar se o processo já começou
		hasStarted = false;
		
		//Definir o tempo entre interacções e o timer desse mesmo tempo
		betweenInteractionsTimeDuration = 2f;
		timerBetweenInteractions = 0;
		timeWhenKeyWasPressed = 0;
		
		//Criar Grelha
		CreateGrelha(10);
		
		//Mudar cor de Background
		parent.background(255);
	}

	@Override
	public void draw(PApplet parent, float dt) {
		
		if(parent.keyPressed) 
		{
			if(parent.key == ' ') 
			{
				if(hasStarted && (timerBetweenInteractions - timeWhenKeyWasPressed) >= betweenInteractionsTimeDuration)
				{
					NextState();
					timeWhenKeyWasPressed = dt;
				}
				else if(!hasStarted)
				{
					ForceActivateCell(grelha.length);
					hasStarted = true;
					timeWhenKeyWasPressed = dt;
				}
			}
		}
		
		if(hasStarted) 
		{
			timerBetweenInteractions = dt;
		}
		
		DrawCelularAutomata(parent);
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
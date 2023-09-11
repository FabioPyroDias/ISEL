package ca;

import processing.core.PApplet;
import setup.IProcessingApp;

public class TestCA implements IProcessingApp{

	CellularAutomata ca;
	
	private int nRows = 15;
	private int nCols = 20;
	private int nStates = 4;
	private int radiusNeighbours = 1;
	
	@Override
	public void setup(PApplet parent) {
		ca = new CellularAutomata(parent, nRows, nCols, nStates, radiusNeighbours);
		ca.InitRandom();
	}

	@Override
	public void draw(PApplet parent, float dt) {
		ca.Display(parent);
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(PApplet parent) {
			Cell cell = ca.PixelTooCell(parent.mouseX, parent.mouseY);

			Cell[] neighbours = cell.GetNeighbours();
			
			for(int neighbour = 0; neighbour < neighbours.length; neighbour++)
			{
				neighbours[neighbour].SetState(nStates - 1);
			}
	}

}

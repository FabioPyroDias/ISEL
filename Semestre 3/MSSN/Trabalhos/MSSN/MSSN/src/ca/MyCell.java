package ca;

import processing.core.PApplet;

public class MyCell {
	private int row, col;
	private int state;
	private MyCell[] neighbours;
	
	private MyCellularAutomata ca;
	
	public MyCell(MyCellularAutomata ca, int row, int col) 
	{
		this.ca = ca;
		this.row = row;
		this.col = col;
		this.state = 0;
		this.neighbours = null;
	}
	
	public void SetNeighbours(MyCell[] neighbours)
	{
		this.neighbours = neighbours;
	}
	
	public MyCell[] GetNeighbours() 
	{
		return neighbours;
	}
	
	public void SetState(int state) 
	{
		this.state = state;
	}
	
	public int GetState() 
	{
		return state;
	}
	
	public void Display(PApplet app) 
	{
		//Isto é rectângulos. Quero circulos.
		app.fill(ca.GetStateColors()[state]);
		//app.rect(col * ca.GetCellWidth(), row * ca.GetCellHeight(), ca.GetCellWidth(), ca.GetCellHeight());
	
		app.ellipse(col * ca.GetCellWidth() + ca.GetCellWidth()/2, row * ca.GetCellHeight() + ca.GetCellHeight()/2, ca.GetCellWidth(), ca.GetCellHeight());
	}
}

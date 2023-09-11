package ca;

import processing.core.PApplet;

public class Cell {
	private int row, col;
	private int state;
	private Cell[] neighbours;
	
	private CellularAutomata ca;
	
	public Cell(CellularAutomata ca, int row, int col) 
	{
		this.ca = ca;
		this.row = row;
		this.col = col;
		this.state = 0;
		this.neighbours = null;
	}
	
	public void SetNeighbours(Cell[] neighbours)
	{
		this.neighbours = neighbours;
	}
	
	public Cell[] GetNeighbours() 
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
		app.fill(ca.GetStateColors()[state]);
		app.rect(col * ca.GetCellWidth(), row * ca.GetCellHeight(), ca.GetCellWidth(), ca.GetCellHeight());
	}
}

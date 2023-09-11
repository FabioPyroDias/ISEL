package ca;

import processing.core.PApplet;

public class CellularAutomata {
	private int nRows;
	private int nCols;
	private int nStates;
	private int radiusNeighbours;
	
	private int[] colors;
	private int cellWidth, cellHeight;
	
	
	private Cell[][] cells;
	
	
	public CellularAutomata(PApplet app, int nRows, int nCols, int nStates, int radiusNeighbours) 
	{
		this.nRows = nRows;
		this.nCols = nCols;
		this.nStates = nStates;
		this.radiusNeighbours = radiusNeighbours;
		
		colors = new int[nStates];
		cellWidth = app.width / nCols;
		cellHeight = app.height/ nRows;
		
		cells = new Cell[nRows][nCols];
		
		CreateCells();
		SetStateColors(app);
	}
	
	public int GetCellWidth() 
	{
		return cellWidth;
	}
	
	public int GetCellHeight()
	{
		return cellHeight;
	}
	
	private void CreateCells() 
	{
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				cells[rows][cols] = new Cell(this, rows, cols);
			}
		}
		
		SetMooreNeighbours();
		
	}
	
	private void SetStateColors(PApplet app) 
	{
		for(int state = 0; state < nStates; state++) {
			colors[state] = app.color(app.random(255), app.random(255), app.random(255));
		}
	}
	
	public int[] GetStateColors() 
	{
		return colors;
	}
	
	public void InitRandom() 
	{
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				cells[rows][cols].SetState((int)((nStates - 1) * Math.random()));
			}
		}
	}
	
	public Cell PixelTooCell(int x, int y)
	{
		int row = y / cellHeight;
		int col = x / cellWidth;
		
		if(row >= nRows)
		{
			row = nRows - 1;
		}
			
		if(col >= nCols)
		{
			col = nCols - 1;
		}
		
		return cells[row][col];
	}
	
	private void SetMooreNeighbours()
	{
		int nNeighbours = (int)Math.pow(2 * radiusNeighbours + 1, 2);
		
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				Cell[] neighbours = new Cell[nNeighbours];
				int neighbourIndex = 0;
				
				for(int horizontalNeighbours = -radiusNeighbours; horizontalNeighbours <= radiusNeighbours; horizontalNeighbours++)
				{
					int row = (rows + horizontalNeighbours + nRows) % nRows;
					
					for(int verticalNeighbours = -radiusNeighbours; verticalNeighbours <= radiusNeighbours; verticalNeighbours++)
					{
						int col = (cols + verticalNeighbours + nCols) % nCols;
						
						neighbours[neighbourIndex++] = cells[row][col];
					}
				}
				
				cells[rows][cols].SetNeighbours(neighbours);
			}
		}
	}
	
	public void Display(PApplet app) 
	{
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				cells[rows][cols].Display(app);
			}
		}
	}
}

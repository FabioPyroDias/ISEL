package ca;

import processing.core.PApplet;

public class MyCellularAutomata {
	private int nRows;
	private int nCols;
	private int nStates;
	private int radiusNeighbours;
	
	private int mode;
	
	private int[] colors;
	private int cellWidth, cellHeight;
	
	private MyCell[][] cells;
	
	public MyCellularAutomata(PApplet app, int nRows, int nCols, int nStates, int radiusNeighbours) 
	{
		this.nRows = nRows;
		this.nCols = nCols;
		this.nStates = nStates;
		this.radiusNeighbours = radiusNeighbours;
		
		colors = new int[nStates];
		cellWidth = app.width / nCols;
		cellHeight = app.height/ nRows;
		
		cells = new MyCell[nRows][nCols];
	
		cells = CreateCells(cells);
		SetMooreNeighbours(cells);
		SetStateColors(app);
		
		mode = 0;
	}
	
	public MyCell[][] CreateCells(MyCell[][] cells)
	{
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				cells[rows][cols] = new MyCell(this, rows, cols);
			}
		}
		
		return cells;
	}
	
	private void SetStateColors(PApplet app) 
	{
		for(int state = 0; state < nStates; state++) {
			colors[state] = app.color(app.random(255), app.random(255), app.random(255));
		}
		
		colors[0] = app.color(0, 0, 0);
		colors[1] = app.color(255, 255, 255);
	}
	
	private void SetMooreNeighbours(MyCell[][] cells)
	{
		int nNeighbours = (int)Math.pow(2 * radiusNeighbours + 1, 2);
		
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				MyCell[] neighbours = new MyCell[nNeighbours];
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
	
	public int[] GetStateColors() 
	{
		return colors;
	}
	
	public int GetCellWidth() 
	{
		return cellWidth;
	}
	
	public int GetCellHeight()
	{
		return cellHeight;
	}
	
	public MyCell PixelTooCell(int x, int y)
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
	
	public void SetNextState()
	{
		MyCell[][] newCells = new MyCell[cells.length][cells[0].length];
		
		newCells = CreateCells(newCells);
		SetMooreNeighbours(newCells);
		
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				newCells[rows][cols].SetState(cells[rows][cols].GetState());
			}
		}
		
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				MyCell[] neighbourCells = cells[rows][cols].GetNeighbours();
				int sumNeighboursStates = 0;
				
				for(int neighbourCell = 0; neighbourCell < neighbourCells.length; neighbourCell++)
				{
					if(neighbourCells[neighbourCell].GetState() == 1)
					{
						if(neighbourCells[neighbourCell] != cells[rows][cols])
						{
							sumNeighboursStates++;							
						}
					}
				}
	
				if(mode == 0)
				{				
					if(sumNeighboursStates < 2)
					{
						newCells[rows][cols].SetState(0);
					}
					else if(sumNeighboursStates == 3)
					{
						newCells[rows][cols].SetState(1);
					}
					else if(sumNeighboursStates > 3)
					{
						newCells[rows][cols].SetState(0);
					}
				}
				else 
				{
					if(sumNeighboursStates < 2)
					{
						newCells[rows][cols].SetState(0);
					}
					else if(sumNeighboursStates == 3 || sumNeighboursStates == 6)
					{
						newCells[rows][cols].SetState(1);
					}
					else if(sumNeighboursStates > 3)
					{
						newCells[rows][cols].SetState(0);
					}
				}
			}
		}
		
		cells = newCells;
	}
	
	public void SetNextState(MyCell cell)
	{
		MyCell[] neighbourCells = cell.GetNeighbours();
		int sumNeighboursStates = 0;
		
		for(int neighbourCell = 0; neighbourCell < neighbourCells.length; neighbourCell++)
		{
			if(neighbourCells[neighbourCell].GetState() == 1)
			{
				if(neighbourCells[neighbourCell] != cell)
				{
					sumNeighboursStates++;
				}
			}
		}
	}
	
	public void RestartCells()
	{
		for(int rows = 0; rows < nRows; rows++)
		{
			for(int cols = 0; cols < nCols; cols++)
			{
				cells[rows][cols].SetState(0);
			}
		}
	}
	
	//Padrões Pré-Definidos por mim
	public void SetBlinker(int nRows, int nCols)
	{		
		int centerPositionRows = nRows/2;
		int centerPositionCols = nCols/2;
		
		cells[centerPositionRows][centerPositionCols].SetState(1);
		cells[centerPositionRows][centerPositionCols-1].SetState(1);
		cells[centerPositionRows][centerPositionCols+1].SetState(1);
		cells[centerPositionRows-1][centerPositionCols].SetState(1);
		cells[centerPositionRows+1][centerPositionCols].SetState(1);
	}
	
	public void SetMajorBlinker(int nRows, int nCols)
	{
		int centerPositionRows = nRows/2;
		int centerPositionCols = nCols/2;
		
		cells[centerPositionRows-1][centerPositionCols].SetState(1);
		cells[centerPositionRows-1][centerPositionCols-2].SetState(1);
		cells[centerPositionRows-1][centerPositionCols+2].SetState(1);
		cells[centerPositionRows][centerPositionCols-3].SetState(1);
		cells[centerPositionRows][centerPositionCols-1].SetState(1);
		cells[centerPositionRows][centerPositionCols+1].SetState(1);
		cells[centerPositionRows][centerPositionCols+3].SetState(1);
		cells[centerPositionRows+1][centerPositionCols].SetState(1);
		cells[centerPositionRows+1][centerPositionCols-2].SetState(1);
		cells[centerPositionRows+1][centerPositionCols+2].SetState(1);
		
	}
	
	public void SetHeart(int nRows, int nCols)
	{
		int centerPositionRows = nRows/2;
		int centerPositionCols = nCols/2;
		
		cells[centerPositionRows][centerPositionCols].SetState(1);
		cells[centerPositionRows][centerPositionCols-1].SetState(1);
		cells[centerPositionRows][centerPositionCols+1].SetState(1);
		cells[centerPositionRows-1][centerPositionCols-1].SetState(1);
		cells[centerPositionRows-1][centerPositionCols+1].SetState(1);
		cells[centerPositionRows+1][centerPositionCols].SetState(1);
	}
	
	public void SetFlower(int nRows, int nCols)
	{
		int centerPositionRows = nRows/2;
		int centerPositionCols = nCols/2;
		
		cells[centerPositionRows-2][centerPositionCols-1].SetState(1);
		cells[centerPositionRows-2][centerPositionCols+1].SetState(1);
		cells[centerPositionRows-1][centerPositionCols].SetState(1);
		cells[centerPositionRows][centerPositionCols-1].SetState(1);
		cells[centerPositionRows][centerPositionCols+1].SetState(1);
		cells[centerPositionRows+1][centerPositionCols].SetState(1);
		cells[centerPositionRows+2][centerPositionCols-1].SetState(1);
		cells[centerPositionRows+2][centerPositionCols+1].SetState(1);
	}
	
	public void SetNextMode()
	{
		mode += 1;
		
		if(mode > 1)
		{
			mode = 0;
		}
		
		if(mode == 0)
		{
			System.out.println();
			System.out.println("Current mode: 23/3");
			System.out.println("Os padrões pré-definidos são agora, de 1 a 4:");
			System.out.println("1 - Blinker | 2 - Major Blinker");
			System.out.println("3 - Heart   | 4 - Flower");
		}
		else
		{
			System.out.println();
			System.out.println("Current mode: 23/36");
			System.out.println("Os padrões pré-definidos são agora, de 1 a 4:");
			System.out.println("1 - Por fazer | 2 - Por fazer");
			System.out.println("3 - Por fazer   | 4 - Por fazer");
		}
	}
}
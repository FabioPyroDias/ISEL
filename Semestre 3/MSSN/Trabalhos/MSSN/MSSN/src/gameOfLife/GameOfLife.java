package gameOfLife;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;

public class GameOfLife {

	private int nRows;
	private int nCols;
	private int nStates;
	private int radiusNeigh;

	private GameCell[][] a_cells;

	private int[] a_colors;

	private int cellWidth, cellHeight;

	private PApplet p;

	private boolean setAsColor = false;
	private boolean setPsy = false;

	private GameOfLifeRules gameRules;
	private BoardType type;

	private boolean isMajorityRule = false;
	
	public enum BoardType {
		COLOR, VOID, PSYCHEDELIC
	}

	public enum GameOfLifeRules {
		R_23_3, R_23_36, MAJORITY_RULE
	}

	public enum BoardSize {
		SMALL, MEDIUM, BIG
	}


	
	public GameOfLife(PApplet p, BoardSize size, BoardType type, int radiusNeigh, boolean isMajorityRule) {
		this.isMajorityRule = isMajorityRule;
		this.p = p;
		
		this.gameRules = isMajorityRule ? GameOfLifeRules.MAJORITY_RULE : type == BoardType.PSYCHEDELIC ? GameOfLifeRules.R_23_36 : GameOfLifeRules.R_23_3;
		
		System.out.println("Initial Game of Life Rule Set to: " + this.gameRules.toString());
		
		this.type = isMajorityRule ? BoardType.VOID : type;
		switch (size) {
			case SMALL:
				this.nRows = 15;
				this.nCols = 15;
				break;
			case MEDIUM:
				this.nRows = 35;
				this.nCols = 35;
				break;
			case BIG:
				this.nRows = 100;
				this.nCols = 100;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + size);
		}

		this.radiusNeigh = radiusNeigh;
		this.a_cells = new GameCell[nRows][nCols];

		this.cellWidth = p.width / nCols;
		this.cellHeight = p.height / nRows;

		if (type == BoardType.PSYCHEDELIC) {
			this.nStates = 13;
		} else {
			this.nStates = 2;
		}
		this.a_colors = new int[nStates];

		createCells();

		switch (type) {
		case COLOR:
			setStateColors(setAsColor = true, setPsy = false);
			break;
		case VOID:
			setStateColors(setAsColor = false, setPsy = false);
			break;
		case PSYCHEDELIC:
			setStateColors(setAsColor = true, setPsy = true);
			break;
		}
		
		if(isMajorityRule) {
			initRandom();
		} else {
			GenerateShapes();
		}
	}

	private void createCells() {

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				a_cells[i][j] = new GameCell(this, p, i, j);
			}
		}
		setMooreNeighbors();
	}

	private void setMooreNeighbors() {

		int nNeigh = (int) Math.pow(2 * radiusNeigh + 1, 2);

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				GameCell[] neigh = new GameCell[nNeigh];
				int n = 0;
				for (int ii = -radiusNeigh; ii <= radiusNeigh; ii++) {
					int row = (i + ii + nRows) % nRows; // Circular
					for (int jj = -radiusNeigh; jj <= radiusNeigh; jj++) {
						int col = (j + jj + nCols) % nCols;
						neigh[n++] = a_cells[row][col];
					}
				}
				a_cells[i][j].setNeighbors(neigh);
			}
		}

	}

	private void setStateColors(boolean setColor, boolean psy) {
		if (setColor && !psy) {
			for (int i = 0; i < nStates; i++) {
				a_colors[i] = p.color(p.random(255), p.random(255), p.random(255));
			}
		} else if (!setColor && !psy) {
			a_colors[0] = p.color(0);
			a_colors[1] = p.color(255);
		} else if (setColor && psy) {
			a_colors[0] = p.color(0);
			for (int i = 1; i < nStates; i++) {
				a_colors[i] = p.color(p.random(255), p.random(255), p.random(255));
			}
		}
	}

	public int[] getStateColors() {
		return this.a_colors;
	}

	public int getColor() {
		return this.a_colors[(int) ((nStates) * Math.random())];
	}

	public void initRandom() {
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				a_cells[i][j].setState((int) ((nStates) * Math.random()));
			}
		}
	}

	public int getCellWidth() {
		return this.cellWidth;
	}

	public int getCellHeight() {
		return this.cellHeight;
	}

	public void display(PApplet p) {
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				a_cells[i][j].display();
			}
		}
	}

	public void resetBoard() {
		this.a_cells = new GameCell[this.nRows][this.nCols];
		this.a_colors = new int[this.nStates];
		createCells();
		setStateColors(setAsColor, setPsy);
		if(isMajorityRule) {
			initRandom();
		}
	}

	public GameCell pixel2Cell(int x, int y) {

		int row = y / cellHeight;
		int col = x / cellWidth;

		if (row >= nRows)
			row = nRows - 1;
		if (col >= nCols)
			col = nCols - 1;

		return a_cells[row][col];

	}
	
	public void ChangeGameOfLifeRules() {
		if(this.gameRules == GameOfLifeRules.R_23_3) {
			this.gameRules = GameOfLifeRules.R_23_36;
			return;
		}
		if(this.gameRules == GameOfLifeRules.R_23_36) {
			this.gameRules = GameOfLifeRules.R_23_3;
			return;
		}
	}
	
	public String GetGameRules() {
		return this.gameRules.toString();
	}
	

	public void setNextState() {
		GameCell[][] a_temp = new GameCell[nRows][nCols];

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				a_temp[i][j] = new GameCell(this, p, i, j);
				a_temp[i][j].setState(a_cells[i][j].getState());
			}
		}
		
		switch (gameRules) {
			case R_23_3:
				for (int i = 0; i < nRows; i++) {
					for (int j = 0; j < nCols; j++) {
						boolean isCellAlive = a_cells[i][j].getState() > 0 ? true : false;
						int neighbours = a_cells[i][j].getNeighborsCount(isCellAlive);
						
						// Primeira condição: A célula está morta, ou renasce ou permanece morta
						if(!isCellAlive) {
							// Se tiver 3 vizinhos, nasce
							if(neighbours == 3) {
								if(this.type == BoardType.PSYCHEDELIC) {
									a_temp[i][j].setState(new Random().nextInt((nStates - 1)) + 1);
								} else {
									a_temp[i][j].setState(1);
								}
							}
						}
						
						// Segunda Condição: A Célula está viva, ou permanece viva ou morre
						if(isCellAlive) {
							// Célula Morre caso exista menos de dois vizinhos ou mais de 3 vizinhos
							if(neighbours < 2 || neighbours > 3) {
								a_temp[i][j].setState(0);
							}
						}
					}
				}
				break;
			case R_23_36:
				for (int i = 0; i < nRows; i++) {
					for (int j = 0; j < nCols; j++) {
						boolean isCellAlive = a_cells[i][j].getState() > 0 ? true : false;
						int neighbours = a_cells[i][j].getNeighborsCount(isCellAlive);
						
						// Primeira Condição: A Célula está morta e é para renascer ou permanecer morta
						if(!isCellAlive) {
							// Se tiver 3 ou 6 vizinhos nasce
							if(neighbours == 3 || neighbours == 6) {
								if(this.type == BoardType.PSYCHEDELIC) {	 // Pyschedelic mode
									a_temp[i][j].setState(new Random().nextInt((nStates -1)) + 1);
								} else {
									a_temp[i][j].setState(1);
								}
							}
						}
						
						// Segunda Condição: A célula está viva e é para continuar viva ou morrer
						if(isCellAlive) {
							// Se tiver 2 ou 3 vizinhos sobrevivem
							if(neighbours == 2 || neighbours == 3) {
								// continue
							}
							// Se tiverem menos de 2 ou mais que 3 morrem
							if(neighbours < 2 || neighbours > 3) {
								a_temp[i][j].setState(0);
							}
						}
					}
				}
				break;
			case MAJORITY_RULE:
				for(int i = 0; i < nRows; i++) {
					for(int j = 0; j < nCols ; j++) {
						
						boolean isCellAlive = a_cells[i][j].getState() > 0 ? true : false;
						int neighbours = a_cells[i][j].getNeighborsCount(isCellAlive);
						
						// Se existir maioria viva
						if(neighbours >= (isCellAlive ? 4 : 5)) {
							a_temp[i][j].setState(1);
						} else if(neighbours == 4) {
							// Continue
						} else {
							a_temp[i][j].setState(0);
						}
					}
				}
				break;
		}

		a_cells = a_temp;
		setMooreNeighbors();
	}

	private int shapeIndex = 0;
	private List<GameCell[][]> shape = new ArrayList<GameCell[][]>();

	private void GenerateShapes() {
	
		// Add empty List (0 - index)
		shape.add(a_cells);

		// Clear a_cells
		resetBoard();

		// The Replicator
		int gridCentralRow = nRows / 2;
		int gridCentralCol = nCols / 2;

		a_cells[gridCentralRow][gridCentralCol].setState(0);
		a_cells[gridCentralRow][gridCentralCol + 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol - 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 1][gridCentralCol + 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 1][gridCentralCol - 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 2][gridCentralCol].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 2][gridCentralCol + 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 2][gridCentralCol + 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);

		a_cells[gridCentralRow + 1][gridCentralCol + 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow + 1][gridCentralCol - 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow + 2][gridCentralCol].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow + 2][gridCentralCol - 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow + 2][gridCentralCol - 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);

		shape.add(a_cells);

		// Clear a_cells
		resetBoard();

		// The Blinker
		a_cells[gridCentralRow][gridCentralCol].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol + 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol - 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);

		shape.add(a_cells);

		// Clear a_cells
		resetBoard();

		// The Glider
		a_cells[gridCentralRow][gridCentralCol - 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 1][gridCentralCol - 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 1][gridCentralCol].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow - 1][gridCentralCol + 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow + 1][gridCentralCol].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);

		shape.add(a_cells);

		// Clear a_cells
		resetBoard();

		// The mouth
		a_cells[gridCentralRow][gridCentralCol].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol + 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol + 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol + 3].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol - 1].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol - 2].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);
		a_cells[gridCentralRow][gridCentralCol - 3].setState(type == BoardType.PSYCHEDELIC ? new Random().nextInt((nStates -1)) + 1 : 1);

		shape.add(a_cells);

		// Clear a_cells
		resetBoard();

	}

	public void SetShape() {
		shapeIndex = (shapeIndex + 1) % shape.size();

		switch (shapeIndex) {
		case 0:
			System.out.println("Empty Grid");
			break;
		case 1:
			System.out.println("The Replicator");
			break;
		case 2:
			System.out.println("Blinker");
			break;
		case 3:
			System.out.println("The Glider");
			break;
		case 4:
			System.out.println("The Mouth");
			break;
		}

		a_cells = shape.get(shapeIndex);
		setMooreNeighbors();
	}

}

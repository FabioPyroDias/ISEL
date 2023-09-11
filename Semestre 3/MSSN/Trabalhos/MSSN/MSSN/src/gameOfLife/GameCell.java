package gameOfLife;

import processing.core.PApplet;
import processing.core.PVector;

public class GameCell {

	public enum State {
		ALIVE, DEAD
	}

	private PVector cellPos; // Sets the cell position in the world
	private int state; // Sets the current state of the cell
	private int color; // Sets the cell color
	private GameCell[] neighbors; // Reference to the neighbors

	private int row, col;

	private PApplet p;

	private GameOfLife ga;

	public GameCell(GameOfLife ga, PApplet parent, int row, int col) {
		this.ga = ga;
		this.p = parent;
		this.neighbors = null;
		this.row = row;
		this.col = col;
		this.cellPos = new PVector(row, col);
		this.state = 0;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
	}

	public void setNeighbors(GameCell[] neigh) {
		this.neighbors = neigh;
	}

	public GameCell[] getNeighbors() {
		return this.neighbors;
	}

	public int getNeighborsCount(boolean isAlive) {
		int counter = isAlive ? -1 : 0;
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i].getState() >= 1) {
				counter++;
			}
		}
		return counter;
	}

	public void display() {
		this.p.fill(ga.getStateColors()[state]);
		this.p.rect(cellPos.y * ga.getCellWidth(), cellPos.x * ga.getCellHeight(), ga.getCellWidth(),
				ga.getCellHeight());
	}

}
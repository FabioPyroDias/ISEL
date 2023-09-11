package gameOfLife;

import gameOfLife.GameOfLife.BoardType;

import gameOfLife.GameOfLife.BoardSize;
import setup.IProcessingApp;
import processing.core.PApplet;

public class GameOfLifeDisplay implements IProcessingApp {

	private int radiusNeigh = 1;
	private GameOfLife gl;

	private boolean isRunning = false;
	private boolean isMenu = true;

	// Menu

	int h_center;
	int v_center;

	@Override
	public void setup(PApplet parent) {
		parent.frameRate(10);
		// gl = new GameOfLife(parent, BoardSize.BIG, BoardType.VOID, radiusNeigh,
		// false);
		// gl.display(parent);

		String displayInputs = "Bem vindos! \n" + "Comandos (teclas): \n"
				+ " - Para correr automáticamente: Barra de Espaços; \n"
				+ " - Para Iterar uma vez: Tecla 'B' \n"
				+ " - Para Reiniciar: Tecla 'R' \n" + " - Para desenhar uma 'Shape': Tecla 'E' \n"
				+ " - Para mudar o tipo de Regra: Tecla 'T'";

		System.out.println(displayInputs);

		this.h_center = parent.width / 2;
		this.v_center = parent.height / 2;

		drawMenu(parent);

	}

	@Override
	public void draw(PApplet parent, float dt) {
		if (isRunning) {
			gl.display(parent);
			gl.setNextState();
		}
		if (isMenu) {
			drawMenu(parent);
		}
	}

	@Override
	public void keyPressed(PApplet parent) {
		if (!isMenu) {
			if (parent.keyPressed) {
				if (parent.key == ' ') { // Plays the Project
					isRunning = !isRunning;
					System.out.println("System Running: " + isRunning);
					gl.display(parent);

				}
				if (parent.key == 'r' || parent.key == 'R') {
					if (isRunning)
						isRunning = false;
					System.out.println("Restarting Board...");
					gl.resetBoard();
					gl.display(parent);
				}
				if (parent.key == 'b' || parent.key == 'B') {
					System.out.println("Single Iteration");
					gl.setNextState();
					gl.display(parent);
				}
				if (parent.key == 'e' || parent.key == 'E') {
					if (isRunning)
						isRunning = false;
					System.out.print("Drawing Shape: ");
					gl.resetBoard();
					gl.SetShape();
					gl.display(parent);
				}
				if (parent.key == 't' || parent.key == 'T') {
					if (isRunning)
						isRunning = false;
					System.out.println("Changing Game Of Life Rule to: " + gl.GetGameRules());
					gl.ChangeGameOfLifeRules();
					gl.resetBoard();
					gl.display(parent);
				}
			}
		}
	}

	@Override
	public void mousePressed(PApplet parent) {
		if (!isMenu) {
			if (!isRunning) {
				GameCell cell = gl.pixel2Cell(parent.mouseX, parent.mouseY);
				if (cell.getState() == 1) {
					cell.setState(0);
				} else {
					cell.setState(1);
				}

				gl.display(parent);
			}
		} else {
			if (defaultHover) {
				InitializeDefault(parent);
			}

			if (psyHover) {
				InitializePsy(parent);
			}

			if (majorityHover) {
				InitializeMajority(parent);
			}
		}
	}

	void InitializeDefault(PApplet p) {
		if (this.gl != null)
			this.gl = null;
		this.gl = new GameOfLife(p, BoardSize.MEDIUM, BoardType.COLOR, radiusNeigh, false);
		isMenu = false;
		gl.display(p);

	}

	void InitializeMajority(PApplet p) {
		if (this.gl != null)
			this.gl = null;
		this.gl = new GameOfLife(p, BoardSize.BIG, BoardType.VOID, radiusNeigh, true);
		isMenu = false;
		gl.display(p);
	}

	void InitializePsy(PApplet p) {
		if (this.gl != null)
			this.gl = null;
		this.gl = new GameOfLife(p, BoardSize.BIG, BoardType.PSYCHEDELIC, radiusNeigh, false);
		isMenu = false;
		gl.display(p);
	}

	private boolean defaultHover = false;
	private boolean psyHover = false;
	private boolean majorityHover = false;

	void drawMenu(PApplet p) {

		// Title \\
		p.textSize(45);
		p.textAlign(p.CENTER);
		p.fill(0, 408, 900);
		p.text("Game Of Life", h_center, v_center / 2);

		// Title (end) \\

		// Menu \\
		p.textSize(25);

		if ((p.mouseX >= 250 && p.mouseX <= 350) && (p.mouseY >= 200 && p.mouseY <= 225)) {
			defaultHover = true;
			p.fill(255);
			p.text("DEFAULT", h_center, v_center - 75);
		} else {
			defaultHover = false;
			p.fill(0);
			p.text("DEFAULT", h_center, v_center - 75);
		}

		if ((p.mouseX >= 228 && p.mouseX <= 370) && (p.mouseY >= 255 && p.mouseY <= 275)) {
			psyHover = true;
			p.fill(255);
			p.text("PSYCHEDELIC", h_center, v_center - 25);
		} else {
			psyHover = false;
			p.fill(0);
			p.text("PSYCHEDELIC", h_center, v_center - 25);
		}

		if ((p.mouseX >= 210 && p.mouseX <= 385) && (p.mouseY >= 300 && p.mouseY <= 325)) {
			majorityHover = true;
			p.fill(255);
			p.text("MAJORITY RULE", h_center, v_center + 25);
		} else {
			majorityHover = false;
			p.fill(0);
			p.text("MAJORITY RULE", h_center, v_center + 25);
		}

	}

}

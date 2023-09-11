package bookcode.p07Arrays;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
 * simple frame that draws an house. Resize the frame. The house will remain at the centre.
 */
public class G04HouseFrame extends JFrame {

	// class id
	private static final long serialVersionUID = 1L;

	// base coordinates of the house
	private int xBase = 100;
	private int yBase = 50;

	// arrays of coordinates
	private int[] xHouse = { xBase, xBase, xBase + 50, xBase + 100, xBase + 100 };
	private int[] yHouse = { 80 + yBase, 20 + yBase, yBase, 20 + yBase,
			80 + yBase };
	private int[] xDoor = { xBase + 25, xBase + 25, xBase + 50, xBase + 50 };
	private int[] yDoor = { 80 + yBase, 40 + yBase, 40 + yBase, 80 + yBase };
	private int[] xWindow = { xBase + 70, xBase + 70, xBase + 90, xBase + 90 };
	private int[] yWindow = { 40 + yBase, 60 + yBase, 60 + yBase, 40 + yBase };

	/**
	 * init
	 */
	public void init() {
		// set title
		setTitle("...: G04HouseFrame :...");
		// set size
		setSize(800, 300);
		// set location at centre
		setLocationRelativeTo(null);
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// set background colour
		getContentPane().setBackground(Color.WHITE);

		setVisible(true);
	}

	/**
	 * paint
	 */
	public void paint(Graphics canvas) {
		// draw background
		paintComponents(canvas);

		int widthCentre = getWidth() / 2 - 50;
		int heightCentre = getHeight() / 2 - 40;

		adjustCoords(widthCentre, heightCentre);

		canvas.setColor(Color.GREEN);
		canvas.fillPolygon(xHouse, yHouse, xHouse.length);

		canvas.setColor(Color.BLACK);
		canvas.drawPolyline(xDoor, yDoor, xDoor.length);
		canvas.drawPolygon(xWindow, yWindow, xWindow.length);

		canvas.drawString("Home sweet home!", xBase, 100 + yBase);
		System.out.println("paint called...");
	}

	/**
	 * method that will adjust the coordinates
	 */
	private void adjustCoords(int newX, int newY) {

		int deltaX = newX - xBase;
		int deltaY = newY - yBase;

		for (int i = 0; i < xHouse.length; i++) {
			xHouse[i] += deltaX;
		}

		for (int i = 0; i < xDoor.length; i++) {
			xDoor[i] += deltaX;
		}

		for (int i = 0; i < xWindow.length; i++) {
			xWindow[i] += deltaX;
		}

		for (int i = 0; i < yHouse.length; i++) {
			yHouse[i] += deltaY;
		}

		for (int i = 0; i < yDoor.length; i++) {
			yDoor[i] += deltaY;
		}

		for (int i = 0; i < yWindow.length; i++) {
			yWindow[i] += deltaY;
		}

		xBase = newX;
		yBase = newY;

	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create the frame object
				G04HouseFrame app = new G04HouseFrame();
				// initialise it
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

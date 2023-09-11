package bookcode.p05ClassesAndMethods;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * the multiple face now in Jframe
 */
public class G02MultipleFacesFrame extends JFrame {

	// class identifier
	private static final long serialVersionUID = 1L;

	// constants that define the face
	public static final int FRAMECORRECTION = 30;

	public static final int FACE_DIAMETER = 50;
	public static final int X_FACE0 = 10;
	public static final int Y_FACE0 = 5 + FRAMECORRECTION;

	public static final int EYE_WIDTH = 5;
	public static final int EYE_HEIGHT = 10;
	public static final int X_RIGHT_EYE0 = 20;
	public static final int Y_RIGHT_EYE0 = 15 + FRAMECORRECTION;
	public static final int X_LEFT_EYE0 = 45;
	public static final int Y_LEFT_EYE0 = Y_RIGHT_EYE0;

	public static final int NOSE_DIAMETER = 5;
	public static final int X_NOSE0 = 32;
	public static final int Y_NOSE0 = 25 + FRAMECORRECTION;

	public static final int MOUTH_WIDTH = 30;
	public static final int MOUTH_HEIGHT0 = 0;
	public static final int X_MOUTH0 = 20;
	public static final int Y_MOUTH0 = 35 + FRAMECORRECTION;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_DEGREES_SHOWN = 180;

	/**
	 * method used to initialise the elements
	 */
	private void init() {
		// set title
		setTitle("...: G02MultipleFaces :...");
		// set size
		setSize(450, 300);
		// set location at center
		setLocationRelativeTo(null);
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// setResizable(false);

		setVisible(true);
	}

	/**
	 * g is the drawing area. i is a parameter for the position of the face. As
	 * i increases the face is drawn lower and further to the right.
	 */
	private void drawFaceSansMouth(Graphics g, int i) {
		g.setColor(Color.BLACK);
		g.drawOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER,
				FACE_DIAMETER);
		// Draw eyes:
		g.setColor(Color.BLUE);
		g.fillOval(X_RIGHT_EYE0 + 50 * i, Y_RIGHT_EYE0 + 30 * i, EYE_WIDTH,
				EYE_HEIGHT);
		g.fillOval(X_LEFT_EYE0 + 50 * i, Y_LEFT_EYE0 + 30 * i, EYE_WIDTH,
				EYE_HEIGHT);
		// Draw nose:
		g.setColor(Color.BLACK);
		g.fillOval(X_NOSE0 + 50 * i, Y_NOSE0 + 30 * i, NOSE_DIAMETER,
				NOSE_DIAMETER);
	}

	/**
	 * the paint method
	 */
	public void paint(Graphics canvas) {
		// draw background
		canvas.setColor(Color.white);
		Rectangle clip = canvas.getClipBounds();
		canvas.clearRect(clip.x, clip.y, clip.width, clip.height);

		int i;
		for (i = 0; i < 5; i++) {// Draw one face:
			if (i % 2 == 0)// if i is even
			{// Make face yellow
				canvas.setColor(Color.YELLOW);
				canvas.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i,
						FACE_DIAMETER, FACE_DIAMETER);
			}
			drawFaceSansMouth(canvas, i);
			// Draw mouth:
			canvas.setColor(Color.RED);
			canvas.drawArc(X_MOUTH0 + 50 * i, Y_MOUTH0 + 30 * i, MOUTH_WIDTH,
					MOUTH_HEIGHT0 + 3 * i, MOUTH_START_ANGLE,
					MOUTH_DEGREES_SHOWN);
		}
		// i == 5

		// Draw kissing face:
		drawFaceSansMouth(canvas, i);
		// Draw mouth in shape of a kiss:
		canvas.setColor(Color.RED);
		canvas.fillOval(X_MOUTH0 + 50 * i + 10, Y_MOUTH0 + 30 * i,
				MOUTH_WIDTH - 20, MOUTH_WIDTH - 20);
		// Add text:
		canvas.setColor(Color.BLACK);
		canvas.drawString("Kiss, Kiss.", X_FACE0 + 50 * i + FACE_DIAMETER,
				Y_FACE0 + 30 * i);

		// Draw blushing face:
		i++;
		// Draw face circle:
		canvas.setColor(Color.PINK);
		canvas.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER,
				FACE_DIAMETER);
		drawFaceSansMouth(canvas, i);
		// Draw mouth:
		canvas.setColor(Color.RED);
		canvas.drawArc(X_MOUTH0 + 50 * i, Y_MOUTH0 + 30 * i, MOUTH_WIDTH,
				MOUTH_HEIGHT0 + 3 * 4,// i == 4 is the smile
				MOUTH_START_ANGLE, MOUTH_DEGREES_SHOWN);
		// Add text:
		canvas.setColor(Color.BLACK);
		canvas.drawString("Tee Hee.", X_FACE0 + 50 * i + FACE_DIAMETER, Y_FACE0
				+ 30 * i);
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// this is necessary
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// here goes the runnable code
				// create a multipleFaces object
				G02MultipleFacesFrame app = new G02MultipleFacesFrame();

				// init it
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}
package bookcode.p04FlowCycles;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */
public class G01MultipleFaces extends JFrame {
	// class identifier
	private static final long serialVersionUID = 1L;

	// constants that define the face
	public static final int FACE_DIAMETER = 50;
	public static final int X_FACE0 = 10;
	public static final int Y_FACE0 = 5;

	public static final int EYE_WIDTH = 5;
	public static final int EYE_HEIGHT = 10;
	public static final int X_RIGHT_EYE0 = 20;
	public static final int Y_RIGHT_EYE0 = 15;
	public static final int X_LEFT_EYE0 = 45;
	public static final int Y_LEFT_EYE0 = Y_RIGHT_EYE0;

	public static final int NOSE_DIAMETER = 5;
	public static final int X_NOSE0 = 32;
	public static final int Y_NOSE0 = 25;

	public static final int MOUTH_WIDTH = 30;
	public static final int MOUTH_HEIGHT0 = 0;
	public static final int X_MOUTH0 = 20;
	public static final int Y_MOUTH0 = 35;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_DEGREES_SHOWN = 180;

	class MyJPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics canvas) {

			// draw 5 smiling faces
			for (int i = 0; i < 5; i++) {

				if (i % 2 == 0) {
					// // if i is even make face yellow
					canvas.setColor(Color.YELLOW);
					canvas.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER, FACE_DIAMETER);
				}

				canvas.setColor(Color.BLACK);
				canvas.drawOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER, FACE_DIAMETER);

				// Draw eyes:
				canvas.setColor(Color.BLUE);
				canvas.fillOval(X_RIGHT_EYE0 + 50 * i, Y_RIGHT_EYE0 + 30 * i, EYE_WIDTH, EYE_HEIGHT);
				canvas.fillOval(X_LEFT_EYE0 + 50 * i, Y_LEFT_EYE0 + 30 * i, EYE_WIDTH, EYE_HEIGHT);

				// Draw nose:
				canvas.setColor(Color.BLACK);
				canvas.fillOval(X_NOSE0 + 50 * i, Y_NOSE0 + 30 * i, NOSE_DIAMETER, NOSE_DIAMETER);

				// Draw mouth:
				canvas.setColor(Color.RED);
				canvas.drawArc(X_MOUTH0 + 50 * i, Y_MOUTH0 + 30 * i, MOUTH_WIDTH, MOUTH_HEIGHT0 + 3 * i,
						MOUTH_START_ANGLE, MOUTH_DEGREES_SHOWN);
			}

			int i = 5;

			// Draw green kissing face:
			// draw face colour
			canvas.setColor(Color.green);
			canvas.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER, FACE_DIAMETER);

			// Draw face circle:
			canvas.setColor(Color.BLACK);
			canvas.drawOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER, FACE_DIAMETER);
			// Draw eyes:
			canvas.setColor(Color.BLUE);
			canvas.fillOval(X_RIGHT_EYE0 + 50 * i, Y_RIGHT_EYE0 + 30 * i, EYE_WIDTH, EYE_HEIGHT);
			canvas.fillOval(X_LEFT_EYE0 + 50 * i, Y_LEFT_EYE0 + 30 * i, EYE_WIDTH, EYE_HEIGHT);
			// Draw nose:
			canvas.setColor(Color.BLACK);
			canvas.fillOval(X_NOSE0 + 50 * i, Y_NOSE0 + 30 * i, NOSE_DIAMETER, NOSE_DIAMETER);
			// Draw mouth in shape of a kiss:
			canvas.setColor(Color.RED);
			canvas.fillOval(X_MOUTH0 + 50 * i + 10, Y_MOUTH0 + 30 * i, MOUTH_WIDTH - 20, MOUTH_WIDTH - 20);
			// Add text:
			canvas.drawString("Kiss, Kiss.", X_FACE0 + 50 * i + FACE_DIAMETER, Y_FACE0 + 30 * i);

			// Draw blushing face:
			i++;
			// Draw face circle:
			canvas.setColor(Color.PINK);
			canvas.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER, FACE_DIAMETER);
			canvas.setColor(Color.BLACK);
			canvas.drawOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i, FACE_DIAMETER, FACE_DIAMETER);
			// Draw eyes:
			canvas.setColor(Color.BLUE);
			canvas.fillOval(X_RIGHT_EYE0 + 50 * i, Y_RIGHT_EYE0 + 30 * i, EYE_WIDTH, EYE_HEIGHT);
			canvas.fillOval(X_LEFT_EYE0 + 50 * i, Y_LEFT_EYE0 + 30 * i, EYE_WIDTH, EYE_HEIGHT);
			// Draw nose:
			canvas.setColor(Color.BLACK);
			canvas.fillOval(X_NOSE0 + 50 * i, Y_NOSE0 + 30 * i, NOSE_DIAMETER, NOSE_DIAMETER);
			// Draw mouth:
			canvas.setColor(Color.RED);
			canvas.drawArc(X_MOUTH0 + 50 * i, Y_MOUTH0 + 30 * i, MOUTH_WIDTH, MOUTH_HEIGHT0 + 3 * 4, // i == 4 is the
																										// smile
					MOUTH_START_ANGLE, MOUTH_DEGREES_SHOWN);
			// Add text:
			canvas.drawString("Tee Hee.", X_FACE0 + 50 * i + FACE_DIAMETER, Y_FACE0 + 30 * i);
		}
	}

	// the constructor, the method called at initialization of a new object
	public G01MultipleFaces() {
		add(new MyJPanel());
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create a new object
				G01MultipleFaces guiWindow = new G01MultipleFaces();
				// call the init method on the new object
				guiWindow.setVisible(true);
			}
		});
	}
}

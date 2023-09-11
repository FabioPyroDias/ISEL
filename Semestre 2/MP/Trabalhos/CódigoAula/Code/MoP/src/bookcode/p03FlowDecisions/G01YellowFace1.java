package bookcode.p03FlowDecisions;

import javax.swing.*;

import java.awt.*;

/**
 * The applet yellow face.
 * 
 * After running one time. Go to run configuration and change the parameters
 * width to 400 and height to 300.
 */
public class G01YellowFace1 extends JFrame {

	// Identifier of the class, if you remove this you will see the following
	// warning: "The serializable class G01YellowFace does not declare a static
	// final serialVersionUID field of type long". In that case just left mouse
	// click on the warning symbol and choose one option to generate the serial
	// version ID automatically.
	private static final long serialVersionUID = 1L;

	// the constants to draw the face
	public static final int FACE_DIAMETER = 200;
	public static final int X_FACE = 100;
	public static final int Y_FACE = 50;

	public static final int EYE_WIDTH = 10;
	public static final int EYE_HEIGHT = 20;
	public static final int X_RIGHT_EYE = 155;
	public static final int Y_RIGHT_EYE = 95;
	public static final int X_LEFT_EYE = 230;
	public static final int Y_LEFT_EYE = Y_RIGHT_EYE;

	public static final int NOSE_DIAMETER = 10;
	public static final int X_NOSE = 195;// Center of nose will be at 200
	public static final int Y_NOSE = 135;

	public static final int MOUTH_WIDTH = 100;
	public static final int MOUTH_HEIGHT = 50;
	public static final int X_MOUTH = 150;
	public static final int Y_MOUTH = 175;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_DEGREES_SHOWN = 180;

	public void paint(Graphics canvas) {
		super.paint(canvas);
		// Draw face circle:
		canvas.setColor(Color.YELLOW);
		canvas.fillOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
		canvas.setColor(Color.BLACK);
		canvas.drawOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
		// Draw eyes:
		canvas.setColor(Color.BLUE);
		canvas.fillOval(X_RIGHT_EYE, Y_RIGHT_EYE, EYE_WIDTH, EYE_HEIGHT);
		canvas.fillOval(X_LEFT_EYE, Y_LEFT_EYE, EYE_WIDTH, EYE_HEIGHT);
		// Draw nose:
		canvas.setColor(Color.BLACK);
		canvas.fillOval(X_NOSE, Y_NOSE, NOSE_DIAMETER, NOSE_DIAMETER);
		// Draw mouth:
		canvas.setColor(Color.RED);
		canvas.drawArc(X_MOUTH, Y_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_START_ANGLE, MOUTH_DEGREES_SHOWN);
	}

	// the constructor, the method called at initialization of a new object
	public G01YellowFace1() {
		// add(new MyJPanel());
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
				G01YellowFace1 guiWindow = new G01YellowFace1();
				// call the init method on the new object
				guiWindow.setVisible(true);
			}
		});
	}
}

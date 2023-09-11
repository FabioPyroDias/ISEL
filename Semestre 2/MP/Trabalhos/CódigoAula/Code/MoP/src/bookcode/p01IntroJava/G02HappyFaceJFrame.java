package bookcode.p01IntroJava;

import javax.swing.*;
import java.awt.*;

/**
 * A GUI program in Swing. The class G02HappyFace is a JFrame (because it
 * extends JFrame).
 * 
 * Graphics file: G02
 * 
 */
public class G02HappyFaceJFrame extends JFrame {

	private static final long serialVersionUID = 13317004685475369L;

	/**
	 * Method used to initialize the frame
	 */
	private void init() {
		// set title
		setTitle("...: My first Painting frame :...");
		// set size
		setSize(400, 300);
		// set location at center
		setLocationRelativeTo(null);
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// set not resizable
		setResizable(false);

		// put the frame visible
		setVisible(true);
	}

	/**
	 * method called by swing to paint the component
	 */
	public void paint(Graphics canvas) {
		// draw background
		canvas.setColor(Color.GREEN);
		canvas.fillRect(0, 0, 400, 300);

		// draw happy face
		canvas.setColor(Color.BLACK);
		canvas.drawOval(100, 50, 200, 200);
		canvas.fillOval(155, 100, 10, 20);
		canvas.fillOval(230, 100, 10, 20);
		canvas.drawArc(150, 160, 100, 50, 180, 180);
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create a new G02HappyFace
				G02HappyFaceJFrame app = new G02HappyFaceJFrame();
				// call the init method on it
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

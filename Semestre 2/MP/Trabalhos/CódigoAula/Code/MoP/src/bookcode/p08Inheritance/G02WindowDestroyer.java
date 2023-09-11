package bookcode.p08Inheritance;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * If you register an object of this class as a listener to any object of the
 * class JFrame, the object will end the program and close the JFrame window if
 * the user clicks the window's close-window button.
 */
public class G02WindowDestroyer extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
		// System.exit(0);
		System.out.println("We will dispose the frame...");
		e.getWindow().dispose();
	}

}

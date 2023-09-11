package bookcode.p06MoreAboutObjectsAndMethod;

import javax.swing.*;

/**
 * This JFrame puts an image in the label. The image in placed on the left side.
 * 
 * 
 * In applets ImageIcon searches file from the src/bin directory. In this code,
 * the image is at class location.
 */

public class G03IconDemoFrame extends JFrame {

	// class id
	private static final long serialVersionUID = 1L;

	/*
	 * Initialisation method
	 */
	public void init() {
		// set title
		setTitle("...: G03IconDemoFrame :...");
		// set size
		setSize(400, 300);
		// set location at center
		setLocationRelativeTo(null);
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// creates the label
		JLabel niceLabel = new JLabel("Java is fun!");

		// load the image
		ImageIcon dukeIcon = new ImageIcon(
				"src/bookcode/p06MoreAboutObjectsAndMethod/duke_waving.gif");

		// set the image to the label
		niceLabel.setIcon(dukeIcon);

		// adds the label to the content pane
		getContentPane().add(niceLabel);

		// set contents visible
		setVisible(true);
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create one object
				G03IconDemoFrame app = new G03IconDemoFrame();
				// initialise it
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

package bookcode.p06MoreAboutObjectsAndMethod;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Simple demonstration of putting buttons in an JFrame. These buttons do not do
 * anything. That comes in a later version.
 */
public class G01PreliminaryButtonDemoFrame extends JFrame {

	// class id
	private static final long serialVersionUID = 1L;

	/*
	 * Initialisation method
	 */
	public void init() {
		// set title
		setTitle("...: G01PreliminaryButtonDemoFrame :...");
		// set size
		setSize(400, 300);
		// set location at center
		setLocationRelativeTo(null);
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// get display area
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);

		// set the layout manager
		contentPane.setLayout(new FlowLayout());

		// create and put button on display area
		JButton sunnyButton = new JButton("Sunny");
		contentPane.add(sunnyButton);

		// create and put button on display area
		JButton cloudyButton = new JButton("Cloudy");
		contentPane.add(cloudyButton);

		// show all
		setVisible(true);
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				G01PreliminaryButtonDemoFrame app = new G01PreliminaryButtonDemoFrame();
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}
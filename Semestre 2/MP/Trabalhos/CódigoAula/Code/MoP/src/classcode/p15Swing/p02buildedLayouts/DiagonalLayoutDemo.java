package classcode.p15Swing.p02buildedLayouts;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * CustomLayoutDemo requires DiagonalLayout.java It's a example from
 * "java toturial examples"
 * 
 * Assunto: DiagonalLayout
 */

public class DiagonalLayoutDemo {
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(new DiagonalLayout());

		pane.add(new JButton("Button 1"));
		pane.add(new JButton("Button 2"));
		pane.add(new JButton("Button 3"));
		pane.add(new JButton("Button 4"));
		pane.add(new JButton("Button 5"));
		pane.add(new JButton("Button 6"));
		pane.add(new JButton("Button 7"));
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Diagonal Layout Demo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.pack();

		// to center a frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

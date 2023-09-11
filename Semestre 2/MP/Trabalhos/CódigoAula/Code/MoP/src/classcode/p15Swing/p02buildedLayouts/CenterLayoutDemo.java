package classcode.p15Swing.p02buildedLayouts;

/*
 * CustomLayoutDemo.java requires the class:
 *   CenterLayout.java
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * CenterLayoutDemo - os botões diminuem ou aumentam a dimensão dos insets
 * 
 * Asuntos: CenterLayout
 * 
 * @author António Teófilo
 * 
 */
public class CenterLayoutDemo {

	public static void addComponentsToPane(Container pane) {
		CenterLayout cl = new CenterLayout();
		pane.setLayout(cl);

		final JLabel label = new JLabel("Yupi!!!");
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		label.setBackground(new Color(0, 200, 100));
		label.setOpaque(true);
		
		label.setPreferredSize(new Dimension(200, 100));
		pane.add(label);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Center Layout Demo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		// frame.pack();
		frame.setSize(400, 400);
		// frame.setMinimumSize(new Dimension(200, 200));

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

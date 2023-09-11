package classcode.p15Swing.p02buildedLayouts;

/*
 * CustomLayoutDemo.java requires the class:
 *   CenterLayout.java
 */

import java.awt.BorderLayout;
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
public class XBorderLayoutDemo {

	public static void addComponentsToPane(Container pane) {
		BorderLayout lm = new BorderLayout();
		pane.setLayout(lm);

		int[] colors = { 0x0588B4 /* Center */, 0x0969B8 /* Norte */,
				0x0969B8 /* Sul */, 0x69A7DB/* Oeste */, 0x69A7DB /* Este */};

		final JLabel labelCenter = new JLabel();
		labelCenter.setVerticalAlignment(SwingConstants.CENTER);
		labelCenter.setHorizontalAlignment(SwingConstants.CENTER);
		labelCenter.setBackground(new Color(colors[0]));
		labelCenter.setOpaque(true);
		labelCenter.setPreferredSize(new Dimension(110, 100));
		pane.add(labelCenter);

		final JLabel labelN = new JLabel();
		labelN.setVerticalAlignment(SwingConstants.CENTER);
		labelN.setHorizontalAlignment(SwingConstants.CENTER);
		labelN.setPreferredSize(new Dimension(35, 33));
		labelN.setBackground(new Color(colors[1]));
		labelN.setOpaque(true);
		pane.add(labelN, BorderLayout.NORTH);

		final JLabel labelS = new JLabel();
		labelS.setVerticalAlignment(SwingConstants.CENTER);
		labelS.setHorizontalAlignment(SwingConstants.CENTER);
		labelS.setPreferredSize(new Dimension(35, 33));
		labelS.setBackground(new Color(colors[2]));
		labelS.setOpaque(true);
		pane.add(labelS, BorderLayout.SOUTH);

		final JLabel labelW = new JLabel();
		labelW.setVerticalAlignment(SwingConstants.CENTER);
		labelW.setHorizontalAlignment(SwingConstants.CENTER);
		labelW.setPreferredSize(new Dimension(35, 33));
		labelW.setBackground(new Color(colors[3]));
		labelW.setOpaque(true);
		pane.add(labelW, BorderLayout.WEST);

		final JLabel labelE = new JLabel();
		labelE.setVerticalAlignment(SwingConstants.CENTER);
		labelE.setHorizontalAlignment(SwingConstants.CENTER);
		labelE.setPreferredSize(new Dimension(35, 33));
		labelE.setBackground(new Color(colors[4]));
		labelE.setOpaque(true);
		pane.add(labelE, BorderLayout.EAST);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI(int x, int y) {
		// Create and set up the window.
		JFrame frame = new JFrame("Border Layout Demo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		// frame.pack();
		frame.setSize(x, y);
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
				createAndShowGUI(300, 300);
				createAndShowGUI(200, 200);
			}
		});
	}
}

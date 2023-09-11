package classcode.p15Swing.p04SimpleSwingApps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 * Assuntos: os vários Borders
 * 
 * 
 * Um bom conjunto de exemplos de Border:
 * http://www.java2s.com/Code/Java/Swing-JFC/Border.htm
 * 
 * @author António Teófilo
 * 
 */

public class C6SomeBorders {

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		System.out.println("End of main...");
	}

	/**
	 * Create and Show GUI
	 */
	public static void createAndShowGUI() {
		// create a JFrame
		JFrame frame = new JFrame();
		// set title
		frame.setTitle("...: My borders frame :...");
		// set size and location
		frame.setSize(600, 400);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		final int nBorders = 9;

		// build gridLayout
		GridLayout gl = new GridLayout(nBorders, 1);
		frame.getContentPane().setLayout(gl);

		// set content pane background color
		frame.getContentPane().setBackground(new Color(200, 150, 200));

		JPanel[] panels = new JPanel[nBorders];
		JLabel[] labels = new JLabel[nBorders];
		// criar Jpanels, JLabels e
		for (int y = 0; y < nBorders; ++y) {
			panels[y] = new JPanel(new BorderLayout());
			labels[y] = new JLabel("  ----  ");
			labels[y].setHorizontalAlignment(SwingConstants.CENTER);
			labels[y].setOpaque(true);
			labels[y].setBackground(new Color(100, 150, 150));
			panels[y].add(labels[y]);
			frame.getContentPane().add(panels[y]);
		}
		gl.setVgap(5);

		// Line border
		panels[0].setBorder(new LineBorder(Color.ORANGE, 4));
		labels[0].setText("Line border");

		// Titled border
		panels[1].setBorder(new TitledBorder("title"));
		panels[1].setBorder(new TitledBorder(new LineBorder(Color.RED, 1),"title"));
		labels[1].setText("Titled border");

		// Empty border
		panels[2].setBorder(new EmptyBorder(0, 0, 10, 10));
		labels[2].setText("Empty border");

		// Bevel border
		panels[3].setBorder(new BevelBorder(BevelBorder.RAISED));
		labels[3].setText("Bevel border");

		// Soft Bevel border
		panels[4].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		labels[4].setText("Soft Bevel border");

		// Etched border
		panels[5].setBorder(new EtchedBorder());
		labels[5].setText("Etched border");

		// Matte border
		panels[6].setBorder(new MatteBorder(0, 0, 10, 10, Color.blue));
		labels[6].setText("Matte border");

		// Compound border
		Border lineBorder = LineBorder.createBlackLineBorder();
		Border bevelBorder = BorderFactory.createRaisedBevelBorder();
		panels[7].setBorder(new CompoundBorder(bevelBorder, lineBorder));
		labels[7].setText("Compound border");

		Border bevelBorder2 = BorderFactory.createLoweredBevelBorder();
		panels[8].setBorder(new CompoundBorder(bevelBorder, bevelBorder2));
		labels[8].setText("Compound2 border");

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Frame created...");

	}
}

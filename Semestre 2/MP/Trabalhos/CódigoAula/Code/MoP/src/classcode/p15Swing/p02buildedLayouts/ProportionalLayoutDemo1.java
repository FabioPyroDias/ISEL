package classcode.p15Swing.p02buildedLayouts;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * ProportionalLayoutDemo1 - requires ProportionalLayout.java
 * 
 * Assunto: proportionalLayout
 * 
 * @author António Teófilo
 * 
 */
public class ProportionalLayoutDemo1 {

	public static void addComponentsToPane(Container pane, float iTop,
			float iBottom, float iLeft, float iRigth, float zTop,
			float zBottom, float zLeft, float zRigth) {

		ProportionalLayout cl = new ProportionalLayout(zTop, zBottom, zLeft,
				zRigth);
		pane.setLayout(cl);

		cl.setInsets(iTop, iBottom, iLeft, iRigth);
		cl.setPGaps(0.02f);

		pane.setBackground(Color.yellow);

		String str = "<html><center>Insets -> " + iTop + " " + iBottom + " "
				+ iLeft + " " + iRigth;
		str += "<br/>Zonesets -> " + zTop + " " + zBottom + " " + zLeft + " "
				+ zRigth + "<center></html>";

		final JLabel label1 = new JLabel(str);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBackground(new Color(255, 00, 00));
		label1.setOpaque(true);
		pane.add(label1, ProportionalLayout.CENTER);
		label1.setBorder(new LineBorder(Color.black));

		JLabel label2 = new JLabel("  xxx   ");
		label2.setBackground(new Color(200, 0, 100));
		label2.setOpaque(true);
		pane.add(label2, ProportionalLayout.NORTH);
		label2.setBorder(new LineBorder(Color.red));

		JLabel label3 = new JLabel("  yyy   ");
		label3.setBackground(new Color(000, 0, 200));
		label3.setOpaque(true);
		pane.add(label3, ProportionalLayout.SOUTH);
		label3.setBorder(new LineBorder(Color.pink));

		JLabel label4 = new JLabel("  zzz   ");
		label4.setBackground(new Color(000, 200, 000));
		label4.setOpaque(true);
		pane.add(label4, ProportionalLayout.WEST);
		label4.setBorder(new LineBorder(Color.green));

		JPanel panel = new JPanel(new ProportionalLayout(0.2f));
		panel.setBorder(new LineBorder(Color.black, 5));

		JLabel label5 = new JLabel("  www   ");
		label5.setBackground(new Color(200, 0, 200));
		label5.setOpaque(true);
		label5.setBorder(new LineBorder(Color.green));
		panel.add(label5, ProportionalLayout.CENTER);

		pane.add(panel, ProportionalLayout.EAST);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static JFrame createAndShowGUI(float iTop, float iBottom,
			float iLeft, float iRigth, float zTop, float zbottom, float zLeft,
			float zRigth) {
		// Create and set up the window.
		JFrame frame = new JFrame("Proportional Layout Demo 1");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane(), iTop, iBottom, iLeft,
				iRigth, zTop, zbottom, zLeft, zRigth);

		// Display the window.
		// frame.pack();
		frame.setSize(400, 400);

		// to center a frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		return frame;
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
				createAndShowGUI(0.05f, 0.05f, 0.05f, 0.05f, 0.1f, 0.1f, 0.1f,
						0.1f);
				createAndShowGUI(0.05f, 0.05f, 0.05f, 0.05f, 0.1f, 0.1f, 0.0f,
						0.0f);

				createAndShowGUI(0.05f, 0.05f, 0.05f, 0.05f, 0.2f, 0.2f, 0.1f,
						0.1f);
				createAndShowGUI(0.05f, 0.05f, 0.05f, 0.05f, 0.1f, 0.1f, 0.2f,
						0.2f);

				createAndShowGUI(0.0f, 0.0f, 0.05f, 0.05f, 0.2f, 0.2f, 0.2f,
						0.1f);
				createAndShowGUI(0.05f, 0.05f, 0.0f, 0.0f, 0.0f, 0.3f, 0.0f,
						0.3f);

				createAndShowGUI(0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.2f, 0.2f);

				createAndShowGUI(0.0f, 0.0f, 0.0f, 0.0f, 0.00f, 0.0f, 0.4f,
						0.0f);

			}
		});
	}
}

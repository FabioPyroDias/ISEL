package classcode.p15Swing.p01layoutframes;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Null layout manager. Posicionamento fixo.
 * 
 * Assunto: null layout manager
 * 
 * @author António Teófilo
 * 
 */
public class C7MyNullFrame {

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
		frame.setTitle("...: My nulll layout frame :...");
		// set size
		frame.setSize(400, 200);
		// set location at center
		frame.setLocationRelativeTo(null);
		// dispose on close
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Random rg = new Random();

		frame.setLayout(null);
		// frame.setLayout(new FlowLayout());

		// criar as labels
		JLabel label1 = C6FrameWithPanels.createJLabel("-- um ---", rg);
		label1.setBounds(0, 0, 100, 50);

		JLabel label2 = C6FrameWithPanels.createJLabel("-- dois ---", rg);
		label2.setBounds(25, 25, 100, 50);

		JLabel label3 = C6FrameWithPanels.createJLabel("-- três ---", rg);
		label3.setBounds(100, 100, 100, 40);

		JLabel label4 = C6FrameWithPanels.createJLabel("-- quatro ---", rg);
		label4.setBounds(200, 200, 100, 30);

		JLabel label5 = C6FrameWithPanels.createJLabel("-- cinco ---", rg);
		label5.setBounds(300, 300, 100, 20);

		// colocá-las no contentPane
		frame.add(label1);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label2);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);

		// life goes on
		System.out.println("Frame created...");
	}

}

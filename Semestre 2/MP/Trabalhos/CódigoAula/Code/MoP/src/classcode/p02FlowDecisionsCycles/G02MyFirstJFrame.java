package classcode.p02FlowDecisionsCycles;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class G02MyFirstJFrame {

	/**
	 * usually we have the init method to initialize the graphic elements
	 * 
	 * Remove each of these actions to see what happens
	 */
	static void init() {

		// create a Frame
		JFrame jframe = new JFrame("..: My First JFrame :..");

		// set default operation on close
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// change the background color of its content pane
		jframe.getContentPane().setBackground(new Color(0, 100, 100));

		// set its size
		jframe.setSize(450, 350);

		// center the frame
		jframe.setLocationRelativeTo(null);

		// frame is ready to be shown
		jframe.setVisible(true);
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// use this stuff - we will explain it latter
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// put you init code in this method
				init();
			}
		});
	}
}

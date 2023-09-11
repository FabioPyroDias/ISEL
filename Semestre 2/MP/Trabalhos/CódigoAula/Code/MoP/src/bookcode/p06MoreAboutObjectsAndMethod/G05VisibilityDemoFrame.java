package bookcode.p06MoreAboutObjectsAndMethod;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Simple demonstration of changing visibility in an Applet.
 */
public class G05VisibilityDemoFrame extends JFrame implements ActionListener {
	// class id
	private static final long serialVersionUID = 1L;

	private JLabel response;
	private Container contentPane;

	/*
	 * Initialisation method
	 */
	public void init() {
		// set title
		setTitle("...: G05VisibilityDemoFrame :...");

		// set size
		setSize(400, 300);

		// set location at centre
		setLocationRelativeTo(null);

		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// get display area and set background colour to white
		contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);

		// build button
		JButton aButton = new JButton("Push me!");
		aButton.addActionListener(this);

		// build label
		response = new JLabel("Thanks. That felt good!");
		ImageIcon smileyFaceIcon = new ImageIcon(
				"src/bookcode/p06MoreAboutObjectsAndMethod/smiley.gif");
		response.setIcon(smileyFaceIcon);
		// set initially invisible
		response.setVisible(false);

		// Add button:
		contentPane.setLayout(new FlowLayout());
		contentPane.add(aButton);

		// Add label
		contentPane.add(response);

		// show frame
		setVisible(true);
	}

	/*
	 * action listener method
	 */
	public void actionPerformed(ActionEvent e) {

		// change the background colour
		contentPane.setBackground(Color.PINK);

		// make label visible
		response.setVisible(true);

		// make invisible the button
		((JButton) e.getSource()).setVisible(false);
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create one object
				G05VisibilityDemoFrame app = new G05VisibilityDemoFrame();
				// initialise it
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

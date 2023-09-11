package bookcode.p06MoreAboutObjectsAndMethod;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Simple demonstration of putting buttons in an JFrame. These buttons do
 * something when clicked.
 */
public class G04ButtonIconDemoFrame extends JFrame implements ActionListener {

	// class id
	private static final long serialVersionUID = 1L;

	/*
	 * Initialisation method
	 */
	public void init() {
		// set title
		setTitle("...: G04ButtonIconDemoFrame :...");
		// set size
		setSize(400, 300);
		// set location at center
		setLocationRelativeTo(null);

		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// get display area
		Container contentPane = getContentPane();
		// set background to white
		contentPane.setBackground(Color.WHITE);
		// set layout manager
		contentPane.setLayout(new FlowLayout());

		// create button, with an icon, add button to display and add listener
		JButton sunnyButton = new JButton("Sunny");
		ImageIcon smileyFaceIcon = new ImageIcon(
				"src/bookcode/p06MoreAboutObjectsAndMethod/smiley.gif");
		sunnyButton.setIcon(smileyFaceIcon);
		contentPane.add(sunnyButton);
		sunnyButton.addActionListener(this);

		// create button, add button to display and add listener
		JButton cloudyButton = new JButton("Cloudy");
		contentPane.add(cloudyButton);
		cloudyButton.addActionListener(this);

		// show frame
		setVisible(true);
	}

	/*
	 * action listener method
	 */
	public void actionPerformed(ActionEvent e) {
		// get display area
		Container contentPane = getContentPane();

		// set background colour to blue or gray
		if (e.getActionCommand().equals("Sunny"))
			contentPane.setBackground(Color.BLUE);
		else if (e.getActionCommand().equals("Cloudy"))
			contentPane.setBackground(Color.GRAY);
		else
			System.out.println("Error in button interface.");
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create one object
				G04ButtonIconDemoFrame app = new G04ButtonIconDemoFrame();
				// initialise it
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

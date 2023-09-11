package bookcode.p06MoreAboutObjectsAndMethod;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Simple demonstration of putting buttons in an JFrame. These buttons do
 * something when clicked.
 */
// the class is a JFrame extended and implements ActionListener
public class G02ButtonDemoFrame extends JFrame implements ActionListener {

	// class id
	private static final long serialVersionUID = 1L;

	/*
	 * Initialisation method
	 */
	public void init() {
		// set title
		setTitle("...: G02ButtonDemoFrame :...");
		// set size
		setSize(400, 300);
		// set location at centre
		setLocationRelativeTo(null);
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// get display area
		Container contentPane = getContentPane();
		// set colour
		contentPane.setBackground(Color.WHITE);
		// set layout manager
		contentPane.setLayout(new FlowLayout());

		// Set sunnyButton actionCommand with "Sunny"
		JButton sunnyButton = new JButton("Sunny");
		contentPane.add(sunnyButton);
		sunnyButton.addActionListener(this);

		// Set cloudyButton actionCommand with "Cloudy"
		JButton cloudyButton = new JButton("Cloudy");
		contentPane.add(cloudyButton);
		cloudyButton.addActionListener(this);

		// show frame and contents
		setVisible(true);
	}

	/**
	 * the method of action listener interface 
	 */
	public void actionPerformed(ActionEvent e) {
		Container contentPane = getContentPane();
		// get actionCommand from the source of the event occurred
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
				G02ButtonDemoFrame app = new G02ButtonDemoFrame();
				// initialise it
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

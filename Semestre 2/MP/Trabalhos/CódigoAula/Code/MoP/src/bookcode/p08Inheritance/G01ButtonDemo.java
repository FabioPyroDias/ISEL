package bookcode.p08Inheritance;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple demonstration of buttons in a JFrame window.
 */
public class G01ButtonDemo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	public void init() {
		setSize(WIDTH, HEIGHT);

		// catch window destroy event and dispose window
		G02WindowDestroyer listener = new G02WindowDestroyer();
		addWindowListener(listener);

		// get the content pane and set is background colour to white
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);

		// place the buttons in a row if possible
		contentPane.setLayout(new FlowLayout());

		// create the sunny button and set its listener to this class
		JButton sunnyButton = new JButton("Sunny");
		sunnyButton.addActionListener(this);
		contentPane.add(sunnyButton);

		// create the cloudy button and set its listener to this class
		JButton cloudyButton = new JButton("Cloudy");
		cloudyButton.addActionListener(this);
		contentPane.add(cloudyButton);

		// centre the frame in screen
		setLocationRelativeTo(null);

		// turn the frame visible
		setVisible(true);
	}

	/**
	 * The listener method - the method that wil run when an ActionEvent is
	 * delivered to this class
	 */
	public void actionPerformed(ActionEvent e) {
		// get actionCommand
		String actionCommand = e.getActionCommand();

		// get contentPane
		Container contentPane = getContentPane();

		// set background to the right colour
		if (actionCommand.equals("Sunny"))
			contentPane.setBackground(Color.BLUE);
		else if (actionCommand.equals("Cloudy"))
			contentPane.setBackground(Color.GRAY);
		else
			System.out.println("Error in button interface.");
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				G01ButtonDemo gui = new G01ButtonDemo();
				gui.init();
			}
		});
	}

}
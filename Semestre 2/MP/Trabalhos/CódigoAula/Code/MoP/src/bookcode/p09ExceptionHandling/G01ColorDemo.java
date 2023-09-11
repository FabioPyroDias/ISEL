package bookcode.p09ExceptionHandling;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import bookcode.p08Inheritance.G02WindowDestroyer;

/**
 * button and JtextField
 */
public class G01ColorDemo extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3549728447837162404L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int NUMBER_OF_CHAR = 20;
	private JTextField colorName;

	/**
	 * init method
	 */
	public void init() {

		setSize(WIDTH, HEIGHT);

		// catch window destroy event and dispose window
		G02WindowDestroyer listener = new G02WindowDestroyer();
		addWindowListener(listener);

		// get the content pane and set is background colour to gray
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.GRAY);

		// place the buttons in a row if possible
		contentPane.setLayout(new FlowLayout());

		// create the show color button and set its listener to this class
		JButton showButton = new JButton("Show Color");
		showButton.addActionListener(this);
		contentPane.add(showButton);

		// create text field
		colorName = new JTextField(NUMBER_OF_CHAR);
		contentPane.add(colorName);

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
		Container contentPane = getContentPane();
		try {
			contentPane.setBackground(getColor(colorName.getText()));
		} catch (C10UnknownColorException exception) {
			colorName.setText("Unknown Color");
			contentPane.setBackground(Color.GRAY);
		}
	}

	/**
	 * auxiliary method to validate and get the colour
	 */
	public Color getColor(String name) throws C10UnknownColorException {
		if (name.equalsIgnoreCase("RED"))
			return Color.RED;
		else if (name.equalsIgnoreCase("WHITE"))
			return Color.WHITE;
		else if (name.equalsIgnoreCase("BLUE"))
			return Color.BLUE;
		else if (name.equalsIgnoreCase("GREEN"))
			return Color.GREEN;
		else
			throw new C10UnknownColorException();
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				G01ColorDemo gui = new G01ColorDemo();
				gui.init();
			}
		});
	}
}

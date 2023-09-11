package bookcode.p07Arrays;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Oracle in a Frame
 */
public class G02OracleFrame extends JFrame implements ActionListener {

	// class id
	private static final long serialVersionUID = 1L;

	// constants
	public static int LINES = 5;
	public static int CHAR_PER_LINE = 40;

	// variables

	private String question;
	private String answer;
	private String advice;

	// the text area
	private JTextArea theText;

	// the buttons
	private JButton getAnswerButton;
	private JButton sendAdviceButton;
	private JButton resetButton;

	/**
	 * init
	 */
	public void init() {
		// set title
		setTitle("...: G05VisibilityDemoFrame :...");
		// set size
		setSize(800, 300);
		// set location at center
		setLocationRelativeTo(null);
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// the graphic area
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		// the label
		JLabel instructions = new JLabel("I will answer any question, "
				+ "but may need some advice from you.");
		contentPane.add(instructions);

		// button GetAnswer
		getAnswerButton = new JButton("Get Answer");
		// the listener of this button will be this object, this class is a
		// Action Listener
		getAnswerButton.addActionListener(this);
		contentPane.add(getAnswerButton);

		// button Send Advice
		sendAdviceButton = new JButton("Send Advice");
		// the listener of this button will be this object, this class is a
		// Action Listener
		sendAdviceButton.addActionListener(this);
		contentPane.add(sendAdviceButton);

		// Button Reset
		resetButton = new JButton("Reset");
		// the listener of this button will be this object, this class is a
		// Action Listener
		resetButton.addActionListener(this);
		contentPane.add(resetButton);

		// text area for input
		theText = new JTextArea(LINES, CHAR_PER_LINE);
		theText.setText("Questions and advice go here.");
		contentPane.add(theText);

		// first answer
		answer = "The answer is: Look around."; // first answer

		// set visible
		setVisible(true);
	}

	/**
	 * action method of the actionListener - the listener is the same for the
	 * three buttons
	 */
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		// if Get answer button pressed
		if (actionCommand.equals("Get Answer")) {
			question = theText.getText();
			theText.setText("That is a difficult question.\n"
					+ "Please give me some advice\n"
					+ "and click the Send Advice button.");
			// adjust buttons
			getAnswerButton.setEnabled(false);
			sendAdviceButton.setEnabled(true);
		} else
		// if Send Advice button pressed
		if (actionCommand.equals("Send Advice")) {
			advice = theText.getText();
			theText.setText("That advice helped.\n"
					+ "You asked the question: " + question + "\n" + answer
					+ "\nClick the Reset button and"
					+ "\nleave the program on for others.");
			answer = "The answer is: " + advice;
			// adjust buttons
			sendAdviceButton.setEnabled(false);
			resetButton.setEnabled(true);
		} else
		// if Reset button pressed
		if (actionCommand.equals("Reset")) {
			theText.setText("Questions and advice go here.");
			// adjust buttons
			resetButton.setEnabled(false);
			getAnswerButton.setEnabled(true);
		} else
			theText.setText("Error");
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create an object Oracle frame
				G02OracleFrame app = new G02OracleFrame();
				// launch its init
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

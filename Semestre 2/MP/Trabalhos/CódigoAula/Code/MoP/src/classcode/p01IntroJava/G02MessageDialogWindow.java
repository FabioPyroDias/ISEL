package classcode.p01IntroJava;

import javax.swing.*;

/**
 * Message dialog window
 */
public class G02MessageDialogWindow {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// message dialog with plain message type
		JOptionPane.showMessageDialog(null, "Hello World!",
				"MyMessageDialog -  Plain message", JOptionPane.PLAIN_MESSAGE);

		// message dialog with information message type
		JOptionPane.showMessageDialog(null, "Hello World!",
				"MyMessageDialog - Information Message",
				JOptionPane.INFORMATION_MESSAGE);

		// message dialog with warning message type
		JOptionPane.showMessageDialog(null, "Hello World!",
				"MyMessageDialog - Warning message",
				JOptionPane.WARNING_MESSAGE);

		// message dialog with error message type
		JOptionPane.showMessageDialog(null, "Hello World!",
				"MyMessageDialog - Error message", JOptionPane.ERROR_MESSAGE);

	}
}

package bookcode.p10StreamAndFileIO;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import bookcode.p08Inheritance.G02WindowDestroyer;

/**
 * Use of File class
 * 
 * A Graphical File Organiser.
 */
public class G01FileOrganizer extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6859889793760306788L;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int NUMBER_OF_CHAR = 30;
	private JTextField fileNameField;
	private JTextField firstLineField;

	public void init() {

		setTitle("File organiser v1.0");

		setSize(WIDTH, HEIGHT);

		// set window destroyer code
		G02WindowDestroyer listener = new G02WindowDestroyer();
		addWindowListener(listener);

		// get content pane
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		// button show first line
		JButton showButton = new JButton("Show first line");
		showButton.addActionListener(this);
		contentPane.add(showButton);

		// button remove file
		JButton removeButton = new JButton("Remove file");
		removeButton.addActionListener(this);
		contentPane.add(removeButton);

		// button reset
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		contentPane.add(resetButton);

		// text field file name
		fileNameField = new JTextField(NUMBER_OF_CHAR);
		contentPane.add(fileNameField);
		fileNameField.setText("Enter file name here.");

		// text field first line
		firstLineField = new JTextField(NUMBER_OF_CHAR);
		contentPane.add(firstLineField);

		setLocationRelativeTo(null);

		setVisible(true);
	}

	/*
	 * Listener that will be called by each event generate in the buttons
	 */
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Show first line"))
			showFirstLine();
		else if (actionCommand.equals("Remove file"))
			removeFile();
		else if (actionCommand.equals("Reset"))
			resetFields();
		else
			firstLineField.setText("Unexpected error.");
	}

	/*
	 * show first line of file
	 */
	private void showFirstLine() {
		Scanner fileInput = null;
		String fileName = fileNameField.getText();
		// create an File object
		File fileObject = new File(fileName);
		// and check if it exists and can be read
		if (!fileObject.exists())
			firstLineField.setText("No such file");
		else if (!fileObject.canRead())
			firstLineField.setText("That file is not readable.");
		else {
			try {
				// use a scanner to read from the file
				fileInput = new Scanner(fileObject);
			} catch (FileNotFoundException e) {
				firstLineField.setText("Error opening the file " + fileName);
			}
			String firstLine = fileInput.nextLine();
			firstLineField.setText(firstLine);
			fileInput.close();
		}
	}

	/**
	 * reset fields action
	 */
	private void resetFields() {
		fileNameField.setText("Enter file name here.");
		firstLineField.setText("");
	}

	/**
	 * remove file
	 */
	private void removeFile() {
		String fileName = fileNameField.getText();
		// create a File
		File fileObject = new File(fileName);
		// check if file exists
		if (!fileObject.exists())
			firstLineField.setText("No such file");
		else // check if can write file
		if (!fileObject.canWrite())
			firstLineField.setText("Permission denied.");
		else {
			// delete the file
			if (fileObject.delete())
				firstLineField.setText("File deleted.");
			else
				firstLineField.setText("Could not delete file.");
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				G01FileOrganizer gui = new G01FileOrganizer();
				gui.init();
			}
		});
	}
}

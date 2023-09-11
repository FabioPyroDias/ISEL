package bookcode.p05ClassesAndMethods;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * An JFrame with text using a label. GridLayout. null layout. setborder.
 * setHorizontalAligment. setBounds.
 * 
 * To correct the imports just do CTRL+SHIFT+o
 */
public class G04LabelDemoFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private void init() {
		// set title
		setTitle("...: G04LabelDemoFrame :...");

		// set size
		setSize(500, 300);

		// set location at center
		setLocationRelativeTo(null);

		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);

		// label 1 - its an object of JLabel class
		JLabel label1 = new JLabel("Hello  hello ");
		label1.setBorder(LineBorder.createGrayLineBorder());

		// label 2 - its an object of JLabel class
		JLabel label2 = new JLabel("out there!");
		label2.setBorder(LineBorder.createGrayLineBorder());

		// label 3 - its an object of JLabel class
		JLabel label3 = new JLabel("    yep!!!!    ");
		label3.setBackground(Color.green);
		label3.setOpaque(true);
		label3.setHorizontalAlignment(SwingConstants.CENTER);

		// put a FlowLayout, that tries to put all elements in a line
		contentPane.setLayout(new FlowLayout());

		// test 1 remove the comment from the following line
		// contentPane.setLayout(new GridLayout(3, 1));

		// add the label to the pane
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);

		// test 2
		// contentPane.setLayout(null);
		// label1.setBounds(10, 10, 200, 100);
		// label2.setBounds(100, 100, 200, 100);
		// label3.setBounds(230, 10, 200, 100);

		setVisible(true);
	}

	/**
	 * main method
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				G04LabelDemoFrame app = new G04LabelDemoFrame();
				app.init();
			}
		});
		System.out.println("End of main...");
	}
}

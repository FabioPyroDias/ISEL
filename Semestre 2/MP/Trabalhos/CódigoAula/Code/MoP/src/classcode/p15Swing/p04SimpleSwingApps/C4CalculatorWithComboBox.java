package classcode.p15Swing.p04SimpleSwingApps;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Calculator with comboBox
 * 
 * Novos componentes: JComboBox
 * 
 * @author António Teófilo
 * 
 */
public class C4CalculatorWithComboBox extends JFrame {

	private static final long serialVersionUID = 1L;

	private FlowLayout layout = null;

	private JLabel label1 = null;

	private JButton buttonDo = null;

	private JLabel label2 = null;

	private JTextField text1 = null;

	private JTextField text2 = null;

	private JTextField textResult = null;

	private JLabel labelResult = null;

	private JComboBox<String> comboOpers = null;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My calculator with a ComboBox :...");

		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		layout = new FlowLayout();
		getContentPane().setLayout(layout);

		// label1 - oper1
		label1 = new JLabel("Value1 :");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label1);

		// text1 - oper1
		text1 = new JTextField("1000", 10);
		getContentPane().add(text1);

		// the Combobox
		comboOpers = new JComboBox<String>();
		comboOpers.addItem("add");
		comboOpers.addItem("sub");
		comboOpers.addItem("mul");
		comboOpers.addItem("div");

		// put one option initially selected - the ADD option
		comboOpers.setSelectedIndex(0); // -1

		getContentPane().add(comboOpers);

		// label2 - oper2
		label2 = new JLabel("Value2 :");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label2);

		// text2 - JTextField oper2
		text2 = new JTextField("200", 10);
		getContentPane().add(text2);

		// buttonDo
		buttonDo = new JButton(" = ");
		getContentPane().add(buttonDo);

		// labelResult
		labelResult = new JLabel("Result :");
		labelResult.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelResult);

		// textResult
		textResult = new JTextField(10);
		getContentPane().add(textResult);
		textResult.setEditable(false);

		// adjust size to minimum as needed
		pack();
		// set location at center
		setLocationRelativeTo(null);
		// disable resize
		setResizable(false);

		// set dynamic behavior

		// Listener for execution
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner sc1 = new Scanner(text1.getText());
				Scanner sc2 = new Scanner(text2.getText());
				if (sc1.hasNextInt() && sc2.hasNextInt()) {
					int oper1 = sc1.nextInt();
					int oper2 = sc2.nextInt();
					int result = 0;
					switch ((String) comboOpers.getSelectedItem()) {
					case "add":
						result = oper1 + oper2;
						break;
					case "sub":
						result = oper1 - oper2;
						break;
					case "mul":
						result = oper1 * oper2;
						break;
					case "div":
						result = oper1 / oper2;
						break;
					}
					textResult.setText(Integer.toString(result));
				} else {
					textResult.setText("Invalid input values!");
				}
				sc1.close();
				sc2.close();
			}
		};
		buttonDo.addActionListener(al);

		// TODO:remove comment from next line, watch the results and understand
		// this situation
		comboOpers.addActionListener(al);

		// puts the frame visible
		setVisible(true);
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C4CalculatorWithComboBox myFrame = new C4CalculatorWithComboBox();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

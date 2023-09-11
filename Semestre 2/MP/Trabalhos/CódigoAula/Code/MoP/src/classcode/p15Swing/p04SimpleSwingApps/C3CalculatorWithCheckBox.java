package classcode.p15Swing.p04SimpleSwingApps;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * Calculator with checkBoxes, use of ButtonGroup
 * 
 * Novos componentes: JCheckBox
 * 
 * @author António Teófilo
 * 
 */
public class C3CalculatorWithCheckBox extends JFrame {

	private static final long serialVersionUID = 1L;

	private FlowLayout layout = null;

	private JLabel label1 = null;

	private JButton buttonDo = null;

	private JLabel label2 = null;

	private JTextField text1 = null;

	private JTextField text2 = null;

	private JTextField textResult = null;

	private JLabel labelResult = null;

	private JCheckBox addBox = null;;

	private JCheckBox subBox = null;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My calculator with checkBoxes :...");

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

		// the radio buttons
		addBox = new JCheckBox("add");
		addBox.setActionCommand("add");

		subBox = new JCheckBox("sub");
		subBox.setActionCommand("sub");
		subBox.setSelected(true);

		// panel for the buttons
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
		buttonsPanel.setBorder(new LineBorder(new Color(30, 150, 100), 2));

		// Group the radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(addBox); // TODO teste, comentar estas duas linhas
		group.add(subBox); // TODO teste, comentar estas duas linhas

		// add the radioButtons to the panel
		buttonsPanel.add(addBox);
		buttonsPanel.add(subBox);

		getContentPane().add(buttonsPanel);

		// label2 - oper2
		label2 = new JLabel("Value2 :");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label2);

		// text2 - JTextField oper2
		text2 = new JTextField("200", 10);
		add(text2);

		// buttonDo
		buttonDo = new JButton(" = ");
		add(buttonDo);

		// labelResult
		labelResult = new JLabel("Result :");
		labelResult.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelResult);

		// textResult
		textResult = new JTextField(10);
		add(textResult);
		textResult.setEditable(false);

		// adjust size to minimum as needed
		pack();
		// set location
		setLocationRelativeTo(null); // to center a frame
		// disable resize
		setResizable(false);

		// set dynamic behavior

		// Listener of button execute
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner sc1 = new Scanner(text1.getText());
				Scanner sc2 = new Scanner(text2.getText());
				if (sc1.hasNextInt() && sc2.hasNextInt()) {
					int oper1 = sc1.nextInt();
					int oper2 = sc2.nextInt();
					int result = 0;
					// test radio buttons
					if (addBox.isSelected()) {
						result = oper1 + oper2;
					} else {
						result = oper1 - oper2;
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

		// TODO teste, descomentar a seguinte linha
		// addBox.addActionListener(al);

		// puts the frame visible and working
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
				C3CalculatorWithCheckBox myFrame = new C3CalculatorWithCheckBox();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

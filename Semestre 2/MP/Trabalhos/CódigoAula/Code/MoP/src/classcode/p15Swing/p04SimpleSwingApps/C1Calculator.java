package classcode.p15Swing.p04SimpleSwingApps;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Calculator
 * 
 * 
 * Novos componentes: JtextField - componente que permite o input de texto
 * 
 * Novas funcionalidades: setEditable, setResizable
 * 
 * @author António Teófilo
 * 
 */
public class C1Calculator extends JFrame {

	private static final long serialVersionUID = 1L;

	private FlowLayout layout = null;

	private JLabel label1 = null;

	private JButton buttonAdd = null;

	private JButton buttonSub = null;

	private JLabel label2 = null;

	private JTextField text1 = null;

	private JTextField text2 = null;

	private JTextField textResult = null;

	private JLabel labelResult = null;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My calculator v1 :...");

		// on close button hide and dispose frame
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		layout = new FlowLayout();
		getContentPane().setLayout(layout);

		// label1 - oper1
		label1 = new JLabel("Value1 :");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label1);

		// text1 - oper1
		text1 = new JTextField("1000", 5);
		getContentPane().add(text1);

		// button1
		buttonAdd = new JButton("+");
		buttonAdd.setActionCommand("add");
		getContentPane().add(buttonAdd);

		// button2
		buttonSub = new JButton("-");
		buttonSub.setActionCommand("sub");
		getContentPane().add(buttonSub);

		// label2 - oper2
		label2 = new JLabel("Value2 :");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label2);

		// text2 - JTextField oper2
		text2 = new JTextField("200", 5);
		add(text2);
		// text2.setEditable(false); // teste 2 - retirar comentário

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
		// set location
		setLocationRelativeTo(null); // to center a frame

		// disable resize ---------------
		setResizable(false);

		// set dynamic behavior
		// Listener comum aos dois botões, a distinção é realizada pelo
		// actionCommand
		ActionListener al = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Scanner sc1 = new Scanner(text1.getText());
				Scanner sc2 = new Scanner(text2.getText());
				
				if (sc1.hasNextInt() && sc2.hasNextInt()) {
					int oper1 = sc1.nextInt();
					int oper2 = sc2.nextInt();
					int result = 0;
					if (e.getActionCommand().equals("add")) {
						result = oper1 + oper2;
					} else { // sub
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
		
		buttonAdd.addActionListener(al);
		buttonSub.addActionListener(al);

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
				C1Calculator myFrame = new C1Calculator();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}

}

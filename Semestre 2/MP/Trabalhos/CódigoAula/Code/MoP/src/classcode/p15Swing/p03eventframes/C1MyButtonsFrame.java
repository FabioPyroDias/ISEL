package classcode.p15Swing.p03eventframes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Assunto: JButton, Event, ActionListeners, registar o listener
 * 
 * Dois botões, em que cada botão tem o seu listener. Os botões alteram o seu
 * texto como resposta ao click. O Listener é implementado como uma classe
 * auxiliar externa.
 * 
 * @author António Teófilo
 * 
 */
public class C1MyButtonsFrame {

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		System.out.println("End of main...");
	}

	public static void createAndShowGUI() {
		// create a JFrame
		JFrame frame = new JFrame();
		// set title
		frame.setTitle("...: My first buttons frame :...");
		// set size
		frame.setSize(400, 200);
		// set location at center
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		GridLayout gl = new GridLayout(2, 1);
		frame.getContentPane().setLayout(gl);

		JButton button1 = new JButton("Ckick here!!!");
		ActionListener al1 = new ButtonActionListener();
		// register the listener
		button1.addActionListener(al1);
		// button1.addActionListener(al1);
		frame.getContentPane().add(button1);

		JButton button2 = new JButton("Ckick here (count twice??)!!!");
		ActionListener al2 = new ButtonActionListener();
		//button2.addActionListener(al1);
		button2.addActionListener(al2);
		button2.addActionListener(al2);
		frame.getContentPane().add(button2);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Frame created...");

		// Exercício: colocar mais um botão. Grelha com 3 linhas.
	}

}

/**
 * Class auxiliar que é um Listener para um JButton
 */
class ButtonActionListener implements ActionListener {

	// contador próprio de cada Listener
	int n = 0;

	public void actionPerformed(ActionEvent e) {
		((JButton) e.getSource()).setText("Click [" + (++n) + "]");
	}
};

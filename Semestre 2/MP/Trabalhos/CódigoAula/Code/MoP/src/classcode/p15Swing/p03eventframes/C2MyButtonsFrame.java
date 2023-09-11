package classcode.p15Swing.p03eventframes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Assuntos: JButton, Event and Listeners
 * 
 * Dois botões. O Listener é implementado como uma classe auxiliar externa. Como
 * resposta aos botões existe uma actualização do conteúdo de uma Label.
 * 
 * Utiliza-se o ProportionalLayout de modo a colocar a disposição de forma
 * proporcional.
 * 
 * 
 * @author António Teófilo
 * 
 */
public class C2MyButtonsFrame {

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
		frame.setTitle("...: My second buttons frame :...");
		// hide and dispose JFrame
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.1f, 0.05f, 0.1f, 0.1f);
		frame.setLayout(cl);

		JPanel panelTop = new JPanel(new BorderLayout());

		// build JLabel
		JLabel label1 = new JLabel("Hello!!!");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBorder(new LineBorder(new Color(100, 210, 80)));
		panelTop.add(label1, BorderLayout.CENTER);

		// build button's panel (with FlowLayout)
		JPanel panelButtons = new JPanel();

		// build JButton1
		JButton button1 = new JButton("Button1");
		// este ActionCommand permite identificar o botão
		button1.setActionCommand("Button1");
		ActionListener al1 = new ButtonActionListener2(label1);
		button1.addActionListener(al1);
		panelButtons.add(button1);

		// build JButton2
		JButton button2 = new JButton("Button2");
		button2.setActionCommand("Button2");
		ActionListener al2 = new ButtonActionListener2(label1);
		button2.addActionListener(al2);
		panelButtons.add(button2);

		panelTop.add(panelButtons, BorderLayout.PAGE_END);
		frame.add(panelTop, ProportionalLayout.CENTER);

		// set minimum size
		frame.setMinimumSize(new Dimension(300, 200));
		// set size
		frame.setSize(400, 200);
		// set location - at center
		frame.setLocationRelativeTo(null);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Frame created...");
	}
}

/**
 * Class auxiliar que é um Listener para um JButton
 */
class ButtonActionListener2 implements ActionListener {

	int n = 0;

	JLabel label = null;

	// o listener necessita de ter acesso à label
	public ButtonActionListener2(JLabel label) {
		this.label = label;
	}

	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		// jb.setText(jb.getText() + " - " + (++n)); // trocar pela linha
		// seguinte
		jb.setText(jb.getActionCommand() + " - " + (++n));
		label.setText("Hello!! That's me " + jb.getText());
	}
};

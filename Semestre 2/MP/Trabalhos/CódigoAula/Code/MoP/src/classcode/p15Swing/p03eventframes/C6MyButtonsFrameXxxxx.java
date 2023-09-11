package classcode.p15Swing.p03eventframes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
 * A classe é uma JFrame. Cada botão tem um listener, mas o código dos listeners
 * agora é remetido para um método da classe.
 * 
 * 
 * @author António Teófilo
 * 
 */
public class C6MyButtonsFrameXxxxx extends JFrame {

	private static final long serialVersionUID = 1L;

	FlowLayout fl = null;

	JLabel label1 = null;

	JButton button1 = null;

	JButton button2 = null;

	JPanel buttonsPanel = null;

	int counter1 = 0;

	int counter2 = 0;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My fifth buttons frame :...");
		// set size
		setSize(400, 200);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.2f, 0.1f, 0.2f, 0.2f);
		setLayout(cl);

		JPanel panelTop = new JPanel(new BorderLayout());

		// build JLabel
		label1 = new JLabel("Hello!!!");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBorder(new LineBorder(new Color(100, 210, 80)));
		panelTop.add(label1, BorderLayout.CENTER);

		// build button's panel
		JPanel panelButtons = new JPanel();

		// build JButton1
		button1 = new JButton("Button1");
		// este ActionCommand permite identificar o botão
		button1.setActionCommand("Button1");
		panelButtons.add(button1);

		// build JButton2
		button2 = new JButton("Button2");
		button2.setActionCommand("Button2");
		panelButtons.add(button2);

		panelTop.add(panelButtons, BorderLayout.PAGE_END);
		add(panelTop);

		// set dynamic part =======================================
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1_actionListener(e);
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button2_actionListener(e);
			}
		});

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	// como se pode facilmente verificar, bastava um método para atender os
	// eventos dos dois botões
	private void button1_actionListener(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		jb.setText("button 1 -  click");
		label1.setText("Hello!! That's me " + jb.getActionCommand() + " - "
				+ ++counter1);
		System.out.println(" Action event from button 1");
	}

	private void button2_actionListener(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		jb.setText("button 2 -  click");
		label1.setText("Hello!! That's me " + jb.getActionCommand() + " - "
				+ ++counter2);
		System.out.println(" Action event from button 2");
	}

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
		C6MyButtonsFrameXxxxx myFrame = new C6MyButtonsFrameXxxxx();
		myFrame.init();
		// life goes on
		System.out.println("Frame created...");
	}

	// exercicio: copiar para C7MyButtonsFrame e no painel de botões colocar uma
	// grelha com 3 * 5 botões, tal que quando for premido um botão deve
	// aparecer no label a indicação de qual o botão premido, o número de vezes
	// que ele foi premido e o número total que os botões foram premidos. Ex:
	// Botão (0,3) premido-> 12, total -> 38

	// exercício 2: fazer o jogo do galo
}

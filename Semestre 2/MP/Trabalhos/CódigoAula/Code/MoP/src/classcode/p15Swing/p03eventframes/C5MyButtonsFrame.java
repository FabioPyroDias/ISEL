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
 * Um só listener para os dois botões.
 * 
 * Agora a classe é ela própria uma JFrame.
 * 
 * 
 * @author António Teófilo
 * 
 */
public class C5MyButtonsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	FlowLayout fl = null;

	JLabel label1 = null;

	JButton button1 = null;

	JButton button2 = null;

	JPanel buttonsPanel = null;

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

		ProportionalLayout cl = new ProportionalLayout(0.2f, 0.1f, 0.2f, 0.2f);
		// cl.setInsets(0.2f, 0.1f, 0.2f, 0.2f);
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
		ActionListener actionListener = new ActionListener() {
			int n = 0, n1 = 0, n2 = 0;

			public void actionPerformed(ActionEvent e) {
				
				JButton jb = (JButton) e.getSource();
				int x;
				if (jb.getActionCommand().equals("Button1"))
					x = ++n1;
				else
					x = ++n2;
				n++;
				jb.setText(jb.getActionCommand() + " - " + (x));
				label1.setText("Hello!! That's me "
						+ ((JButton) e.getSource()).getActionCommand() + " - "
						+ n);

				System.out.println(" Action event from button "
						+ jb.getActionCommand());
			}
		};

		button1.addActionListener(actionListener);
		button2.addActionListener(actionListener);

		// puts the frame visible (is not visible at start)
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
				createAndShowGUI();
			}
		});
		System.out.println("End of main...");
	}

	public static void createAndShowGUI() {
		C5MyButtonsFrame myFrame = new C5MyButtonsFrame();
		myFrame.init();
		// life goes on
		System.out.println("Frame created...");
	}

}

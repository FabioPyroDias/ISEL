package classcode.p15Swing.p03eventframes;

import java.awt.BorderLayout;
import java.awt.Color;
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
 * Agora todo o contexto passou para o domínio da instância da classe.
 * 
 * As classes anónimas (Listeners) agora já podem aceder sem problemas às
 * variáveis da instância. Estas classes anónimas são declaradas na sua
 * utilização.
 * 
 * @author António Teófilo
 * 
 */
public class C4MyButtonsFrame {

	private String frameName;

	private JFrame frame = null;

	private JLabel label1 = null;

	private JButton button1 = null;

	private JButton button2 = null;

	int globalNumberOfEvents = 0;

	/**
	 * 
	 */
	public C4MyButtonsFrame(String frameName) {
		this.frameName = frameName;
	}

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// new JFrame
		frame = new JFrame();
		// set title
		frame.setTitle(frameName);
		// set size
		frame.setSize(400, 200);
		// set location
		frame.setLocationRelativeTo(null); // to center a frame
		// hide and dispose
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.2f, 0.1f, 0.2f, 0.2f);
		frame.setLayout(cl);

		JPanel panelTop = new JPanel(new BorderLayout());

		// build JLabel
		label1 = new JLabel("Hello!!!");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBorder(new LineBorder(new Color(100, 210, 80)));
		panelTop.add(label1, BorderLayout.CENTER);

		// build button's panel - aqueles objectos que prevemos que nunca iremos
		// necessitar de os aceder podemos não os declarar como atributos da
		// classe, mas sim como variáveis no método
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
		frame.add(panelTop);

		// set dynamic part =======================================

		button1.addActionListener(new ActionListener() {
			int n = 0;

			public void actionPerformed(ActionEvent e) {
				JButton jb = (JButton) e.getSource();
				jb.setText(jb.getActionCommand() + " - " + (++n));
				label1.setText("Hello!! That's me "
						+ ((JButton) e.getSource()).getActionCommand() + " - "
						+ n + " global -> " + ++globalNumberOfEvents);
				System.out.println("frame -> " + frameName
						+ " Action event from " + jb.getActionCommand()
						+ ", local counter -> " + n + ", global counter -> "
						+ globalNumberOfEvents);
			}
		});

		button2.addActionListener(new ActionListener() {
			int n = 0;

			public void actionPerformed(ActionEvent e) {
				JButton jb = (JButton) e.getSource();
				jb.setText(jb.getActionCommand() + " - " + (++n));
				label1.setText("Hello!! That's me "
						+ ((JButton) e.getSource()).getActionCommand() + " - "
						+ n + " global -> " + ++globalNumberOfEvents);
				System.out.println("frame -> " + frameName
						+ " Action event from " + jb.getActionCommand()
						+ ", local counter -> " + n + ", global counter -> "
						+ globalNumberOfEvents);
			}
		});

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		
		System.out.println("Frame visible");
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
		C4MyButtonsFrame myFrame = new C4MyButtonsFrame("...: Frame one :...");
		myFrame.init();

		C4MyButtonsFrame myFrame2 = new C4MyButtonsFrame("...: Frame two :...");
		myFrame2.init();

		// life goes on
		System.out.println("Frame created...");
	}
}

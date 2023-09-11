package classcode.p15Swing.p06moreStuff;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Novidades: Timer
 * 
 * Um Timer pode ser programado para disparar de forma cíclica ou apenas uma vez
 * ("one shot timer"). Pode-se programar o tempo do primeiro disparo diferente
 * do tempo do intervalo entre disparos. Para se activar um timer faz-se
 * "start", para cancelar um timer activo faz-se "stop".
 * 
 * Se se faz close à frame com um timer activo, ele vai continuar activo e não
 * permitirá terminar a aplicação. Deve-se apanhar o evento de Window close de
 * forma a parar o timer e terminar de forma ordeira
 * 
 * 
 * @author António Teófilo
 * 
 */
public class C1MyTimerFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel label1 = null;

	private JButton buttonStart = null;

	private JButton buttonStop = null;

	private JButton buttonResetCounter = null;

	JPanel buttonsPanel = null;

	private JPanel buttonsPanelinternal;

	JCheckBox repeatCheckBox = null;

	private Timer timer = null;

	private final Color labelColor = new Color(120, 240, 140);

	private final Color timerColor = new Color(120, 140, 240);

	private int n = 0;

	private String buildLabelText() {
		return "Timer fired " + n + " times";
	}

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Timer frame :...");
		// set size
		setSize(500, 200);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.1f, 0.2f, 0.2f, 0.2f);
		setLayout(cl);

		buttonsPanel = new JPanel(new CenterLayout());
		add(buttonsPanel, ProportionalLayout.SOUTH);

		buttonsPanelinternal = new JPanel();
		buttonsPanel.add(buttonsPanelinternal);

		// build JLabel
		label1 = new JLabel("Timer wait for action");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(labelColor);
		add(label1, ProportionalLayout.CENTER);

		// TODO uncomment this
		// addWindowListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// if (timer.isRunning())
		// timer.stop();
		// }
		// });

		// Timer action
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++n;
				if (n == 5)
					timer.stop();
				label1.setText(buildLabelText());
				// if timer does not repeat - prepare buttons for new start
				if (!timer.isRepeats() || !timer.isRunning()) {
					// set buttons state: start -> on, stop -> off
					label1.setBackground(labelColor);
					buttonStop.setEnabled(false);
					buttonStart.setEnabled(true);
					repeatCheckBox.setEnabled(true);
					buttonResetCounter.setEnabled(true);
				}
			}
		};
		int delay = 1000; // milliseconds, start time and period
		timer = new Timer(delay, taskPerformer);

		// Checkbox para indicar se o timer é cíclico ou não
		repeatCheckBox = new JCheckBox("Cyclic timer", false);
		buttonsPanelinternal.add(repeatCheckBox);

		// buttonStart
		buttonStart = new JButton("Start timer");
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set button state
				buttonStart.setEnabled(false);
				buttonStop.setEnabled(true);
				buttonResetCounter.setEnabled(false);
				timer.setRepeats(repeatCheckBox.isSelected());
				// timer.setDelay(5000);
				// timer.setInitialDelay(5000);
				timer.start();
				label1.setBackground(timerColor);
				repeatCheckBox.setEnabled(false);
			}
		});
		buttonsPanelinternal.add(buttonStart);

		// buttonStop
		buttonStop = new JButton("Stop timer");
		buttonStop.setEnabled(false);
		buttonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				label1.setText(buildLabelText());
				label1.setBackground(labelColor);
				buttonStop.setEnabled(false);
				buttonStart.setEnabled(true);
				buttonResetCounter.setEnabled(true);
				repeatCheckBox.setEnabled(true);
			}
		});
		buttonsPanelinternal.add(buttonStop);

		// buttonStop
		buttonResetCounter = new JButton("Reset Counter");
		buttonResetCounter.setEnabled(false);
		buttonResetCounter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n = 0;
				label1.setText(buildLabelText());
			}
		});
		buttonsPanelinternal.add(buttonResetCounter);

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
				C1MyTimerFrame myFrame = new C1MyTimerFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

// TODO 1: colocar a checkbox disable enquando o timer estiver activo (a correr)
// TODO 2: colocar um novo botão, que utiliza um outro timer e que só faz três
// disparos, mas se for premido entretanto o mesmo botão ele anula a sequência
// anterior e inica nova sequência de três disparos. O texto a mostrar deve ser
// "Timer2 -> disparo n"

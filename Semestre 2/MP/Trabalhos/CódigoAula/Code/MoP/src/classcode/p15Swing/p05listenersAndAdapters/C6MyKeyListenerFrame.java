package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * KeyListener: key Events, registo de uma acção no ActionMap associado às
 * teclas, e apanhar os eventos no dispatcher
 * 
 * @author António Teófilo
 * 
 */
public class C6MyKeyListenerFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	GridLayout gl = null;

	JLabel label1 = null;

	JButton button1 = null;

	private final Color leftColor = new Color(120, 240, 140);

	private final Color rightColor = new Color(120, 140, 240);

	private JPanel buttonsPanel;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Mouse Motion Listener frame :...");
		// set size
		setSize(400, 200);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.1f, 0.2f, 0.2f, 0.2f);
		setLayout(cl);

		// buttons Panel
		JPanel panelAux = new JPanel(new CenterLayout());
		buttonsPanel = new JPanel();
		panelAux.add(buttonsPanel);
		add(panelAux, ProportionalLayout.SOUTH);

		// build JLabel
		label1 = new JLabel("See events in console...");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(rightColor);
		add(label1, ProportionalLayout.CENTER);

		// button1
		button1 = new JButton("B1 Ckick here!!!");
		MouseListener ml = new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				System.out.print("Mouse clicked...");
				int b = e.getButton();
				switch (b) {
				case MouseEvent.BUTTON1:
					System.out.println(" left button...");
					label1.setBackground(leftColor);
					break;
				case MouseEvent.BUTTON2:
					System.out.println(" center button...");
					label1.setBackground(Color.white);
					break;
				case MouseEvent.BUTTON3:
					System.out.println(" right button...");
					label1.setBackground(rightColor);
					break;
				default:
					System.out.println(" other button...");
					// C1MyMouseListenerFrame.this.dispose(); // 118
				}
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse entered...");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited...");
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("Mouse pressed...");
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse released...");
			}
		};
		button1.addMouseListener(ml);
		buttonsPanel.add(button1);

		JButton button2 = new JButton("B2 Button of keys");
		buttonsPanel.add(button2);

		label1.addMouseListener(ml);

		MouseWheelListener mwl = new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("mouseWheelMoved event...");

			}
		};
		label1.addMouseWheelListener(mwl);

		/**
		 * HERE Uma forma de apanhar keys, registar uma ActionKey num componente
		 * 
		 * criar uma acção para ser executada quando button1 receber F2
		 */
		Action doActionF2 = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("doActionF2...");
				label1.setVisible(!label1.isVisible());
			}
		};

		// registar a acção para quando button1 tiver o focus e for
		// premido F2
		button1.getInputMap().put(KeyStroke.getKeyStroke("F2"), "doActionF2");
		button1.getActionMap().put("doActionF2", doActionF2);

		/**
		 * 
		 * HERE Outra forma de apanhar uma key num componente, registar um
		 * KeyListener
		 * 
		 ** registar um KeyListener no Button2
		 **/
		KeyListener kl = new KeyListener() {
			public void keyTyped(KeyEvent e) {
				print(e, "typed");
			}

			public void keyPressed(KeyEvent e) {
				print(e, "pressed");
			}

			public void keyReleased(KeyEvent e) {
				print(e, "released");
			}

			private void print(KeyEvent e, String keyAction) {
				System.out.println("  button2 has focus: received key "
						+ keyAction + " -> " + e.getKeyChar() + " "
						+ e.getKeyCode());
				System.out.println("  - " + e + " " + keyAction);
			}
		};
		button2.addKeyListener(kl);

		/**
		 * 
		 * HERE Uma forma de apanhar keys em termos globais a uma aplicação
		 * 
		 * Registar um KeyDispatcher, no FocusManager - um keyDispatcher é um
		 * componente que deve gerir o que fazer com as keys entregues à
		 * aplicação
		 */
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(new KeyEventDispatcher() {

					public boolean dispatchKeyEvent(KeyEvent e) {
						System.out.println("KD " + e);
						if (e.getID() == KeyEvent.KEY_TYPED)
							System.out.println("KD key typed on dispatcher -> "
									+ e.getKeyChar() + " " + e.getKeyCode());
						if (e.getID() == KeyEvent.KEY_RELEASED)
							System.out.println();

						// false, tells: key event should be processed
						return false;
					}
				});

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
				C6MyKeyListenerFrame myFrame = new C6MyKeyListenerFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

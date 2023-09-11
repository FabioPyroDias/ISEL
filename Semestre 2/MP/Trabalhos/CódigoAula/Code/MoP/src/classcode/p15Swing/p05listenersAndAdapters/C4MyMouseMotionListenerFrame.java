package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * MouseMotionListener: mouse motion Events, MouseWheelListener
 * 
 * @author António Teófilo
 * 
 */
public class C4MyMouseMotionListenerFrame extends JFrame {

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

		// use of BorderLayout
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new CenterLayout());
		add(buttonsPanel, ProportionalLayout.SOUTH);

		// build JLabel
		label1 = new JLabel("See events in console...");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(rightColor);
		add(label1, ProportionalLayout.CENTER);

		// button1
		button1 = new JButton("Ckick here!!!");
		MouseListener ml = new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				System.out.print("Mouse clicked...");
				int b = e.getButton();
				// System.out.println(e);
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

		// label1.addMouseListener(ml); // 141
		MouseMotionListener mml = new MouseMotionListener() {

			// event that fires when mouse moves over component
			public void mouseMoved(MouseEvent e) {
				System.out.println("Mouse moved at -> " + e.getX() + ","
						+ e.getY());
			}

			// event that fires when mouse moves over component (and outside)
			// when mouse is pressed
			public void mouseDragged(MouseEvent e) {
				System.out.println("Mouse dragged at -> " + e.getX() + ","
						+ e.getY());
			}
		};
		label1.addMouseMotionListener(mml);
		label1.addMouseListener(ml);

		MouseWheelListener mwl = new MouseWheelListener() {
			// event that fires when user moves mouse wheel over component
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("mouseWheelMoved event... "
						+ e.getPreciseWheelRotation() + " "
						+(e.getPreciseWheelRotation() > 0 ? "up" : "down"));
			}
		};
		label1.addMouseWheelListener(mwl);

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
				C4MyMouseMotionListenerFrame myFrame = new C4MyMouseMotionListenerFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

// teste1: retirar o comentário da linha 118 e observar o resultado
// teste2: retirar o comentário da linha 141 e observar o resultado

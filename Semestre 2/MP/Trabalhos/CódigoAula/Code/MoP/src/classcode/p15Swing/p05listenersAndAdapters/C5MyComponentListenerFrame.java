package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * JComponentListener, ToogleButton, ToolTipText
 * 
 * @author António Teófilo
 * 
 */
public class C5MyComponentListenerFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	GridLayout gl = null;

	JLabel label1 = null;

	JButton button1 = null;

	private final Color greenColor = new Color(120, 240, 140);

	private final Color blueColor = new Color(120, 140, 240);

	private JPanel buttonsPanel;

	private JPanel buttonsPanelinternal;

	JToggleButton jtb1 = null;

	private boolean labelBlueColor = false;

	private int numberOfClicks = 0;

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
		buttonsPanel = new JPanel(new CenterLayout());
		add(buttonsPanel, ProportionalLayout.SOUTH);

		buttonsPanelinternal = new JPanel();
		buttonsPanel.add(buttonsPanelinternal);

		// build JLabel
		label1 = new JLabel("See events in console...");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(greenColor);
		add(label1, ProportionalLayout.CENTER);

		// button1
		button1 = new JButton("Change color!!!");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label1.setText("click..." + ++numberOfClicks);
				labelBlueColor = !labelBlueColor;
				if (labelBlueColor)
					label1.setBackground(blueColor);
				else
					label1.setBackground(greenColor);
				System.out.println("Change color button pressed...");
			}
		});
		buttonsPanelinternal.add(button1);

		jtb1 = new JToggleButton("Hide label");
		jtb1.setToolTipText("Hide or show label...");
		jtb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label1.setVisible(!jtb1.isSelected());
				jtb1.setText(jtb1.isSelected() ? "Show label" : "Hide label");
			}
		});
		buttonsPanelinternal.add(jtb1);

		// the component listener
		ComponentListener compListener = new ComponentListener() {

			// Invoked when the component's size changes.
			public void componentResized(ComponentEvent e) {
				System.out.println("ComponentResized event "
						+ label1.getWidth() + ", " + label1.getHeight());
			}

			// Invoked when the component's position changes.
			public void componentMoved(ComponentEvent e) {
				System.out.println("componentMoved event " + label1.getX()
						+ ", " + label1.getY());
			}

			// Invoked when the component has been made visible.
			public void componentShown(ComponentEvent e) {
				System.out.println("componentShown event ");
			}

			// Invoked when the component has been made invisible.
			public void componentHidden(ComponentEvent e) {
				System.out.println("componentHidden event ");
			}
		};
		label1.addComponentListener(compListener);
		label1.setToolTipText("This label is great!");

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
				C5MyComponentListenerFrame myFrame = new C5MyComponentListenerFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

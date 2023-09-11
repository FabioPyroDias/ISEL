package classcode.p15Swing.p02buildedLayouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * ProportionalLayoutDemo2 - requires ProportionalLayout.java
 * 
 * 
 * Assuntos: proportionalLayout, actionListeners (ver package seguinte)
 * 
 * @author António Teófilo
 * 
 */
public class ProportionalLayoutDemo21 {

	static Color ColorRed = new Color(150, 0, 0);
	static Color ColorGreen = new Color(0, 200, 100);

	private JButton buttonChangeColor;
	
	public void addComponentsToPane(Container pane) {
		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.2f);

		pane.setLayout(cl);
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		final JLabel label = new JLabel("Yupi!!!");
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(ColorGreen);
		label.setOpaque(true);
		jp.add(label, BorderLayout.CENTER);

		// classe e objecto que permitem receber os eventos de click no botão
		// quando for premido o botão (por click do rato em cima dele) será
		// executado o método action performed
		ActionListener al = new ActionListener() {
			boolean isColorRed = false;

			public void actionPerformed(ActionEvent e) {
				label.setBackground(isColorRed ? ColorGreen : ColorRed);
				isColorRed = !isColorRed;
			}
		};

		JPanel jp2 = new JPanel();

		buttonChangeColor = new JButton("Change color");
		// registar o listener no botão
		buttonChangeColor.addActionListener(al);
		jp2.add(buttonChangeColor);

		jp.add(jp2, BorderLayout.SOUTH);

		pane.add(jp);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Proportional Layout Demo 2");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		// frame.pack();
		frame.setSize(400, 400);

		// to center a frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ProportionalLayoutDemo21().createAndShowGUI();
			}
		});
	}
}

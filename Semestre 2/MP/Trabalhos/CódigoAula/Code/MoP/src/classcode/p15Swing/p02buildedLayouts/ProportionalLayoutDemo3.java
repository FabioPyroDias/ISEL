package classcode.p15Swing.p02buildedLayouts;

/*
 * CenterLayoutDemo2 requires the class CenterLayout
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * ProportionalLayoutDemo3 - requires ProportionalLayout.java. Os botões
 * diminuem ou aumentam a dimensão dos insets.
 * 
 * Assunto: proportionalLayout dentro de ProportionalLayout, ajuste dinâmico do
 * layout, doLayout, validade
 * 
 * @author António Teófilo
 * 
 */
public class ProportionalLayoutDemo3 {
	static ProportionalLayout cl;
	static JFrame frame;

	public static void addComponentsToPane(Container pane) {
		//content pane layout
		cl = new ProportionalLayout(0.1f, 0.0f, 0.1f, 0.1f);
		cl.setInsets(0.05f);
		pane.setLayout(cl);

		// center panel
		JPanel jpCenter = new JPanel(new ProportionalLayout(0.0f, 0.2f, 0.0f,
				0.0f));

		final JLabel label = new JLabel("Yupi!!!");
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(new Color(0, 200, 100));
		label.setOpaque(true);
		jpCenter.add(label, ProportionalLayout.CENTER);

		ActionListener al = new ActionListener() {
			float insets = 0.05f;

			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("-")) {
					label.setBackground(new Color(150, 0, 0));
					if (insets < 0.25f)
						insets += 0.05f;
				}
				if (e.getActionCommand().equals("+")) {
					label.setBackground(new Color(0, 200, 100));
					if (insets > 0.1f)
						insets -= 0.05f;
				}
				System.out.println("insets -> " + insets);
				cl.setInsets(insets);
				frame.getContentPane().doLayout();
				frame.getContentPane().validate();
			}
		};

		// buttons panel
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1, 2));

		// each button is in a JPanel with CenterLayout
		JPanel jp1 = new JPanel();
		jp1.setLayout(new CenterLayout());
		JButton b1 = new JButton("+");
		b1.setActionCommand("+");
		b1.addActionListener(al);
		Dimension d = b1.getPreferredSize();
		d.width = 70;
		b1.setPreferredSize(d);
		jp1.add(b1);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new CenterLayout());
		JButton b2 = new JButton("-");
		b2.setActionCommand("-");
		b2.addActionListener(al);
		b2.setPreferredSize(d);
		jp2.add(b2);

		jp.add(jp1);
		jp.add(jp2);

		jpCenter.add(jp, ProportionalLayout.SOUTH);
		frame.add(jpCenter, ProportionalLayout.CENTER);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		frame = new JFrame("Proportional Layout Demo 3");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		// frame.pack();
		frame.setSize(400, 400);
		frame.setMinimumSize(new Dimension(200, 200));

		// to center a frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

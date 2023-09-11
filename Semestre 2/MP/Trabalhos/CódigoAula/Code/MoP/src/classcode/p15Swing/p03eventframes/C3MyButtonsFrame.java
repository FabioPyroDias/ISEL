package classcode.p15Swing.p03eventframes;

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
 * Dois botões com listeners implementados como inner classe anónimas
 * 
 * @author António Teófilo
 * 
 */
public class C3MyButtonsFrame {

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
		// set size
		frame.setSize(400, 200);
		// set location
		frame.setLocationRelativeTo(null); // to center a frame
		// hide and dispose jframe
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.0f, 0.2f, 0f, 0f);
		cl.setInsets(0.2f, 0.0f, 0.2f, 0.2f);
		frame.setLayout(cl);


		// build JLabel
		 final JLabel label1 = new JLabel("Hello!!!");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBorder(new LineBorder(new Color(100, 210, 80)));
		frame.add(label1, ProportionalLayout.CENTER);

		// build button's panel
		JPanel panelButtons = new JPanel();

		// build JButton1
		JButton button1 = new JButton("Button1");
		// este ActionCommand permite identificar o botão
		button1.setActionCommand("Button1");
		panelButtons.add(button1);

		// build JButton2
		JButton button2 = new JButton("Button2");
		button2.setActionCommand("Button2");
		panelButtons.add(button2);

		frame.add(panelButtons, ProportionalLayout.SOUTH);

		// set dynamic part =======================================

		// anonymous inner classes, can access to instance variables, but only
		// to final variables in static or local context.
		ActionListener al1 = new ActionListener() {
			int n = 0;

			public void actionPerformed(ActionEvent e) {
				JButton jb = (JButton) e.getSource();
				jb.setText(jb.getActionCommand() + " - " + (++n));
				label1.setText("Hello!! That's me "
						+ ((JButton) e.getSource()).getActionCommand() + " - "
						+ n);
			}
		};

		// outra possibilidade seria:
		// class Xpto implements ActionListener {
		// int n = 0;
		//
		// public void actionPerformed(ActionEvent e) {
		// JButton jb = (JButton) e.getSource();
		// jb.setText(jb.getActionCommand() + " - " + (++n));
		// label1.setText("Hello!! That's me "
		// + ((JButton) e.getSource()).getActionCommand() + " - "
		// + n);
		// }
		// }
		// ActionListener al3 = new Xpto();

		button1.addActionListener(al1);

		ActionListener al2 = new ActionListener() {
			int n = 0;

			public void actionPerformed(ActionEvent e) {
				JButton jb = (JButton) e.getSource();
				jb.setText(jb.getActionCommand() + " - " + (++n));
				label1.setText("Hello!! That's me "
						+ ((JButton) e.getSource()).getActionCommand() + " - "
						+ n);
			}
		};

		button2.addActionListener(al2);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Frame created...");
	}

}

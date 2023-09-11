package classcode.p15Swing.p01layoutframes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * Demonstra a utilização de JPanel. Utiliza vários layout managers
 * 
 * Novo: BoxLayout, Glue, RigidArea
 * 
 * @author António Teófilo
 * 
 */

public class C6FrameWithPanels {

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

	/**
	 * Método auxiliar para criar uma JLabel de forma expedita
	 */
	public static JLabel createJLabel(String text, Random rg) {
		JLabel label = new JLabel(text);
		label.setOpaque(true);
		label.setBackground(
				new Color(rg.nextInt(256), rg.nextInt(256), rg.nextInt(256)));
		label.setBorder(new LineBorder(Color.yellow, 1));
		return label;
	}

	/**
	 * Create and Show GUI
	 */
	public static void createAndShowGUI() {
		// create a JFrame
		JFrame frame = new JFrame();
		// set title
		frame.setTitle("...: My multi Panels frame :...");
		// set size
		frame.setSize(400, 200);
		// set location
		frame.setLocationRelativeTo(null); // to center a frame
		// set what happends when close button is pressed
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// criar o GridLayout de topo
		GridLayout gl = new GridLayout(2, 3);
		frame.getContentPane().setLayout(gl);

		Random rg = new Random();

		int nLabels = 5;

		// JPanel 0, com borderLayout
		JPanel panel0 = new JPanel();
		BorderLayout bl = new BorderLayout();
		panel0.setLayout(bl);
		JLabel[] labels0 = new JLabel[nLabels];
		String[] loc = { BorderLayout.CENTER, BorderLayout.PAGE_START,
				BorderLayout.PAGE_END, BorderLayout.LINE_START,
				BorderLayout.LINE_END };

		// criar JLabels
		for (int i = 0; i < nLabels; ++i) {
			labels0[i] = createJLabel("--" + i + "--", rg);
			labels0[i].setHorizontalAlignment(SwingConstants.CENTER);
			panel0.add(labels0[i], loc[i]);
		}
		bl.setVgap(2);

		// JPanel 1, com gridLayout - linhas
		JPanel panel1 = new JPanel();
		GridLayout gl1 = new GridLayout(nLabels, 1);
		panel1.setLayout(gl1);
		JLabel[] labels1 = new JLabel[nLabels];
		// criar JLabels
		for (int i = 0; i < nLabels; ++i) {
			labels1[i] = createJLabel(null, rg);
			panel1.add(labels1[i]);
		}
		gl1.setVgap(2);

		// JPanel 2, com gridLayout - colunas
		JPanel panel2 = new JPanel();
		GridLayout gl2 = new GridLayout(1, nLabels);
		panel2.setLayout(gl2);
		JLabel[] labels2 = new JLabel[nLabels];
		// criar JLabels
		for (int i = 0; i < nLabels; ++i) {
			labels2[i] = createJLabel(" ", rg);
			panel2.add(labels2[i]);
		}
		gl2.setHgap(2);

		// JPanel 3, com FlowLayout - default center alignment
		JPanel panel3 = new JPanel();
		FlowLayout fl = new FlowLayout();
		panel3.setLayout(fl);
		JLabel[] labels3 = new JLabel[nLabels];
		// criar JLabels
		for (int i = 0; i < nLabels; ++i) {
			if (i == 1) {
				JPanel panelaux = new JPanel();
				panelaux.setLayout(new GridLayout(2, 1));
				JLabel aux1 = createJLabel("---", rg);
				panelaux.add(aux1);
				JLabel aux2 = createJLabel("-x-", rg);
				panelaux.add(aux2);
				panel3.add(panelaux);
			}
			labels3[i] = createJLabel("        ", rg);
			panel3.add(labels3[i]);
		}
		fl.setHgap(2);

		// JPanel 4, com BoxLayout - os componentes fica com align 0.5 (ou seja
		// no meio)
		JPanel panel4 = new JPanel();
		BoxLayout boxl = new BoxLayout(panel4, BoxLayout.Y_AXIS);
		panel4.setLayout(boxl);
		JLabel[] labels4 = new JLabel[nLabels];
		// criar JLabels
		for (int i = 0; i < nLabels; ++i) {
			labels4[i] = createJLabel("        ", rg);
			labels4[i].setAlignmentX(0.25f);
			panel4.add(labels4[i]);
		}

		// JPanel 5, com GridLayout - mas com invisible filler componentes
		JPanel panel5 = new JPanel();
		GridLayout gl5 = new GridLayout(5, 1);
		panel5.setLayout(gl5);

		// line 0 - BorderLayout - one label one the left and one on the right
		JPanel panel50 = new JPanel();
		BorderLayout bl50 = new BorderLayout();
		panel50.setLayout(bl50);
		JLabel l501 = createJLabel("     ", rg);
		panel50.add(l501, BorderLayout.WEST);
		JLabel l502 = createJLabel("     ", rg);
		panel50.add(l502, BorderLayout.EAST);
		panel5.add(panel50);

		// line 1 - BoxLayout - one label, one space (rigidArea), another label
		JPanel panel51 = new JPanel();
		BoxLayout bl51 = new BoxLayout(panel51, BoxLayout.X_AXIS);
		panel51.setLayout(bl51);
		JLabel l511 = createJLabel("-----", rg);
		panel51.add(l511);
		// rigidArea ###################################
		panel51.add(Box.createRigidArea(new Dimension(20, 0)));
		JLabel l512 = createJLabel("     ", rg);
		panel51.add(l512);
		panel5.add(panel51);

		// line 2 - BoxLayout - one label one the left and one on the right, with
		// one Glue in-between
		JPanel panel52 = new JPanel();
		BoxLayout bl52 = new BoxLayout(panel52, BoxLayout.X_AXIS);
		panel52.setLayout(bl52);
		JLabel l521 = createJLabel("     ", rg);
		panel52.add(l521);
		// glue
		panel52.add(Box.createGlue()); // glue #######################
		JLabel l522 = createJLabel("     ", rg);
		panel52.add(l522);
		panel5.add(panel52);

		// line 3 - FlowLayout - center
		JPanel panel53 = new JPanel();
		FlowLayout fl53 = new FlowLayout(FlowLayout.CENTER, 0, 0);
		panel53.setLayout(fl53);
		JLabel l531 = createJLabel("     ", rg);
		panel53.add(l531);
		// rigid area #######################
		panel53.add(Box.createRigidArea(new Dimension(20, 0)));
		JLabel l532 = createJLabel("     ", rg);
		panel53.add(l532);
		panel5.add(panel53);

		panel50.setBorder(new LineBorder(Color.orange, 3));
		panel51.setBorder(new LineBorder(Color.orange, 3));
		panel52.setBorder(new LineBorder(Color.orange, 3));
		panel53.setBorder(new LineBorder(Color.orange, 3));

		// adicionar os panels á frame
		frame.add(panel0);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(panel5);
		gl.setHgap(5);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Frame created...");

	}
}

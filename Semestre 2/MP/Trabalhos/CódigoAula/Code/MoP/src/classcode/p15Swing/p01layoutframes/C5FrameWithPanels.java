package classcode.p15Swing.p01layoutframes;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * Demonstra a utilização de JPanel. Um JPanel é um Container que permite
 * organizar a sua área com um LayoutManager e conter outros elementos dentro
 * dele. Com a utilização de JPanels podemos ter JPanels dentro de JPanels cada
 * um com o seu layout manager.
 * 
 * Um JPanel tem um FlowLayout como layout manager por omissão. Uma JFrame tem
 * um BorderLayout como o layout manager por omissão.
 * 
 * Utiliza um GridLayout com duas colunas. Cada um delas leva um JPanel com um
 * grid Layout.
 * 
 * Assuntos: JPanel
 * 
 * @author António Teófilo
 * 
 */

public class C5FrameWithPanels {

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
	 * Create and Show GUI
	 */
	public static void createAndShowGUI() {
		// create a JFrame
		JFrame frame = new JFrame();
		// set title
		frame.setTitle("...: My Panels oriented frame :...");
		// set size
		frame.setSize(400, 200);
		// set location
		frame.setLocationRelativeTo(null); // to center a frame
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		int nLabels = 8;

		// activar uma das seguintes duas linhas
		GridLayout gl = new GridLayout(1, 2); // 1 linha, 2 colunas
		// GridLayout gl = new GridLayout(2, 1); // 2 linhas, 1 coluna
		frame.setLayout(gl);

		Random rg = new Random();

		// JPanel 1, com linhas
		JPanel panel1 = new JPanel();
		GridLayout gl1 = new GridLayout(nLabels, 1);
		panel1.setLayout(gl1);
		JLabel[] labels1 = new JLabel[nLabels];
		// criar JLabels
		for (int i = 0; i < nLabels; ++i) {
			JLabel label = labels1[i] = new JLabel();
			label.setOpaque(true);
			label.setBackground(new Color(rg.nextInt(256), rg.nextInt(256),
					rg.nextInt(256)));
			panel1.add(label);
		}
		// colocar a distancia vertical neste gridLayout
		gl1.setVgap(2);

		// JPanel 2, com colunas
		JPanel panel2 = new JPanel();
		GridLayout gl2 = new GridLayout(1, nLabels);
		// descomentar
		panel2.setLayout(gl2);

		// panel2.setLayout(new FlowLayout()); // FlowLayout.LEFT

		JLabel[] labels2 = new JLabel[nLabels];
		// criar JLabels
		for (int i = 0; i < nLabels; ++i) {
			JLabel label = labels2[i] = new JLabel("- - - - -");
			label.setOpaque(true);
			label.setBackground(new Color(rg.nextInt(256), rg.nextInt(256),
					rg.nextInt(256)));
			panel2.add(label);
		}
		// colocar a distancia horizontal neste gridLayout
		gl2.setHgap(2);

		// adicionar os JPanels á frame
		frame.add(panel1);
		frame.add(panel2);

		panel1.setBorder(new LineBorder(Color.orange, 15));
		panel2.setBorder(new LineBorder(Color.green, 5));

		// colocar a distancia horizontal do gridLayout de topo
		gl.setHgap(5);

		// exercício: colocar um lineBorder em cada um dos JPanels

		// frame.setMinimumSize(new Dimension(400, 400));

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);

		// life goes on
		System.out.println("Frame created...");

	}
}

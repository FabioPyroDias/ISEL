package classcode.p15Swing.p01layoutframes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * Demonstra a utilização de FlowLayout. Um flow layout dispõe os componentes em
 * linha, mas muda os componentes de linha quando necessário. Os componentes
 * podem ficar alinhados à esquerda, direita ou centro.
 * 
 * Assuntos: FlowLayout, LineBorder
 * 
 * 
 * @author António Teófilo
 * 
 */

public class C4FrameWithFlowLayout {

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
		frame.setTitle("...: My flow layout frame :...");
		// set size
		frame.setSize(400, 200);
		// set location at center
		frame.setLocationRelativeTo(null); 
		// close frame on close pressed
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		FlowLayout fl = new FlowLayout();
		frame.setLayout(fl);

		int nLabels = 10;

		Random rg = new Random();
		JLabel[] labels = new JLabel[nLabels];
		// criar JLabels
		for (int x = 0; x < nLabels; ++x) {
			JLabel label = labels[x] = new JLabel("   Label " + x + "  ");
			label.setOpaque(true);
			label.setBackground(new Color(rg.nextInt(256), rg.nextInt(256), rg
					.nextInt(256)));
			frame.add(label);
		}

		JLabel label = new JLabel(" Redimensionar lateralmente a janela ");
		// colocar um rebordo a azul para que se veja os contornos
		label.setBorder(new LineBorder(Color.BLUE, 2, true));
		frame.add(label);

		/**
		 * Teste 1 - alinhar à esquerda
		 */
//		fl.setAlignment(FlowLayout.LEFT);
		
		// frame.setMinimumSize(new Dimension(300, 300));
		// frame.setResizable(false);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);

		// life goes on
		System.out.println("Frame created...");

	}
}

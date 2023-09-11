package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * MouseAdapter
 * 
 * Um Adapter (neste contexto) é uma classe que implementa um Listener, mas
 * disponibilizando métodos com o corpo vazio. Deste modo, se um Listener tiver
 * 10 métodos, podemos facilmente criar uma classe derivada do respectivo
 * adapter (se existir) e só definir os métodos que queremos redefinir (porque
 * os outros já têm uma imlementação vazia). Um adapter só serve para não termos
 * de declarar todos os métodos em que não estamos interessados.
 * 
 * Assim, quando temos que utilizar parte dos métodos de um listener devemos
 * verificar se existe já um adpater definido. Caso não exista temos sempre a
 * possibilidade de fazer um nosso.
 * 
 * @author António Teófilo
 * 
 */
public class C2MyMouseAdapterFrame extends JFrame {

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
		setTitle("...: My Mouse Adapter frame :...");
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
		button1.addMouseListener(new MouseAdapter() {

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
					//C2MyMouseAdapterFrame.this.dispose();
					break;
				default:
					System.out.println(" other button...");
				}
			}

			// cool, we don't need to write the other methods :)
		});
		buttonsPanel.add(button1);

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
				C2MyMouseAdapterFrame myFrame = new C2MyMouseAdapterFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

/**
 * Exemplo de MouseAdapter
 */
class MyMouseAdapter implements MouseListener {

	public void mouseReleased(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
};

package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * MouseListener, mouse Events
 * 
 * Um Event Listener, é um objecto receptor de um tipo de eventos.
 * 
 * O MouseListener recebe os eventos do rato de: mouseEntered, mouseExited,
 * mousePressed, mouseReleased, mouseClicked
 * 
 * Relacionados com o rato existem ainda os seguintes listeners: "mouse-motion
 * listener", que recebe os eventos da posição do cursor sobre o componente; e
 * "mouse-wheel listener", recebe os eventos da roda do rato sobre o componente.
 * 
 * 
 * Além dos Listeners já mencionados nesta página, existem ainda mais uns
 * Listeners que são suportados por qualquer componente Swing: "component
 * listener"", recebe eventos de alteração de dimensão, posição e visibilidade;
 * "focus listener", eventos de adquirir e perder o focus, ou seja, a capacidade
 * de receber inputs do teclado; e "key listener", eventos relativos (às teclas)
 * do teclado. Os eventos do teclado são disparados somente no componente que
 * tem o focus.
 * 
 * 
 * Além dos Listeners que qualquer componente suporta, existem listeners
 * especifícos para certos componentes. Para mais informações consultar a
 * página: uiswing\events\eventsandcomponents.html do java Tutorial. Link
 * directo para a Oracle:
 * http://download.oracle.com/javase/tutorial/uiswing/events/
 * eventsandcomponents.html
 * 
 * 
 * Notar que os eventos estão declarados em: java.awt.event
 * 
 * @author António Teófilo
 * 
 */
public class C1MyMouseListenerFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Color normalColor = Color.yellow;

	private final Color mouseOverlabelColor = Color.green;

	private final Color mouseOverButtonColor = Color.red;

	private JLabel label1 = null;

	private JButton button1 = null;

	private JPanel buttonsPanel;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Mouse Listener frame :...");
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
		label1.setBackground(normalColor);
		add(label1, ProportionalLayout.CENTER);

		// button1
		button1 = new JButton("Ckick here!!!");
		MouseListener ml = new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				System.out.print("Mouse clicked...");
				int b = e.getButton();
				switch (b) {
				case MouseEvent.BUTTON1:
					System.out.println(" left button...");
					label1.setBackground(normalColor);
					break;
				case MouseEvent.BUTTON2:
					System.out.println(" center button... ");
					break;
				case MouseEvent.BUTTON3:
					System.out.println(" right button...");
					label1.setBackground(mouseOverlabelColor);
					break;
				default:
					System.out.println(" other button: " + b);
					// C1MyMouseListenerFrame.this.dispose(); // 118
				}
				//System.out.println("Click count = " + e.getClickCount());
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse entered...");
				label1.setBackground(mouseOverButtonColor);
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited...");
				label1.setBackground(normalColor);
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("Mouse pressed..." + e.getButton());
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse released...");
			}
		};

		// apenas lançado com click do botão do lado esquerdo do rato
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action event generated...");
			}
		});

		button1.addMouseListener(ml);
		buttonsPanel.add(button1);

		MouseListener lml = new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
			
			public void mouseEntered(MouseEvent e) {
				label1.setBackground(mouseOverlabelColor);
			}

			public void mouseExited(MouseEvent e) {
				label1.setBackground(normalColor);
			}	

		};

		// class MyMouseAdapter implements MouseListener {
		//
		// public void mouseReleased(MouseEvent e) {
		// }
		//
		// public void mousePressed(MouseEvent e) {
		// }
		//
		// public void mouseExited(MouseEvent e) {
		// }
		//
		// public void mouseEntered(MouseEvent e) {
		// }
		//
		// public void mouseClicked(MouseEvent e) {
		// }
		// }
		// ;
		//
		// MouseListener mlll = new MyMouseAdapter() {
		// public void mouseClicked(MouseEvent e) {
		// System.out.println("clicked");
		// }
		// };

		// this.addMouseListener(ml);

		// label1.addMouseListener(ml); // 207
		label1.addMouseListener(lml);

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
				C1MyMouseListenerFrame myFrame = new C1MyMouseListenerFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

// teste1: retirar o comentário da linha 122 e observar o resultado
// teste2: retirar o comentário da linha 207 e observar o resultado

package classcode.p15Swing.p05listenersAndAdapters;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * MouseAdapter - este exemplo pinta as células percorridas pelo rato\
 * 
 * Utiliza o ProportionalLayout
 * 
 * @author António Teófilo
 * 
 */
public class C9MouseAdapterExampleV2 extends JFrame {

	private static final long serialVersionUID = 1L;

	static final Color[] colors = { Color.green, Color.blue, Color.orange,
			Color.red, Color.magenta };

	static final Color SHIPCOLOR = new Color(20, 220, 140);

	static final Color BACKGROUNDCOLOR = new Color(120, 140, 240);

	// enumerado com as quatro direcções
	static enum Direction {
		UP, RIGHT, DOWN, LEFT
	};

	// array com as quatro direcções
	static Direction[] dirValues = Direction.values();

	GridLayout gl = null;

	JButton bReset = null;

	private JPanel buttonsPanel;

	LineBorder border = new LineBorder(Color.orange, 2);

	private JPanel p;

	Direction direction = Direction.UP;

	private int currentColor = 0;

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

		ProportionalLayout cl = new ProportionalLayout(0.1f, 0.2f, 0.1f, 0.1f);
		setLayout(cl);

		// use of BorderLayout
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new CenterLayout());
		add(buttonsPanel, ProportionalLayout.SOUTH);

		p = new JPanel(new GridLayout(10, 10, 1, 1));
		add(p, ProportionalLayout.CENTER);

		// button1
		bReset = new JButton("Reset board");
		bReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < p.getComponentCount(); i++) {
					((MyLabel) p.getComponent(i)).deactivate();
				}
			}
		});
		buttonsPanel.add(bReset);

		MouseListener lml = new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				((MyLabel) e.getSource()).activate(colors[currentColor]);
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("Changing color...");
				currentColor = (currentColor + 1) % colors.length;
			}
		};

		// create labels
		for (int i = 0; i < 100; i++) {
			JLabel l = new MyLabel();
			l.setOpaque(true);
			l.setBackground(BACKGROUNDCOLOR);
			l.addMouseListener(lml);
			p.add(l);
		}

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	/**
	 * 
	 */
	class MyLabel extends JLabel {
		private static final long serialVersionUID = 1L;
		boolean activated = false;

		void activate(Color color) {
			activated = true;
			setBackground(color);
		}

		void deactivate() {
			activated = false;
			setBackground(BACKGROUNDCOLOR);
		}
	}

	/**
	 * 
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C9MouseAdapterExampleV2 myFrame = new C9MouseAdapterExampleV2();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

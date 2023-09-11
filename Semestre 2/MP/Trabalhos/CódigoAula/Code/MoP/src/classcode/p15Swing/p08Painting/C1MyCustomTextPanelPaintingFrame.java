package classcode.p15Swing.p08Painting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Painting - desenhar livremente sobre um componente
 * 
 * @author António Teófilo
 * 
 */
public class C1MyCustomTextPanelPaintingFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static Random rg = new Random();

	GridLayout gl = null;

	JLabel label1 = null;

	JButton buttonLeft = null;

	JButton buttonRight = null;

	JButton buttonBottom = null;

	JButton buttonTop = null;

	private JPanel buttonsPanel;

	private MyPanel myPanel = null;

	private JPanel buttonsOuterPanel;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My first Painting frame :...");
		// set size
		// setSize(400, 200);
		setMinimumSize(new Dimension(500, 400));
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		ProportionalLayout cl = new ProportionalLayout(0.1f, 0.2f, 0.1f, 0.1f);
		setLayout(cl);

		// buttonsPanel
		buttonsPanel = new JPanel();
		buttonsOuterPanel = new JPanel(new CenterLayout());
		buttonsOuterPanel.add(buttonsPanel);
		add(buttonsOuterPanel, ProportionalLayout.SOUTH);

		myPanel = new MyPanel("This is my custom Panel!");
		// myPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		add(myPanel, ProportionalLayout.CENTER);

		// button1
		buttonLeft = new JButton(" left ");
		buttonsPanel.add(buttonLeft);
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveToLeft();
			}
		});

		buttonRight = new JButton("right");
		buttonsPanel.add(buttonRight);
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveToRight();
			}
		});

		buttonBottom = new JButton("bottom");
		buttonsPanel.add(buttonBottom);
		buttonBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveToBottom();
			}
		});

		buttonTop = new JButton(" top ");
		buttonsPanel.add(buttonTop);
		buttonTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveToTop();
			}
		});

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
				C1MyCustomTextPanelPaintingFrame myFrame = new C1MyCustomTextPanelPaintingFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}

	public static Color randomColor() {
		return new Color(rg.nextInt(255), rg.nextInt(255), rg.nextInt(255));
	}
}

/**
 *
 */
class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	String str = null;

	int x = 10;

	int y = 20;

	int step = 5;

	public MyPanel(String str) {
		this.str = str;
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.GREEN);
	}

	public Dimension getPreferredSize() {
		return new Dimension(250, 200);
	}

	// method callback that should paint the component
	public void paintComponent(Graphics g) {
		// first draw the super component
		// that means, draw the background object
		super.paintComponent(g);

		// Draw drawings on this object
		g.drawString(str, x, y);

		g.setColor(C1MyCustomTextPanelPaintingFrame.randomColor());
		g.drawLine(x, y + 10, x + 140, y + 10);

		g.setColor(C1MyCustomTextPanelPaintingFrame.randomColor());
		g.drawRoundRect(x, y + 20, 140, 10, 20, 3);

		g.setColor(C1MyCustomTextPanelPaintingFrame.randomColor());
		g.fillOval(x, y + 40, 140, 40);

		g.setColor(C1MyCustomTextPanelPaintingFrame.randomColor());
		g.drawOval(x, y + 40, 140, 40);

	}

	public void drawString(String str) {
		this.str = str;
		this.repaint();
	}

	public void moveToLeft() {
		x -= step;
		repaint();
	}

	public void moveToRight() {
		x += step;
		repaint();
	}

	public void moveToBottom() {
		y += step;
		repaint();
	}

	public void moveToTop() {
		y -= step;
		repaint();
	}
}

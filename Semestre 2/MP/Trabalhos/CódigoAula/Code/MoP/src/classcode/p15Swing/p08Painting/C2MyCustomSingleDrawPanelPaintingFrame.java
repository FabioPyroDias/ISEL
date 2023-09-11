package classcode.p15Swing.p08Painting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Painting - aqui pode-se seleccionar com o rato o quadrado que aparece e
 * colocá-lo noutro local. Verificar que o quadrado quando é premido o botão do
 * rato, desloca-se para baixo e esquerda do local do rato. Não é muito
 * estético. vamos resolver isso no próximo exemplo. Para tal temos que guardar
 * o offset relativo dentro do quadrado de modo a compensar sempre cada vez que
 * se mostra o quadrado.
 * 
 * @author António Teófilo
 * 
 */
public class C2MyCustomSingleDrawPanelPaintingFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	GridLayout gl = null;

	JLabel label1 = null;

	JButton buttonLeft = null;

	JButton buttonRight = null;

	JButton buttonBottom = null;

	JButton buttonTop = null;

	private JPanel buttonsPanel;

	private MyPanel2 myPanel = null;

	private JPanel buttonsOuterPanel;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My single drawing Painting frame :...");
		// set size
		setMinimumSize(new Dimension(400, 200));
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

		myPanel = new MyPanel2("Hello");
		add(myPanel, ProportionalLayout.CENTER);

		// button1
		buttonLeft = new JButton(" left ");
		buttonsPanel.add(buttonLeft);
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveStringToLeft();
			}
		});

		buttonRight = new JButton("right");
		buttonsPanel.add(buttonRight);
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveStringToRight();
			}
		});

		buttonBottom = new JButton("bottom");
		buttonsPanel.add(buttonBottom);
		buttonBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveStringToBottom();
			}
		});

		buttonTop = new JButton(" top ");
		buttonsPanel.add(buttonTop);
		buttonTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.moveStringToTop();
			}
		});

		System.out.println("Press mouse buttons inside panel");

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
				C2MyCustomSingleDrawPanelPaintingFrame myFrame = new C2MyCustomSingleDrawPanelPaintingFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

/**
 * 
 */
class MyPanel2 extends JPanel {

	private static final long serialVersionUID = 1L;

	String str = null;

	int x = 10;

	int y = 20;

	int step = 5;

	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 20;
	private int squareH = 20;

	public MyPanel2(String str) {
		this.str = str;
		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// call moveSquare or moveSquare2
				moveSquare2(e.getX(), e.getY());
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				// call moveSquare or moveSquare2
				moveSquare2(e.getX(), e.getY());
			}
		});

	}

	public void moveSquare(int x, int y) {
		if ((squareX != x) || (squareY != y)) {
			squareX = x;
			squareY = y;
			repaint(); // repaint geral a todo o componente
		}
	}

	/**
	 * Com clipping area
	 */
	private void moveSquare2(int x, int y) {
		int OFFSET = 1;
		if ((squareX != x) || (squareY != y)) {
			// redesenhar somente a antiga zona do quadrado
			// TEST comnetar a linha seguinte
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x;
			squareY = y;
			// redesenhar somente a nova zona do quadrado
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			// os dois repaints serão entregues agora no final do método
			// por isso o primeiro repaint já vai apanharo quadraddo na posição
			// final e vai desenhar o background
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw Text
		g.drawString(str, x, y);

		// draw the rectangle
		g.setColor(Color.RED);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);

	}

	public void drawString(String str) {
		this.str = str;
		this.repaint();
	}

	public void moveStringToLeft() {
		x -= step;
		repaint();
	}

	public void moveStringToRight() {
		x += step;
		repaint();
	}

	public void moveStringToBottom() {
		y += step;
		repaint();
	}

	public void moveStringToTop() {
		y -= step;
		repaint();
	}
}

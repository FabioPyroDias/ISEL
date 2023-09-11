package classcode.p15Swing.p08Painting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Painting - squares now move at all the same rhythm, they use all the same
 * timer. There is some information on the Panel class.
 * 
 * @author António Teófilo
 * 
 */
public class C4FallingBalls extends JFrame {

	private static final long serialVersionUID = 1L;

	static Random rg = new Random();

	JButton buttonClearAll = null;

	private JPanel buttonsPanel = null;

	private MyPanel31 myPanel = null;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My multi-drawings Painting frame :...");
		// set size
		setSize(800, 600);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		WindowAdapter wa = new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.out.println(" windowClosed...");
				myPanel.timer.stop();
			}
		};

		addWindowListener(wa);

		// button1
		JButton buttonClearAll = new JButton("Clear all");
		buttonClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.clearAll();
			}
		});

		buttonsPanel = new JPanel(new CenterLayout());
		buttonsPanel.add(buttonClearAll);

		getContentPane().setLayout(new ProportionalLayout(0.1f));

		myPanel = new MyPanel31();

		add(myPanel, ProportionalLayout.CENTER);
		add(buttonsPanel, ProportionalLayout.SOUTH);

		System.out.println("Press mouse buttons inside panel");

		// start to move the squares, after some initial delay
		myPanel.timer.setInitialDelay(100);
		myPanel.timer.start();

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
				C4FallingBalls myFrame = new C4FallingBalls();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

/**
 * Transformar esta classe numa classe Cenario
 */
class MyPanel31 extends JPanel {

	private static final long serialVersionUID = 1L;

	Square1[] squares = new Square1[10];

	int numberOfSquares = 1;

	Square1 currentSquare = null;

	int buttonPressed = -1;

	int deltaX = 0;
	int deltaY = 1;

	int width = 0;
	int height = 0;

	ActionListener alTimer = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			timerAction();
		}
	};

	Timer timer = new Timer(20, alTimer);

	public MyPanel31() {
		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// right mouse button
				buttonPressed = e.getButton();
				if (e.getButton() == MouseEvent.BUTTON3) {
					// left button - create new square
					if (numberOfSquares < squares.length) {
						squares[numberOfSquares] = new Square1(MyPanel31.this,
								e.getX(), e.getY(), new Color(
										C4FallingBalls.rg.nextInt(256),
										C4FallingBalls.rg.nextInt(256),
										C4FallingBalls.rg.nextInt(256)));
						currentSquare = squares[numberOfSquares];
						numberOfSquares++;
						deltaX = deltaY = 0;
						repaint();
					}
				} else {
					// right button - move squares
					// find if mouse is over one square
					for (int i = numberOfSquares - 1; i >= 0; i--) {
						if (squares[i].isXYOverSquare(e.getX(), e.getY())) {
							currentSquare = squares[i];
							// System.out.println("mouse over component...");
							deltaX = e.getX() - currentSquare.getX();
							deltaY = e.getY() - currentSquare.getY();
							break;
						}
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				currentSquare = null;
				buttonPressed = -1;
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (buttonPressed == MouseEvent.BUTTON1) {
					if (currentSquare != null)
						moveSquare(currentSquare, e.getX(), e.getY());
				}
			}
		});

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				System.out.println("Label resized...");
				resized();
			}
		});

		// first square
		squares[0] = new Square1(this, 50, 50, Color.red);
	}

	protected void resized() {
		width = getWidth();
		height = getHeight();

		System.out.println("width -> " + width + " height -> " + height);
	}

	private void timerAction() {
		for (int i = 0; i < numberOfSquares; i++) {
			squares[i].moveDown();
		}
		repaint();
	}

	public void clearAll() {
		for (int i = 0; i < numberOfSquares; i++) {
			squares[i] = null;
		}
		numberOfSquares = 0;
		repaint();
	}

	private void moveSquare(Square1 rs, int xx, int yy) {
		int x = rs.getX();
		int y = rs.getY();
		int width = rs.getWidth();
		int height = rs.getHeight();
		int OFFSET = 1;

		// The square is moving, repaint background
		// over the old square location.
		repaint(x, y, width + OFFSET, height + OFFSET);

		// Update coordinates.
		x = xx - deltaX;
		rs.setX(x);
		y = yy - deltaY;
		rs.setY(y);

		// Repaint the square at the new location.
		repaint(x, y, width + OFFSET, height + OFFSET);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < numberOfSquares; i++) {
			squares[i].paintSquare(g);
		}
	}
}

/**
 * 
 */
class Square1 {

	private int xPos = 50;
	private int yPos = 50;
	private int width = 20;
	private int height = 20;

	MyPanel31 myPanel;
	private Color color;

	public Square1(MyPanel31 myPanel, int x, int y, Color color) {
		this.myPanel = myPanel;
		xPos = x;
		yPos = y;
		this.color = color;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getX() {
		return xPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void paintSquare(Graphics g) {
		g.setColor(color);
		g.fillRect(xPos, yPos, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
	}

	public boolean isXYOverSquare(int x, int y) {
		return x >= getX() && x <= getX() + getWidth() && y >= getY()
				&& y <= getY() + getHeight();
	}

	public void moveDown() {
		yPos++;
		if (yPos + height > myPanel.height) {
			yPos = 0;
			xPos = C4FallingBalls.rg.nextInt(myPanel.width - width);
		}

		if (xPos + width > myPanel.width)
			xPos -= 2;
	}
}

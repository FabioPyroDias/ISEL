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
 * Painting - several squares, all of them share the same rhythm and timer. All
 * the information is on main class.
 * 
 * @author António Teófilo
 * 
 */
public class C5FallingBallsV2 extends JFrame {

	private static final long serialVersionUID = 1L;

	static Random rg = new Random();

	JButton buttonClearAll = null;

	private JPanel buttonsPanel = null;

	private MyPanel4 myPanel = null;

	Timer timer = null;

	Square2[] squares = new Square2[20];

	int numberOfSquares = 1;

	Square2 currentSquare = null;

	int buttonPressed = -1;

	int deltaX = 0;
	int deltaY = 1;

	int width = 0;
	int height = 0;

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
				timer.stop();
			}
		};
		addWindowListener(wa);

		// button1
		JButton buttonClearAll = new JButton("Clear all");
		buttonClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});

		buttonsPanel = new JPanel(new CenterLayout());
		buttonsPanel.add(buttonClearAll);

		getContentPane().setLayout(new ProportionalLayout(0.1f));

		myPanel = new MyPanel4();
		myPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		add(myPanel, ProportionalLayout.CENTER);
		add(buttonsPanel, ProportionalLayout.SOUTH);

		System.out.println("Press mouse buttons inside panel");

		// first square
		squares[0] = new Square2(myPanel, 50, 50, Color.red);

		ActionListener alTimer = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timerAction();
			}
		};
		timer = new Timer(20, alTimer);

		// start to move the squares, after some initial delay
		timer.setInitialDelay(100);
		timer.start();

		myPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// right mouse button
				buttonPressed = e.getButton();
				if (e.getButton() == MouseEvent.BUTTON3) {
					// left button - create new square
					if (numberOfSquares < squares.length) {
						squares[numberOfSquares] = new Square2(myPanel, e
								.getX(), e.getY(), new Color(
								C5FallingBallsV2.rg.nextInt(256),
								C5FallingBallsV2.rg.nextInt(256),
								C5FallingBallsV2.rg.nextInt(256)));
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

		myPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (buttonPressed == MouseEvent.BUTTON1) {
					if (currentSquare != null)
						moveSquare(currentSquare, e.getX(), e.getY());
				}
			}
		});

		myPanel.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				System.out.println("Label resized...");
				myPanelResized();
			}
		});

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	protected void myPanelResized() {
		width = myPanel.getWidth();
		height = myPanel.getHeight();
		System.out.println("width -> " + width + " height -> " + height);
	}

	private void timerAction() {
		for (int i = 0; i < numberOfSquares; i++) {
			squares[i].moveDown();
		}
		myPanel.repaint();
	}

	public void clearAll() {
		for (int i = 0; i < numberOfSquares; i++) {
			squares[i] = null;
		}
		numberOfSquares = 0;
		myPanel.repaint();
	}

	private void moveSquare(Square2 rs, int xx, int yy) {
		int x = rs.getX();
		int y = rs.getY();
		int width = rs.getWidth();
		int height = rs.getHeight();
		int OFFSET = 1;

		// The square is moving, repaint background
		// over the old square location.
		myPanel.repaint(x, y, width + OFFSET, height + OFFSET);

		// Update coordinates.
		x = xx - deltaX;
		rs.setX(x);
		y = yy - deltaY;
		rs.setY(y);

		// Repaint the square at the new location.
		myPanel.repaint(x, y, width + OFFSET, height + OFFSET);
		// myPanel.repaint();
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C5FallingBallsV2 myFrame = new C5FallingBallsV2();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}

	// MyPanel e Square como inner classes de modo a poderem aceder aos
	// atributos da classe C5FallingBalls

	// class MyPanel
	class MyPanel4 extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			// System.out.println("paintComponent called");
			super.paintComponent(g);
			for (int i = 0; i < numberOfSquares; i++) {
				squares[i].paintSquare(g);
			}

		}
	}

	/**
	 * class Square
	 */
	class Square2 {
		private int xPos;
		private int yPos;
		private int width = 20;
		private int height = 20;

		MyPanel4 myPanel;
		private Color color;

		public Square2(MyPanel4 myPanel, int x, int y, Color color) {
			this.myPanel = myPanel;
			this.color = color;
			xPos = x;
			yPos = y;
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
			if (yPos + height > C5FallingBallsV2.this.height) {
				yPos = 0;
				xPos = C5FallingBallsV2.rg.nextInt(C5FallingBallsV2.this.width
						- width);
			}

			if (xPos + width > C5FallingBallsV2.this.width)
				xPos -= 2;
		}
	}

}

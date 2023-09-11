package classcode.p15Swing.p08Painting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Painting - we can create more squares with the right mouse button. We can
 * move the squares with left muse button.
 * 
 * @author António Teófilo
 * 
 */
public class C3MyCustomMultiDrawPanelPaintingFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	GridLayout gl = null;

	JLabel label1 = null;

	JButton buttonClearAll = null;

	JButton buttonRight = null;

	JButton buttonBottom = null;

	JButton buttonTop = null;

	private JPanel buttonsPanel;

	private MyPanel3 myPanel = null;

	private JPanel buttonsOuterPanel;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My multi-drawings Painting frame :...");
		// set size
		setSize(600, 300);
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

		myPanel = new MyPanel3("Hello");
		add(myPanel, ProportionalLayout.CENTER);

		// buttonClearAll
		buttonClearAll = new JButton("Clear all");
		buttonsPanel.add(buttonClearAll);
		buttonClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.clearAll();
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
				C3MyCustomMultiDrawPanelPaintingFrame myFrame = new C3MyCustomMultiDrawPanelPaintingFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

class MyPanel3 extends JPanel {

	private static final long serialVersionUID = 1L;

	static final int DIMSQUARE = 20;

	Square[] squares = new Square[10];

	int numberOfSquares = 1;

	Square currentSquare = null;

	int buttonPressed = -1;

	int deltaX = 0;
	int deltaY = 0;

	public MyPanel3(String str) {
		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				buttonPressed = e.getButton();
				if (e.getButton() == MouseEvent.BUTTON3) {
					// right mouse button
					if (numberOfSquares < squares.length) {
						squares[numberOfSquares] = new Square(e.getX() - DIMSQUARE / 2, e.getY() - DIMSQUARE / 2,
								C1MyCustomTextPanelPaintingFrame.randomColor());
						repaint();
						currentSquare = squares[numberOfSquares];
						numberOfSquares++;
						deltaX = deltaY = 0;
					}
				} else {
					// button left
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
		// first square
		squares[0] = new Square(50, 50, Color.red);
	}

	public void clearAll() {
		for (int i = 0; i < numberOfSquares; i++) {
			squares[i] = null;
		}
		numberOfSquares = 0;
		repaint();
	}

	/**
	 * Repainting only the specific parts of this component.
	 * 
	 */
	private void moveSquare(Square rs, int x, int y) {
		// Current square state, stored as final variables
		// to avoid repeat invocations of the same methods.
		final int CURR_X = rs.getX();
		final int CURR_Y = rs.getY();
		final int CURR_W = rs.getWidth();
		final int CURR_H = rs.getHeight();
		final int OFFSET = 1;

		if ((CURR_X != x) || (CURR_Y != y)) {
			// The square is moving, repaint background
			// over the old square location.
			repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);

			// Update coordinates.
			rs.setX(x - deltaX);
			rs.setY(y - deltaY);

			// Repaint the square at the new location.
			repaint(rs.getX(), rs.getY(), rs.getWidth() + OFFSET, rs.getHeight() + OFFSET);

			// repaint();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < numberOfSquares; i++) {
			squares[i].paintSquare(g);
		}
	}
}

class Square {

	private int xPos = 50;
	private int yPos = 50;
	private int width = MyPanel3.DIMSQUARE;
	private int height = MyPanel3.DIMSQUARE;

	private Color color;

	public Square(int x, int y, Color color) {
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
		return x >= getX() && x <= getX() + getWidth() && y >= getY() && y <= getY() + getHeight();
	}
}

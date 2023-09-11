package classcode.p15Swing.p10Sound;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Novidades: scale an image, neste exemplo é utilizado o método g2.drawImage
 * que permite desenhar num x,y e com um width,height, ou seja, faz o scaling em
 * cada draw.
 * 
 * @author António Teófilo
 * 
 */
public class C03SeveralImages extends JFrame {

	enum COLISION {
		NOPE, GODOWN, GOUP, GORIGHT, GOLEFT
	};

	private static final long serialVersionUID = 1L;

	private static final int NFISHES = 3;

	private static final int TIMERDELAY = 50;

	static Random rg = new Random();

	private MyPanel panelCenter = null;

	private JButton buttonGrow = null;

	private JButton buttonShrink = null;

	JPanel panelControl = null;

	private final Color greenColor = new Color(0, 200, 0);

	private ImageIcon icon;

	private JButton stepButton;

	private Timer timer;

	private JButton startStopTimerButton;

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Several Images frame :...");
		// set size
		setSize(600, 400);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// add JLabel at center
		JPanel jpCenterOuter = new JPanel();
		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.15f, 0.1f, 0.1f, 0.1f);
		jpCenterOuter.setLayout(cl);

		// build JLabel
		panelCenter = new MyPanel();
		panelCenter.setOpaque(true);
		panelCenter.setBackground(greenColor);

		jpCenterOuter.add(panelCenter);
		add(jpCenterOuter, BorderLayout.CENTER);

		// Painel dos botões
		panelControl = new JPanel(); // Janel default layout -> FlowLayout
		TitledBorder tb = new TitledBorder("Control panel");
		tb.setTitleJustification(TitledBorder.CENTER);
		panelControl.setBorder(tb);

		stepButton = new JButton("Step");
		stepButton.setSelected(false);
		stepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stepAction();
			}
		});
		panelControl.add(stepButton);

		startStopTimerButton = new JButton("Stop Timer");
		startStopTimerButton.setSelected(false);
		startStopTimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startStopTimerAction();
			}
		});
		panelControl.add(startStopTimerButton);

		// buttonStart
		buttonGrow = new JButton("Grow");
		buttonGrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				growActions();
			}
		});
		panelControl.add(buttonGrow);

		// buttonStop
		buttonShrink = new JButton("Shrink");
		buttonShrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shrinkActions();
			}
		});
		panelControl.add(buttonShrink);

		// adicionar o painel do botões à frame principal
		add(panelControl, BorderLayout.PAGE_END);

		icon = C01ImageManager.Images.PUFFERFISH.getImageIcon();
		// panelFish.setIcon(icon);
		for (int i = 0; i < NFISHES; i++) {
			Fish f = new Fish(icon, rg.nextInt(1000), rg.nextInt(1000),
					rg.nextInt(4), panelCenter);
			panelCenter.addFish(f);
		}

		startMovements();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				C03SeveralImages.this.windowClosing();
			}
		});

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	/**
	 *
	 */
	protected void startStopTimerAction() {
		if (timer.isRunning()) {
			timer.stop();
			startStopTimerButton.setText("Start timer");
		} else {
			timer.start();
			startStopTimerButton.setText("Stop timer");
		}
	}

	/**
	 *
	 */
	protected void windowClosing() {
		if (timer.isRunning())
			timer.stop();
	}

	/**
	 *
	 */
	private void stepAction() {
		panelCenter.step();
	}

	/**
	 *
	 */
	private void growActions() {
		panelCenter.grow();
		panelCenter.repaint();
	}

	/**
	 *
	 */
	private void shrinkActions() {
		panelCenter.shrink();
		panelCenter.repaint();
	}

	/**
	 *
	 */
	private void startMovements() {
		timer = new Timer(TIMERDELAY, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCenter.step();
			}
		});
		timer.start();
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C03SeveralImages myFrame = new C03SeveralImages();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}

	/**
	 *
	 */
	class MyPanel extends JPanel {
		private static final long serialVersionUID = -4351607655559842105L;

		ArrayList<Fish> fishes = new ArrayList<Fish>();

		/**
		 *
		 */
		public void paintComponent(Graphics g) {
			// draw background
			super.paintComponent(g);
			// draw fishes
			for (Fish fish : fishes) {
				fish.paintComponent(g);
			}
		}

		/**
		 *
		 */
		public void step() {

			System.out.println("step...");
			for (Fish fish : fishes) {
				fish.step();
			}
			for (int i = 0; i < fishes.size(); ++i) {
				Fish fish = fishes.get(i);
				for (int j = 0; j < fishes.size(); ++j) {
					if (j == i)
						continue;
					fish.adjustPosition(fishes.get(j));
				}
				fish.step();
			}

			repaint();
		}

		/**
		 *
		 */
		public void grow() {
			for (Fish fish : fishes) {
				fish.grow();
			}
		}

		/**
		 *
		 */
		public void shrink() {
			for (Fish fish : fishes) {
				fish.shrink();
			}
		}

		/**
		 *
		 */
		void addFish(Fish fish) {
			fishes.add(fish);
		}
	}

	/**
	 *
	 */
	class Fish {

		final int STEP = 2;

		int iconWidth = 0;
		int iconHeigth = 0;

		int iconWidthScaled = 0;
		int iconHeigthScaled = 0;

		float scale = 0.3f;

		Image image = null;

		JPanel panel = null;

		int x = 0;
		int y = 0;

		// 0 - east, 1 - south, 2 - west, 3 - north
		int direction = 0;

		/**
		 *
		 */
		public Fish(ImageIcon icon, int x, int y, int direction, JPanel panel) {
			setIcon(icon);
			this.direction = direction % 4;
			this.panel = panel;
			this.x = x;
			this.y = y;
		}

		/**
		 *
		 */
		public void adjustPosition(Fish fish) {
			int panelWith = panel.getWidth();
			int panelheight = panel.getHeight();

			COLISION colision = colidesWith(fish);
			if (colision != COLISION.NOPE)
				System.out.println("Colision...");

			switch (colision) {
			case GODOWN:
				y += STEP;
				if ((panelheight * y) / 1000.0f >= panelheight
						- iconHeigth * scale)
					y -= STEP;
				System.out.println("y -> " + y);
				break;
			case GOUP:
				y -= STEP;
				if (--y < 0)
					y += STEP;
				System.out.println("y -> " + y);
				break;
			case GORIGHT:
				x += STEP;
				if ((panelWith * x) / 1000.0f >= panelWith - iconWidth * scale)
					x -= STEP;
				System.out.println("x -> " + x);
				break;
			case GOLEFT:
				x -= STEP;
				if (--x < 0)
					x += STEP;
				System.out.println("x -> " + x);
			default:
				break;
			}
		}

		/**
		 *
		 */
		int getCenterX() {
			return (int) ((x * panel.getWidth()) / 1000.0f + iconWidth / 2);
		}

		/**
		 *
		 */
		int getCenterY() {
			return (int) ((y * panel.getHeight()) / 1000.0f + iconHeigth / 2);
		}

		/**
		 *
		 */
		private COLISION colidesWith(Fish fish) {
			int panelWith = panel.getWidth();
			int panelHeight = panel.getHeight();
			// check if there is a collision
			int xi1 = (int) (x * panelWith / 1000.0f);
			int xi2 = (int) (fish.x * panelWith / 1000.0f);
			int xf1 = xi1 + iconWidthScaled;
			int xf2 = xi2 + fish.iconWidthScaled;

			int yi1 = (int) (y * panelHeight / 1000.0f);
			int yi2 = (int) (fish.y * panelHeight / 1000.0f);
			int yf1 = yi1 + iconHeigthScaled;
			int yf2 = yi2 + fish.iconHeigthScaled;

			if (!(((xi1 >= xi2 && xi1 <= xf2) || (xf1 >= xi2 && xf1 <= xf2)
					|| (xi2 >= xi1 && xi2 <= xf1))
					&& ((yi1 >= yi2 && yi1 <= yf2) || (yf1 >= yi2 && yf1 <= yf2)
							|| (yi2 >= yi1 && yi2 <= yf1))))
				return COLISION.NOPE;

			int yCenter = getCenterY();
			int yFishCenter = fish.getCenterY();
			int xCenter = getCenterX();
			int xFishCenter = fish.getCenterX();

			if (direction == 1) {
				if (yCenter >= yFishCenter)
					return COLISION.GODOWN;
				return COLISION.GOUP;
			}
			if (direction == 3) {
				if (yCenter < yFishCenter)
					return COLISION.GOUP;
				return COLISION.GODOWN;
			}
			if (direction == 0) {
				if (xCenter >= xFishCenter)
					return COLISION.GORIGHT;
				return COLISION.GOLEFT;
			}
			if (direction == 2) {
				if (xCenter < xFishCenter)
					return COLISION.GOLEFT;
				return COLISION.GORIGHT;
			}
			System.out.println(
					"will return null - invalid direction -> " + direction);
			return null;
		}

		/**
		 *
		 */
		public void step() {
			int panelWith = panel.getWidth();
			int panelheight = panel.getHeight();

			if (direction == 1) {
				x += STEP;
				if ((panelWith * x) / 1000.0f >= panelWith - iconWidthScaled) {
					x = x - 2 * STEP;
					direction = 3;
				}
			} else if (direction == 3) {
				x -= STEP;
				if (--x < 0) {
					x = 1;
					direction = 1;
				}
			}
			if (direction == 2) {
				y += STEP;
				if ((panelheight * y) / 1000.0f >= panelheight
						- iconHeigthScaled) {
					y = y - 2 * STEP;
					direction = 0;
				}
			} else if (direction == 0) {
				y -= STEP;
				if (--y < 0) {
					y = 1;
					direction = 2;
				}
			}

		}

		/**
		 *
		 */
		public void setIcon(ImageIcon icon) {
			image = icon.getImage();
			iconWidth = icon.getIconWidth();
			iconHeigth = icon.getIconHeight();
			scale();
		}

		/**
		 *
		 */
		public void shrink() {
			scale *= 0.8;
			scale();
			System.out.println("new scale -> " + scale);
			repaint();
		}

		/**
		 *
		 */
		public void grow() {
			scale *= 1.2;
			scale();
			System.out.println("new scale -> " + scale);
			repaint();
		}

		/**
		 *
		 */
		private void scale() {
			iconWidthScaled = (int) (iconWidth * scale);
			iconHeigthScaled = (int) (iconHeigth * scale);
		}

		/**
		 *
		 */
		public void paintComponent(Graphics g) {
			int panelWith = panel.getWidth();
			int panelheight = panel.getHeight();

			Graphics2D g2 = (Graphics2D) g;
			// scaling by buttons
			g2.drawImage(image, (int) (x * panelWith / 1000.0f),
					(int) (y * panelheight / 1000.0f),
					(int) (iconWidth * scale), (int) (iconHeigth * scale),
					null);
		}
	}
}

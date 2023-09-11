package tps.tp1.pack1Ciclos;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import tps.layouts.ProportionalLayout;

public class P03ColorFrame extends JFrame {
	private static final long serialVersionUID = -330888082383077655L;

	private static Color INITIAL_COLOR_0   = Color.GREEN;
	private static Color INITIAL_COLOR_90  = Color.RED;
	private static Color INITIAL_COLOR_180 = Color.BLUE;
	private static Color INITIAL_COLOR_270 = Color.ORANGE;

	
	private MyLabel label1;
	private JButton bnColor0;
	private JButton bnColor90;
	private JButton bnColor180;
	private JButton bnColor270;
	
	/**
	 * init
	 */
	protected void init() {
		setTitle("...: ColorFrame :...");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// panel central
		JPanel jpCentral = new JPanel(new ProportionalLayout(0.1f));
		jpCentral.setBackground(Color.WHITE);
		jpCentral.setOpaque(true);
		add(jpCentral, BorderLayout.CENTER);

		// label central
		label1 = new MyLabel();
		jpCentral.add(label1, ProportionalLayout.CENTER);	

		// buttons panel
		JPanel jpButtons = new JPanel();
		add(jpButtons, BorderLayout.SOUTH);

		// button outside color
		bnColor0 = new JButton("Color 0�");
		bnColor0.setBackground(INITIAL_COLOR_0);
		bnColor0.setOpaque(true);
		bnColor0.setHorizontalAlignment(SwingConstants.CENTER);
		jpButtons.add(bnColor0);

		// button inside color
		bnColor90 = new JButton("Color 90�");
		bnColor90.setBackground(INITIAL_COLOR_90);
		bnColor90.setOpaque(true);
		bnColor90.setHorizontalAlignment(SwingConstants.CENTER);
		jpButtons.add(bnColor90);

		 // button inside color
	     bnColor180 = new JButton("Color 180�");
		 bnColor180.setBackground(INITIAL_COLOR_180);
		 bnColor180.setOpaque(true);
		 bnColor180.setHorizontalAlignment(SwingConstants.CENTER);
		 jpButtons.add(bnColor180);
		 
		// button color at 0
	     bnColor270 = new JButton("Color 270�");
		 bnColor270.setBackground(INITIAL_COLOR_270);
		 bnColor270.setOpaque(true);
		 bnColor270.setHorizontalAlignment(SwingConstants.CENTER);
		 jpButtons.add(bnColor270);
		 
		// button color at 90
		 bnColor0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(P03ColorFrame.this, "Choose Color at 0�", bnColor0.getBackground());
				if(newColor != null) bnColor0.setBackground(newColor);
				label1.repaint();
			}
		});

		// button color at 180
		bnColor90.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(P03ColorFrame.this, "Choose Color at 90�", bnColor90.getBackground());
				if(newColor != null) bnColor90.setBackground(newColor);
				label1.repaint();
			}
		});

		// button color at 180
		bnColor180.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(P03ColorFrame.this, "Choose Color at 180�",
				bnColor180.getBackground());
				if(newColor != null) bnColor180.setBackground(newColor);
				label1.repaint();
			}
		});
		
		// button color at 270
		bnColor270.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Color newColor = JColorChooser.showDialog(P03ColorFrame.this, "Choose Color at 270�", bnColor270.getBackground());
				if(newColor != null) bnColor270.setBackground(newColor);
				label1.repaint();
			}
		});	
		
		
		// set frame visible
		setVisible(true);
	}

	/**
	 * Main method - the execution starts here
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				P03ColorFrame frame = new P03ColorFrame();
				frame.init();
			}
		});
	}

	/**
	 * Auxiliary class that extends JLabel
	 */
	class MyLabel extends JLabel {
		private static final long serialVersionUID = -4402584053051810107L;

		{
			// setBorder(BorderFactory.createLineBorder(Color.GRAY));
			setBackground(new Color(255, 255, 255));
			setOpaque(true);
		}

		public void paint(Graphics g) {
			super.paint(g);
			System.out.println("Paint...");
            drawColors(g, getWidth(), getHeight(), bnColor0.getBackground(), bnColor90.getBackground(), bnColor180.getBackground(),bnColor270.getBackground());
		}

		/**
		 * Should draw all the drawing area with lines with color varying from
		 * outsideColor to insideColor. See example in the text.
		 * 
		 * @param g            the graphics where we should draw the lines
		 * @param dimX         x dimension of drawing area
		 * @param dimY         y dimension of drawing area
		 * @param outsideColor outside color
		 * @param insideColor  inside color
		 */
		private void drawColors(Graphics g, int dimX, int dimY, Color c0, Color c90, Color c180, Color c270) {
	
			Graphics2D gd2 = (Graphics2D)g;
			int centerX = dimX/2;
		    int centerY = dimY/2;
		    int radius = (dimX > dimY) ? dimY/2 : dimX/2;
		    
		    //TO DO
		    //Alterar e trabalhar apenas dentro deste m�todo.
		    
		    gd2.setStroke(new BasicStroke(2));
            g.setColor(c0);         
            g.drawLine(centerX, centerY, centerX + radius,centerY);
            
        }
	
	}		
}



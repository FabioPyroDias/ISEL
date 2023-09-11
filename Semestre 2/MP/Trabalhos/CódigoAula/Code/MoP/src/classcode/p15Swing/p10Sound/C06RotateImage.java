package classcode.p15Swing.p10Sound;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * builds a frame with rotated and scaled icon in a label
 */
public class C06RotateImage extends JFrame {
	private static final long serialVersionUID = 1L;

	private static double DELTATHETA = Math.PI / 2;

	/**
	 * Initializes JFrame
	 */
	public C06RotateImage() {
		setTitle("Rotate and scale Image");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		TheLabel lab = new TheLabel();
		add(lab);

		setSize(400, 400);
		setLocationRelativeTo(null);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lab.rotate();
			}

		});
		setVisible(true);
	}

	/**
	 * Rotate received icon
	 */
	private ImageIcon rotateIcon(ImageIcon ic, double theta) {
		Image image = ic.getImage();

		// Get buffered image from original image
		BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = bimage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();

		// Define rotation transformation
		AffineTransform tx = AffineTransform.getRotateInstance(theta, bimage.getWidth() / 2, bimage.getHeight() / 2);

		// Transformation operation with interpolation
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		// apply the transformation operation
		bimage = op.filter(bimage, null);

		return new ImageIcon(bimage);
	}

	/**
	 * the label with icon
	 */
	public class TheLabel extends JLabel implements ComponentListener {
		private static final long serialVersionUID = 1L;

		private ImageIcon icon;

		private ImageIcon currentIcon;

		private double theta = Math.PI / 2;

		/**
		 * build the label with rotated icon
		 */
		public TheLabel() {
			setHorizontalAlignment(SwingConstants.CENTER);

			// get original image
			icon = getImageIcon("puffer_fish.jpg");

			currentIcon = rotateIcon(icon, theta);

			// set rotated icon
			setIcon(currentIcon);

			addComponentListener(this);
		}

		/*
		 * 
		 */
		public void rotate() {
			theta += DELTATHETA;
			currentIcon = rotateIcon(icon, theta);
			Image img = currentIcon.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_DEFAULT);
			setIcon(new ImageIcon(img));
		}

		/**
		 * Resize image
		 */
		public void componentResized(ComponentEvent e) {
			System.out.println("Image resized...");
			// adjust scaled image
			Image img = currentIcon.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_DEFAULT);
			setIcon(new ImageIcon(img));
			
		}

		public void componentMoved(ComponentEvent e) {

		}

		public void componentShown(ComponentEvent e) {

		}

		public void componentHidden(ComponentEvent e) {

		}
	}

	/**
	 * get imageIcon from file
	 */
	public ImageIcon getImageIcon(String fileName) {

		String path = "images/" + fileName;

		java.net.URL imgURL = this.getClass().getResource(path);
		if (imgURL == null) {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
		ImageIcon ic = new ImageIcon(imgURL);
		if (ic.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
			System.err.println("Couldn't load file: " + path);
			return null;
		}
		System.out.println("Image: " + path + " loaded");
		return ic;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new C06RotateImage();
			}
		});
	}
}

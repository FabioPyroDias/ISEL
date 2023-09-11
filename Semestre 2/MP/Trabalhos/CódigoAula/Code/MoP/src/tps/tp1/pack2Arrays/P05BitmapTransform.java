package tps.tp1.pack2Arrays;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * Apply a fancy border to an image
 * 
 * @author António Teófilo and Pedro Fazenda
 * 
 */
public class P05BitmapTransform {
	public static final String IMAGEPATH = "images/image1.jpg";
//	public static final String IMAGEPATH = "images/image2.jpg";
//	public static final String IMAGEPATH = "images/image3.jpg";

	
	/**
	 * This method transforms an image into grayscale.
	 * 
	 * @param image the image to be transformed
	 * @return a new image in grayscale
	 */
	public static BufferedImage makeGrayscale(BufferedImage image) {

		int height = image.getHeight();
		int width = image.getWidth();

		System.out.println("Image height = " + height);
		System.out.println("Image width = " + width);

		// create new image
		BufferedImage bi = new BufferedImage(width, height, image.getType());

		// copy image
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int pixelRGB = image.getRGB(x, y);
				int r = getRGBRed(pixelRGB); 
				int g = getRGBGreen(pixelRGB);
				int b = getRGBBlue(pixelRGB);
				int Y = (int)(0.299*(double)r + 0.587*(double)g + 0.114*(double)b);
				int newPixelRGB = 0;
				newPixelRGB = setRGBRed(newPixelRGB, Y);
				newPixelRGB = setRGBGreen(newPixelRGB, Y);
				newPixelRGB = setRGBBlue(newPixelRGB, Y);
				bi.setRGB(x, y, newPixelRGB);
			}
		}
	
		return bi;
		
	}
	
	
	

	/**
	 * This method adds borders to an image.
	 * 
	 * @param enlargeFactorPercentage the border in percentage
	 * @param dimAvg                  the radius in pixels to get the average color
	 *                                of each pixel for the border
	 * 
	 * @return a new image extended with borders
	 */
	public static BufferedImage addBorders(BufferedImage image, int enlargeFactorPercentage, int dimAvg) {

		// TODO method to be done

		int height = image.getHeight();
		int width = image.getWidth();

		System.out.println("Image height = " + height);
		System.out.println("Image width = " + width);

		// create new image
		BufferedImage bi = new BufferedImage(width, height, image.getType());

		// copy image
		for (int y = 0; y < height / 2; y++) {
			for (int x = 0; x < width / 2; x++) {
				int pixelRGB = image.getRGB(x, y);
				bi.setRGB(x, y, pixelRGB);
			}
		}

		// draw top and bottom borders

		// draw left and right borders

		// draw corners

		return bi;
	}
	
	/**
	 * TODO Method to be done.
	 * 
	 * gets the average RGB from image (x,y)
	 * 
	 * First finish previous method, without changing this one
	 */
	public static int getAvgRGB(int x, int y, BufferedImage image, int dim) {

		// TODO method to be done

		int pixelRGB = image.getRGB(x, y);

		return pixelRGB;
	}

	
	/**
	 * show original image
	 * 
	 */
	public static void showOriginalImageTask() throws IOException {
		// read the image to memory
		BufferedImage image = loadImage(IMAGEPATH);

		// show original image
		buildFrameForImage(image, "Original image");
	}

	/**
	 * show image in greyscale
	 * 
	 */
	public static void showGrayscaleTask() throws IOException {

		// read the image to memory
		BufferedImage image = loadImage(IMAGEPATH);
		
		// apply reduction
		BufferedImage newImage = makeGrayscale(image);

		// show reduced image
		buildFrameForImage(newImage, "Grayscale Image");

	}

	/**
	 * add borders to image
	 * 
	 */
	public static void AddBordersTask() throws IOException {
		// read the image to memory
		BufferedImage image = loadImage(IMAGEPATH);

		int dim = 5;

		// apply reduction
		BufferedImage newImage = addBorders(image, 10, dim);

		// show reduced image
		buildFrameForImage(newImage, "Image with borders, DIM = " + dim);
	}
	
	/**
	 * load image
	 */

	private static BufferedImage loadImage(String imagePath) throws IOException {
		return ImageIO.read(P05BitmapTransform.class.getResource(imagePath));
	}
	
	/**
	 * Method that shows one image ina new frame
	 */
	public static void buildFrameForImage(BufferedImage image, String title) throws IOException {
		// the frame
		JFrame frame = new JFrame(title);

		// frame should be disposed when we press close button
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// set frame size
		frame.setSize(400, 300);

		// center the frame
		frame.setLocationRelativeTo(null);

		// show the image inside a label
		ImageIcon img = new ImageIcon(image);
		JLabel label = new JLabel(img, JLabel.CENTER);
		// add the label to frame
		frame.add(label);

		// turn frame visible
		frame.setVisible(true);
	}

	/**
	 * method that gets the blue value from a RGB pixel value
	 */
	static int getRGBBlue(int rgb) {
		return (rgb) & 0xFF;
	}

	/**
	 * method that gets the green value from a RGB pixel value
	 */
	static int getRGBGreen(int rgb) {
		return (rgb >> 8) & 0xFF;
	}

	/**
	 * method that gets the red value from a RGB pixel value
	 */
	static int getRGBRed(int rgb) {
		return (rgb >> 16) & 0xFF;
	}

	/**
	 * method that set the blue value to a RGB pixel value
	 * 
	 * @return the new pixel RGB value
	 */
	static int setRGBBlue(int rgb, int blue) {
		return (rgb & 0xFFFFFF00) | (blue & 0xFF);
	}

	/**
	 * method that sets the green value to a RGB pixel value
	 * 
	 * @return the new pixel RGB value
	 */
	static int setRGBGreen(int rgb, int green) {
		return (rgb & 0xFFFF00FF) | ((green & 0xFF) << 8);
	}

	/**
	 * method that sets the red value to a RGB pixel value
	 * 
	 * @return the new pixel RGB value
	 */
	static int setRGBRed(int rgb, int red) {
		return ((red & 0xFF) << 16) | rgb & 0xFF00FFFF;
	}

	/**
	 * Main method - execution entry point
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					// show original image
					showOriginalImageTask();

					// show a new image with in grayscale
					showGrayscaleTask();

					// Add borders to the image
					AddBordersTask();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

	}

}























	
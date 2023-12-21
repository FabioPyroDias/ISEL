package GestAl;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Base64;

import javax.imageio.*;
import javax.swing.*;

public class Foto {
	byte[] img = null;

	public final static String omissa = "silhueta.jpg";
	public static String path = "src/main/webapp/";

	public static void main(String[] args) throws Exception { 
		Foto ft1 = new Foto();
		Foto ft2 = new Foto();
		String f1="p1.jpg";
		String f2="p2.jpg";
		Foto.setPath("C:\\Partilha\\ISEL\\SBD\\2022-2023 Inv\\Laboratório\\2AulaPratica\\fotos\\");
		ft1.load(f1);
		ft1.show("Fotografia: "+f1);
		ft2.load(f2);
		ft2.show("Fotografia: "+f2);
		System.out.println("Semelhança: "+ft1.compareTo(ft2)+"%");
	}
	// modifica o caminho estabelecido por omissão
	public static void setPath(String path) {
		Foto.path=path;
	}
	// modifica o byte[] armazenado
	public void setFoto(byte[] img) {
		this.img=img;
	}
	//devolve o byte[] armazenado
	public byte[] getFoto() {
		return img;
	}
	// usa base64 para modificar o byte[] armazenado 
	public void setFoto64(String encoded64) {
		Base64.getDecoder().decode(encoded64);
	}
	// devolve a imagem em base64
	public String getFoto64() {
		return Base64.getEncoder().encodeToString(img);
	}
	// transforma o byte[] em BufferedImage
	private static BufferedImage createImageFromBytes(byte[] imageData) {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);) {
			// RGBA stands for red green blue alpha.
			// TYPE_INT_ARGB means that we are
			// representing the RGBA
			// component of the image pixel using 8 bit
			// integer value.
			// image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			return ImageIO.read(bais);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	// devolve o objeto que representa a imagem
	public BufferedImage getBufferedImage() {
		return Foto.createImageFromBytes(img);
	}
	// facilita o título da janela por omissão
	public void show() {
		show("Fotografia");
	}
	// mostra a imagem mantida no byte[] foto
	public void show(String titulo) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame editorFrame = new JFrame(titulo);
				// editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				BufferedImage image = null;
				if (img == null)
					try {
						load(omissa);
					} catch (Exception e) {
						return;
					}
				image = getBufferedImage();
				ImageIcon imageIcon = new ImageIcon(image);
				JLabel jLabel = new JLabel();
				jLabel.setIcon(imageIcon);
				editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
				editorFrame.pack();
				editorFrame.setLocationRelativeTo(null);
				editorFrame.setVisible(true);
			}
		});
	}
	// define a imagem a partir do ficheiro indicado em parametro
	public void load(final String filename) throws Exception {
		// Creating an object of File class and
		// providing local directory path of a file
		File file = new File(path + filename);
		// Creating an object of FileInputStream to
		// read from a file
		FileInputStream fl = new FileInputStream(file);
		// Now creating byte array of same length as file
		img = new byte[(int) file.length()];
		// Reading file content to byte array
		// using standard read() method
		fl.read(img);
		// lastly closing an instance of file input stream
		// to avoid memory leakage
		fl.close();
	}
	// escreve a imagem no ficheiro indicado em parametro
	public void save(final String filename) throws Exception {
		 FileOutputStream fos = new FileOutputStream(path + filename); 
         fos.write(img);
         fos.close();
	}
	// Compara com a imagem e devolve a percentagem de semelhança
	public BigDecimal compareTo(Foto ft) throws Exception {
		BufferedImage imgA = getBufferedImage();
		BufferedImage imgB = ft.getBufferedImage();
		// Assigning dimensions to image
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();
		// Checking whether the images are of same size
		if ((width1 != width2) || (height1 != height2)) {
			// Display message straightaway
			System.out.println("Error: Images dimensions" + " mismatch");
			return new BigDecimal(-1);
		}
		// By now, images are of same size
		long difference = 0;
		// Treating images likely 2D matrix
		// Outer loop for rows(height)
		for (int y = 0; y < height1; y++) {
			// Inner loop for columns(width)
			for (int x = 0; x < width1; x++) {
				int rgbA = imgA.getRGB(x, y);
				int rgbB = imgB.getRGB(x, y);
				int redA = (rgbA >> 16) & 0xff;
				int greenA = (rgbA >> 8) & 0xff;
				int blueA = (rgbA) & 0xff;
				int redB = (rgbB >> 16) & 0xff;
				int greenB = (rgbB >> 8) & 0xff;
				int blueB = (rgbB) & 0xff;
				difference += Math.abs(redA - redB);
				difference += Math.abs(greenA - greenB);
				difference += Math.abs(blueA - blueB);
			}
		}
		// Total number of red pixels = width * height
		// Total number of blue pixels = width * height
		// Total number of green pixels = width * height
		// So total number of pixels = width * height * 3
		double total_pixels = width1 * height1 * 3;
		// Normalizing the value of different pixels
		// for accuracy
		// Note: Average pixels per color component
		double avg_different_pixels = difference / total_pixels;
		// There are 255 values of pixels in total
		double percentage = (avg_different_pixels / 255) * 100;
		BigDecimal bd = BigDecimal.valueOf(100-percentage);
		return bd.setScale(2, RoundingMode.HALF_UP);
	}
}
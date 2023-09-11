

/**
 * @author PFilipe
 *
 */
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * A Java class to demonstrate how to load an image from disk with the
 * ImageIO class. Also shows how to display the image by creating an
 * ImageIcon, placing that icon an a JLabel, and placing that label on
 * a JFrame.
 * 
 * @author alvin alexander, devdaily.com
 */
public class ImageDemo
{
  public static void main(String[] args) throws Exception
  {
    // new ImageDemo(args[0]);
	  new ImageDemo("WebContent"+ File.separator + "fotos"+ File.separator + "isel.png");
  }

  private BufferedImage createImageFromBytes(byte[] imageData) {
	    ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
	    try {
	        return ImageIO.read(bais);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}
  
  public ImageDemo(byte[] foto) {
	    SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	        JFrame editorFrame = new JFrame("Fotografia");
	        //editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        
	        BufferedImage image = createImageFromBytes(foto);
	       
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
  
  public ImageDemo(final String filename) throws Exception
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        JFrame editorFrame = new JFrame("Image Demo");
        //editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        BufferedImage image = null;
       
        try
        {
          image = ImageIO.read(new File(filename));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
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
}
package classcode.p15Swing.p06moreStuff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Este é o exemplo RadioButtonsDemo do tutorial do Java. A classe C6IconsDemo
 * extende de JPanel e implementa o ActionListener. Como implementa o Listener
 * terá de implementar o método desse listener. Esta configuração é posível,
 * embora seja um pouco limitadora.
 * 
 * Novidade: carregar imagens
 * 
 * RadioButtonDemo.java requires these files: images/Bird.gif images/Cat.gif
 * images/Dog.gif images/Rabbit.gif images/Pig.gif
 */

/**
 * Primeiro foi criado um folder denominado images para conter as imagens. As
 * images foram adicionadas directamente no novo folder, via eclipse
 */

public class C6IconsDemo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 188341113685474123L;

	static String birdString = "Bird";

	static String catString = "Cat";

	static String dogString = "Dog";

	static String rabbitString = "Rabbit";

	static String pigString = "Pig";

	JLabel picture;

	private ImageIcon imageIconBird = null;

	private ImageIcon imageIconCat;

	private ImageIcon imageIconDog;

	private ImageIcon imageIconRabbit;

	private ImageIcon imageIconPig;

	// Um HashMap é um contentor que guarda pares com "valor, objecto", e que
	// permite obter o objecto com base no valor
	private HashMap<String, ImageIcon> images;

	public C6IconsDemo() {
		super(new BorderLayout());

		// Create the radio buttons.
		JRadioButton birdButton = new JRadioButton(birdString);
		birdButton.setMnemonic(KeyEvent.VK_B);
		birdButton.setActionCommand(birdString);
		birdButton.setSelected(true);

		JRadioButton catButton = new JRadioButton(catString);
		catButton.setMnemonic(KeyEvent.VK_C);
		catButton.setActionCommand(catString);

		JRadioButton dogButton = new JRadioButton(dogString);
		dogButton.setMnemonic(KeyEvent.VK_D);
		dogButton.setActionCommand(dogString);

		JRadioButton rabbitButton = new JRadioButton(rabbitString);
		rabbitButton.setMnemonic(KeyEvent.VK_R);
		rabbitButton.setActionCommand(rabbitString);

		JRadioButton pigButton = new JRadioButton(pigString);
		pigButton.setMnemonic(KeyEvent.VK_P);
		pigButton.setActionCommand(pigString);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(birdButton);
		group.add(catButton);
		group.add(dogButton);
		group.add(rabbitButton);
		group.add(pigButton);

		// Register a listener for the radio buttons.
		birdButton.addActionListener(this);
		catButton.addActionListener(this);
		dogButton.addActionListener(this);
		rabbitButton.addActionListener(this);
		pigButton.addActionListener(this);

		imageIconBird = loadImageIcon2("images/" + birdString + ".gif");
		imageIconCat = loadImageIcon(C6IconsDemo.class, "images/" + catString + ".gif");
		imageIconDog = loadImageIcon(this.getClass(), "images/" + dogString + ".gif");
		imageIconRabbit = loadImageIcon(this.getClass(), "images/" + rabbitString + ".gif");
		imageIconPig = loadImageIcon(this.getClass(), "images/" + pigString + ".gif");

		images = new HashMap<String, ImageIcon>();
		images.put(birdString, imageIconBird);
		images.put(catString, imageIconCat);
		images.put(dogString, imageIconDog);
		images.put(rabbitString, imageIconRabbit);
		images.put(pigString, imageIconPig);

		// Set up the picture label.
		picture = new JLabel(imageIconBird);
		// picture.setOpaque(true);
		// picture.setBackground(Color.blue);

		// The preferred size is hard-coded to be the width of the
		// widest image and the height of the tallest image.
		// A real program would compute this.
		picture.setSize(new Dimension(300, 200));

		// Put the radio buttons in a column in a panel.
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(birdButton);
		radioPanel.add(catButton);
		radioPanel.add(dogButton);
		radioPanel.add(rabbitButton);
		radioPanel.add(pigButton);

		add(radioPanel, BorderLayout.LINE_START);
		add(picture, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	/** Listens to the radio buttons. */
	public void actionPerformed(ActionEvent e) {
		picture.setIcon(images.get(e.getActionCommand()));
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon loadImageIcon(Class<?> theClass, String path) {
		// getResource - verifica se o recurso existe, constroi um path com o
		// pathname modificado, para o file system, do package da classe
		// C6IconsDemo
		java.net.URL imgURL = theClass.getResource(path);
		if (imgURL != null) {
			ImageIcon ic = new ImageIcon(imgURL);
			if (ic.getImageLoadStatus() == java.awt.MediaTracker.COMPLETE) {
				System.out.println("Image: " + path + " loaded");
				return ic;
			} else {
				System.err.println("Couldn't load file: " + path);
				return null;
			}
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	// segunda versão
	protected static ImageIcon loadImageIcon2(String path) {
		// A path é relativa à root do projecto
		path = "bin/classcode/p15Swing/p06moreStuff/" + path;

		ImageIcon ic = new ImageIcon(path);
		if (ic.getImageLoadStatus() == java.awt.MediaTracker.COMPLETE) {
			System.out.println("Image loaded: " + path);
			return ic;
		} else {
			System.err.println("Couldn't load file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("RadioButtonDemo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Create and set up the content pane.
		JComponent newContentPane = new C6IconsDemo();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		frame.setSize(600, 400);

		// Display the window.
		// frame.pack();
		// to center a frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		// Todas as interacções com elementos GUI devem ser realizados pela
		// Event-dispatching thread
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

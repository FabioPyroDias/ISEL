package classcode.p15Swing.p07MyModelViewController;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Esta classe é um Viewer
 * 
 */
class VisualTemp extends JLabel implements ChangeListener {
	private static final long serialVersionUID = 5424313808713066892L;

	private static String[] weatherChanges = { "sunny", "mostly_sunny",
			"chance_of_rain", "cloudy", "rain", "chance_of_storm",
			"thunderstorm" };

	// MODEL
	Weather weather;

	private ImageIcon[] images = null;

	public VisualTemp(Weather weather) {
		super();
		this.weather = weather;
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		images = new ImageIcon[weatherChanges.length];
		loadImages();
		setImage(weather.getValue());
		// REGISTO NO MODEL
		weather.addChangeListener(this);
	}

	private void loadImages() {
		for (int i = 0; i < weatherChanges.length; i++) {
			images[i] = loadImageIcon("images/" + weatherChanges[i] + ".gif");
		}
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon loadImageIcon(String path) {
		// getResource - verifica se o recurso existe
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			ImageIcon ic = new ImageIcon(imgURL);
			System.out.println("Image: " + path + " loaded");
			return ic;
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private void setImage(int value) {
		int idx = 0;
		if (value < 10) {
			idx = images.length - 1;
		} else if (value < 25) {
			idx = (int) (((15 - (value - 10)) / 15.0f) * (images.length - 2)) + 1;
		}
		setIcon(images[idx]);
		System.out.println("image index -> " + idx);
		setText(weatherChanges[idx]);
	}

	public void stateChanged(ChangeEvent e) {
		setImage(weather.getValue());
	}
}

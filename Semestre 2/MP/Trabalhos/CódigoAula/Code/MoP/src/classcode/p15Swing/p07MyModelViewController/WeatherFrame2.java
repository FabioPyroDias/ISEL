package classcode.p15Swing.p07MyModelViewController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Agora com dois viewers
 * 
 */

public class WeatherFrame2 implements ActionListener, ChangeListener {

	JFrame frame = null;

	private JPanel buttons = null;

	private JButton incButton = null;

	private JButton decButton = null;

	private JLabel tempLabel = null;

	Weather lisbonWeather = null;

	private JPanel displays = null;

	private VisualTemp visualTemp = null;

	public void init() {

		// MODEL
		lisbonWeather = new Weather(20);
		
		// esta classe é um viewer do model
		lisbonWeather.addChangeListener(this);

		// mais um VIEWER, o construtor regista-se no MODEL recebido
		visualTemp = new VisualTemp(lisbonWeather);

		frame = new JFrame("Lisbon weather");
		buttons = new JPanel();

		// buttons
		incButton = new JButton("Increase");
		incButton.addActionListener(this);
		decButton = new JButton("Decrease");
		decButton.addActionListener(this);
		buttons.add(decButton);
		buttons.add(incButton);
		frame.add(BorderLayout.PAGE_START, buttons);

		// displays
		displays = new JPanel(new GridLayout(1, 2));
		tempLabel = new JLabel(String.valueOf(lisbonWeather.getValue()));
		tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = new Font("Courier", Font.ITALIC | Font.BOLD, 100);
		tempLabel.setFont(font);
		displays.add(tempLabel);
		displays.add(visualTemp);

		frame.add(BorderLayout.CENTER, displays);

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setMinimumSize(new Dimension(300, 200));
		frame.setLocationRelativeTo(null); // to center a frame
		frame.setVisible(true);
	}

	// evento disparado pelo butão
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		lisbonWeather.setValue(lisbonWeather.getValue()
				+ (button.getText().equals("Increase") ? +1 : -1));
	}

	// evento disparado pelo Notifier
	public void stateChanged(ChangeEvent e) {
		tempLabel.setText(String.valueOf(lisbonWeather.getValue()));
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				WeatherFrame2 lisbonFrame = new WeatherFrame2();
				lisbonFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

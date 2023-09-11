package classcode.p15Swing.p07MyModelViewController;

import java.awt.BorderLayout;
import java.awt.Font;
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
 * Esta frame controla gráficamente um objecto Weather. Quando há alterações
 * nesse objecto ele dispara um evento de Change para a frame (porque esta se
 * registou como ChangeListener). Como resposta a esse evento é actualizada a
 * label.
 * 
 * O objecto Weather também pode ser controlado pelo modo de texto, conforme se
 * pode experimentar no método MAIN existente na classe Weather.
 * 
 * Esta classe funciona como Controller e Viewer de Weather
 * 
 */

public class WeatherFrame implements ActionListener, ChangeListener {

	JFrame frame = null;

	private JPanel buttons = null;

	private JButton incButton = null;

	private JButton decButton = null;

	private JLabel tempLabel = null;

	Weather lisbonWeather = null;

	public void init() {
		// MODEL e REGISTO NO MODEL
		lisbonWeather = new Weather(30);
		lisbonWeather.addChangeListener(this);

		frame = new JFrame("Lisbon weather");
		frame.setSize(300, 200);
		buttons = new JPanel();

		incButton = new JButton("Increase");
		incButton.addActionListener(this);
		decButton = new JButton("Decrease");
		decButton.addActionListener(this);
		buttons.add(decButton);
		buttons.add(incButton);
		frame.add(BorderLayout.PAGE_START, buttons);

		tempLabel = new JLabel(String.valueOf(lisbonWeather.getValue()));
		tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = new Font("Courier", Font.ITALIC | Font.BOLD, 100);
		tempLabel.setFont(font);
		frame.add(BorderLayout.CENTER, tempLabel);

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // to center a frame
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		lisbonWeather.setValue(lisbonWeather.getValue()
				+ (button.getText().equals("Increase") ? +1 : -1));
	}

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
				WeatherFrame lisbonFrame = new WeatherFrame();
				lisbonFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

package classcode.p15Swing.p10Sound;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;

/**
 * Apenas suporta ficheiros ".wav"
 * 
 * Na lista de sons deve-se colocar ficheiros que existam na root do projecto
 */
public class C05SoundTest extends JFrame {

	private static final long serialVersionUID = -7125947483935629979L;

	C04Sound currSound = null;

	String[] soundsNames = { "HelloJavaMMProg.wav", "MexicoSound.wav" };
	C04Sound[] sounds = null;

	HashMap<String, C04Sound> map = new HashMap<String, C04Sound>();

	// Constructor
	public void init() {
		setTitle("Test Sounds");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Pre-load all the sound files
		sounds = new C04Sound[soundsNames.length];
		for (int i = 0; i < sounds.length; i++) {
			sounds[i] = new C04Sound(soundsNames[i]);
			sounds[i].load();
		}

		currSound = sounds[0];

		// Set up UI components
		setLayout(new GridLayout(2, 1));
		JPanel jpSoundsMain = new JPanel(new CenterLayout());
		JPanel jpSounds = new JPanel();
		jpSoundsMain.add(jpSounds);

		JPanel jpControlsMain = new JPanel(new CenterLayout());
		JPanel jpControls = new JPanel();
		jpControlsMain.add(jpControls);

		ButtonGroup bg = new ButtonGroup();

		for (int i = 0; i < sounds.length; i++) {
			String soundName = "Sound " + i;
			JToggleButton button = new JToggleButton(soundName);
			map.put(soundName, sounds[i]);
			if (i == 0)
				button.setSelected(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currSound = map.get(((JToggleButton) e.getSource())
							.getText());
				}
			});
			jpSounds.add(button);
			bg.add(button);
		}

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currSound.play();
			}
		});
		jpControls.add(btnStart);

		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currSound.pause();
			}
		});
		jpControls.add(btnPause);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currSound.stop();
			}
		});
		jpControls.add(btnStop);

		JButton btnRewind = new JButton("Rewind");
		btnRewind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currSound.rewind();
			}
		});
		jpControls.add(btnRewind);

		add(jpSoundsMain);
		add(jpControlsMain);

		setSize(400, 200);
		setLocationRelativeTo(null);

		setMinimumSize(new Dimension(330, 120));

		setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C05SoundTest myFrame = new C05SoundTest();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}

}

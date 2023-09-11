package classcode.p15Swing.p06moreStuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Novidades: JMenu, JMenuItem, setMnemonic, Accelerator e etc
 * 
 * @author António Teófilo
 * 
 */
public class C5MyMenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel label1 = null;

	private JButton buttonStart = null;

	private JButton buttonStop = null;

	JPanel panel = null;

	JCheckBox repeatCheckBox = null;

	private Timer timer = null;

	private final Color greenColor = new Color(0, 200, 0);

	private final Color redColor = Color.RED;

	private int n = 0;

	private JRadioButtonMenuItem rbMenuRedColor;

	private JRadioButtonMenuItem rbMenuGreenColor;

	private JMenu submenuTimerControl;

	private JCheckBoxMenuItem cbMenuEnableColorChange;

	private JCheckBoxMenuItem cbMenuEnableTimerControl;

	private JMenuItem menuStartTimer;

	private JMenuItem menuStopTimer;

	private JMenuBar menuBar;

	private JMenuItem rbMenuRedColorMenuItem;

	private JMenuItem rbMenuGreenColorMenuItem;

	private String buildLabelText() {
		return "Timer fired " + n + " times";
	}

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Menu Timer frame :...");
		// set size
		setSize(600, 400);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// build JLabel
		label1 = new JLabel(buildLabelText());
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(greenColor);

		// add JLabel at center
		JPanel jpCenter = new JPanel();

		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.1f, 0.05f, 0.05f, 0.05f);
		jpCenter.setLayout(cl);

		jpCenter.add(label1, ProportionalLayout.CENTER);
		add(jpCenter, BorderLayout.CENTER);

		// programação do timer
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++n;
				label1.setText(buildLabelText());
				if (!timer.isRepeats()) {
					// must reverse buttons state (start -> on, stop -> off)
					stopTimerActions();
				}
			}
		};
		int delay = 1000; // milliseconds, start time and period
		timer = new Timer(delay, taskPerformer);

		// Painel dos botões
		panel = new JPanel(); // Janel default layout -> FlowLayout
		TitledBorder tb = new TitledBorder("Control panel");
		tb.setTitleJustification(TitledBorder.CENTER);
		panel.setBorder(tb);

		// Checkbox para indicar se o timer é cíclico ou não
		repeatCheckBox = new JCheckBox("Cyclic timer", false);
		panel.add(repeatCheckBox);

		// buttonStart
		buttonStart = new JButton("Start timer");
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTimerActions();
				timer.start();
			}
		});
		panel.add(buttonStart);

		// buttonStop
		buttonStop = new JButton("Stop timer");
		buttonStop.setEnabled(false);
		buttonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				stopTimerActions();
			}
		});
		panel.add(buttonStop);

		// adicionar o painel do botões à frame principal
		add(panel, BorderLayout.PAGE_END);

		// build menu
		buildMenu();

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	private void startTimerActions() {
		buttonStart.setEnabled(false);
		buttonStop.setEnabled(true);
		timer.setRepeats(repeatCheckBox.isSelected());
		menuStartTimer.setEnabled(false);
		menuStopTimer.setEnabled(true);
	}

	private void stopTimerActions() {
		buttonStop.setEnabled(false);
		buttonStart.setEnabled(true);
		menuStartTimer.setEnabled(true);
		menuStopTimer.setEnabled(false);
	}

	/**
	 * buildMenu
	 */
	private void buildMenu() {
		JMenu menu;
		JMenuItem menuItem;
		ActionListener al = null;

		// Menu Action Listener
		al = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JMenuItem mi = (JMenuItem) (e.getSource());
				String menuItemText = mi.getText();
				System.out.println("Menu item click -> " + menuItemText + " - "
						+ e.getSource().getClass().getSimpleName() + ", id -> " + e.getID());

				if (menuItemText.equals("Start timer")) {
					startTimerActions();
					timer.start();
				}
				if (menuItemText.equals("Stop timer")) {
					timer.stop();
					stopTimerActions();
				}
				if (menuItemText.equals("Red center Label")) {
					System.out.println("Red center Label event .......");
					label1.setBackground(redColor);
				}
				if (menuItemText.equals("Green center label")) {
					label1.setBackground(greenColor);
				}
				if (menuItemText.equals("Enable color change")) {
					boolean enable = ((JCheckBoxMenuItem) mi).isSelected();
					rbMenuRedColor.setEnabled(enable);
					rbMenuGreenColor.setEnabled(enable);
				}
				if (menuItemText.equals("Enable timer control")) {
					boolean enable = ((JCheckBoxMenuItem) mi).isSelected();
					submenuTimerControl.setEnabled(enable);
				}
				if (menuItemText.equals("Reset counter")) {
					n = 0;
					label1.setText(buildLabelText());
				}
				if (menuItemText.equals("Set Red menu item")) {
					System.out.println("Set Red menu item");
					// ver e.gedID
					ActionEvent ae = new ActionEvent(rbMenuRedColor, 1001, "");
					actionPerformed(ae);
				}
				if (menuItemText.equals("Set Green menu item")) {
					System.out.println("Set Green menu item");
					ActionEvent ae = new ActionEvent(rbMenuGreenColor, 1001, "");
					actionPerformed(ae);
				}
				System.out.println("menu event");
			}

		};

		// Create the menu bar.
		menuBar = new JMenuBar();
		// Build the first menu.
		menu = new JMenu("Actions");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		// not a good idea
		// JMenuItem test = new JMenuItem("test");
		// menuBar.add(test);

		// a group of JMenuItems
		menuItem = new JMenuItem("Reset counter", KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(al);
		menu.add(menuItem);

		menu.addSeparator();

		// a group of radio button menu items
		ButtonGroup group = new ButtonGroup();
		rbMenuRedColor = new JRadioButtonMenuItem("Red center Label");
		rbMenuRedColor.setMnemonic(KeyEvent.VK_R);
		rbMenuRedColor.addActionListener(al);
		group.add(rbMenuRedColor);
		menu.add(rbMenuRedColor);

		rbMenuGreenColor = new JRadioButtonMenuItem("Green center label");
		rbMenuGreenColor.setSelected(true);
		rbMenuGreenColor.setMnemonic(KeyEvent.VK_G);
		rbMenuGreenColor.addActionListener(al);
		group.add(rbMenuGreenColor);
		menu.add(rbMenuGreenColor);

		// a group of check box menu items
		menu.addSeparator();

		cbMenuEnableColorChange = new JCheckBoxMenuItem("Enable color change");
		cbMenuEnableColorChange.setSelected(true);
		cbMenuEnableColorChange.setMnemonic(KeyEvent.VK_C);
		cbMenuEnableColorChange.addActionListener(al);
		menu.add(cbMenuEnableColorChange);

		cbMenuEnableTimerControl = new JCheckBoxMenuItem("Enable timer control");
		cbMenuEnableTimerControl.setSelected(true);
		cbMenuEnableTimerControl.setMnemonic(KeyEvent.VK_T);
		cbMenuEnableTimerControl.addActionListener(al);
		menu.add(cbMenuEnableTimerControl);

		// a submenu
		menu.addSeparator();

		submenuTimerControl = new JMenu("Timer control");
		submenuTimerControl.setMnemonic(KeyEvent.VK_L);

		menuStartTimer = new JMenuItem("Start timer");
		menuStartTimer.setMnemonic(KeyEvent.VK_A);
		menuStartTimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuStartTimer.addActionListener(al);
		submenuTimerControl.add(menuStartTimer);

		menuStopTimer = new JMenuItem("Stop timer");
		menuStopTimer.setMnemonic(KeyEvent.VK_O);
		menuStopTimer.setEnabled(false);
		menuStopTimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		menuStopTimer.addActionListener(al);
		submenuTimerControl.add(menuStopTimer);

		menu.add(submenuTimerControl);

		// Build second menu in the menu bar.
		menu = new JMenu("Menu2");
		menu.setMnemonic(KeyEvent.VK_M);
		menuBar.add(menu);

		rbMenuRedColorMenuItem = new JMenuItem("Set Red menu item");
		rbMenuRedColorMenuItem.setMnemonic(KeyEvent.VK_R);
		rbMenuRedColorMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		menu.add(rbMenuRedColorMenuItem);
		rbMenuRedColorMenuItem.addActionListener(al);

		rbMenuGreenColorMenuItem = new JMenuItem("Set Green menu item");
		rbMenuGreenColorMenuItem.setMnemonic(KeyEvent.VK_G);
		rbMenuGreenColorMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
		menu.add(rbMenuGreenColorMenuItem);
		rbMenuGreenColorMenuItem.addActionListener(al);

		// set Menu Bar on JFrame
		setJMenuBar(menuBar);
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C5MyMenuFrame myFrame = new C5MyMenuFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}

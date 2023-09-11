package classcode.p15Swing.p06moreStuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

/**
 * Novidades: JSpinner, SpinnerNumberModel, JEmptyBorder, LineBorder
 * 
 * Um JSpinner tem de ter um "model" para definir o valor inicial, valor mínimo,
 * máximo e o salto. Models existentes: SpinnerNumberModel, SpinnerDateModel,
 * SpinnerListModel, AbstractSpinnerModel. Se não for indicado nenhum model é
 * utilizado um SpinnerNumberModel
 * 
 * 
 * @author António Teófilo
 * 
 */
public class C3MySpinnerFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel label1 = null;

	private JButton buttonGetValue = null;

	private JButton buttonAddSpinnerValue = null;

	JPanel panelSpinnerControl = null;

	JSpinner spinner = null;

	SpinnerNumberModel spModel = null;

	private final Color labelColor = new Color(120, 240, 140);

	private int spinnerValue = 0;

	private String buildLabelText() {
		return "Spinner value -> " + spinnerValue + " ";
	}

	/**
	 * Este método cria toda a frame e coloca-a visível
	 * 
	 */
	public void init() {
		// set title
		setTitle("...: My Spinner frame :...");
		// set size
		setSize(500, 400);
		setMinimumSize(getSize());
		// set location
		setLocationRelativeTo(null); // to center a frame
		// set what happens when close button is pressed
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// ============================
		ProportionalLayout cl = new ProportionalLayout(0.0f);
		cl.setInsets(0.05f, 0.05f, 0.05f, 0.05f);
		setLayout(cl);

		// center panel will support all components in Border Layout
		JPanel panelCenter = new JPanel(new BorderLayout());
		// panelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,
		// 20));
		// panelCenter.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

		// build JLabel
		label1 = new JLabel(buildLabelText());
		label1.setFont(new Font("Courier", Font.BOLD, 14));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(labelColor);
		// add JLabel at center
		panelCenter.add(label1, BorderLayout.CENTER);

		JPanel panelControl = new JPanel(new GridLayout(2, 1));

		// SPINNER CONTROLS ====================================
		// Painel dos botões
		panelSpinnerControl = new JPanel();
		// panelSpinnerControl.setBorder(BorderFactory.createLineBorder(
		// Color.GRAY, 1));
		panelSpinnerControl.setBorder(new TitledBorder("Spinner controls"));

		// ###################################################################
		// Spinner and SpinnerModel ##########################################
		spModel = new SpinnerNumberModel(5, 0, 10, 2); // value, min, max, step
		spinner = new JSpinner(spModel);
		panelSpinnerControl.add(spinner);

		// buttonStart
		buttonGetValue = new JButton("Get spinner value");
		buttonGetValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spinnerValue = (Integer) spinner.getValue();
				label1.setText(buildLabelText());
				// afectar o step dinâmicamente
				spModel.setStepSize(spinnerValue);
			}
		});
		panelSpinnerControl.add(buttonGetValue);

		// buttonStop
		buttonAddSpinnerValue = new JButton("Add spinner value");
		buttonAddSpinnerValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = spinner.getModel().getNextValue(); // spModel
				if (o != null) {
					spinnerValue = (Integer) o;
					spinner.getModel().setValue(spinnerValue);
					label1.setText(buildLabelText());
				}
			}
		});
		panelSpinnerControl.add(buttonAddSpinnerValue);
		
		// HERE NEW CODE
		spModel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerValue = (int) spModel.getValue();
				label1.setText(buildLabelText());
			}
		});

		// EXTRA CONTROLS ====================================
		JPanel panelExtraControls = new JPanel();
		panelExtraControls.setBorder(new TitledBorder("Extra controls"));

		JLabel lab = new JLabel("Spinner with same model: ");
		panelExtraControls.add(lab);

		// one spinner with the same model
		JSpinner spinner2 = new JSpinner(spModel);
		panelExtraControls.add(spinner2);

		// separador
		panelExtraControls.add(Box.createHorizontalStrut(20));

		// one default spinner
		JLabel lab2 = new JLabel("Default spinner: ");
		panelExtraControls.add(lab2);

		JSpinner spinner3 = new JSpinner();
		panelExtraControls.add(spinner3);
		// set the width of default spinner
		Dimension d = spinner3.getPreferredSize();
		d.width = 80;
		spinner3.setPreferredSize(d);

		// adicionar o painel do botões à frame principal
		panelControl.add(panelSpinnerControl);
		panelControl.add(panelExtraControls);
		panelCenter.add(panelControl, BorderLayout.PAGE_END);

		// ===================================
		add(panelCenter);

		// puts the frame visible (is not visible at start)
		setVisible(true);
	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C3MySpinnerFrame myFrame = new C3MySpinnerFrame();
				myFrame.init();
				// life goes on
				System.out.println("Frame created...");
			}
		});
		System.out.println("End of main...");
	}
}
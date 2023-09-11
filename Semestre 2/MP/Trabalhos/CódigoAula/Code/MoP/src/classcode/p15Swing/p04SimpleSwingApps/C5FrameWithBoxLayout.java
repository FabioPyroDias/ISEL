package classcode.p15Swing.p04SimpleSwingApps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 * Demonstra a utilização de BoxLayout.
 * 
 * 
 * Um Box layout dispõe os componentes numa linha na horizontal (X_axis) ou na
 * vertical (Y_axis), e essa linha pode estar em qualquer lado cima, baixo,
 * lados,...
 * 
 * @author António Teófilo
 * 
 */

public class C5FrameWithBoxLayout extends JFrame {

	private static final long serialVersionUID = -6678839556956235986L;

	private JPanel buttonsPanel;

	private JPanel boxesPanel;

	private JButton buttonXaxis;

	private JButton buttonYaxis;

	private JButton buttonAlignLeft;

	private JButton buttonAlignCenter;

	private JButton buttonAlignRight;

	private BoxLayout blXaxis;

	private BoxLayout blYaxis;

	private BoxLayout currentBoxlayout;

	int nLabels = 10;

	enum AlignType {
		ALIGNX, ALIGNY;
	}

	AlignType currentAlign = AlignType.ALIGNY;

	Random rg = new Random();

	JLabel[] labels = new JLabel[nLabels];

	private JPanel buttonsPanel1;

	private JPanel buttonsPanel2;

	private JButton buttonAlignRandom;

	private JButton buttonAlignTop;

	private JButton buttonAlignBottom;

	public void init() {
		// set title
		setTitle("...: My box layout frame :...");
		// set size
		setSize(700, 300);
		// set location
		setLocationRelativeTo(null); // to center a frame
		// hide and dispose jframe
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// build buttonsPanel
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 1));
		add(buttonsPanel, BorderLayout.PAGE_END);

		buttonsPanel1 = new JPanel();
		buttonsPanel1.setLayout(new FlowLayout());
		buttonsPanel.add(buttonsPanel1);

		buttonsPanel2 = new JPanel();
		buttonsPanel2.setLayout(new FlowLayout());
		buttonsPanel.add(buttonsPanel2);

		// build boxesPanel
		boxesPanel = new JPanel();
		boxesPanel.setBorder(new LineBorder(Color.gray));
		blYaxis = new BoxLayout(boxesPanel, BoxLayout.Y_AXIS); // top to bottom
		blXaxis = new BoxLayout(boxesPanel, BoxLayout.X_AXIS); // left to right

		currentBoxlayout = blYaxis;
		boxesPanel.setLayout(currentBoxlayout);
		System.out.println("BoxLayout: AlignType -> ALIGNY");

		add(boxesPanel, BorderLayout.CENTER);

		// build JLabels
		for (int x = 0; x < nLabels; ++x) {
			JLabel label = labels[x] = new JLabel("  Label " + x + "  ");
			label.setOpaque(true);
			label.setBackground(new Color(rg.nextInt(256), rg.nextInt(256), rg
					.nextInt(256)));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setAlignmentY(Component.CENTER_ALIGNMENT); // com X_AXIS
			boxesPanel.add(label);

		}

		// build buttonXaxis
		buttonXaxis = new JButton("Box x_Axis");
		buttonXaxis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentAlign = AlignType.ALIGNX;
				currentBoxlayout = blXaxis;
				System.out.println("BoxLayout: AlignType -> ALIGNX");
				boxesPanel.setLayout(currentBoxlayout);
				// boxesPanel.doLayout();
				boxesPanel.validate();
				buttonYaxis.setEnabled(true);
				buttonXaxis.setEnabled(false);
			}
		});
		buttonsPanel1.add(buttonXaxis);

		// build buttonYaxis
		buttonYaxis = new JButton("Box y_Axis");
		buttonYaxis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentAlign = AlignType.ALIGNY;
				currentBoxlayout = blYaxis;
				System.out.println("BoxLayout: AlignType -> ALIGNY");
				boxesPanel.setLayout(currentBoxlayout);
				boxesPanel.validate();
				buttonXaxis.setEnabled(true);
				buttonYaxis.setEnabled(false);
			}
		});
		buttonYaxis.setEnabled(false);
		buttonsPanel1.add(buttonYaxis);

		// build buttonAlignTop
		buttonAlignTop = new JButton("Align Top");
		buttonAlignTop.setActionCommand("ButtonTop");
		buttonsPanel2.add(buttonAlignTop);
		buttonAlignTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlignOnLabels(currentAlign, Component.TOP_ALIGNMENT);
			}
		});

		// build buttonAlignLeft
		buttonAlignLeft = new JButton("Align Left");
		buttonAlignLeft.setActionCommand("ButtonLeft");
		buttonsPanel2.add(buttonAlignLeft);
		buttonAlignLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlignOnLabels(currentAlign, Component.LEFT_ALIGNMENT);
			}
		});

		// build buttonAlignCenter
		buttonAlignCenter = new JButton("Align Center");
		buttonAlignCenter.setActionCommand("ButtonCenter");
		buttonsPanel2.add(buttonAlignCenter);
		buttonAlignCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlignOnLabels(currentAlign, Component.CENTER_ALIGNMENT);
			}
		});

		// build buttonAlignRandom
		buttonAlignRandom = new JButton("Align Random");
		buttonAlignRandom.setActionCommand("ButtonRandom");
		buttonsPanel2.add(buttonAlignRandom);
		buttonAlignRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlignOnLabels(currentAlign, -1.0f);
			}
		});

		// build buttonAlignLast
		buttonAlignRight = new JButton("Align Right");
		buttonAlignRight.setActionCommand("ButtonRight");
		buttonsPanel2.add(buttonAlignRight);
		buttonAlignRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlignOnLabels(currentAlign, Component.RIGHT_ALIGNMENT);
			}
		});

		// build buttonAlignBottom
		buttonAlignBottom = new JButton("Align Bottom");
		buttonAlignBottom.setActionCommand("ButtonBottom");
		buttonsPanel2.add(buttonAlignBottom);
		buttonAlignBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlignOnLabels(currentAlign, Component.BOTTOM_ALIGNMENT);
			}
		});

		// puts the frame visible (is not visible at start)
		setVisible(true);
		// life goes on
		System.out.println("Frame created...");

	}

	void setAlignOnLabels(AlignType align, float aligment) {
		for (int i = 0; i < nLabels; ++i) {
			if (align == AlignType.ALIGNX)
				labels[i].setAlignmentY(aligment != -1.0f ? aligment : rg
						.nextFloat());
			else
				labels[i].setAlignmentX(aligment != -1.0f ? aligment : rg
						.nextFloat());
			// invalidate() the component and call validate() on it - forçando a
			// sua actualização
			labels[i].revalidate();  // invalidate a validate
		}

	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				C5FrameWithBoxLayout frame = new C5FrameWithBoxLayout();
				frame.init();
			}
		});
		System.out.println("End of main...");
	}
}

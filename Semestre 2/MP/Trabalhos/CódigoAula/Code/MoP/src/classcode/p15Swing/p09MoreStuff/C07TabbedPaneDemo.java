/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package classcode.p15Swing.p09MoreStuff;

/**
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import classcode.p15Swing.p02buildedLayouts.CenterLayout;
import classcode.p15Swing.p02buildedLayouts.ProportionalLayout;

public class C07TabbedPaneDemo extends JPanel {
	private static final long serialVersionUID = 1L;

	private Random rg = new Random();

	public C07TabbedPaneDemo() {
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();

		ImageIcon icon = createImageIcon("images/middle.gif");
		ImageIcon icon2 = createImageIcon("images/middle2.gif");
		ImageIcon icon3 = createImageIcon("images/middle3.gif");
		ImageIcon icon4 = createImageIcon("images/middle4.gif");

		JComponent panel1 = makePanel1("Panel #1");
		tabbedPane.addTab("Tab 1", icon, panel1, "Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = makePanel2("Panel #2");
		tabbedPane.addTab("Tab 2", icon2, panel2, "Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = makePanel3("Panel #3");
		tabbedPane.addTab("Tab 3", icon3, panel3, "Still does nothing");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = makePanel4("Panel #4");
		panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Tab 4", icon4, panel4, "Does nothing at all");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	protected JComponent makePanel1(String text) {
		JPanel panel = new JPanel(false);

		panel.setLayout(new ProportionalLayout(0.15f));
		JLabel filler = new JLabel(text);
		filler.setBorder(new LineBorder(Color.green, 5, true));
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);
		return panel;
	}

	protected JComponent makePanel2(String text) {
		JPanel panel = new JPanel(new ProportionalLayout(0.05f, 0.1f, 0.1f,
				0.1f));

		JLabel label = new JLabel(text);
		label.setBorder(new LineBorder(Color.blue, 5, true));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, ProportionalLayout.CENTER);

		JPanel panelParentControl = new JPanel(new CenterLayout());
		JPanel panelControl = new JPanel();
		panelControl.add(new JButton("Adicionar"));
		panelControl.add(new JButton("Remover"));

		panelParentControl.add(panelControl);

		panel.add(panelParentControl, ProportionalLayout.SOUTH);
		return panel;
	}

	// protected JComponent makePanel2(String text) {
	// JPanel panel = new JPanel(false);
	// panel.setLayout(new BorderLayout());
	//
	// JPanel panelCenter = new JPanel(new ProportionalLayout(0.1f, 0.1f,
	// 0.3f, 0.3f));
	// JLabel filler = new JLabel(text);
	// filler.setBorder(new LineBorder(Color.blue, 5, true));
	// filler.setHorizontalAlignment(JLabel.CENTER);
	// panelCenter.add(filler);
	//
	// panel.add(panelCenter, ProportionalLayout.CENTER);
	//
	// JPanel panelParentControl = new JPanel(new CenterLayout());
	// JPanel panelControl = new JPanel();
	// panelControl.add(new JButton("Adicionar"));
	// panelControl.add(new JButton("Remover"));
	//
	// panelParentControl.add(panelControl);
	//
	// panel.add(panelParentControl, ProportionalLayout.SOUTH);
	// return panel;
	// }

	protected JComponent makePanel3(String text) {
		JPanel panel = new JPanel(false);
		panel.setLayout(new ProportionalLayout(0.1f, 0.1f, 0.1f, 0.1f));
		int nCells = 10;
		JPanel panelx = new JPanel(new GridLayout(1, nCells));
		for (int i = 0; i < nCells; i++) {
			JLabel label = new JLabel();
			label.setBackground(new Color(rg.nextInt(256), rg.nextInt(256), rg
					.nextInt(256)));
			label.setOpaque(true);
			panelx.add(label);
		}
		panel.add(panelx);
		return panel;
	}

	protected JComponent makePanel4(String text) {
		JPanel panel = new JPanel(false);
		panel.setLayout(new GridLayout(1, 2));
		panel.add(makePanel2("esq"));
		panel.add(makePanel2("dir"));
		return panel;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = C07TabbedPaneDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TabbedPaneDemo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Add content to the window.
		frame.add(new C07TabbedPaneDemo(), BorderLayout.CENTER);

		// Display the window.
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}

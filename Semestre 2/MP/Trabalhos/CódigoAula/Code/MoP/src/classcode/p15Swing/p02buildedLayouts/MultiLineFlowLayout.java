package classcode.p15Swing.p02buildedLayouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author Brenden
 */
public class MultiLineFlowLayout extends FlowLayout {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getAnonymousLogger();

	/**
	 * 
	 */
	static {
		ConsoleHandler ch = new ConsoleHandler();
		// ch.setLevel(Level.ALL);
		ch.setLevel(Level.INFO);
		log.addHandler(ch);
		log.setLevel(Level.ALL);
	}

	/**
	 * 
	 */
	public void addLayoutComponent(String name, Component comp) {
		log.entering("FlowLayout", "addLayoutComponent", new Object[] { name, comp });
		super.addLayoutComponent(name, comp);
		log.exiting("FlowLayout", "addLayoutComponent");
	}

	/**
	 * 
	 */
	public void removeLayoutComponent(Component comp) {
		log.entering("FlowLayout", "removeLayoutComponent", new Object[] { comp });
		super.removeLayoutComponent(comp);
		log.exiting("FlowLayout", "removeLayoutComponent");
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * 
	 */
	public Dimension preferredLayoutSize(Container parent) {
		log.entering("FlowLayout", "preferredLayoutSize", new Object[] { parent });
		Dimension rt = super.preferredLayoutSize(parent);
		log.finest("Dimensions=" + rt);

		Insets insets = parent.getInsets();
		int maxwidth = parent.getWidth() - (insets.left + insets.right + super.getHgap() * 2);
		int ourMaxwidth = 0;
		int nmembers = parent.getComponentCount();
		int x = 0, y = insets.top + super.getVgap(), rowh = 0;

		boolean useBaseline = getAlignOnBaseline();
		int[] ascent = null;
		int[] descent = null;

		if (useBaseline) {
			ascent = new int[nmembers];
			descent = new int[nmembers];
		}

		for (int i = 0; i < nmembers; i++) {
			Component comp = parent.getComponent(i);
			if (comp.isVisible()) {
				Dimension d = comp.getPreferredSize();
				comp.setSize(d);

				if (useBaseline) {
					int baseline = comp.getBaseline(d.width, d.height);
					if (baseline >= 0) {
						ascent[i] = baseline;
						descent[i] = d.height - baseline;
					} else {
						ascent[i] = -1;
					}
				}
				if ((x == 0) || ((x + d.width) <= maxwidth)) {
					if (x > 0) {
						x += super.getHgap();
					}
					x += d.width;
					rowh = Math.max(rowh, d.height);
				} else {
					ourMaxwidth = Math.max(ourMaxwidth, x);
					x = d.width;
					y += super.getVgap() + rowh;
					rowh = d.height;
				}
			}
		}

		// final extra space
		y += super.getVgap();

		ourMaxwidth = Math.max(ourMaxwidth, x);
		Dimension rt2 = new Dimension(ourMaxwidth, y + rowh);
		log.finest("Dimensions=" + rt2);
		log.exiting("FlowLayout", "preferredLayoutSize");
		return rt2;
	}

	/**
	 * 
	 */
	public Dimension minimumLayoutSize(Container parent) {
		log.entering("FlowLayout", "minimumLayoutSize", new Object[] { parent });
		Dimension rt = super.minimumLayoutSize(parent);
		log.finest("Dimensions=" + rt);
		log.exiting("FlowLayout", "minimumLayoutSize");
		return rt;
	}

	/**
	 * 
	 */
	public void layoutContainer(Container parent) {
		log.entering("FlowLayout", "layoutContainer", new Object[] { parent });
		super.layoutContainer(parent);
		log.exiting("FlowLayout", "layoutContainer");
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("MultilineFlowLayout demo");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);

		JPanel p1 = new JPanel();
		p1.setBackground(Color.BLUE);
		for (int i = 0; i < 10; i++) {
			p1.add(new JLabel("  aaa  "));
		}
		frame.add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel(new MultiLineFlowLayout());
		p2.setBackground(Color.BLUE);
		for (int i = 0; i < 10; i++) {
			p2.add(new JLabel("  aaa  "));
		}
		frame.add(p2, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
}
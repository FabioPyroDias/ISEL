package classcode.p15Swing.p02buildedLayouts;

/**
 * Center layout - este layout coloca o único componente no centro e packed
 *   
 * ATENÇÃO: este é um exemplo de um layout manager construído por nós.
 * Em MoP não estamos interessados em construir layout managers.
 * Este exemplo apenas mostra que eu era necessário fazer para se construir um.
 * 
 * Contudo este layout manager fica disponível para utilização.
 * 
 * By: António Teófilo, em desenvolvimento
 */

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;

public class CenterLayout implements LayoutManager2 {

	public CenterLayout() {

	}

	/* Required by LayoutManager - deprecated */
	public void addLayoutComponent(String name, Component comp) {
		// System.out.println("CL: called addLayoutComponent with::: " + name
		// + " " + comp);
	}

	/* Required by LayoutManager. */
	public void addLayoutComponent(Component comp, Object constraints) {
		// System.out.println("CL: called addLayoutComponent with " + comp + " "
		// + constraints);
	}

	/* Required by LayoutManager. */
	public void removeLayoutComponent(Component comp) {
		// System.out.println("CL: removeLayoutComponent called");
	}

	public Component getLayoutComponent(Object constraints) {
		// System.out.println("CL: getLayoutComponent called");
		return null;
	}

	public Component getLayoutComponent(Container target, Object constraints) {
		// System.out
		// .println("CL: Unimplemented method getLayoutComponent has called ------");
		return null;
	}

	/* Required by LayoutManager. */
	public Dimension preferredLayoutSize(Container parent) {
		// System.out.println("CL: preferredLayoutSize called");
		Dimension dim = new Dimension(0, 0);
		Component c = parent.getComponent(0);

		// setSizes(parent);
		if (c != null) {
			dim = c.getPreferredSize();
		}

		// Always add the container's insets!
		Insets insets = parent.getInsets();
		dim.width += insets.left + insets.right;
		dim.height += insets.top + insets.bottom;

		return dim;
	}

	/* Required by LayoutManager. */
	public Dimension minimumLayoutSize(Container parent) {
		// System.out.println("CL: minimumLayoutSize called");
		Dimension dim = new Dimension(0, 0);
		Component c = parent.getComponent(0);

		// setSizes(parent);
		if (c != null) {
			dim = c.getPreferredSize();
		}

		// Always add the container's insets!
		Insets insets = parent.getInsets();
		dim.width += insets.left + insets.right;
		dim.height += insets.top + insets.bottom;

		return dim;
	}

	/* Required by LayoutManager. */
	/*
	 * This is called when the panel is first displayed, and every time its size
	 * changes. Note: You CAN'T assume preferredLayoutSize or minimumLayoutSize
	 * will be called -- in the case of applets, at least, they probably won't
	 * be.
	 */
	public void layoutContainer(Container parent) {
		// System.out.println("CL: layoutContainer(Container parent) called");
		Insets insets = parent.getInsets();
		Dimension dimParent = parent.getSize();
		Component comp = parent.getComponent(0);

		// the component
		if (comp != null && comp.isVisible()) {
			Dimension preferedSize = comp.getPreferredSize();
			if (dimParent.width < preferedSize.width + insets.left
					+ insets.right)
				preferedSize.width = dimParent.width - insets.left
						- insets.right;
			if (dimParent.height < preferedSize.height + insets.top
					+ insets.bottom)
				preferedSize.height = dimParent.height - insets.top
						- insets.bottom;
			int x = (dimParent.width - insets.left - insets.right - preferedSize.width) / 2;
			int y = (dimParent.height - insets.top - insets.bottom - preferedSize.height) / 2;
			// Set the component's size and position.
			comp.setBounds(x + insets.left, y + insets.top, preferedSize.width,
					preferedSize.height);
		}
	}

	public String toString() {
		// System.out.println("CL: toString called");
		return getClass().getName();
	}

	public void repaint(Container parent) {
		// System.out.println("CL: repaint called");
		// setSizes(parent);
	}

	public Dimension maximumLayoutSize(Container target) {
		// System.out.println("CL: maximumLayoutSize called");
		return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	public float getLayoutAlignmentX(Container target) {
		// System.out.println("CL: getLayoutAlignmentX called");
		return 0.5f;
	}

	public float getLayoutAlignmentY(Container target) {
		// System.out.println("CL: getLayoutAlignmentY called");
		return 0.5f;
	}

	public void invalidateLayout(Container target) {
		// System.out.println("CL: invalidateLayout called");
	}
}

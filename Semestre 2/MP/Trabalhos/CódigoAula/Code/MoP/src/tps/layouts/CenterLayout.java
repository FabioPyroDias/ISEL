package tps.layouts;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

/**
 * Center layout - este layout coloca o único componente no centro e packed. Mas
 * se tiver a propriedade de isAllwaysCentred a false então no caso de falta de
 * algum componente o componente central é deslocado nessa direcção mas mantendo
 * sempre as suas dimensões.
 * 
 * By: António Teófilo, v3.0 June, 2014
 */
public class CenterLayout extends BorderLayout {

	private static final long serialVersionUID = 4295666446169476878L;

	// isAlwaysCentred =========================
	// this property is only used when there are missing components
	// if true, the central component will be positioning always in the centre
	// if not, the central component will positioned depending of the others.
	private boolean isAlwaysCentred = true;

	public CenterLayout() {
		this(0, 0);
	}

	/**
	 * Constructs a border layout with the specified gaps between components.
	 * The horizontal gap is specified by <code>hgap</code> and the vertical gap
	 * is specified by <code>vgap</code>.
	 * 
	 * @param hgap
	 *            the horizontal gap.
	 * @param vgap
	 *            the vertical gap.
	 */
	public CenterLayout(int hgap, int vgap) {
		super(hgap, vgap);
	}

	public void setAlwaysCentred(boolean isAlwaysCentred) {
		this.isAlwaysCentred = isAlwaysCentred;
	}

	public boolean getAlwaysCentred() {
		return isAlwaysCentred;
	}

	private Dimension zeroDim = new Dimension(0, 0);

	public void layoutContainerX(Container target) {
		synchronized (target.getTreeLock()) {
			Insets insets = target.getInsets();
			int top = insets.top;
			int bottom = target.getHeight() - insets.bottom;
			int left = insets.left;
			int right = target.getWidth() - insets.right;

			Component c = null;

			Dimension preferedSizeCenterComp = getChild(CENTER)
					.getPreferredSize();
			if (preferedSizeCenterComp == null)
				preferedSizeCenterComp = zeroDim;

			int deltaX = (right - left - preferedSizeCenterComp.width) / 2;
			int deltaY = (bottom - top - preferedSizeCenterComp.height) / 2;

			if ((c = getChild(NORTH)) != null) {
				c.setBounds(left, top, right - left, deltaY);
				top += deltaY + getVgap();
			}
			if ((c = getChild(SOUTH)) != null) {
				c.setBounds(left, bottom - deltaY, right - left, deltaY);
				bottom -= deltaY + getVgap();
			}
			if ((c = getChild(EAST)) != null) {
				c.setBounds(right - deltaX, top, deltaX, bottom - top);
				right -= deltaX + getHgap();
			}
			if ((c = getChild(WEST)) != null) {
				c.setBounds(left, top, deltaX, bottom - top);
				left += deltaX + getHgap();
			}
			if ((c = getChild(CENTER)) != null) {
				c.setBounds(left, top, right - left, bottom - top);
			}
		}
	}

	public void layoutContainer(Container target) {
		synchronized (target.getTreeLock()) {
			Insets insets = target.getInsets();
			int top = insets.top;
			int bottom = target.getHeight() - insets.bottom;
			int left = insets.left;
			int right = target.getWidth() - insets.right;

			int vgap = getVgap(), hgap = getHgap();

			// boolean ltr = target.getComponentOrientation().isLeftToRight();
			Component c = null;

			Dimension preferedSizeCenterComp = getChild(CENTER)
					.getPreferredSize();
			if (preferedSizeCenterComp == null)
				preferedSizeCenterComp = zeroDim;

			int deltaX = (right - left - preferedSizeCenterComp.width) / 2;
			int deltaY = (bottom - top - preferedSizeCenterComp.height) / 2;

			if ((c = getChild(NORTH)) != null) {
				if (getChild(SOUTH) != null || isAlwaysCentred) {
					c.setBounds(left, top, right - left, deltaY);
					top += deltaY + vgap;
				} else {
					// there is not SOUTH component: NORTH components get up
					// free space
					c.setBounds(left, top, right - left, bottom - top
							- preferedSizeCenterComp.height - vgap);
					top = bottom - preferedSizeCenterComp.height;
				}
			} else {
				if (isAlwaysCentred)
					top += deltaY + vgap;
			}

			if ((c = getChild(SOUTH)) != null) {
				if (getChild(NORTH) != null || isAlwaysCentred) {
					c.setBounds(left, bottom - deltaY, right - left, deltaY);
					bottom -= deltaY + vgap;
				} else {
					// there is not NORTH component: SOUTH components get up
					// free space
					c.setBounds(left, preferedSizeCenterComp.height + vgap,
							right - left, bottom - top
									- preferedSizeCenterComp.height - vgap);
					bottom = top + preferedSizeCenterComp.height;
				}
			} else {
				if (isAlwaysCentred)
					bottom -= deltaY + vgap;
			}

			if ((c = getChild(WEST)) != null) {
				if (getChild(EAST) != null || isAlwaysCentred) {
					c.setBounds(left, top, deltaX, bottom - top);
					left += deltaX + hgap;
				} else {
					// there is not EAST component: WEST components get up
					// free space
					c.setBounds(left, top, right - left
							- preferedSizeCenterComp.width - hgap, bottom - top);
					left += right - preferedSizeCenterComp.width - hgap + hgap;
				}
			} else {
				if (isAlwaysCentred)
					left += deltaX + hgap;
			}

			if ((c = getChild(EAST)) != null) {
				if (getChild(WEST) != null || isAlwaysCentred) {
					c.setBounds(right - deltaX, top, deltaX, bottom - top);
					right -= deltaX + hgap;
				} else {
					// there is not WEST component: EAST components get up
					// free space
					c.setBounds(left + preferedSizeCenterComp.width + hgap,
							top, right - preferedSizeCenterComp.width - hgap
									- left, bottom - top);
					right -= right - preferedSizeCenterComp.width - left - hgap
							+ hgap;
					// preferedSizeCenterComp.width + hgap + left ;
				}
			} else {
				if (isAlwaysCentred)
					right -= deltaX + hgap;
			}

			if ((c = getChild(CENTER)) != null) {
				c.setBounds(left, top, right - left, bottom - top);
			}
		}
	}

	Component getChild(String key) {
		Component result = getLayoutComponent(key);
		if (result != null && !result.isVisible())
			result = null;
		return result;
	}
}

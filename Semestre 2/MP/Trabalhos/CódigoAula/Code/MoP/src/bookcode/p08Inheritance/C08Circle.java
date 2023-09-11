package bookcode.p08Inheritance;

/**
 * A class of circles.
 */
public class C08Circle implements C06IMeasurable {

	// attributes
	private double myRadius;

	public C08Circle(double radius) {
		myRadius = radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * myRadius;
	}

	public double getCircumference() {
		return getPerimeter();
	}

	public double getArea() {
		return Math.PI * myRadius * myRadius;
	}
}

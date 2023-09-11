package bookcode.p08Inheritance;

/**
 * A class that implements an interface.
 * 
 * 
 * A class of rectangles.
 */
public class C07Rectangle implements C06IMeasurable {

	// attributes
	private double myWidth;
	private double myHeight;

	public C07Rectangle(double width, double height) {
		myWidth = width;
		myHeight = height;
	}

	public double getPerimeter() {
		return 2 * (myWidth + myHeight);
	}

	public double getArea() {
		return myWidth * myHeight;
	}
}

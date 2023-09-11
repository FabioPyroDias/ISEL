package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Overloading in static methods
 * 
 * This class illustrates overloading. Overloading means that we have at least
 * two method with the same name but with different argument list. The return
 * value and visibility doesn't matter.
 * 
 * Overloading can occurs in static and non-static methods (even in
 * constructors)
 */
public class C13Overload {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// use the method getAverage(double, double)
		double average1 = C13Overload.getAverage(40.0, 50.0);
		System.out.println("average1 = " + average1);

		// use the method getAverage(double, double, double)
		double average2 = C13Overload.getAverage(1.0, 2.0, 3.0);
		System.out.println("average2 = " + average2);

		// use the method getAverage(char, char)
		char average3 = C13Overload.getAverage('a', 'c');
		System.out.println("average3 = " + average3);
	}

	/**
	 * 
	 */
	public static double getAverage(double first, double second) {
		return (first + second) / 2.0;
	}

	/**
	 * 
	 */
	public static double getAverage(double first, double second, double third) {
		return (first + second + third) / 3.0;
	}

	/**
	 * 
	 */
	public static char getAverage(char first, char second) {
		return (char) (((int) first + (int) second) / 2);
	}
}

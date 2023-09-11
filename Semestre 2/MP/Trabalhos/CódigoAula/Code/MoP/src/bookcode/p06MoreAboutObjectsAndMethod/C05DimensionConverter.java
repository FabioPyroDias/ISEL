package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Static MEMBERS: static METHODS and static ATTRIBUTES.
 * 
 * Static members can be access by any context, be it static or an instance.
 * 
 * but a static method can't access directly instance members: attributes or
 * methods.
 */

/**
 * Class of static methods to perform dimension conversions.
 */
public class C05DimensionConverter {

	// a static final variable; means that is global to the class and once
	// initialised can not be changed
	public static final int INCHES_PER_FOOT = 12;

	/**
	 * static method to convert from feet to inches
	 */
	public static double convertFeetToInches(double feet) {
		// can (directly) access static attributes and static methods
		return feet * INCHES_PER_FOOT;
	}

	/**
	 * static method to convert from inches to feet
	 */
	public static double convertInchesToFeet(double inches) {
		// this too
		return inches / INCHES_PER_FOOT;
	}
}

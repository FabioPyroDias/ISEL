package bookcode.p05ClassesAndMethods;

public class C11RectangleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create a new rectangle
		C10Rectangle rect = new C10Rectangle();

		// set its data
		rect.setDimensions(20, 30);

		// write its data to the console
		System.out.println("Rctangle with width " + rect.getWidth()
				+ " and height " + rect.getHeight() + "\nHave an area of -> "
				+ rect.getArea());
	}

}

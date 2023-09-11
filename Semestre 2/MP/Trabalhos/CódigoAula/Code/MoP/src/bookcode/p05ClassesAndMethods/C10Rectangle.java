package bookcode.p05ClassesAndMethods;

/**
 * class rectangle
 * 
 */
public class C10Rectangle {

	private int width;
	private int height;

	// method to set data
	public void setDimensions(int newWidth, int newHeight) {
		width = newWidth;
		height = newHeight;
	}

	// method to get width value
	public int getWidth() {
		return width;
	}

	// method to get height value
	public int getHeight() {
		return height;
	}

	// method to get area value
	public int getArea() {
		// area is a result from the other two attributes
		return width * height;
	}
}

package bookcode.p08Inheritance;

/**
 * An Abstract class.
 * 
 * Abstract base class for drawing simple shapes on the screen using characters.
 */
public abstract class C20ShapeBase implements C09IShapeInterface {

	private int offset;

	public C20ShapeBase() {
		offset = 0;
	}

	public C20ShapeBase(int theOffset) {
		offset = theOffset;
	}

	public void setOffset(int newOffset) {
		offset = newOffset;
	}

	public int getOffset() {
		return offset;
	}

	public void drawAt(int lineNumber) {
		for (int count = 0; count < lineNumber; count++)
			System.out.println();
		drawHere();
	}

	/**
	 * An abstract method.
	 * 
	 * Now this method doesn't have an implementation. So the class should be
	 * abstract. In this case, that this class says that implements Shape
	 * interface and is abstract, it's no need to declare the drawHere method.
	 * Because the class is abstract it means that the class could have methods
	 * that needs to be implemented
	 */
	public abstract void drawHere();
}

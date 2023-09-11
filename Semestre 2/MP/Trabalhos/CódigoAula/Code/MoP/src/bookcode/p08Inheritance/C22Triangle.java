package bookcode.p08Inheritance;

/**
 * Class for drawing triangles on the screen using keyboard characters. A
 * triangle points up. Its size is determined by the length of its base, which
 * must be an odd integer. Inherits getOffset, setOffset, and drawAt from the
 * class ShapeBasics.
 */
public class C22Triangle extends C20ShapeBase implements
		C11ITriangleInterface {
	private int base;

	public C22Triangle() {
		super();
		base = 0;
	}

	public C22Triangle(int theOffset, int theBase) {
		super(theOffset);
		base = theBase;
	}

	/** Precondition: newBase is odd. */
	public void set(int newBase) {
		base = newBase;
	}

	public void drawHere() {
		drawTop();
		drawBase();
	}

	private void drawBase() {
		skipSpaces(getOffset());
		for (int count = 0; count < base; count++)
			System.out.print('*');
		System.out.println();
	}

	private void drawTop() {
		// startOfLine == number of spaces to the
		// first '*' on a line. Initially set to the
		// number of spaces before the topmost '*'.
		int startOfLine = getOffset() + base / 2;
		skipSpaces(startOfLine);
		System.out.println('*');// top '*'
		int lineCount = base / 2 - 1;// height above base
		// insideWidth == number of spaces between the
		// two '*'s on a line.
		int insideWidth = 1;
		for (int count = 0; count < lineCount; count++) {
			// Down one line, so the first '*' is one more
			// space to the left.
			startOfLine--;
			skipSpaces(startOfLine);
			System.out.print('*');
			skipSpaces(insideWidth);
			System.out.println('*');
			// Down one line, so the inside is 2 spaces wider.
			insideWidth = insideWidth + 2;
		}
	}

	private static void skipSpaces(int number) {
		for (int count = 0; count < number; count++)
			System.out.print(' ');
	}
}

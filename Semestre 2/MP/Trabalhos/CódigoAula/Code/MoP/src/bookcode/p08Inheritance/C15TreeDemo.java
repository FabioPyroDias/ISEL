package bookcode.p08Inheritance;

/**
 * A program that draws a fir tree composed of a triangle and a rectangle, both
 * drawn using keyboard characters.
 */
public class C15TreeDemo {
	public static final int INDENT = 5;
	public static final int TREE_TOP_WIDTH = 21;// must be odd
	public static final int TREE_BOTTOM_WIDTH = 4;
	public static final int TREE_BOTTOM_HEIGHT = 4;

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// draw a tree
		drawTree(TREE_TOP_WIDTH, TREE_BOTTOM_WIDTH, TREE_BOTTOM_HEIGHT);
	}

	// method that draws a tree
	public static void drawTree(int topWidth, int bottomWidth, int bottomHeight) {
		System.out.println(" Save the Redwoods!");

		// build and draw the tree top
		C11ITriangleInterface treeTop = new C14Triangle(INDENT, topWidth);
		drawTop(treeTop);

		// build and draw the tree trunk
		C10IRectangleInterface treeTrunk = new C13Rectangle(INDENT
				+ (topWidth / 2) - (bottomWidth / 2), bottomHeight, bottomWidth);
		drawTrunk(treeTrunk);
	}

	// draw the tree top - an triangle
	private static void drawTop(C11ITriangleInterface treeTop) {
		treeTop.drawAt(1);
	}

	// draw the tree trunk - a rectangle
	private static void drawTrunk(C10IRectangleInterface treeTrunk) {
		treeTrunk.drawHere(); // or treeTrunk.drawAt(0);
	}
}
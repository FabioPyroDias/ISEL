package bookcode.p08Inheritance;

/**
 * A program that draws a fir tree composed of a triangle and a rectangle, both
 * drawn using keyboard characters.
 */
public class C23TreeDemo {
	public static final int INDENT = 5;
	public static final int TREE_TOP_WIDTH = 21;// must be odd
	public static final int TREE_BOTTOM_WIDTH = 4;
	public static final int TREE_BOTTOM_HEIGHT = 4;

	/**
	 * main
	 */
	public static void main(String[] args) {
		drawTree(TREE_TOP_WIDTH, TREE_BOTTOM_WIDTH, TREE_BOTTOM_HEIGHT);
	}

	public static void drawTree(int topWidth, int bottomWidth, int bottomHeight) {
		System.out.println(" Save the Redwoods!");
		C11ITriangleInterface treeTop = new C22Triangle(INDENT, topWidth);
		drawTop(treeTop);
		C10IRectangleInterface treeTrunk = new C21Rectangle(INDENT
				+ (topWidth / 2) - (bottomWidth / 2), bottomHeight, bottomWidth);
		drawTrunk(treeTrunk);
	}

	private static void drawTop(C11ITriangleInterface treeTop) {
		treeTop.drawAt(1);
	}

	private static void drawTrunk(C10IRectangleInterface treeTrunk) {
		treeTrunk.drawHere(); // or treeTrunk.drawAt(0);
	}
}
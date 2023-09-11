package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Enumerate. Enables us to define several values of the same type and they have
 * a relation of order
 * 
 * An enumeration of card suits.
 * */
public enum C18Suit {
	// definition of the values: they must be compatible with one constructor
	CLUBS("black"), DIAMONDS("red"), HEARTS("red"), SPADES("black");

	// data for each instances
	private final String color;

	// instance methods

	private C18Suit(String suitColor) {
		color = suitColor;
	}

	public String getColor() {
		return color;
	}
}

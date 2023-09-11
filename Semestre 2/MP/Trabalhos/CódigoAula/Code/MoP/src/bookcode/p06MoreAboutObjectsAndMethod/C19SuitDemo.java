package bookcode.p06MoreAboutObjectsAndMethod;

/*
 * Enumeration demo
 */
public class C19SuitDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// get SPADES and saved it in cardSuit
		C18Suit cardSuit = C18Suit.SPADES;

		// print cardSuit
		System.out.println("cardSuit -> " + cardSuit);
		// print the ordinal of cardSuit
		System.out.println("cardSuit.ordinal() -> " + cardSuit.ordinal());

		// compare cradSuit with CLUBS
		// equals
		System.out.println("cardSuit.equals(C18Suit.CLUBS) -> "
				+ cardSuit.equals(C18Suit.CLUBS));
		// compare
		System.out.println("cardSuit.compareTo(C18Suit.CLUBS) -> "
				+ cardSuit.compareTo(C18Suit.CLUBS));

		// valueOf
		System.out.println("C18Suit.valueOf(\"CLUBS\") -> "
				+ C18Suit.valueOf("CLUBS"));
		System.out.println("C18Suit.valueOf(cardSuit.toString() -> "
				+ C18Suit.valueOf(cardSuit.toString()));
		// get colour
		System.out.println("cardSuit.getColor() -> " + cardSuit.getColor());

		// toString is a method that every Object have- when the object needs to
		// be shown as a string the toString is called
		System.out.println("cardSuit.toString() -> " + cardSuit.toString());
	}
}

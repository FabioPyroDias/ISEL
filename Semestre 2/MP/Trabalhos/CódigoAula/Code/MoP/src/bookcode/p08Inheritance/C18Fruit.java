package bookcode.p08Inheritance;

/**
 * A Fruit that is comparable.
 * 
 * Para j� vamos ignorar os warning referentes aos gen�ricos. Vamos resolver
 * isso no m�dulo de estruturas din�micas onde no qual abordaremos os gen�ricos.
 * Por isso colquei a directiva de suppresswarning the "rawTypes"
 * 
 */
@SuppressWarnings("rawtypes")
public class C18Fruit implements Comparable {
	private String fruitName;

	public C18Fruit() {
		fruitName = "";
	}

	public C18Fruit(String name) {
		fruitName = name;
	}

	public void setName(String name) {
		fruitName = name;
	}

	public String getName() {
		return fruitName;
	}

	public int compareTo(Object o) {
		if ((o != null) && (o instanceof C18Fruit)) {
			C18Fruit otherFruit = (C18Fruit) o;
			return (fruitName.compareTo(otherFruit.fruitName));
		}
		return -1; // Default if other object is not a Fruit
	}
}

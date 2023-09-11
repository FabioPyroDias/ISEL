package bookcode.p07Arrays;

/**
 * An object of this class is a special kind of list of strings. You can write
 * the list only from beginning to end. You can add only to the end of the list.
 * You cannot change individual entries, but you can erase the entire list and
 * start over. No entry may appear more than once on the list. You can use int
 * variables as position markers into the list.
 */

public class C09OneWayNoRepeatsList {

	public static int DEFAULT_SIZE = 50;
	// entry.length is the total number of items you have room
	// for on the list (its capacity); countOfEntries is the number of
	// items currently on the list.
	private int countOfEntries; // can be less than entry.length.
	private String[] entry;

	/**
	 * Creates an empty list with a given capacity.
	 */
	public C09OneWayNoRepeatsList(int maximumNumberOfEntries) {
		entry = new String[maximumNumberOfEntries];
		countOfEntries = 0;
	}

	/**
	 * Creates an empty list with a capacity of DEFAULT_SIZE.
	 */
	public C09OneWayNoRepeatsList() {
		entry = new String[DEFAULT_SIZE];
		countOfEntries = 0;
		// or replace these two statements with this(DEFAULT_SIZE);
	}

	/**
	 * return true if list is full
	 */
	public boolean isFull() {
		return countOfEntries == entry.length;
	}

	/**
	 * return true if list is Empty
	 */
	public boolean isEmpty() {
		return countOfEntries == 0;
	}

	/**
	 * Precondition: List is not full. Postcondition: If item was not on the
	 * list, it has been added to the list.
	 */
	public void addItem(String item) {
		if (!isOnList(item)) {
			if (countOfEntries == entry.length) {
				System.out.println("Adding to a full list!");
				System.exit(0);
			} else {
				entry[countOfEntries] = item;
				countOfEntries++;
			}
		} // else do nothing. Item is already on the list.
	}

	/**
	 * If the argument indicates a position on the list, the entry at that
	 * specified position is returned; otherwise, null is returned.
	 */
	public String getEntryAt(int position) {
		String result = null;
		if ((1 <= position) && (position <= countOfEntries))
			result = entry[position - 1];
		return result;
	}

	/**
	 * Returns true if position indicates the last item on the list; otherwise,
	 * returns false.
	 */
	public boolean atLastEntry(int position) {
		return position == countOfEntries;
	}

	/**
	 * Returns true if item is on the list; otherwise, returns false. Does not
	 * differentiate between uppercase and lowercase letters.
	 */
	public boolean isOnList(String item) {
		boolean found = false;
		int i = 0;
		while (!found && (i < countOfEntries)) {
			if (item.equalsIgnoreCase(entry[i]))
				found = true;
			else
				i++;
		}
		return found;
	}

	/**
	 * get Maximum Number Of Entries
	 */
	public int getMaximumNumberOfEntries() {
		return entry.length;
	}

	/**
	 * get Number Of Entries
	 */
	public int getNumberOfEntries() {
		return countOfEntries;
	}

	/**
	 * erase List
	 */
	public void eraseList() {
		countOfEntries = 0;
	}
}

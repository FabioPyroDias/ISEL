package classcode.p13EDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C11CollectionsDemo {

	static class CmpByLength implements Comparator<String> {
		static Comparator<String> cmp = new CmpByLength();

		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	}

	public static Comparator<String> getComparator() {
		return CmpByLength.cmp;
	}

	public static void main(String[] args) {

		ArrayList<String> al1 = new ArrayList<String>(Arrays.asList("Marta",
				"Ana", "Pedro", "João"));
		System.out.println("al1 -> " + al1);

		// static <T> boolean addAll(Collection<? super T> c, T... elements)
		Collections.addAll(al1, "Tiago", "Amilcar");
		System.out.println("\nCollections.addAll(al1, \"Tiago\", \"Amilcar\")");
		System.out.println("al1 -> " + al1);

		// static <T> void fill(List<? super T> list, T obj)
		// Replaces all of the elements of the specified list with the
		// specified element.
		ArrayList<String> al2 = new ArrayList<String>(al1);
		Collections.fill(al2, "Francisco");
		System.out.println("\nCollections.fill(al2, \"...\")");
		System.out.println("al2 -> " + al2);

		// static <T> void copy(List<? super T> dest, List<? extends T> src)
		// Copies all of the elements from one list into another.
		// the dest collection must have size >= src.size()
		Collections.copy(al2, al1);
		System.out.println("\nCollections.copy(al2, al1)");
		System.out.println("al2 -> " + al2);

		// static int frequency(Collection<?> c, Object o)
		// Returns the number of elements in the specified collection equal to
		// the specified object.
		Collections.addAll(al1, "Ana", "Ana");
		System.out.println("\nal1 -> " + al1);
		int noccurs = Collections.frequency(al1, "Ana");
		System.out.println("Collections.frequency(al1, \"Ana\") -> " + noccurs);
		System.out.println("Collections.frequency(al1, \"Pedro\") -> "
				+ Collections.frequency(al1, "Pedro"));

		// static void reverse(List<?> list)
		// Reverses the order of the elements in the specified list.
		Collections.reverse(al1);
		System.out.println("\nCollections.reverse(al1)");
		System.out.println("al1 -> " + al1);

		// static <T extends Comparable<? super T>> void sort(List<T> list)
		// Sorts the specified list into ascending order, according to the
		// natural ordering of its elements.
		Collections.sort(al1);
		System.out.println("\nCollections.sort(al1)");
		System.out.println("al1 -> " + al1);

		// static <T> void sort(List<T> list, Comparator<? super T> c)
		// Sorts the specified list according to the order induced by the
		// specified comparator.
		Collections.sort(al1, getComparator());
		System.out.println("\nCollections.sort(al1, getComparator())");
		System.out.println("al1 -> " + al1);

		// static <T> Comparator<T> reverseOrder()
		// Returns a comparator that imposes the reverse of the natural
		// ordering on a collection of objects that implement the Comparable
		// interface.
		Comparator<String> cmp = Collections.reverseOrder();
		Collections.sort(al1, cmp);
		System.out
				.println("\nCollections.sort(al1, Collections.reverseOrder())");
		System.out.println("al1 -> " + al1);

		// static <T> Comparator<T> reverseOrder(Comparator<T> cmp)
		// Returns a comparator that imposes the reverse ordering of the
		// specified comparator.
		cmp = Collections.reverseOrder(getComparator());
		Collections.sort(al1, cmp);
		System.out.println("\nCollections.sort(al1, "
				+ "Collections.reverseOrder(getComparator()))");
		System.out.println("al1 -> " + al1);

		// static <T> int binarySearch(List<? extends Comparable<? super T>>
		// list, T key)
		// Searches the specified list for the specified object using the
		// binary search algorithm.
		Collections.sort(al1);
		System.out.println("\nal1 -> " + al1);
		int idx = Collections.binarySearch(al1, "Pedro");
		System.out
				.println("Collections.binarySearch(al1, \"Pedro\") -> " + idx);

		// static <T> int binarySearch(List<? extends T> list, T key,
		// Comparator<? super T> c)
		// Searches the specified list for the specified object using the
		// binary search algorithm.
		cmp = getComparator();
		Collections.sort(al1, cmp);
		System.out.println("\nal1 -> " + al1);
		idx = Collections.binarySearch(al1, "Marta", cmp);
		System.out
				.println("Collections.binarySearch(al1, \"Marta\", getComparator()) -> "
						+ idx);

		// static <T> List<T> nCopies(int n, T o)
		// Returns an immutable list consisting of n copies of the specified
		// object.
		List<String> l = Collections.nCopies(4, "Joana");
		System.out.println("\nl = Collections.nCopies(4, \"Joana\")");
		System.out.println("l -> " + l);

		// static boolean disjoint(Collection<?> c1, Collection<?> c2)
		// Returns true if the two specified collections have no elements in
		// common.
		System.out.println("\nal1 -> " + al1);
		System.out.println("l -> " + l);
		boolean b = Collections.disjoint(al1, l);
		System.out.println("Collections.disjoint(al1, l) -> " + b);
		System.out.println("al2 -> " + al2);
		b = Collections.disjoint(al1, al2);
		System.out.println("Collections.disjoint(al1, al2) -> " + b);

		// static int indexOfSubList(List<?> source, List<?> target)
		// Returns the starting position of the first occurrence of the
		// specified target list within the specified source list, or -1 if
		// there is no such occurrence.
		al2 = new ArrayList<String>(Arrays.asList("Ana", "João"));
		System.out.println("\nal1 -> " + al1);
		System.out.println("al2 -> " + al2);
		idx = Collections.indexOfSubList(al1, al2);
		System.out.println("Collections.indexOfSubList(al1, al2) -> " + idx);

		// static int lastIndexOfSubList(List<?> source, List<?> target)
		// Returns the starting position of the last occurrence of the
		// specified target list within the specified source list, or -1 if
		// there is no such occurrence.

		// static <T extends Object & Comparable<? super T>> T max(Collection<?
		// extends T> coll)
		// Returns the maximum element of the given collection, according to
		// the natural ordering of its elements.
		System.out.println("\nal1 -> " + al1);
		String s = Collections.max(al1);
		System.out.println("Collections.max(al1) -> " + s);

		// static <T> T max(Collection<? extends T> coll, Comparator<? super T>
		// comp)
		// Returns the maximum element of the given collection, according to
		// the order induced by the specified comparator.
		System.out.println("\nal1 -> " + al1);
		s = Collections.max(al1, getComparator());
		System.out.println("Collections.max(al1, getComparator()) -> " + s);

		// static <T extends Object & Comparable<? super T>> T min(Collection<?
		// extends T> coll)
		// Returns the minimum element of the given collection, according to
		// the natural ordering of its elements.

		// static <T> T min(Collection<? extends T> coll, Comparator<? super T>
		// comp)
		// Returns the minimum element of the given collection, according to
		// the order induced by the specified comparator.

		// static void rotate(List<?> list, int distance)
		// Rotates the elements in the specified list by the specified
		// distance.
		System.out.println("\nal1 -> " + al1);
		Collections.rotate(al1, 3);
		System.out.println("Collections.rotate(al1, 3)");
		System.out.println("al1 -> " + al1);

		// static void shuffle(List<?> list)
		// Randomly permutes the specified list using a default source of
		// randomness.
		System.out.println("\nal1 -> " + al1);
		Collections.shuffle(al1);
		System.out.println("Collections.shuffle(al1)");
		System.out.println("al1 -> " + al1);

		// static void shuffle(List<?> list, Random rnd)
		// Randomly permute the specified list using the specified source of
		// randomness.

		// static void swap(List<?> list, int i, int j)
		// Swaps the elements at the specified positions in the specified
		// list.

		Collections.sort(al1);
		System.out.println("\nal1 -> " + al1);
		Collections.swap(al1, 2, 6);
		System.out.println("Collections.swap(al1, 2, 6)");
		System.out.println("al1 -> " + al1);

		// static <T> Collection<T> unmodifiableCollection(Collection<? extends
		// T> c)
		// Returns an unmodifiable view of the specified collection.
		System.out.println("\nal1 -> " + al1);
		Collection<String> c = Collections.unmodifiableCollection(al1);
		System.out.println("Collections.unmodifiableCollection(al1)");
		System.out.println("c -> " + c);
		try {
			System.out.println("c.add(\"Rodrigo\")");
			c.add("Rodrigo");
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getClass().getSimpleName());
		}

		// static <T> List<T> unmodifiableList(List<? extends T> list)
		// Returns an unmodifiable view of the specified list.
		System.out.println("\nal1 -> " + al1);
		List<String> list = Collections.unmodifiableList(al1);
		System.out.println("Collections.unmodifiableList(al1)");
		System.out.println("lis -> " + list);
		try {
			System.out.println("list.add(\"Rodrigo\")");
			list.add("Rodrigo");
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getClass().getSimpleName());
		}
	}
}

package classcode.p14EDDLinkedLists.p2GenericLinkedList;

import java.util.*;

public class C02GenericListDemo {
	public static void main(String[] args) {

		C01GenericLinkedList<String> stringList = new C01GenericLinkedList<String>();

		System.out.println("Lista de String ...");
		stringList.addANodeToStart("Hello");
		stringList.addANodeToStart("Good-bye");
		System.out.println("\nListagem da lista:");
		stringList.showList();
		String aux = stringList.deleteHeadNode();
		System.out.println("\nFoi removido o elemento -> " + aux);
		System.out.println("\nListagem da lista:");
		stringList.showList();

		System.out.println("\nLista de Integer ...");
		C01GenericLinkedList<Integer> numberList = new C01GenericLinkedList<Integer>();

		int i;
		for (i = 0; i < 10; i++)
			numberList.addANodeToStart(i);

		ArrayList<Integer> v = numberList.ArrayListCopy();

		int position;
		int vectorSize = v.size();

		for (position = 0; position < vectorSize; position++)
			System.out.println(v.get(position));

	}
}

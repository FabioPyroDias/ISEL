package classcode.p14EDDLinkedLists.p6Maps;

import java.util.Set;
import java.util.TreeSet;

public class C02SetTest {

	public static void main(String[] args) {

		// a set
		Set<Pessoa> set = new TreeSet<Pessoa>();

		// create some elements
		Pessoa p1 = new Pessoa("José", 12345611);
		Pessoa p2 = new Pessoa("Pedro", 564564566);
		Pessoa p3 = new Pessoa("Marco", 745547457);
		Pessoa p4 = new Pessoa("André", 46546);

		// add the elements to the set
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);

		
		// show set contents
		System.out.println("set -> " + set);

		// try to add an element that already exists in the set
		boolean result = set.add(p4);
		// show the result
		System.out.println("Set.add(" + p4 + ")  -> " + result);
		System.out.println("set -> " + set);
	}

}

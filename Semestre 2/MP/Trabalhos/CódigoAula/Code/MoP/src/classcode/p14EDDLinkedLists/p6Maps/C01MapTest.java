package classcode.p14EDDLinkedLists.p6Maps;

import java.util.HashMap;
import java.util.Map;

public class C01MapTest {

	public static void main(String[] args) {
		// Map<Integer, Pessoa> map = new Hashtable<Integer, Pessoa>();
		Map<Integer, Pessoa> map = new HashMap<Integer, Pessoa>();

		Pessoa p1 = new Pessoa("José", 12345611);
		Pessoa p2 = new Pessoa("Pedro", 564564566);
		Pessoa p3 = new Pessoa("Marco", 745547457);
		Pessoa p4 = new Pessoa("André", 46546);

		map.put(p1.bi, p1);
		map.put(p2.bi, p2);
		map.put(p3.bi, p3);
		map.put(p4.bi, p4);
		map.put(8000, p4);

		System.out.println("map.get(46546) -> " + map.get(46546));

		System.out.println("map -> " + map);

		// hash code test
		String s = "a";
		System.out.println("hashcode of " + s + " -> " + s.hashCode());
		s = "aa";
		System.out.println("hashcode of " + s + " -> " + s.hashCode());
	}

}

class Pessoa implements Comparable<Pessoa> {
	String name;
	int bi;

	public Pessoa(String name, int bi) {
		this.name = name;
		this.bi = bi;
	}

	public String toString() {
		return name + " " + bi;
	}

	public int compareTo(Pessoa p) {
		if (p == null)
			throw new NullPointerException();
		return name.compareTo(p.name);
	}
}

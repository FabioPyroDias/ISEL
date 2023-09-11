package classcode.p13EDD;

import java.util.Arrays;

public class C10Cloneable {

	public static void main(String[] args) {

		// shallow copy test
		System.out.println("Shallow copy:");

		CShallowCopy c1 = new CShallowCopy("Ana", 100);
		CShallowCopy c2 = (CShallowCopy) (c1.clone());

		System.out.println(c1.toString());
		System.out.println(c2.toString());

		// alterar valores de C1
		c1.name = "João";
		c1.num = 200;
		c1.array[0] = 20;

		// verificar o estado dos dois objectos
		System.out.println(c1.toString());
		System.out.println(c2.toString());

		System.out.println();

		// deep copy test
		System.out.println("Deep copy:");

		CDeepCopyClone cdc1 = new CDeepCopyClone("Ana", 100);
		CDeepCopyClone cdc2 = (CDeepCopyClone) (cdc1.clone());

		System.out.println(cdc1.toString());
		System.out.println(cdc2.toString());

		// alterar valores de C1
		cdc1.name = "João";
		cdc1.num = 200;
		cdc1.array[0] = 20;

		// verificar o estado dos dois objectos
		System.out.println(cdc1.toString());
		System.out.println(cdc2.toString());

		// deep copy test REALLY DEEP
		System.out.println("\nReally Deep copy:");

		CReallyDeepCopyClone p1 = new CReallyDeepCopyClone(new Pessoa(100,
				"Ana"));
		CReallyDeepCopyClone p2 = (CReallyDeepCopyClone) (p1.clone());

		System.out.println(p1.toString());
		System.out.println(p2.toString());

		// alterar valores de C1
		p1.array[0].name = "João";
		p2.array[0].id = 20;

		// verificar o estado dos dois objectos
		System.out.println(p1.toString());
		System.out.println(p2.toString());

	}
}

// class with clone with shallow copy
class CShallowCopy implements Cloneable {
	String name; // an immutable object
	int num; // an primitive type
	int[] array = new int[1]; // an normal object

	public CShallowCopy(String name, int num) {
		this.name = name;
		this.num = num;
		array[0] = num;
	}

	public String toString() {
		return name + " " + num + " " + array[0];
	}

	public Object clone() {
		try {
			// shallow copy - only copy values and references at top level
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new RuntimeException(e);
		}
	}
}

// class with clone with deep copy
class CDeepCopyClone implements Cloneable {
	String name;
	int num;
	int[] array = new int[1];

	public CDeepCopyClone(String name, int num) {
		this.name = name;
		this.num = num;
		array[0] = num;
	}

	public String toString() {
		return name + " " + num + " " + array[0];
	}

	public Object clone() {
		try {
			// a deep copy
			// 1º do the shallow copy of the attributes
			CDeepCopyClone theCopy = (CDeepCopyClone) super.clone();
			// 2º duplicate the array
			theCopy.array = array.clone();
			return theCopy;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new RuntimeException(e);
		}
	}
}

// class with clone with deep copy
class CReallyDeepCopyClone implements Cloneable {

	Pessoa[] array = new Pessoa[1];

	public CReallyDeepCopyClone(Pessoa p) {
		array[0] = p;
	}

	public String toString() {
		return Arrays.toString(array);
	}

	public Object clone() {
		try {
			// a deep copy
			// 1º do the shallow copy of the attributes
			CReallyDeepCopyClone theCopy = (CReallyDeepCopyClone) super.clone();
			// 2º deep duplicate the array
			theCopy.array = array.clone();
			for (int i = 0; i < array.length; i++) {
				theCopy.array[i] = (Pessoa) array[i].clone();}
			return theCopy;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new RuntimeException(e);
		}
	}
}

class Pessoa implements Cloneable {
	int id;
	String name;

	public Pessoa(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Object clone() {
		try {
			// a deep copy
			// 1º do the shallow copy of the attributes
			Pessoa theCopy = (Pessoa) super.clone();
			return theCopy;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new RuntimeException(e);
		}
	}

	public String toString() {
		return id + " " + name;
	}

}
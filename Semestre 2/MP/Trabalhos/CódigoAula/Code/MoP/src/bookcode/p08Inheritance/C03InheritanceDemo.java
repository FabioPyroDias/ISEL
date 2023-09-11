package bookcode.p08Inheritance;

/**
 * Inheritance Demo
 */
public class C03InheritanceDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {

		C02Student s = new C02Student();
		s.setName("Warren Peace");
		s.setStudentNumber(1234);

		s.writeOutput();
		System.out.println(s);

		C02Student s2 = new C02Student("Tio Patinhas", 34666);
		System.out.println(s2);
	}
}
package bookcode.p08Inheritance;

/**
 * Class Person extends Person
 */
public class C02Student extends C01Person {

	// student number
	private int studentNumber;

	// constructors

	public C02Student() {
		studentNumber = 0;// Indicating no number yet
	}

	public C02Student(String initialName, int initialStudentNumber) {
		super(initialName);
		studentNumber = initialStudentNumber;
	}

	// other methods

	public void reset(String newName, int newStudentNumber) {
		setName(newName);
		studentNumber = newStudentNumber;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int newStudentNumber) {
		studentNumber = newStudentNumber;
	}

	public void writeOutput() {
		System.out.println("Name: " + getName());
		System.out.println("Student Number: " + studentNumber);
	}

	public boolean equals(C02Student otherStudent) {
		return this.hasSameName(otherStudent)
				&& (this.studentNumber == otherStudent.studentNumber);
	}

	// a better equals
	public boolean equals(Object otherObject) {
		boolean isEqual = false;
		if ((otherObject != null) && (otherObject instanceof C02Student)) {
			C02Student otherStudent = (C02Student) otherObject;
			isEqual = this.hasSameName(otherStudent)
					&& (this.studentNumber == otherStudent.studentNumber);
		}
		return isEqual;
	}

	public String toString() {
		return "[ " + super.toString() + ", " + getStudentNumber() + " ]";
	}
}

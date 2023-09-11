package bookcode.p08Inheritance;

public class C04Undergraduate extends C02Student {

	// 1 for freshman, 2 for sophomore, 3 for junior, or 4 for senior.
	private int level;

	// constructors

	public C04Undergraduate() {
		// call the empty constructor of super class
		super();
		level = 1;
	}

	public C04Undergraduate(String initialName, int initialStudentNumber,
			int initialLevel) {
		// call a constructor of super class
		super(initialName, initialStudentNumber);
		setLevel(initialLevel); // checks 1 <= initialLevel <= 4
	}

	// other methods

	public void reset(String newName, int newStudentNumber, int newLevel) {
		reset(newName, newStudentNumber); // Student's reset
		setLevel(newLevel); // Checks 1 <= newLevel <= 4
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int newLevel) {
		if ((1 <= newLevel) && (newLevel <= 4))
			level = newLevel;
		else {
			System.out.println("Illegal level!");
			System.exit(0);
		}
	}

	public void writeOutput() {
		super.writeOutput();
		System.out.println("StudentLevel: " + level);
	}

	public boolean equals(C04Undergraduate otherUndergraduate) {
		return equals((C02Student) otherUndergraduate)
				&& (this.level == otherUndergraduate.level);
	}
}

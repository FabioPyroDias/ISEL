package bookcode.p07Arrays;

/**
 * Class that records the time worked by each of a company's employees during
 * one five-day week. A sample application is in the main method.
 * 
 * Employee number start at 1.
 */

public class C14TimeBook {

	private static final int NUMBER_OF_WORKDAYS = 5;
	private static final int MON = 0;
	private static final int TUE = 1;
	private static final int WED = 2;
	private static final int THU = 3;
	private static final int FRI = 4;

	// number of employees
	private int numberOfEmployees;

	// hours[i][j] has the hours for employee j on day i.
	private int[][] hours;

	// weekHours[i] has the week's hours worked for employee i + 1.
	private int[] weekHours;

	// dayHours[i] has the total hours worked by all employees on day i.
	private int[] dayHours;

	/**
	 * Reads hours worked for each employee on each day of the work week into
	 * the two-dimensional array hours. (The method for input is just a stub in
	 * this preliminary version.) Computes the total weekly hours for each
	 * employee and the total daily hours for all employees combined.
	 */

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the constant that defines the number of employees
		final int NUMBER_OF_EMPLOYEES = 3;

		// the time book
		C14TimeBook book = new C14TimeBook(NUMBER_OF_EMPLOYEES);

		// A class generally has more methods. We have defined
		// only the following three.

		// fill the worked hours
		book.setHours();

		book.update();

		book.showTable();

	}

	/**
	 * Constructor
	 * 
	 * @param theNumberOfEmployees
	 */
	public C14TimeBook(int theNumberOfEmployees) {
		// set the number of employees
		numberOfEmployees = theNumberOfEmployees;

		// create the array of worked hours for every employee
		hours = new int[NUMBER_OF_WORKDAYS][numberOfEmployees];

		// create the array of week ours for every employee
		weekHours = new int[numberOfEmployees];

		// array of number of days
		dayHours = new int[NUMBER_OF_WORKDAYS];
	}

	/**
	 * 
	 */
	// The final program would replace the stub setHours with a complete method
	// toObtain the employee data from the user.
	public void setHours() {
		// This is a stub. Which means a automatic generated code.
		hours[0][0] = 8;
		hours[0][1] = 0;
		hours[0][2] = 9;
		hours[1][0] = 8;
		hours[1][1] = 0;
		hours[1][2] = 9;
		hours[2][0] = 8;
		hours[2][1] = 8;
		hours[2][2] = 8;
		hours[3][0] = 8;
		hours[3][1] = 8;
		hours[3][2] = 4;
		hours[4][0] = 8;
		hours[4][1] = 8;
		hours[4][2] = 8;
	}

	/**
	 * update data
	 */
	public void update() {

		computeWeekHours();
		computeDayHours();
	}

	/**
	 * compute week hours
	 */
	void computeWeekHours() {
		// for every employee
		for (int employeeNumber = 1; employeeNumber <= numberOfEmployees; employeeNumber++) {
			// Process one employee:
			int sum = 0;
			for (int day = MON; day <= FRI; day++)
				sum = sum + hours[day][employeeNumber - 1];
			// sum contains the sum of all the hours worked in one week by the
			// employee with number employeeNumber.
			weekHours[employeeNumber - 1] = sum;
		}
	}

	/**
	 * Compute then day Hours
	 */
	private void computeDayHours() {
		for (int day = MON; day <= FRI; day++) {
			// Process one day (for all employees):
			int sum = 0;
			for (int employeeNumber = 1; employeeNumber <= numberOfEmployees; employeeNumber++)
				sum = sum + hours[day][employeeNumber - 1];
			// sum contains the sum of all hours worked by all
			// employees on one day.
			dayHours[day] = sum;
		}
	}

	/**
	 * This method can and should be made more robust
	 */
	public void showTable() {
		System.out.print("Employee  ");
		for (int employeeNumber = 1; employeeNumber <= numberOfEmployees; employeeNumber++)
			System.out.print(employeeNumber + "  ");
		System.out.println("Totals");
		System.out.println();
		// row entries
		for (int day = MON; day <= FRI; day++) {
			System.out.print(getDayName(day) + " ");
			for (int column = 0; column < hours[day].length; column++)
				System.out.print(hours[day][column] + "  ");
			System.out.println(dayHours[day]);
		}
		System.out.println();
		System.out.print("Total  = ");
		for (int column = 0; column < numberOfEmployees; column++)
			System.out.print(weekHours[column] + " ");
		System.out.println();
	}

	/**
	 * Converts 0 to "Monday", 1 to "Tuesday", etc. Blanks are inserted to make
	 * all strings the same length.
	 */
	private String getDayName(int day) {
		String dayName = null;
		switch (day) {
		case MON:
			dayName = "Monday   ";
			break;
		case TUE:
			dayName = "Tuesday  ";
			break;
		case WED:
			dayName = "Wednesday";
			break;
		case THU:
			dayName = "Thursday ";
			break;
		case FRI:
			dayName = "Friday   ";
			break;
		default:
			System.out.println("Fatal Error.");
			System.exit(0);
			break;
		}
		return dayName;
	}
}

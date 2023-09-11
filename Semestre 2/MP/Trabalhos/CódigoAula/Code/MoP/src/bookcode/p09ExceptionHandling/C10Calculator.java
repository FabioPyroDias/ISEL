package bookcode.p09ExceptionHandling;

import java.util.Scanner;

/**
 * Simple line-oriented calculator program. The class can also be used to create
 * other calculator programs.
 */
public class C10Calculator {
	private double result;
	private double precision = 0.0001;

	private Scanner keyboard = new Scanner(System.in);

	// Numbers this close to zero are treated as if equal to zero.
	public static void main(String[] args) {
		C10Calculator clerk = new C10Calculator();
		try {
			System.out.println("Calculator is on.");
			System.out.print("Format of each line: ");
			System.out.println("operator space number");
			System.out.println("For example: + 3");
			System.out.println("To end, enter the letter e.");
			clerk.doCalculation();
		} catch (C08UnknownOpException e) {
			clerk.handleUnknownOpException(e);
		} catch (C03DivideByZeroException e) {
			clerk.handleDivideByZeroException(e);
		}
		System.out.println("The final result is " + clerk.getResult());
		System.out.println("Calculator program ending.");
	}

	public C10Calculator() {
		result = 0;
	}

	public void handleDivideByZeroException(C03DivideByZeroException e) {
		System.out.println("Dividing by zero.");
		System.out.println("Program aborted");
		System.exit(0);
	}

	public void handleUnknownOpException(C08UnknownOpException e) {
		System.out.println(e.getMessage());
		System.out.println("Try again from the beginning:");
		try {
			System.out.print("Format of each line: ");
			System.out.println("operator number");
			System.out.println("For example: + 3");
			System.out.println("To end, enter the letter e.");
			doCalculation();
		} catch (C08UnknownOpException e2) {
			System.out.println(e2.getMessage());
			System.out.println("Try again at some other time.");
			System.out.println("Program ending.");
			System.exit(0);
		} catch (C03DivideByZeroException e3) {
			handleDivideByZeroException(e3);
		}
	}

	public void reset() {
		result = 0;
	}

	public void setResult(double newResult) {
		result = newResult;
	}

	public double getResult() {
		return result;
	}

	/**
	 * Returns n1 op n2, provided op is one of '+', '–', '*',or '/'. Any other
	 * value of op throws UnknownOpException.
	 */
	public double evaluate(char op, double n1, double n2)
			throws C03DivideByZeroException, C08UnknownOpException {
		double answer;
		switch (op) {
		case '+':
			answer = n1 + n2;
			break;
		case '-':
			answer = n1 - n2;
			break;
		case '*':
			answer = n1 * n2;
			break;
		case '/':
			if ((-precision < n2) && (n2 < precision))
				throw new C03DivideByZeroException();
			answer = n1 / n2;
			break;
		default:
			throw new C08UnknownOpException(op);
		}
		return answer;
	}

	public void doCalculation() throws C03DivideByZeroException,
			C08UnknownOpException {
		boolean done = false;
		result = 0;
		System.out.println("result = " + result);
		while (!done) {
			char nextOp = (keyboard.next()).charAt(0);
			if ((nextOp == 'e') || (nextOp == 'E'))
				done = true;
			else {
				double nextNumber = keyboard.nextDouble();
				result = evaluate(nextOp, result, nextNumber);
				System.out.println("result " + nextOp + " " + nextNumber
						+ " = " + result);
				System.out.println("updated result = " + result);
			}
		}
	}
}
package classcode.p08AbstractClassesAndInterfaces;

class C08BigNumber implements C06IWritable, C07IRelatable {

	private String number;

	/**
	 * 
	 */
	public C08BigNumber(String number) {
		if (!setValue(number))
			throw new IllegalArgumentException("Número inválido -> " + number);
	}

	/**
	 * 
	 */
	public boolean setValue(String n) {
		if (n == null)
			return false;
		// clean starting and ending spaces
		n = n.trim();

		// check if only digits
		if (!isValidNumber(n))
			return false;

		this.number = cleanLeftZeros(n);
		return true;
	}

	/**
	 * 
	 */
	public String getValue() {
		return this.toString();
	}

	/**
	 * 
	 */
	public String toString() {
		return number;
	}

	/**
	 * 
	 */
	public void writeOutput(String prefix) {
		System.out.println(prefix + this);
	}

	/**
	 * 
	 */
	private static boolean isValidNumber(String n) {
		for (int i = 0; i < n.length(); i++)
			if (!Character.isDigit(n.charAt(i)))
				return false;
		return true;
	}

	/**
	 * 
	 */
	public boolean isEquals(C07IRelatable other) {
		if (other == null)
			return false;
		String o = other.getValue();
		if (!isValidNumber(o))
			throw new IllegalArgumentException(
					"O argumento recebido não contém um número válido -> " + o);
		return number.equals(cleanLeftZeros(o));
	}

	/**
	 * 
	 */
	private static String cleanLeftZeros(String num) {
		int numberOfLeftZeros = 0;
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '0')
				numberOfLeftZeros++;
			else
				break;
		}
		return num.substring(numberOfLeftZeros);
	}

	/**
	 * 
	 */
	public boolean isBiggerThan(C07IRelatable other) {
		if (other == null)
			return false;
		String o = other.getValue();
		if (!isValidNumber(o))
			throw new IllegalArgumentException(
					"O argumento recebido não contém um número válido -> " + o);
		o = cleanLeftZeros(o);

		if (number.length() != o.length())
			return number.length() > o.length();

		for (int i = 0; i < number.length(); ++i)
			if (number.charAt(i) != o.charAt(i))
				return number.charAt(i) > o.charAt(i);

		return false;
	}

	/**
	 * 
	 */
	public boolean isSmallerThan(C07IRelatable other) {
		return !isEquals(other) && !isBiggerThan(other);
	}

	/**
	 * 
	 */
	public void add(C07IRelatable other) {
		if (other == null)
			throw new IllegalArgumentException("O argumento recebido é null");
		String o = other.getValue();
		if (!isValidNumber(o))
			throw new IllegalArgumentException(
					"O argumento recebido não contém um número válido -> "
							+ other);
		o = cleanLeftZeros(o);
		// add
		String result = "";
		int toAdd = 0, n = 0;
		for (int i = 0; true; i++) {
			if (i >= number.length() && i >= o.length()) {
				if (toAdd > 0)
					result = toAdd + result;
				break;
			}
			if (i < number.length() && i < o.length())
				n = (int) number.charAt(number.length() - 1 - i) - '0'
						+ (int) o.charAt(o.length() - 1 - i) - '0' + toAdd;
			else if (i < number.length())
				n = (int) number.charAt(number.length() - 1 - i) - '0' + toAdd;
			else
				n = (int) o.charAt(o.length() - 1 - i) - '0' + toAdd;
			result = (char) ((n % 10) + '0') + result;
			toAdd = n / 10;
		}

		number = result;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		C08BigNumber bn1 = new C08BigNumber("00072800000000000999999999");
		System.out.println("bn1 -> " + bn1.toString());

		C08BigNumber bn2 = new C08BigNumber("000000072800000000000999999999");
		System.out.println("bn2 -> " + bn2.toString());

		System.out.println("bn1.isEquals(bn2) -> " + bn1.isEquals(bn2));
		System.out.println();

		C08BigNumber bn3 = new C08BigNumber("0001111");
		System.out.println("bn3 -> " + bn3.toString());

		bn1.add(bn3);
		System.out.println("bn1.add(bn3), bn1 -> " + bn1.toString());
		System.out.println();

		System.out.println("bn1 instanceof C08BigNumber -> "
				+ (bn1 instanceof C08BigNumber));
		System.out.println("bn1 instanceof C06IWritable -> "
				+ (bn1 instanceof C06IWritable));
		System.out.println("bn1 instanceof C07IRelatable -> "
				+ (bn1 instanceof C07IRelatable));
		System.out.println("bn1 instanceof Object -> "
				+ (bn1 instanceof Object));

		// System.out.println((int) '9' + (int) '2');
		// char x1 = '9';
		// char x2 = '2';
		// System.out.println(x1 - '0');
	
	}

}

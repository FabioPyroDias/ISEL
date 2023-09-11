package classcode.p11StreamsAndFileIO;

import java.util.Arrays;

/**
 * Métodos úteis de String para procurar com caracteres ou conjuntos de
 * caracteres dentro de Strings
 * 
 */
public class C14StringMethods {

	/**
	 * main
	 */
	public static void main(String[] args) {
		String str = "src\\classcode\\p11StreamsAndFileIO\\exers\\C01.java";

		System.out.println("str -> " + str);

		// charAt(int index)
		int idx = 6;
		System.out.println("str.charAt(idx) -> " + str.charAt(idx));

		// indexOf(int ch), indexOf(int ch, int fromIndex), indexOf(String),
		// indexOf(String str, int fromIndex), substring(int beginIndex),
		// substring(int beginIndex, int endIndex)
		System.out.println("str vai ser separada por '\\'");
		idx = 0;
		int idx2 = 0;
		while ((idx = str.indexOf("\\", idx)) != -1) {
			System.out.print(str.substring(idx2, idx) + " \\ ");
			idx2 = ++idx;
		}
		System.out.println(str.substring(idx2, str.length()));

		// trim()
		str = "   olá   ";
		String str2 = str.trim();
		System.out.println("str = [" + str + "]");
		System.out.println("str.trim() = [" + str2 + "]");
		System.out.println();

		// uso de expressões regulares
		// matches(String regex), split(String regex)
		// uma expressão regular define um padrão
		// exemplos de padrões. Ver definição dos comandos para expressões
		// regulares no final do ficheiro

		// matches(String regex)
		System.out.println("\"olaaaa\".matches(\"^oa*\") -> "
				+ "olaaaa".matches("^ola*"));

		System.out.println("\"olaaaa\".matches(\"^oa{5}\") -> "
				+ "olaaaa".matches("^ola{5}"));

		String email = "joao.mateus@gmail.gmail.com";
		boolean isValidEmail = email.matches("^\\w+(.\\w+)*@\\w+(.\\w+).\\w+$");
		System.out.println("email " + email + " isValid -> " + isValidEmail);
		email = "joao.mateus.h200@gmail.gmail.com";
		isValidEmail = email.matches("^\\w+(.\\w+)*@\\w+(.\\w+).\\w+$");
		System.out.println("email " + email + " isValid -> " + isValidEmail);
		email = "joao.mateus.h200@com";
		isValidEmail = email.matches("^\\w+(.\\w+)*@\\w+(.\\w+).\\w+$");
		System.out.println("email " + email + " isValid -> " + isValidEmail);
		email = "joao.mateus.h200.gmail.com";
		isValidEmail = email.matches("^\\w+(.\\w+)*@\\w+(.\\w+).\\w+$");
		System.out.println("email " + email + " isValid -> " + isValidEmail);
		System.out.println();

		// split(String regex)
		str = "src\\classcode\\p11StreamsAndFileIO\\exers\\C01.java";
		String[] parts = str.split("\\\\"); // duplo processamento da string
		System.out.println("str -> " + str);
		System.out.println("str.split(\"\\\") -> " + Arrays.toString(parts));

		parts = str.split("1"); // duplo processamento da string
		System.out.println("str -> " + str);
		System.out.println("str.split(1) -> " + Arrays.toString(parts));
	}
}

// expressões regulares - tirado de java doc sobre regular expressions na Class
// Pattern. Por exemplo sobre o método matches de String, ver o javaDoc e
// seleccionar o link de Regular Expression
// Segue uma seleção dos comandos mais gerais

// Character classes
// [abc] a, b, or c (simple class)
// [^abc] Any character except a, b, or c (negation)
// [a-zA-Z] a through z or A through Z, inclusive (range)
// [a-d[m-p]] a through d, or m through p: [a-dm-p] (union)
// [a-z&&[def]] d, e, or f (intersection)
// [a-z&&[^bc]] a through z, except for b and c: [ad-z] (subtraction)
// [a-z&&[^m-p]] a through z, and not m through p: [a-lq-z](subtraction)

// Predefined character classes
// . Any character (may or may not match line terminators)
// \d A digit: [0-9]
// \D A non-digit: [^0-9]
// \s A whitespace character: [ \t\n\x0B\f\r]
// \S A non-whitespace character: [^\s]
// \w A word character: [a-zA-Z_0-9]
// \W A non-word character: [^\w]

// Boundary matchers
// ^ The beginning of a line
// $ The end of a line
// \b A word boundary
// \B A non-word boundary
// \A The beginning of the input
// \G The end of the previous match
// \Z The end of the input but for the final terminator, if any
// \z The end of the input

// Greedy quantifiers
// X? X, once or not at all
// X* X, zero or more times
// X+ X, one or more times
// X{n} X, exactly n times
// X{n,} X, at least n times
// X{n,m} X, at least n but not more than m times

// Logical operators
// XY X followed by Y
// X|Y Either X or Y
// (X) X, as a capturing group


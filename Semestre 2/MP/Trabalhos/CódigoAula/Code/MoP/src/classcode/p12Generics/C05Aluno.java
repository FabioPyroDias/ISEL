package classcode.p12Generics;

import java.util.Arrays;
import java.util.Comparator;

/**
 * C05Aluno, além da comparação pela ordem natural, define mais dois
 * comparadores para disponibilizar dois outros critérios de comparação
 */
public class C05Aluno implements Comparable<C05Aluno> {
	private String name;
	private int numero;
	private int nUCTerminadas;

	private C05Aluno(String name, int num, int nUCTerminadas) {
		this.name = name;
		this.numero = num;
		this.nUCTerminadas = nUCTerminadas;
	}

	// implementa a odem natural de comparação
	public int compareTo(C05Aluno p) {
		return name.compareTo(p.name);
	}

	public String toString() {
		return name + " " + numero + " " + nUCTerminadas;
	}

	// um comparador pelo numero de aluno - é uma nested class
	private static class MyComparatorByNum implements Comparator<C05Aluno> {
		// variável estática que contém o único comparador
		private static Comparator<C05Aluno> COMPBYNUM = new MyComparatorByNum();

		public int compare(C05Aluno a1, C05Aluno a2) {
			if (a1 == null || a2 == null)
				throw new NullPointerException();
			return a1.numero - a2.numero;
		}

		// método que devolve sempre a mesma instância do comparador
		// assim evita-se estar a criar instâncias desnecessárias do comparador
		public static Comparator<C05Aluno> getComparator() {
			return COMPBYNUM;
		}
	}

	// um comparador pelo numero de UCs terminadas - nested class
	private static class MyComparatorByNUCTerm implements Comparator<C05Aluno> {
		// variável estática que contém o único comparador
		private static Comparator<C05Aluno> COMPBYNUCTERMINADAS = new MyComparatorByNUCTerm();

		public int compare(C05Aluno a1, C05Aluno a2) {
			if (a1 == null || a2 == null)
				throw new NullPointerException();
			return a1.nUCTerminadas - a2.nUCTerminadas;
		}

		// método que devolve sempre a mesma instância do comparador
		public static Comparator<C05Aluno> getComparator() {
			return COMPBYNUCTERMINADAS;
		}
	}

	public static void main(String[] args) {
		C05Aluno[] alunos = { new C05Aluno("José", 10000, 5),
				new C05Aluno("Maria", 20000, 3),
				new C05Aluno("Filipa", 15000, 4) };

		System.out.println("Array at beginning -> " + Arrays.toString(alunos));

		// ordenar pela ordem natural
		Arrays.sort(alunos);
		System.out.println("Array after sorting by natural order -> "
				+ Arrays.toString(alunos));

		// ordenar pelo número de aluno
		Arrays.sort(alunos, MyComparatorByNum.getComparator());
//		Arrays.sort(alunos, MyComparatorByNum.getComparator().reversed());
		System.out.println(
				"Array after sorting by Numero -> " + Arrays.toString(alunos));

		// ordenar pelo número de UCs terminadas
		Arrays.sort(alunos, MyComparatorByNUCTerm.getComparator());
		System.out.println("Array after sorting by Num UC Terminadas -> "
				+ Arrays.toString(alunos));

	}
}

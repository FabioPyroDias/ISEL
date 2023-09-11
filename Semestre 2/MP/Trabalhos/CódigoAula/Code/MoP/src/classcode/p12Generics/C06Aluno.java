package classcode.p12Generics;

import java.util.Arrays;
import java.util.Comparator;

/**
 * sort(T[] a, Comparator<? super T> c)
 * 
 * Esta class elucida que o comparador pode ser um comparador de um tipo mais
 * base.
 * 
 * A classe C06Aluno deriva de Pessoa. O comparador disponibilizado é
 * Comparator<Pessoa>
 * 
 */
public class C06Aluno extends Pessoa {
	private int numero;
	private int nUCTerminadas;

	public C06Aluno(String name, int bi, int num, int nUCTerminadas) {
		super(name, bi);
		this.numero = num;
		this.nUCTerminadas = nUCTerminadas;
	}

	public String toString() {
		return super.toString() + " " + getBI() + " " + numero + " "
				+ nUCTerminadas;
	}

	public static void main(String[] args) {
		C06Aluno[] alunos = { new C06Aluno("José", 10008888, 10000, 5),
				new C06Aluno("Maria", 10002222, 20000, 3),
				new C06Aluno("Filipa", 10003333, 15000, 4) };

		System.out.println("Array at beginning -> " + Arrays.toString(alunos));

		// sort by natural order
		Arrays.sort(alunos);
		System.out.println("Array after sorting by natural order -> "
				+ Arrays.toString(alunos));

		// sort by BI
		// utilização do sort(T[] a, Comparator<? super T> c)
		// sort(C05Aluno[], Comparator<Pessoa>) - Pessoa is super of C05Aluno
		Arrays.sort(alunos, Pessoa.MyComparatorByBI.getComparator());
		System.out.println("Array after sorting by BI -> "
				+ Arrays.toString(alunos));
	}
}

class Pessoa implements Comparable<Pessoa> {
	private String name;
	private long bi;

	Pessoa(String name, long bi) {
		this.name = name;
		this.bi = bi;
	}

	public String getName() {
		return name;
	}

	public long getBI() {
		return bi;
	}

	public String toString() {
		return getName();
	}

	// implementa a odem natural de comparação
	public int compareTo(Pessoa p) {
		return name.compareTo(p.name);
	}

	// um comparador pelo bi
	public static class MyComparatorByBI implements Comparator<Pessoa> {
		// variável estática que contém o único comparador
		private static Comparator<Pessoa> COMPBYBI = new MyComparatorByBI();

		public int compare(Pessoa a1, Pessoa a2) {
			if (a1 == null || a2 == null)
				throw new NullPointerException();
			return (int) (a1.bi - a2.bi);
		}

		// método que devolve sempre a mesma instância do comparador
		public static Comparator<Pessoa> getComparator() {
			return COMPBYBI;
		}
	}

}

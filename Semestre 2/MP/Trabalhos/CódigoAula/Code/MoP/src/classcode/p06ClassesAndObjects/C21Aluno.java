package classcode.p06ClassesAndObjects;

/**
 * Classe Aluno com construtor
 */
public class C21Aluno {
	// nome do aluno
	String nome;

	// n�mero do aluno
	int numero;

	/**
	 * m�todo construtor, m�todo que inicializa uma nova inst�ncia de aluno
	 */
	public C21Aluno(String nome, int numero) {
		this.nome = nome;
		// nome = this.nome;
		this.numero = numero;
	}

	/**
	 * M�todo toString, m�todo que a plataforma java quando necessita de
	 * "converter" o objecto para String. Deve devolver uma descri��o textual do
	 * objecto
	 */

	public String toString() {
		return nome + ", " + numero;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		C21Aluno a1 = new C21Aluno("Jo�o Almeida", 75678);
		System.out.println(a1);

		C21Aluno a2 = new C21Aluno("Ana Martins", 75070);
		System.out.println(a2);
	}
}

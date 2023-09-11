package classcode.p06ClassesAndObjects;

/**
 * Class b�sica Aluno
 */
public class C20Aluno {
	// nome do aluno
	String nome;

	// n�mero do aluno
	int numero;

	/**
	 * M�todo toString, m�todo que a plataforma java quando necessita de
	 * "converter" o objecto para String. Deve devolver uma descri��o textual do
	 * objecto
	 */
	public String toString() {
		return nome + ", " + numero;
	}

	/**
	 * M�todo que permite alterar ou afectar os atributos do aluno
	 */
	public void setData(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// criar um objecto Aluno, colocar nele os seus dados e mostr�-lo na
		// consola
		C20Aluno a1 = new C20Aluno();
		a1.nome = "Jo�o Almeida";
		a1.numero = 75678;
		System.out.println(a1);

		// outro aluno
		C20Aluno a2 = new C20Aluno();
		a2.setData("Ana Martins", 75070);
		System.out.println(a2);
	}
}

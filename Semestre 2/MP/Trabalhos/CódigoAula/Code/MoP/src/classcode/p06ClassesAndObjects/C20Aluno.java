package classcode.p06ClassesAndObjects;

/**
 * Class básica Aluno
 */
public class C20Aluno {
	// nome do aluno
	String nome;

	// número do aluno
	int numero;

	/**
	 * Método toString, método que a plataforma java quando necessita de
	 * "converter" o objecto para String. Deve devolver uma descrição textual do
	 * objecto
	 */
	public String toString() {
		return nome + ", " + numero;
	}

	/**
	 * Método que permite alterar ou afectar os atributos do aluno
	 */
	public void setData(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// criar um objecto Aluno, colocar nele os seus dados e mostrá-lo na
		// consola
		C20Aluno a1 = new C20Aluno();
		a1.nome = "João Almeida";
		a1.numero = 75678;
		System.out.println(a1);

		// outro aluno
		C20Aluno a2 = new C20Aluno();
		a2.setData("Ana Martins", 75070);
		System.out.println(a2);
	}
}

package classcode.p07Inheritance;

public class Animal {
	String nome;

	public Animal(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}

	public static void main(String[] args) {
		Animal[] animais = new Animal[100];

		animais[0] = new Gato("Tareco");
		animais[1] = new Cao("Tobias");
		animais[2] = new Gato("Mareco");

		// imprimir todos os animais
		for (int i = 0; i < animais.length; i++) {
			if (animais[i] != null) {
				System.out.println(animais[i]);
			}
		}
		System.out.println();

		// imprimir s� os gatos
		for (int i = 0; i < animais.length; i++) {
			if (animais[i] != null && animais[i] instanceof Gato)
				System.out.println(animais[i]);
		}

		// alguns gatos v�o soltar bolas de p�lo
		for (int i = 0; i < animais.length; i++) {
			if (animais[i] != null && animais[i] instanceof Gato) {
				// cast para converter a refer�ncia para Animal em refer�ncia
				// para Gato
				Gato gato = (Gato) animais[i];
				// alguns gatos soltam bolas de p�lo
				if (Math.random() < 0.5)
					gato.soltarBolaDePelo();
			}
		}

	}

}

/**
 * classe Gato
 */
class Gato extends Animal {

	public Gato(String nome) {
		super(nome);
	}

	public void soltarBolaDePelo() {
		System.out.println(nome + " pop hairball...");
	}

}

/**
 * classe Cao
 */
class Cao extends Animal {

	public Cao(String nome) {
		super(nome);
	}

	// public void soltarBolaDePelo() {
	// System.out.println(nome + " pop hairball...");
	// }

}

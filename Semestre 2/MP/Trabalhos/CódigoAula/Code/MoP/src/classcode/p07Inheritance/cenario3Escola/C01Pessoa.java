package classcode.p07Inheritance.cenario3Escola;

/**
 * Classe Pessoa - classe base para Aluno e Docente
 * 
 */
public class C01Pessoa {

	private String nome;
	private int id;

	/*
	 * 
	 */
	public C01Pessoa(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getFuncao() {
		return "função não definida";
	}

	public String toString() {
		return getNome() + ", nº " + getId() + ", " + getFuncao();
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		C01Pessoa p1 = new C01Pessoa("Marco Fernandes", 1);
		System.out.println("p1 -> " + p1);

	}

}

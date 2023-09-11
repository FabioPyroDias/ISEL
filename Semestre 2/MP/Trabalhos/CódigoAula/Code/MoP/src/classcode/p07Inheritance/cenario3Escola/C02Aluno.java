package classcode.p07Inheritance.cenario3Escola;

/**
 * Classe derivada de Aluno
 */
public class C02Aluno extends C01Pessoa {

	private String nomeDaLicenciatura;

	/**
	 * 
	 */
	public C02Aluno(String nome, int id, String nomeDaLicenciatura) {
		super(nome, id);
		this.nomeDaLicenciatura = nomeDaLicenciatura;
	}

	/**
	 * 
	 */
	public String getNomeDaLicenciatura() {
		return nomeDaLicenciatura;
	}

	/**
	 * 
	 */
	public void setNomeDaLicenciatura(String nomeDaLicenciatura) {
		this.nomeDaLicenciatura = nomeDaLicenciatura;
	}

	/**
	 * 
	 */
	public String getFuncao() {
		return "aluno";
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		C02Aluno a1 = new C02Aluno("Amilcar Fernandes", 2,
				"Engenharia Física Tecnológica");
		System.out.println("a1 -> " + a1);

	}

}

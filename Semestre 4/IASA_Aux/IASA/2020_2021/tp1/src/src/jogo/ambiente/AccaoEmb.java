package jogo.ambiente;

public enum AccaoEmb implements reacao.Accao {
	PATRULHAR,
	APROXIMAR,
	AVISAR,
	DEFENDER,
	ATACAR,
	PROCURAR,
	INICIAR;

	@Override
	public void executar() {
		System.out.println("Accão: " + this);
		
	}
}

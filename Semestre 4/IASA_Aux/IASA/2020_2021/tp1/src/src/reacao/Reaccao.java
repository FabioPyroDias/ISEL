package reacao;

public class Reaccao implements Comportamento{
	private Estimulo estimulo;
	private Accao resposta;
	
	public Reaccao(Estimulo estimulo, Accao resposta){
		this.estimulo = estimulo;
		this.resposta = resposta;
	}
	
	public Accao ativar(Estimulo estimuloEntrada) {
		//this.estimulo == estimulo ? acao:null 
		if(this.estimulo.equals(estimuloEntrada)) { //TODO: Override equals
			return resposta;
		}
		return null;
	}
}

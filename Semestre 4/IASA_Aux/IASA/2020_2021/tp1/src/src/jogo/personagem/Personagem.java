package jogo.personagem;

import reacao.Accao;
import reacao.Estimulo;


import jogo.ambiente.Ambiente;
import jogo.personagem.comport.ComportPersonagem;

public class Personagem {
	private Ambiente ambiente;
	private ComportPersonagem comport;
	public Personagem(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.comport = new ComportPersonagem();
	}
	public void executar() {
		Estimulo estimulo = this.percepcionar();
		Accao accao = this.processar(estimulo);
		this.atuar(accao);
		this.mostrar();
		
	}
	
	private Estimulo percepcionar() { // TODO
		return ambiente.getEvento(); //Pedir ao ambiente para me dar um evento (AKA Estimulo)
	}
	
	private Accao processar(Estimulo estimulo) {
		Accao resposta = comport.ativar(estimulo);
		return resposta;
	}


	private void atuar(Accao resposta) {
		//Executar uma ação
		if(resposta != null) resposta.executar();	
	}
	

	private void mostrar() {
		System.out.println("Estado:" + this.comport.getEstado());

	} 
	


}

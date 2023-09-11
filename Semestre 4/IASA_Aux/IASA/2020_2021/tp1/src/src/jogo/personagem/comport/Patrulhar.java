package jogo.personagem.comport;

import jogo.ambiente.AccaoEmb;
import jogo.ambiente.EventoAmb;
import reacao.Comportamento;
import reacao.Reaccao;

public class Patrulhar extends reacao.ComportHierarq{

	public Patrulhar() {
		//Adicionar os comportamentos na classe
		super(new Comportamento[]{ 
			new Reaccao(EventoAmb.RUIDO, AccaoEmb.APROXIMAR),
			new Reaccao(EventoAmb.SILENCIO, AccaoEmb.PATRULHAR),
			}
		);
		
	}
	
	public Patrulhar(Comportamento[] comportamentos) {
		super(comportamentos);
	}

}

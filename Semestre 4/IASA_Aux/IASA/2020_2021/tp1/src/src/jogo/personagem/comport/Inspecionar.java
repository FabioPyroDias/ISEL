package jogo.personagem.comport;

import jogo.ambiente.AccaoEmb;
import jogo.ambiente.EventoAmb;
import reacao.Comportamento;
import reacao.Reaccao;

public class Inspecionar extends reacao.ComportHierarq{

	public Inspecionar() {
		super(new Comportamento[]{
				new Reaccao(EventoAmb.RUIDO, AccaoEmb.PROCURAR),
				new Reaccao(EventoAmb.INIMIGO, AccaoEmb.APROXIMAR),
		});
	}

}

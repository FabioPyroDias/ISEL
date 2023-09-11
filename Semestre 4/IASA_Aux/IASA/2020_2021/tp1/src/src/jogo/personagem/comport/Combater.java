package jogo.personagem.comport;

import jogo.ambiente.AccaoEmb;
import jogo.ambiente.EventoAmb;
import reacao.ComportHierarq;
import reacao.Comportamento;
import reacao.Reaccao;

public class Combater extends ComportHierarq {

	public Combater() {
		super(new Comportamento[]{
				new Reaccao(EventoAmb.DERROTA, AccaoEmb.INICIAR),
				new Reaccao(EventoAmb.INIMIGO, AccaoEmb.ATACAR),
		});
	}

}

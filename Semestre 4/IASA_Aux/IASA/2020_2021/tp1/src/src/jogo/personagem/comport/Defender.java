package jogo.personagem.comport;

import jogo.ambiente.AccaoEmb;
import jogo.ambiente.EventoAmb;
import reacao.ComportHierarq;
import reacao.Comportamento;
import reacao.Reaccao;

public class Defender extends ComportHierarq {

	public Defender() {
		super(new Comportamento[] {
				new Reaccao(EventoAmb.INIMIGO, AccaoEmb.DEFENDER),
		});
	}

}

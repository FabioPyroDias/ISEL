package jogo.personagem.comport;
import reacao.*;
import jogo.ambiente.EventoAmb;
import maqest.*;
public class ComportPersonagem extends ComportMaqEst{
	protected MaquinaEstados<Estimulo> iniciar() {
		Estado<Estimulo> patrulha = new Estado<Estimulo>("Patrulha");
		Estado<Estimulo> inspecao = new Estado<>("Inspecao");
		Estado<Estimulo> defesa = new Estado<>("Defesa");
		Estado<Estimulo> combate = new Estado<>("Combate");
	
		patrulha.transicao(EventoAmb.RUIDO,  inspecao) //Retnora-e a si mesmo, então é possivel "encadiar" à la jQuery
			.transicao(EventoAmb.SILENCIO, patrulha);
		
		inspecao.transicao(EventoAmb.SILENCIO, patrulha)
			.transicao(EventoAmb.RUIDO, inspecao)
			.transicao(EventoAmb.INIMIGO, defesa);
		
		defesa.transicao(EventoAmb.INIMIGO, combate)
			.transicao(EventoAmb.FUGA, inspecao);
		
		combate.transicao(EventoAmb.FUGA, patrulha)
			.transicao(EventoAmb.VITORIA, patrulha)
			.transicao(EventoAmb.DERROTA, patrulha);
		
		//TODO: Porque é que estes comportamentos não são adicionados por aqui?
		/*Comportamento[] comport_patrulha = { 
				new Reaccao(EventoAmb.RUIDO, AccaoEmb.APROXIMAR),
				new Reaccao(EventoAmb.SILENCIO, AccaoEmb.PATRULHAR),
		};
		this.comport(patrulha, new Patrulhar(comport_patrulha));*/
		

		
		this.comport(patrulha, new Patrulhar());
		this.comport(inspecao, new Inspecionar());
		this.comport(defesa, new Defender());
		this.comport(combate, new Combater());
		
		return new MaquinaEstados<Estimulo>(patrulha);
	}
}

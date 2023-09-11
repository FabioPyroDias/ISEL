package maqest;

import java.util.HashMap;
import java.util.Map;

public class Estado<EV> {	
	private String nome;
	private Map<EV, Estado<EV>> transicoes; //hashmaps
	
	public Estado(String nome) {
		transicoes = new HashMap<EV, Estado<EV>>();
		this.nome = nome;
	}

	public Estado<EV> transicao(EV evento, Estado<EV> estado){
		transicoes.put(evento, estado);
		return this;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public Estado<EV> processar(EV evento){
		return transicoes.get(evento);
		
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}

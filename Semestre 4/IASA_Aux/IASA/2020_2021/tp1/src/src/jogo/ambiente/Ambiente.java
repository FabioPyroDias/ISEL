package jogo.ambiente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ambiente {
	private EventoAmb evento = null;
	Map<String,EventoAmb> mapaEventos = new HashMap<String,EventoAmb>();
	private Scanner input = new Scanner(System.in);

	public Ambiente() {
		//Mapear teclas para eventos com um Map, para ser mais "direto" identificar os eventos
		mapaEventos.put("v",EventoAmb.VITORIA);
		mapaEventos.put("s",EventoAmb.SILENCIO);
		mapaEventos.put("i",EventoAmb.INIMIGO);
		mapaEventos.put("r",EventoAmb.RUIDO);
		mapaEventos.put("d",EventoAmb.DERROTA);
		mapaEventos.put("t",EventoAmb.TERMINAR);
		mapaEventos.put("f",EventoAmb.FUGA);
	}
	
	public void evoluir() {
		this.gerarEvento(); //Já faz update ao evento
		this.mostrar();
	}
	
	public EventoAmb getEvento() {
		return evento;
	}	
	
	
	private EventoAmb gerarEvento() {
		System.out.println("\nGerar Evento:");
		String eventoInput = this.input.next();	
		
		//Obter evento pelo hashmap
		this.evento = mapaEventos.get(eventoInput);
		return evento;
	
	};
	private void mostrar() {
		if(this.evento != null) {
			System.out.println("Evento: " + this.evento);
		}
	}	
}

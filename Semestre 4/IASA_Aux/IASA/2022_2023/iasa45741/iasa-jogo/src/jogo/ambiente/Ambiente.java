package jogo.ambiente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ambiente {
    private Evento evento;
    private Map<String, Evento> eventos;
    private Scanner sc;

    public Ambiente() {
        // Mapear teclas para eventos com um Map, para ser mais "direto" identificar os
        // Gerar os eventos para o autómato reagir. Conhecemos o ambiente todo, portanto
        // é determinístico e discreto

        sc = new Scanner(System.in);
        eventos = new HashMap<String, Evento>();
        eventos.put("s", Evento.SILENCIO);
        eventos.put("r", Evento.RUIDO);
        eventos.put("a", Evento.ANIMAL);
        eventos.put("f", Evento.FUGA);
        eventos.put("o", Evento.FOTOGRAFIA);
        eventos.put("t", Evento.TERMINAR);
    }

    public Evento getEvento() {
        return evento;
    }

    public void evoluir() {
        evento = gerarEvento();
        mostrar();
    }

    private Evento gerarEvento() {
        System.out.println("\nGerar Evento:");
        String comando = sc.next();
        return eventos.get(comando);
    }

    public void mostrar() {
        System.out.println("Evento: " + getEvento());
    }
}

package jogo;

import jogo.ambiente.Ambiente;
import jogo.ambiente.Evento;
import jogo.personagem.Personagem;

public class Jogo {

    private static Ambiente ambiente = new Ambiente();
    private static Personagem personagem = new Personagem(ambiente);

    public static void main(String[] args) {
        executar();
    }

    private static void executar() {
        do {
            personagem.executar();
            ambiente.evoluir();

        } while (ambiente.getEvento() != Evento.TERMINAR);
    }
}

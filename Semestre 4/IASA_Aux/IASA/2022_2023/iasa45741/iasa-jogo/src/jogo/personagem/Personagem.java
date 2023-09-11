package jogo.personagem;

import jogo.ambiente.Ambiente;
import jogo.ambiente.Evento;

public class Personagem {
    private Ambiente ambiente;
    private Controlo controlo;

    public Personagem(Ambiente ambiente) {
        this.controlo = new Controlo();
        this.ambiente = ambiente;
    }

    // Ao executar este método, o personagem vai ler o último evento do ambiente e
    // vai reagir a esse evento
    public void executar() {
        Percepcao percepcao = percepcionar(); // Ler o ambiente (percecionar o que aconteceu)
        Accao accao = controlo.processar(percepcao); // Atuar sobre essa "percepção"
        atuar(accao); // TLDR: É só um println
    }

    private void atuar(Accao accao) {
        if (accao != null) {
            System.out.println("Acção: " + accao);
        }
    }

    private Percepcao percepcionar() {
        Evento evento = ambiente.getEvento();
        return new Percepcao(evento);
    }
}

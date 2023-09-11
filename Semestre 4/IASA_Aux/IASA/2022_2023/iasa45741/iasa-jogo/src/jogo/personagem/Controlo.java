package jogo.personagem;

import jogo.ambiente.Evento;
import maqest.Estado;
import maqest.MaquinaEstados;

public class Controlo {
    private MaquinaEstados<Evento, Accao> maqEst;

    public Controlo() {

        // Criar os vários estados do autómato. Para cada estado temos sempre a mesma
        // transição, estado e ação.
        Estado<Evento, Accao> procura = new Estado<>("Procura");
        Estado<Evento, Accao> inspecao = new Estado<>("Inspecao");
        Estado<Evento, Accao> observacao = new Estado<>("Observacao");
        Estado<Evento, Accao> registo = new Estado<>("Registo");

        // Definir transições para cada estado acima definido
        procura.transicao(Evento.ANIMAL, observacao, Accao.APROXIMAR) // Evento, estado seguinte, acção
                .transicao(Evento.RUIDO, inspecao, Accao.APROXIMAR)
                .transicao(Evento.SILENCIO, procura, Accao.PROCURAR);

        inspecao.transicao(Evento.ANIMAL, observacao, Accao.APROXIMAR)
                .transicao(Evento.RUIDO, inspecao, Accao.PROCURAR)
                .transicao(Evento.SILENCIO, procura);

        observacao.transicao(Evento.ANIMAL, registo, Accao.OBSERVAR)
                .transicao(Evento.FUGA, inspecao);

        registo.transicao(Evento.FUGA, procura)
                .transicao(Evento.FOTOGRAFIA, procura)
                .transicao(Evento.ANIMAL, registo, Accao.FOTOGRAFAR);

        maqEst = new MaquinaEstados<>(procura); // Estado inical do autómato

    }

    public Estado<Evento, Accao> getEstado() {
        return maqEst.getEstado();
    }

    public Accao processar(Percepcao percepcao) {
        // Ao processar vai mudar para outro estado, e ativar uma ação do personagem e
        // mudar para o novo estado
        Accao accao = maqEst.processar(percepcao.getEvento());
        mostrar(); // É só println
        return accao; // return da ação para dps fazer o println na personagem
    };

    private void mostrar() {
        System.out.printf("Estado: %s \n", getEstado().getNome());
    }
}

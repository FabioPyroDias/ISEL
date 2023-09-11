package maqest;

import java.util.HashMap;
import java.util.Map;

public class Estado<EV, AC> {
    private String nome;
    private Map<EV, Transicao<EV, AC>> transicoes;

    public Estado(String nome) {
        this.nome = nome;
        transicoes = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public Transicao<EV, AC> processar(EV evento) {
        return transicoes.get(evento);

    }

    public Estado<EV, AC> transicao(EV evento, Estado<EV, AC> estadoSucessor) {
        return transicao(evento, estadoSucessor, null);

    }

    // Criar um novo estado para dps ser utilizado na máquina de estados
    public Estado<EV, AC> transicao(EV evento, Estado<EV, AC> estadoSucessor, AC accao) {
        transicoes.put(evento, new Transicao<>(estadoSucessor, accao));
        return this;
    }

}
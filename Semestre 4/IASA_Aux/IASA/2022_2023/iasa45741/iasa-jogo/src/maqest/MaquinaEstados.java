package maqest;

public class MaquinaEstados<EV, AC> {
    private Estado<EV, AC> estado;

    public MaquinaEstados(Estado<EV, AC> estado) {
        this.estado = estado;
    }

    public Estado<EV, AC> getEstado() {
        return estado;
    }

    // Transformar estados em ações, ou seja, atuar com a informação que temos do
    // estado
    public AC processar(EV evento) {
        Transicao<EV, AC> transicao = estado.processar(evento);
        if (transicao != null) {
            /*
             * estado após ter reagido ao evento, para depois ser usada nos eventos
             * seguintes
             */
            estado = transicao.getEstadoSucessor();
            return transicao.getAccao(); // ação indica o que a maquina tem de fazer para reagir ao evento
        }
        return null;
    }
}
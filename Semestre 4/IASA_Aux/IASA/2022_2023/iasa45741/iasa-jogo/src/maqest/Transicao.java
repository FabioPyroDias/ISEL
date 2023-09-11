package maqest;

// Função de saida e/ou transição, que é passada na altura da configuração
public class Transicao<EV, AC> {
    private AC accao;
    private Estado<EV, AC> estadoSucessor;

    public Transicao(Estado<EV, AC> estadoSucessor, AC accao) {
        this.accao = accao;
        this.estadoSucessor = estadoSucessor;
    }

    public Estado<EV, AC> getEstadoSucessor() {
        return estadoSucessor;
    }

    public AC getAccao() {
        return accao;
    }

}

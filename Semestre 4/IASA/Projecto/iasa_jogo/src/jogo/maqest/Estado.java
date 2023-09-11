import java.util.HashMap;
import java.util.Map;

public class Estado<EV, AC> {
    
    /**
     * O nome será o nome do Estado que pode ser um de quatro:
     * Procura, Inspecção, Observação e Registo
     */
    private String nome;

    /**
     * Este Estado possui Transições específicas e determinadas.
     * Ou seja, cada Estado, dependendo do Evento que recebe, devolve uma Transição que possui
     * o Estado Seguinte e uma Acção (caso tenha).
     */
    private Map<EV, Transicao<EV, AC>> transicoes;

    /**
     * Afecta o nome do Estado e inicializa o Map (Dicionário)
     * @param nome O nome do Estado
     */
    public Estado(String nome)
    {
        this.nome = nome;
        transicoes = new HashMap<>();
    }

    /**
     * @return O nome do Estado
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * Um determinado Evento juntamente com um Estado específico tem uma determinada Transição.
     * Ou seja, dependendo do Evento recebido, este método devolve essa Transição.
     * @param evento O evento cuja Transição está associada.
     * @return A Transição, caso exista, ou null.
     */
    public Transicao<EV, AC> processar(EV evento)
    {
        return transicoes.get(evento);
    }

    /**
     * Este método guarda a Transição, associando-a a um Evento
     * @param evento O Evento associado à Transição.
     * @param estadoSucessor O Estado Seguinte que será guardado na Transição
     * @return O mesmo Estado atualizado com a Transição
     */
    public Estado<EV, AC> transicao(EV evento, Estado<EV, AC> estadoSucessor)
    {
        transicao(evento, estadoSucessor, null);

        return this;
    }

    /**
     * Este método guarda a Transição, associando-a a um Evento
     * @param evento O Evento associado à Transição.
     * @param estadoSucessor O Estado Seguinte que será guardado na Transição
     * @param accao A Accao que será guardada na Transição.
     * @return O mesmo Estado atualizado com a Transição
     */
    public Estado<EV, AC> transicao(EV evento, Estado<EV, AC> estadoSucessor, AC accao)
    {
        transicoes.put(evento, new Transicao<EV, AC>(estadoSucessor, accao));

        return this;
    }
}

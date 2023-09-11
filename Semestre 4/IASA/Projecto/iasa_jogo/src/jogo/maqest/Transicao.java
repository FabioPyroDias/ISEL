public class Transicao<EV, AC> {
    
    /**
     * Pensar neste Estado como o Estado Seguinte.
     */
    private Estado<EV, AC> estadoSucessor;

    /**
     * Cada Transição pode possuir uma Accao mas nem todas o têm.
     */
    private AC accao;

    /**
     * @param estadoSucessor O Estado Seguinte
     * @param accao A Accao que a Transição pode conter.
     */
    public Transicao(Estado<EV, AC> estadoSucessor, AC accao)
    {
        this.estadoSucessor = estadoSucessor;
        this.accao = accao;
    }

    /**
     * @return O Estado Seguinte
     */
    public Estado<EV, AC> getEstadoSucessor()
    {
        return estadoSucessor;
    }

    /**
     * @return A Acção associada à Transição. Pode ser null.
     */
    public AC getAccao()
    {
        return accao;
    }
}

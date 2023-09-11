/**
 * Esta Máquina de Estados Mealy, dado que a função de saída depende das entradas.
 */
public class MaquinaEstados<EV, AC> {
    
    /**
     * Considerado o Estado Actual da Máquina
     */
    private Estado<EV, AC> estado;

    /**
     * @param estado Define o Estado Actual da Máquina
     */
    public MaquinaEstados(Estado<EV, AC> estado)
    {
        this.estado = estado;
    }

    /**
     * @return Retorna o Estado Actual
     */
    public Estado<EV, AC> getEstado()
    {
        return estado;
    }

    /**
     * Este método procura saber se, dado um Evento, o Estado tem uma Transição pré-definida.
     * Caso tenha, a Acção dessa Transição é devolvida e o Estado Actual é actualizado para o Estado Sucessor.
     * Caso não tenha, mantém-se no mesmo Estado.
     * @param evento O Evento que pode possuir uma Transição válida.
     * @return A Accao associada à Transição, caso exista. Null se não existir.
     */
    public AC processar(EV evento)
    {
        Transicao<EV, AC> transicao = estado.processar(evento);

        if(transicao != null)
        {
            estado = transicao.getEstadoSucessor();

            return transicao.getAccao();
        }
        else
        {
            return null;
        }
    }
}
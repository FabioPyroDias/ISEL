public class Controlo {

    /**
     * Possui as combinações possiveis de Estados e Eventos
     */
    private MaquinaEstados<Evento, Accao> maqEst;

    /**
     * A Accao que a Personagem vai efectuar.
     */
    private Accao accao;

    /**
     * Aqui são definidos os Estados Possíveis e as possíveis Transições de cada Estado.
     */
    public Controlo()
    {
        //Definir Estados
        Estado<Evento, Accao> procura = new Estado<>("Procura");
        Estado<Evento, Accao> inspeccao = new Estado<>("Inspecção");
        Estado<Evento, Accao> observacao = new Estado<>("Observação");
        Estado<Evento, Accao> registo = new Estado<>("Registo");

        //Definir transições
        procura
            .transicao(Evento.ANIMAL, observacao, Accao.APROXIMAR)
            .transicao(Evento.RUIDO, inspeccao, Accao.APROXIMAR)
            .transicao(Evento.SILENCIO, procura, Accao.PROCURAR);

        inspeccao
            .transicao(Evento.ANIMAL, observacao, Accao.APROXIMAR)
            .transicao(Evento.RUIDO, inspeccao, Accao.PROCURAR)
            .transicao(Evento.SILENCIO, procura);

        observacao
            .transicao(Evento.FUGA, inspeccao)
            .transicao(Evento.ANIMAL, registo, Accao.OBSERVAR);

        registo
            .transicao(Evento.ANIMAL, registo, Accao.FOTOGRAFAR)
            .transicao(Evento.FUGA, procura)
            .transicao(Evento.FOTOGRAFIA, procura);

        maqEst = new MaquinaEstados<Evento, Accao>(procura);
    }

    /**
     * @return O Estado Actual
     */
    public Estado<Evento, Accao> getEstado()
    {
        return maqEst.getEstado();
    }

    /**
     * Com base no Evento que aconteceu no Ambiente, a MáquinaEstados vai evoluir o Sistema.
     * @param percepcao A Percepção do Agente Inteligente
     * @return A Acção do Agente Inteligente
     */
    public Accao processar(Percepcao percepcao) {

        accao = maqEst.processar(percepcao.getEvento());

        mostrar();

        return accao;
    }

    /**
     * Este método mostrará o Estado Actual do Sistema, já actualizado.
     */
    private void mostrar()
    {
        System.out.println("O Sistema encontra-se no Estado: " + maqEst.getEstado().getNome());
    }
}

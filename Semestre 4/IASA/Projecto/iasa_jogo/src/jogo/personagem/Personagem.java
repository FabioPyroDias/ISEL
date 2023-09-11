public class Personagem {

    /**
     * Referência ao Ambiente
     */
    private Ambiente ambiente;

    /**
     * Referência ao Controlo.
     * Este será usado para o segundo passo do ciclo percepção-processamento-acção. 
     */
    private Controlo controlo;

    /**
     * Construtor da classe, recebe um ambiente previamente criado.
     * Isto é necessário pois o agente vai agir perante este ambiente.
     * Inicializa o Controlo.
     * 
     * @param ambiente
     */
    public Personagem(Ambiente ambiente) {
        this.ambiente = ambiente;

        controlo = new Controlo();
        //controlo.processar(percepcionar());
    }

    /**
     * Passa as Percepcoes para o Controlo,
     * Recebe uma Accao e envia-a directamente ao método actuar.
     * Esta será a organização interna do agente inteligente.
     */
    public void executar() {
        actuar(controlo.processar(percepcionar()));
    }

    /**
     * Obtém as Percepções a partir dos seus sensores.
     * É com base nesta que o processamento será efectuado.
     * @return A Percepção efectuado
     */
    private Percepcao percepcionar() {

        Evento evento = ambiente.getEvento();
        Percepcao percepcao = new Percepcao(evento);

        return percepcao;
    }

    /**
     * Com base no processamento feito, o agente vai actuar.
     * Isto será a saída do Sistema.
     * 
     * @param accao A acção que o agente inteligente vai efectuar
     */
    private void actuar(Accao accao) {

        if(accao == null)
        {
            System.out.println("A Personagem não executou nenhuma acção");
            return;
        }

        System.out.println("A personagem executou a acção: " + accao);
    }
}
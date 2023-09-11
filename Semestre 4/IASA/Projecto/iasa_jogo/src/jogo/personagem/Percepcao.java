public class Percepcao {

    /**
     * A Percepção do nosso agente inteligente é o Evento que aconteceu no Ambiente em que este
     * se encontra.
     */
    private Evento evento;

    /**
     * Guarda o Evento.
     * @param evento O evento que aconteceu no ambiente.
     */
    public Percepcao(Evento evento) {
        this.evento = evento;
    }

    /**
     * 
     * @return O Evento que aconteceu no ambiente
     */
    public Evento getEvento() {
        return evento;
    }

}
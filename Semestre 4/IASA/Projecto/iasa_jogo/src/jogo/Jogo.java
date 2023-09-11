public class Jogo {
    /**
     * Referência da Personagem, este é o nosso agente inteligente.
     */
    private static Personagem personagem;

    /**
     * Referência da Ambiente, este será o elemento de suporte do processamento interno do agente.
     * Este Ambiente é a representação do jogador.
     */
    private static Ambiente ambiente;

    /**
     * Inicializar as variáveis e chamar o método executar
     * 
     * @param args
     */
    public static void main(String[] args) {
        ambiente = new Ambiente();
        personagem = new Personagem(ambiente);

        executar();
    }

    /**
     * Loop principal do jogo.
     * O agente inteligente reage à evolução do ambiente e o jogador decide que Evento lançar.
     */
    private static void executar() {
        while(ambiente.getEvento() != Evento.TERMINAR)
        {
            personagem.executar();
            ambiente.evoluir();
        }
    }
}
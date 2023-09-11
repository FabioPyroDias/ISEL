import java.util.Scanner;

public class Ambiente
{
    private Evento evento;
    private Evento[] eventos;

    /**
     * Será o ponto de entrada do Ambiente.
     * Temos o número total, finito, de Eventos possíveis para este Ambiente.
     * Definimos o primeiro Evento como Silêncio.
     */
    public Ambiente()
    {
        eventos = new Evento[]
        {
            Evento.SILENCIO,
            Evento.RUIDO,
            Evento.ANIMAL,
            Evento.FUGA,
            Evento.FOTOGRAFIA,
            Evento.TERMINAR
        };

        evento = eventos[0];
    }

    public Evento getEvento()
    {
        return evento;
    }

    /**
     * O Ambiente será estocástico dado que somos nós que controlamos os Eventos.
     * É pedido para o jogador decidir o Evento 
     */
    public void evoluir()
    {
        gerarEvento();
        mostrar();
    }

    private void gerarEvento()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccionar a opção \n"
        + "0 : Silêncio \n"
        + "1 : Ruído \n"
        + "2 : Animal \n"
        + "3 : Fuga \n"
        + "4 : Fotografia \n"
        + "5 : Terminar");

        boolean opcaoValida = false;
        
        while (!opcaoValida) {
  
            boolean isValid = false;
            int opcao = 0;

            try
            {
                opcao = Integer.parseInt(scanner.nextLine());
                isValid = true;
            }
            catch(Exception e)
            {
                System.out.println("Resposta recebida inválida");
            }

            if(isValid)
            {
                if(opcao < 0 || opcao > 5)
                {
                    System.out.println("Opção Inválida");
                }
                else
                {
                    evento = eventos[opcao];
                    opcaoValida = true;
                }
            }
        }
    }

    //Ainda não percebi bem se vai ser void ou não. Acredito que deve ser uma
    //string que detalha o que está acontecer, tendo em conta o evento em que se encontra.
    private void mostrar()
    {
        System.out.println("O Evento decidido foi: " + evento);
    }
}
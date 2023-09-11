import java.util.Scanner;

public class ServidorTeste {

	private static CanalComunicacaoConsistente canalDeComunicacaoVaguear;
	
	public ServidorTeste()
	{
		canalDeComunicacaoVaguear = new CanalComunicacaoConsistente();
	}
	
	public static void main(String[] args) {
		ServidorTeste testServer = new ServidorTeste();
		
		testServer.run();
	}
	
	private void run()
	{
		Scanner scanner = new Scanner(System.in);
		
		canalDeComunicacaoVaguear.abrirCanal("CanalDeComunicacaoVaguear", false);
		
		while(true)
		{
			scanner.next();
			
			Mensagem mensagem = canalDeComunicacaoVaguear.GetAndSetServidor();
			
			if(mensagem != null)
			{
				if(mensagem.getTipo() != Mensagem.VAZIO)
				{
					mensagem.printMensagem();
					System.out.println();
				}
			}
		}
	}
}
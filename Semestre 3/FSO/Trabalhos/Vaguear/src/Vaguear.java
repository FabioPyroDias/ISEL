public class Vaguear {
	
	private static GUI_Vaguear gui;
	private static CanalComunicacaoConsistente canalDeComunicacaoVaguear;
	
	private enum Atividades
	{
		Iniciar,
		GerarComando,
		EscreverMensagem,
		EsperarTempoComando,
		Dormir
	}
	
	private Atividades atividadeActual;
	
	private Mensagem mensagemAleatoria;
	
	public Vaguear()
	{
		gui = new GUI_Vaguear();
		canalDeComunicacaoVaguear = new CanalComunicacaoConsistente();
		atividadeActual = Atividades.Iniciar;		
	}
	
	public static void main(String[] args) {
		Vaguear vaguear = new Vaguear();
		
		vaguear.run();
	}
	
	private void run()
	{
		while(true)
		{
			switch(atividadeActual)
			{
				case Iniciar:

					if(!canalDeComunicacaoVaguear.abrirCanal("../Servidor/CanalDeComunicacaoVaguear", true))
					{
						System.out.println("Falhou a abrir o canal Evitar -> Servidor");
						System.out.println();
						break;
					}
					
					canalDeComunicacaoVaguear.DebugBuffer();
					atividadeActual = Atividades.GerarComando;
					
					gui.debugMode("Canal De Comunicação Vaguear aberto com sucesso");
					
					break;
				
				case GerarComando:
					
					mensagemAleatoria = GerarComandoAleatorio();
					
					atividadeActual = Atividades.EscreverMensagem;
					
					break;
					
				case EscreverMensagem:
					
					boolean enviou = canalDeComunicacaoVaguear.GetAndSetCliente(mensagemAleatoria); 
					
					if(enviou)
					{
						System.out.println();
						mensagemAleatoria.printMensagem();
						//EscreverNaConsola(mensagemAleatoria);
						canalDeComunicacaoVaguear.DebugBuffer();
						
						atividadeActual = Atividades.EsperarTempoComando;
						
						gui.debugMode("Mensagem Enviada: " + mensagemAleatoria.getInfo());
					}
					else
					{
						atividadeActual = Atividades.Dormir;
					}
					
					break;
					
				case EsperarTempoComando:
					
					EsperarTempoComando(mensagemAleatoria, 30);
					
					atividadeActual = Atividades.GerarComando;
					
					break;
					
				case Dormir:
					
					Dormir();
					
					atividadeActual = Atividades.GerarComando;
					
					break;
					
				default:
					
					throw new IllegalArgumentException("Estado não compreendido pelo Vaguear");
			}
		}
	}	
	
	private Mensagem GerarComandoAleatorio()
	{
		int tipo = GerarValores(Mensagem.RETA, Mensagem.PARAR);
		
		switch(tipo)
		{
			case Mensagem.RETA:
		
				int distancia = GerarValores(5, 50);
				//int distancia = GerarValores(5, 10);
					
				return new MensagemReta(0, Mensagem.RETA, distancia);
			
			case Mensagem.CURVAR_ESQUERDA:
			case Mensagem.CURVAR_DIREITA:
		
				int raio = GerarValores(0, 40);
				int angulo = GerarValores(20, 90);
				//int raio = GerarValores(0, 5);
				//int angulo = GerarValores(5, 10);
					
				return new MensagemCurvar(0, tipo, raio, angulo);
		
			case Mensagem.PARAR:

				int sincrono = GerarValores(0, 1);

				return new MensagemParar(0, tipo, sincrono);
		}
		
		return null;
	}
	
	private int GerarValores(int minimumValue, int maximumValue)
	{	
		return (int) ((Math.random() * (maximumValue - minimumValue)) + minimumValue);
	}
	
	private void EsperarTempoComando(Mensagem mensagem, int velocidadeRobot)
	{
		long tempo = 1000;
		
		switch(mensagem.getTipo())
		{
			case Mensagem.RETA:
				
				tempo = (long)(((MensagemReta) mensagem).getDistancia() / (float) velocidadeRobot * 1000f);
				
				break;
				
			case Mensagem.CURVAR_ESQUERDA:
			case Mensagem.CURVAR_DIREITA:
				
				tempo = (long) ((float) Math.toRadians(((MensagemCurvar) mensagem).getAngulo()) * (((MensagemCurvar) mensagem).getRaio()) / (float) velocidadeRobot * 1000f);
				
				break;
			
			case Mensagem.PARAR:
				
				tempo = 1;
				
				break;
		}
		
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println("Não foi posssível esperar");
		}
	}
	
	private void Dormir()
	{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Não foi posssível esperar");
		}
	}
	
	private void EscreverNaConsola(Mensagem mensagem)
	{
		String aImprimir = "";
		
		switch(mensagem.getTipo())
		{
			case Mensagem.RETA:
				
				aImprimir = "Tipo : Reta | Distancia : " + ((MensagemReta) mensagem).getDistancia();
				
				break;
				
			case Mensagem.CURVAR_ESQUERDA:
				
				aImprimir = "Tipo : Curvar Esquerda | Raio : " + ((MensagemCurvar) mensagem).getRaio() + " | Angulo : " + ((MensagemCurvar) mensagem).getAngulo();
				
				break;
				
			case Mensagem.CURVAR_DIREITA:
				
				aImprimir = "Tipo : Curvar Direita | Raio : " + ((MensagemCurvar) mensagem).getRaio() + " | Angulo : " + ((MensagemCurvar) mensagem).getAngulo();
				
				break;
				
			case Mensagem.PARAR:
	
				aImprimir = "Tipo : Parar | Sincrono : " + ((MensagemParar) mensagem).getSincrono();
				
				break;
		}
		
		gui.debugMode(aImprimir + "\r\n");
	}
}
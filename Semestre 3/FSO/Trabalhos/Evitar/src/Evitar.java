public class Evitar{
	
	private static GUI_Evitar gui;
	private static CanalComunicacaoConsistente canalDeComunicacaoEvitarParaServidor;
	private static CanalComunicacaoConsistente canalDeComunicacaoServidorParaEvitar;
	
	private enum Atividades
	{
		Iniciar,
		EnviarPrioridade,
		EnviarPedidoSensor,
		ReceberRespostaSensor,
		GerarComando,
		EscreverMensagem,
		EsperarTempoComando,
		EnviarFimPrioridade,
		Dormir
	}
	//TODO Quando recebo o toque, se for negativo, esperar 250 ms
	private Atividades atividadeActual;
	private Atividades atividadeAnterior;
	
	private Mensagem mensagemAleatoria;
	
	private boolean aEvitar;
	private int numeroComando;
	
	public Evitar()
	{
		gui = new GUI_Evitar();
		canalDeComunicacaoEvitarParaServidor = new CanalComunicacaoConsistente();
		canalDeComunicacaoServidorParaEvitar = new CanalComunicacaoConsistente();
		atividadeActual = Atividades.Iniciar;
		atividadeAnterior = atividadeActual;
		aEvitar = true;
		numeroComando = 0;
	}
	
	public static void main(String[] args) {
		Evitar evitar = new Evitar();
		
		evitar.run();
	}
	
	private void run()
	{
		while(true)
		{
			switch(atividadeActual)
			{
				case Iniciar:

					System.out.println("Iniciar");
					
					if(!canalDeComunicacaoEvitarParaServidor.abrirCanal("../Servidor/CanalDeComunicacaoEvitarParaServidor", true))
					{
						System.out.println("Falhou a abrir o canal Evitar -> Servidor");
						System.out.println();
						break;
					}
					else
					{
						gui.debugMode("Canal De Comunicação Evitar para Servidor aberto com sucesso");
					}
					
					if(!canalDeComunicacaoServidorParaEvitar.abrirCanal("../Servidor/CanalDeComunicacaoServidorParaEvitar", true))
					{
						System.out.println("Falhou a abrir o canal Servidor -> Evitar");
						System.out.println();
						break;
					}
					else
					{
						gui.debugMode("Canal De Comunicação Servidor para Evitar aberto com sucesso");
					}
					
					atividadeActual = Atividades.EnviarPrioridade;
					
					break;
				
				case EnviarPrioridade:

					//System.out.println("Enviar Prioridade");
					
					if(!enviarMensagem(Atividades.EnviarPrioridade, Atividades.EnviarPedidoSensor, new MensagemPrioridade(0, Mensagem.PRIORIDADE, 1)))
					{
						System.out.println("Falhou Enviar Mensagem");
						System.out.println();
						atividadeActual = Atividades.Dormir;
					}
					else
					{
						/*
						System.out.println();
						System.out.print("Mensagem Enviada: ");
						mensagemAleatoria.printMensagem();
						System.out.println("Buffer Atualmente: ");
						canalDeComunicacaoEvitarParaServidor.DebugBuffer();
						System.out.println();
						*/
						gui.debugMode("Mensagem Enviada: " + mensagemAleatoria.getInfo());
					}
					
					break;
					
				case EnviarPedidoSensor:
					
					//System.out.println("Enviar Pedido Sensor");
					
					if(!enviarMensagem(Atividades.EnviarPedidoSensor, Atividades.ReceberRespostaSensor, new MensagemPedidoToque(0, Mensagem.SENSOR_PEDIDO)))
					{
						//ALTERAR PORTO
						//System.out.println("Falhou Enviar Mensagem");
						//System.out.println();
						atividadeActual = Atividades.Dormir;
					}
					else
					{
						/*
						System.out.println();
						System.out.print("Mensagem Enviada: ");
						mensagemAleatoria.printMensagem();
						System.out.println("Buffer Atualmente: ");
						canalDeComunicacaoEvitarParaServidor.DebugBuffer();
						System.out.println();
						*/
						gui.debugMode("Mensagem Enviada: " + mensagemAleatoria.getInfo());
					}
					
					break;
					
				case ReceberRespostaSensor:
					
					System.out.println("Receber Resposta Sensor");
					
					atividadeAnterior = Atividades.ReceberRespostaSensor;
					
					mensagemAleatoria = canalDeComunicacaoServidorParaEvitar.GetAndSetServidor();
					
					if(mensagemAleatoria != null)
					{
						System.out.println("Mensagem Recebida:");
						mensagemAleatoria.printMensagem();
						
						if(mensagemAleatoria.getTipo() == Mensagem.SENSOR_RESPOSTA)
						{
							System.out.println("A mensagem é Sensor Resposta: ");
							if(((MensagemRespostaToque)mensagemAleatoria).getResposta() == 1)
							{
								atividadeActual = Atividades.GerarComando;
								
								aEvitar = true;
								System.out.println("O robot está a bater");
								System.out.println();
								break;
							}
							else
							{
								System.out.println("O robot não está a bater");
								System.out.println();
								atividadeActual = Atividades.EnviarFimPrioridade;
							}
							
							gui.debugMode("Mensagem Enviada: " + mensagemAleatoria.getInfo());
						}
						else
						{
							System.out.println("A Mensagem não é do Tipo Sensor Resposta");
							System.out.println();
							atividadeActual = Atividades.Dormir;		
						}
					}
					else
					{
						System.out.println("A Mensagem é null");
						System.out.println();
						atividadeActual = Atividades.Dormir;	
					}
					
					break;
					
				case GerarComando:
					
					mensagemAleatoria = gerarComando();
					
					atividadeActual = Atividades.EscreverMensagem;

					System.out.println("Gerar Comando");
					System.out.print("Mensagem Gerada: ");
					mensagemAleatoria.printMensagem();
					System.out.println();
					
					break;
					
				case EscreverMensagem:
					
					System.out.println("Escrever Mensagem");
					
					if(!enviarMensagem(Atividades.EscreverMensagem, Atividades.EsperarTempoComando, mensagemAleatoria))
					{
						System.out.println("Falhou Enviar Mensagem");
						System.out.println();
						
						atividadeActual = Atividades.Dormir;
						
						break;
					}
					
					System.out.println("A mensagem foi enviada com sucesso");
					//canalDeComunicacaoEvitarParaServidor.DebugBuffer();
					
					if(!aEvitar)
					{
						System.out.println("Acabou de Evitar");
						System.out.println();
						atividadeActual = Atividades.EnviarFimPrioridade;
					}
					
					gui.debugMode("Mensagem Enviada: " + mensagemAleatoria.getInfo());
					
					break;
					
				case EnviarFimPrioridade:
					
					System.out.println("Fim Prioridade");
					
					if(!enviarMensagem(Atividades.EnviarFimPrioridade, Atividades.EsperarTempoComando, new MensagemPrioridade(0, Mensagem.FIM_PRIORIDADE, 0)))
					{
						System.out.println("Falhou Enviar Mensagem");
						System.out.println();
						atividadeActual = Atividades.Dormir;
					}
					else
					{
						System.out.print("Mensagem Enviada: ");
						mensagemAleatoria.printMensagem();
						//canalDeComunicacaoEvitarParaServidor.DebugBuffer();
						
						gui.debugMode("Mensagem Enviada: " + mensagemAleatoria.getInfo());
					}
					
					break;
					
				case EsperarTempoComando:
					
					System.out.println("Esperar Tempo Comando");
					
					EsperarTempoComando(mensagemAleatoria, 30);
					
					if(mensagemAleatoria != null)
					{
						if(mensagemAleatoria.getTipo() == Mensagem.FIM_PRIORIDADE)
						{
							atividadeActual = Atividades.EnviarPrioridade;

							System.out.println("Mensagem é Fim Prioridade.");
							System.out.println();
							
							break;
						}
					}
					
					atividadeActual = Atividades.GerarComando;
					
					break;
				
				case Dormir:
				
					System.out.println("A Dormir");
					System.out.println();
					
					Dormir();
					
					atividadeActual = atividadeAnterior;
					
					break;
				
				default:
					
					throw new IllegalArgumentException("Estado não compreendido pelo Evitar");
			}
		}
	}	
	
	private void EsperarTempoComando(Mensagem mensagem, int velocidadeRobot)
	{
		long tempo = 0;
		
		switch(mensagem.getTipo())
		{
			case Mensagem.RETA:
				
				tempo = (long)(-((MensagemReta) mensagem).getDistancia() / (float) velocidadeRobot * 1000f + 1000f);
				
				break;
				
			case Mensagem.CURVAR_ESQUERDA:
			case Mensagem.CURVAR_DIREITA:
				
				tempo = (long) ((float) Math.toRadians(((MensagemCurvar) mensagem).getAngulo()) * (((MensagemCurvar) mensagem).getRaio()) / (float) velocidadeRobot * 1000f + 1000f);
				
				break;
			
			case Mensagem.PARAR:
				
				tempo = 1;
				
				System.out.println("Parar");
				
				break;
				
			case Mensagem.FIM_PRIORIDADE:
				
				tempo = 250;
				
				break;
		}
		
		System.out.println(tempo);
		
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
				
			case Mensagem.PRIORIDADE:
				
				aImprimir = "Tipo : Prioridade";
				
				break;
				
			case Mensagem.FIM_PRIORIDADE:
				
				aImprimir = "Tipo : Fim Prioridade";
		}
		
		gui.debugMode(aImprimir + "\r\n");
	}
	
	private boolean enviarMensagem(Atividades estadoActual, Atividades estadoSeguinte, Mensagem mensagemAEnviar)
	{
		atividadeAnterior = estadoActual;
		mensagemAleatoria = mensagemAEnviar;
		
		boolean enviou = canalDeComunicacaoEvitarParaServidor.GetAndSetCliente(mensagemAleatoria); 
		
		if(enviou)
		{
			atividadeActual = estadoSeguinte;
			
			return true;
		}
			
		return false;
	}
	
	private Mensagem gerarComando()
	{
		Mensagem mensagem = null;
		
		switch(numeroComando)
		{
			case 0:
				
				mensagem = new MensagemParar(0, Mensagem.PARAR, 0);
				
				break;
			
			case 1:
				
				mensagem = new MensagemReta(0, Mensagem.RETA, -15);
				
				break;
			
			case 2:
				
				mensagem = new MensagemParar(0, Mensagem.PARAR, 0);
				
				break;
			
			case 3:
				
				mensagem = new MensagemCurvar(0, Mensagem.CURVAR_ESQUERDA, 0, 90);
				
				break;
				
			case 4:
				
				mensagem = new MensagemParar(0, Mensagem.PARAR, 0);
				
				aEvitar = false;
				
				break;
				
			default:
				
				System.out.println("Comando não reconhecido");
				
				break;
		}
		
		numeroComando = (numeroComando + 1) % 5;
		return mensagem;
	}
}
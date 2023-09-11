import robot.RobotLegoEV3;

public class Servidor {
	
	private static GUI gui;
	private static minhasVariaveis mv;
	private static CanalComunicacaoConsistente canalDeComunicacaoVaguear;
	private static CanalComunicacaoConsistente canalDeComunicacaoEvitarParaServidor;
	private static CanalComunicacaoConsistente canalDeComunicacaoServidorParaEvitar;

	//Acredito que necessitamos desta flag
	private static boolean prioridadeEvitar;
	
	private enum Estados
	{
		Inicial,
		LerCanalEvitar,
		LerCanalVaguear,
		EnviarMensagem,
		Dormir
	}
	
	private Estados estadoAnterior;
	private Estados estadoActual;

	private Mensagem mensagemActual;
	
	public Servidor()
	{
		mv = new minhasVariaveis();
		gui = new GUI(mv);

		canalDeComunicacaoVaguear = new CanalComunicacaoConsistente();
		canalDeComunicacaoEvitarParaServidor = new CanalComunicacaoConsistente();
		canalDeComunicacaoServidorParaEvitar = new CanalComunicacaoConsistente();
		
		estadoActual = Estados.Inicial;
		mensagemActual = null;
		prioridadeEvitar = false;
	}
	
	private static void main(String[] args)
	{
		Servidor servidor = new Servidor();
		servidor.run();
	}
	
	private void run()
	{
		while(true)
		{
			switch(estadoActual)
			{
				case Inicial:
					
					if(Inicializar())
					{
						estadoActual = Estados.LerCanalEvitar;
					}
					
					break;
					
				case LerCanalEvitar:
					
					if(LerCanalDeComunicacao(canalDeComunicacaoEvitarParaServidor.GetAndSetServidor()))
					{
						estadoActual = Estados.EnviarMensagem;
						
						break;
					}
					
					if(prioridadeEvitar)
					{
						estadoAnterior = Estados.LerCanalEvitar;
						estadoActual = Estados.Dormir;
					}
					else
					{
						estadoActual = Estados.LerCanalVaguear;
					}
					
					break;
					
				case LerCanalVaguear:
					
					if(LerCanalDeComunicacao(canalDeComunicacaoEvitarParaServidor.GetAndSetServidor()))
					{
						estadoActual = Estados.EnviarMensagem;
						
						break;
					}
					
					estadoAnterior = Estados.LerCanalEvitar;
					estadoActual = Estados.Dormir;
					
					break;
					
				case EnviarMensagem:
					
					boolean enviou = InterpretarEEnviarMensagem();
					
					if(!enviou)
					{
						estadoAnterior = Estados.EnviarMensagem;
					}
					
					estadoActual = Estados.Dormir;
					
					break;
					
				case Dormir:
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("Não foi capaz de Dormir");
					}
				
					estadoActual = estadoAnterior;
					
					break;
				
				default:
					
					break;
			}
		}
	}
	
	private boolean Inicializar()
	{
		if(!canalDeComunicacaoVaguear.abrirCanal("CanalDeComunicacaoVaguear", false))
		{
			return false;
		}
		
		if(!canalDeComunicacaoEvitarParaServidor.abrirCanal("CanalDeComunicacaoEvitarParaServidor", true))
		{
			return false;
		}
		
		if(!canalDeComunicacaoServidorParaEvitar.abrirCanal("CanalDeComunicacaoServidorParaEvitar", true))
		{
			return false;
		}
		
		return true;
	}

	private boolean LerCanalDeComunicacao(Mensagem mensagem)
	{
		if(mensagem == null)
		{			
			return false;
		}
		
		if(mensagem.getTipo() == Mensagem.VAZIO)
		{
			return false;
		}
		
		mensagemActual = mensagem;
		
		return true;
	}

	private boolean InterpretarEEnviarMensagem()
	{
		switch(mensagemActual.getTipo())
		{
			case Mensagem.RETA:
				
				mv.getRobot().Reta(((MensagemReta) mensagemActual).getDistancia());
				
				break;
			
			case Mensagem.CURVAR_ESQUERDA:
				
				MensagemCurvar mensagemCurvarEsquerda = ((MensagemCurvar) mensagemActual);
				mv.getRobot().CurvarEsquerda(mensagemCurvarEsquerda.getRaio(), mensagemCurvarEsquerda.getAngulo());
				
				break;
				
			case Mensagem.CURVAR_DIREITA:
				
				MensagemCurvar mensagemCurvarDireita = ((MensagemCurvar) mensagemActual);
				mv.getRobot().CurvarDireita(mensagemCurvarDireita.getRaio(), mensagemCurvarDireita.getAngulo());
				
				break;
				
			case Mensagem.PARAR:
				
				mv.getRobot().Parar(((MensagemParar) mensagemActual).getSincrono() == 0 ? false : true);
				
				break;
				
			case Mensagem.SENSOR_PEDIDO:
				
				int sensorToque = mv.getRobot().SensorToque(RobotLegoEV3.S_1);
				
				MensagemRespostaToque mensagemRespostaToque = new MensagemRespostaToque(0, Mensagem.SENSOR_RESPOSTA, sensorToque);
				
				if(!canalDeComunicacaoServidorParaEvitar.GetAndSetCliente(mensagemRespostaToque))
				{
					return false;
				}
				
				break;
				
			case Mensagem.PRIORIDADE:
				
				prioridadeEvitar = true;
				
				break;
				
			case Mensagem.FIM_PRIORIDADE:
				
				prioridadeEvitar = false;
				
				break;
				
			default:
				
				break;
		}
		
		return true;
	}
	
}

/*

public class Servidor {

	private static GUI gui;
	private static CanalComunicacaoConsistente canalDeComunicacaoVaguear;
	private static CanalComunicacaoConsistente canalDeComunicacaoEvitarParaServidor;
	private static CanalComunicacaoConsistente canalDeComunicacaoServidorParaEvitar;
	private static minhasVariaveis mv;
	
	//Acredito que necessitamos desta flag
	private static boolean prioridadeEvitar;
	
	private static int toqueAnterior;
	
	private enum Estados
	{
		Inicial,
		LerCanalEvitar,
		LerCanalVaguear,
		ReceberMensagem,
		EnviarMensagem,
		Dormir
	}
	
	private Estados estadoActual;
	
	private Mensagem mensagemActual;
	
	public Servidor()
	{
		mv = new minhasVariaveis();
		gui = new GUI(mv);
		canalDeComunicacaoVaguear = new CanalComunicacaoConsistente();
		canalDeComunicacaoEvitarParaServidor = new CanalComunicacaoConsistente();
		canalDeComunicacaoServidorParaEvitar = new CanalComunicacaoConsistente();
		
		estadoActual = Estados.Inicial;
		prioridadeEvitar = false;
	}
	
	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.run();
	}
	
	private void run()
	{
		while(true)
		{
			switch(estadoActual)
			{
				case Inicial:
					toqueAnterior = 0;
					if(Initialize())
					{
						estadoActual = Estados.LerCanalEvitar;
					}
					
					break;
				
				case LerCanalEvitar:
					
					//System.out.println("Ler Canal Evitar");
					
					if(!LerCanalDeComunicacao(canalDeComunicacaoEvitarParaServidor.GetAndSetServidor()))
					{
						if(!prioridadeEvitar)
						{
							//System.out.println("Vou para o Ler Canal Vaguear");
							estadoActual = Estados.LerCanalVaguear;							
						}
						else
						{
							//System.out.println("Vou dormir");
							estadoActual = Estados.Dormir;
						}

//						System.out.println();
						
						break;
					}
					
					estadoActual = Estados.ReceberMensagem;
					
					gui.myPrint("Mensagem Recebida de Evitar: " + mensagemActual.getInfo());
					
					if(mensagemActual != null)
					{
						
						System.out.println("Mensagem Recebida: ");
						mensagemActual.printMensagem();
						System.out.println();
						
					}
					
					break;
					
				case LerCanalVaguear:
					
					//System.out.println("Ler Canal Vaguear");
					
					if(!LerCanalDeComunicacao(canalDeComunicacaoVaguear.GetAndSetServidor()))
					{
						//System.out.println("Vou dormir, não recebi mensagem");
						estadoActual = Estados.Dormir;
					}
					else
					{
						//System.out.println("Recebi mensagem, vou processá-la");
						estadoActual = Estados.ReceberMensagem;	
						canalDeComunicacaoVaguear.DebugBuffer();
						//System.out.println();
						
						gui.myPrint("Mensagem Recebida de Vaguear: " + mensagemActual.getInfo());
					}
					
					break;
					
				case ReceberMensagem:
					
					InterpretarMensagem();

					if(mensagemActual != null)
					{
						//System.out.print("Mensagem Recebida: ");	
						//mensagemActual.printMensagem();
					}
					
					estadoActual = Estados.Dormir;
					
					break;
					
				case Dormir:
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("Não foi capaz de Dormir");
					}
				
					estadoActual = Estados.LerCanalEvitar;
					
					break;
				
				default:
					
					break;
			}
		}
	}
	
	private boolean Initialize()
	{
		if(!canalDeComunicacaoVaguear.abrirCanal("CanalDeComunicacaoVaguear", false))
		{
			return false;
		}
		
		gui.myPrint("Canal De Comunicação Vaguear aberto com sucesso");
		
		if(!canalDeComunicacaoEvitarParaServidor.abrirCanal("CanalDeComunicacaoEvitarParaServidor", true))
		{
			return false;
		}
		
		gui.myPrint("Canal De Comunicação Evitar para Servidor aberto com sucesso");
		
		if(!canalDeComunicacaoServidorParaEvitar.abrirCanal("CanalDeComunicacaoServidorParaEvitar", true))
		{
			return false;
		}
		
		gui.myPrint("Canal De Comunicação Servidor para Evitar aberto com sucesso");
		
		return true;
	}
	
	private boolean LerCanalDeComunicacao(Mensagem mensagem)
	{
		if(mensagem == null || mensagem.getTipo() == Mensagem.VAZIO)
		{
			return false;
		}
		
		mensagemActual = mensagem;
		
		return true;
	}
	
	private void InterpretarMensagem()
	{
		
		if(mensagemActual == null)
		{
			return;
		}
		
		switch(mensagemActual.getTipo())
		{
			case Mensagem.PRIORIDADE:
				
				if(prioridadeEvitar)
				{
					return;
				}
				
				prioridadeEvitar = true;
				
				break;
			
			case Mensagem.FIM_PRIORIDADE:
				
				prioridadeEvitar = false;
				
				toqueAnterior = 0;
				
				break;
				
			case Mensagem.SENSOR_PEDIDO:
				
				System.out.println("RECEBI");
				
				int toque = mv.getRobot().SensorToque(RobotLegoEV3.S_1);

				if(toque == 1 && toqueAnterior == 0)
				{
					canalDeComunicacaoServidorParaEvitar.GetAndSetCliente(new MensagemRespostaToque(0, Mensagem.SENSOR_RESPOSTA, 1));					
				}
				else
				{
					canalDeComunicacaoServidorParaEvitar.GetAndSetCliente(new MensagemRespostaToque(0, Mensagem.SENSOR_RESPOSTA, 0));
				}
				
				toqueAnterior= toque;
				
				System.out.println("Toque: " + toque);
				
				gui.myPrint("Comando Enviado: Sensor Toque | Resposta : " + toque);
				
				break;
				
			case Mensagem.RETA:
				
				mv.getRobot().Reta(((MensagemReta) mensagemActual).getDistancia());
				
				gui.myPrint("Comando Enviado: Reta | Distancia : " + ((MensagemReta) mensagemActual).getDistancia());
				
				break;
				
			case Mensagem.CURVAR_ESQUERDA:
				
				MensagemCurvar mensagemCurvarEsquerda = ((MensagemCurvar) mensagemActual);
				mv.getRobot().CurvarEsquerda(mensagemCurvarEsquerda.getRaio(), mensagemCurvarEsquerda.getAngulo());
				
				gui.myPrint("Comando Enviado: Curvar Esquerda | Raio : " + mensagemCurvarEsquerda.getRaio() + " | Angulo : " + mensagemCurvarEsquerda.getAngulo());
				
				break;
			
			case Mensagem.CURVAR_DIREITA:
				
				MensagemCurvar mensagemCurvarDireita = ((MensagemCurvar) mensagemActual);
				mv.getRobot().CurvarDireita(mensagemCurvarDireita.getRaio(), mensagemCurvarDireita.getAngulo());
				
				gui.myPrint("Comando Enviado: Curvar Direita | Raio : " + mensagemCurvarDireita.getRaio() + " | Angulo : " + mensagemCurvarDireita.getAngulo());
					
				break;
				
			case Mensagem.PARAR:
				
				mv.getRobot().Parar(((MensagemParar) mensagemActual).getSincrono() == 1 ? true : false);
	
				gui.myPrint("Comando Enviado: Parar | Sincrono : " + ((MensagemParar) mensagemActual).getSincrono());
				
				break;
		}
	}
}

*/
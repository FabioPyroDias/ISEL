import java.util.concurrent.Semaphore;

import robot.RobotLegoEV3;

public class Evitar extends Tarefa{
	
	private static GUI_Evitar gui;
	
	public Evitar(BufferCircularMT buffer, RobotLegoEV3 robot, Semaphore semaforo)
	{
		super(buffer, robot, semaforo);
		
		gui = new GUI_Evitar();
	}
	
	@Override
	public void funcao()
	{
		
	}
	
	/*
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
	*/
}
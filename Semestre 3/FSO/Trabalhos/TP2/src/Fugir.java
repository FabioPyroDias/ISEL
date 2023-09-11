import java.util.concurrent.Semaphore;
import robot.RobotLegoEV3;

public class Fugir extends Tarefa{
	
	private enum Estados_Fugir
	{
		LerSensor,
		EnviarComando,
		EsperarComando,
		Parar
	}
	
	private Estados_Fugir estadoActual;
	
	private GUI_Fugir gui;
	
	private Semaphore semaforo;

	private Vaguear vaguear;
	
	private int distancia, angulo, comando, numeroTotalComandos, velocidadeNormalPercentagem, velocidadeFugirPercentagem;
	private float raio, respostaSensor, velocidadeNormal, velocidadeFugir;
	
	public Fugir(Vaguear vaguear, Semaphore semaforo)
	{
		super(semaforo);
		
		gui = new GUI_Fugir();
		
		estadoActual = Estados_Fugir.LerSensor;
		
		this.vaguear = vaguear;
		
		numeroTotalComandos = 5;
		comando = 0;
		
		velocidadeNormalPercentagem = 50;
		velocidadeFugirPercentagem = 80;
		
		velocidadeNormal = 30;
		velocidadeFugir = velocidadeFugirPercentagem * velocidadeNormalPercentagem / (velocidadeNormal * 1.0f);
	}
	
	public Fugir(Vaguear vaguear)
	{	
		gui = new GUI_Fugir();
		
		estadoActual = Estados_Fugir.LerSensor;
		
		semaforo = new Semaphore(0);
		
		this.vaguear = vaguear;
		
		numeroTotalComandos = 5;
		comando = 0;
		
		velocidadeNormalPercentagem = 50;
		velocidadeFugirPercentagem = 80;
		
		velocidadeNormal = 30;
		velocidadeFugir = velocidadeFugirPercentagem * velocidadeNormalPercentagem / (velocidadeNormal * 1.0f);
	}
	
	@Override
	public void funcao()
	{
		switch (estadoActual) {

			case LerSensor:
				
				ObterSensorResposta();
				
				gui.debugMode("Obtida Resposta Sensor: " + respostaSensor + " cm");
				
				if(estadoActual == Estados_Fugir.LerSensor)
				{
					if(respostaSensor < 50)
					{
						System.out.println("Comando Antes Sensor: " + comando);
						comando++;
						System.out.println("Comando Após Sensor: " + comando);
						estadoActual = Estados_Fugir.EnviarComando;
					}
					else
					{
						estadoActual = Estados_Fugir.EsperarComando;
					}					
				}
			
				break;
		
			case EnviarComando:
			
				if(estadoActual == Estados_Fugir.EnviarComando)
				{
					EnviarComando();					
				}
				
				if(estadoActual == Estados_Fugir.EnviarComando)
				{
					estadoActual = Estados_Fugir.EsperarComando;					
				}
			
				break;

			case EsperarComando:
				
				EsperarTempoComando();
				
				if(estadoActual == Estados_Fugir.EsperarComando)
				{
					if(comando == 0)
					{
						estadoActual = Estados_Fugir.LerSensor;					
					}
					else
					{
						estadoActual = Estados_Fugir.EnviarComando;
					}
				}
				
				break;
				
			default:
				
				break;
		}
	}
	
	private void ObterSensorResposta()
	{
		respostaSensor = robot.SensorUS(RobotLegoEV3.S_2);
	}
	
	private void EnviarComando()
	{
		System.out.println("Comando: " + comando);
		
		switch(comando)
		{
			case 1:
				
				robot.SetVelocidade(velocidadeFugirPercentagem);
				
				gui.debugMode("Velocidade do Robot Mudada: " + velocidadeFugirPercentagem);
				
				distancia = 50;
				
				robot.Reta(distancia);
				
				gui.debugMode("Reta - Distancia: " + distancia);
				
				break;
		
			case 2:
	
				robot.Parar(false);
				
				gui.debugMode("Parar - Sincrono: 0");
				
				break;
				
			case 3:
				
				int minimumValue = 0;
				int maximumValue = 1;
				int random = (int) (minimumValue + Math.floor(Math.random() * (maximumValue - minimumValue + 1)));
				
				raio = 0;
				angulo = 90;
				
				if(random == 0)
				{
					robot.CurvarEsquerda(raio, angulo);
					
					gui.debugMode("Curvar Esquerda - Raio: " + raio + " | Angulo: " + angulo);
				}
				else
				{
					robot.CurvarDireita(raio, angulo);	
					
					gui.debugMode("Curvar Direita - Raio: " + raio + " | Angulo: " + angulo);	
				}
				
				break;
			
			case 4:
				
				robot.Parar(false);
			
				gui.debugMode("Parar - Sincrono: 0");
				
				robot.SetVelocidade(velocidadeNormalPercentagem);
				
				gui.debugMode("Velocidade do Robot Mudada: " + velocidadeNormalPercentagem);
				
				break;
				
			default:
				
				break;
		}
	}
	
	private void EsperarTempoComando()
	{
		long tempo = 0;
		
		switch(comando)
		{
			case 0:
				
				tempo = 250;

				break;
				
			case 1:
				
				tempo = (long) (distancia / 30. * 1000);
				//tempo = 5000;
				
				comando++;
				
				break;
	
			case 2:
				
				//tempo = 100;
				tempo = 1000;
				
				comando++;
				
				break;
				
			case 3:

				tempo = (long)((float) Math.toRadians(angulo * raio)/ (float) velocidadeFugir * 1000);
				//tempo = 5000;
				
				comando++;
				
				break;
				
			case 4:
				
				//tempo = 100;
				tempo = 1000;
				
				comando++;
				
				break;
					
			default:
				
				break;
		}
		
		try {
			//TODO Remover linha abaixo
			tempo = 3000;
			gui.debugMode("Dormir: " + tempo + " milisegundos");
			gui.debugMode("");
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println("Não foi possível dormir");
		}
		
		comando = comando % numeroTotalComandos;
	}
			
	public void Parar()
	{
		estadoActual = Estados_Fugir.Parar;
	}
	
	public void Retomar()
	{
		semaforo.release();
		
		estadoActual = Estados_Fugir.LerSensor;
	}
	
	public void PararTarefas()
	{
		vaguear.Parar();
	}
	
	public void RetomarTarefas()
	{
		vaguear.Retomar();
	}
	
	@Override
	public void funcionar()
	{
		estadoActual = Estados_Fugir.LerSensor;
		comando = 0;
		
		super.funcionar();
	}
	
	//VAI SER PRECISO:
	/* Um estado PARAR que vai fazer apenas semaforo.acquire();
	 * Dois métodos públicos:
	 *  - Retomar -> Reinicia o processo.
	 *  - Parar -> Faz o estado = PARAR.
	 *  Parar()
	 * {
	 *   estado = PARAR
	 * }
	 * 
	 *  Retomar()
	 * {
	 *   estado = LerSensor.
	 *   semaforo.release();
	 * }
	 * 
	 * Algo que também acontece é:
	 * case LerSensor:
	 *  d = SensorUS();
	 *  if(d < 50)
	 *  {
	 *    if(estado == LerSensor)
	 *    {
	 *      estado = EnviarComando
	 *    }
	 *  }
	 *  
	 *  Ou seja, vamos ter sempre de verificar se ainda estamos nesse estado ANTES de enviar comandos ou mudar de estado.
	 *  
	 *  Também podemos fazer Herança:
	 *  Classe Processo -> Cria Evitar Fugir Vaguear.
	 */
}
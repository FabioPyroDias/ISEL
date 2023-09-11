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
		
		semaforo = new Semaphore(1);
		
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
			case Parar:
				if(estadoActual  == Estados_Fugir.Parar) {

					robot.Parar(true);
					try {
						gui.debugMode("Fugir parado por semáforo");
						semaforo.acquire();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			break;

			case LerSensor:
				
				ObterSensorResposta();
				
				gui.debugMode("Obtida Resposta Sensor: " + respostaSensor + " cm");
				
				if(estadoActual == Estados_Fugir.LerSensor)
				{
					
					if(respostaSensor < 50)
					{
						comando++;
						PararTarefas();
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
					EnviarComando(); // Pode perder o processo aqui 				
				}
				// O estado Parar é colocado por outro processo, 
				// e por isso temos de validar outravez antes de mudar o estado	
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
				
				robot.SetVelocidade(velocidadeNormalPercentagem);
				
				gui.debugMode("Reta - Distancia: " + distancia);
				
				break;
		
			case 2:

				gui.debugMode(" - Sincrono: 0");
				
				break;
				
			case 3:
				
				int minimumValue = 0;
				int maximumValue = 1;
				int random = (int) (minimumValue + Math.floor(Math.random() * (maximumValue - minimumValue + 1)));
				
				raio = 20;
				angulo = 90;
				
				robot.SetVelocidade(velocidadeFugirPercentagem);
				
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
				
				robot.SetVelocidade(velocidadeNormalPercentagem);
				
				break;
			
			case 4:
				
				robot.Parar(false);
				gui.debugMode("Parar - Sincrono: 0");		
				robot.SetVelocidade(velocidadeNormalPercentagem);
				gui.debugMode("Velocidade do Robot Mudada: " + velocidadeNormalPercentagem);
				RetomarTarefas();

				
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
				comando++;
				
				break;
	
			case 2:
				tempo = 0;
				comando++;
				
				break;
				
			case 3:
				// tempo = (long)((float) Math.toRadians(angulo * raio)/ (float) velocidadeFugir * 1000);
				tempo = 100;
				comando++;
				
				break;
				
			case 4:
				tempo = 100;
				comando++;
				
				break;
					
			default:
				break;
		}
		
		try {
		
			if(robot.isSimulado()) {
				tempo = 1000; // Mandar mais tempo
			}
		
			gui.debugMode("Dormir: " + tempo + " milisegundos");
			gui.debugMode("");
			if(tempo > 0) {
				Thread.sleep(tempo);				
			}
		} catch (InterruptedException e) {
			System.out.println("N�o foi poss�vel dormir");
		}
		
		comando = comando % numeroTotalComandos;
	}
			
	public void Parar()
	{
		estadoActual = Estados_Fugir.Parar;	}
	
	public void Retomar()
	{	
		estadoActual = Estados_Fugir.LerSensor;
		semaforo.release();
		gui.debugMode("Fugir - semaforo libertado");

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
	
	@Override
	public void setRobot(RobotLego robot)
	{
		super.setRobot(robot);
		gui.setRobo(robot);
	}
	
	
	//VAI SER PRECISO:
	/* Um estado PARAR que vai fazer apenas semaforo.acquire();
	 * Dois m�todos p�blicos:
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
	 * Algo que tamb�m acontece �:
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
	 *  Tamb�m podemos fazer Heran�a:
	 *  Classe Processo -> Cria Evitar Fugir Vaguear.
	 */
}
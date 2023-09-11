import java.util.concurrent.Semaphore;
import robot.RobotLegoEV3;

public class Evitar extends Tarefa{
	
	private enum Estados_Evitar
	{
		LerSensor,
		EnviarComando,
		EsperarComando,
		Parar
	}
	
	private Estados_Evitar estadoActual;
	
	private GUI_Evitar gui;

	private Fugir fugir;
	private Vaguear vaguear;
	
	private int distancia, angulo, respostaSensor, comando, numeroTotalComandos;
	private float raio;
	
	public Evitar(Fugir fugir, Vaguear vaguear, Semaphore semaforo)
	{
		super(semaforo);
		
		gui = new GUI_Evitar();
		
		estadoActual = Estados_Evitar.LerSensor;
		
		semaforo = new Semaphore(1);
		
		this.fugir = fugir;
		this.vaguear = vaguear;
		
		numeroTotalComandos = 6;
		comando = numeroTotalComandos - 1;
	}
	
	public Evitar(Fugir fugir, Vaguear vaguear)
	{	
		gui = new GUI_Evitar();
		
		estadoActual = Estados_Evitar.LerSensor;
		
		this.fugir = fugir;
		this.vaguear = vaguear;
		
		numeroTotalComandos = 6;
		comando = numeroTotalComandos - 1;
	}
	
	@Override
	public void funcao()
	{
		switch (estadoActual) {

			case LerSensor:
				
				ObterSensorResposta();
				
				gui.debugMode("Obtida Resposta Sensor: " + respostaSensor + (respostaSensor == 0 ? " (N�o Colide)" : " (Colide)"));
				
				if(estadoActual == Estados_Evitar.LerSensor)
				{
			
					if(respostaSensor == 1)
					{	
						PararTarefas();			
						comando++;
						estadoActual = Estados_Evitar.EnviarComando;
						
					}
					else
					{
						estadoActual = Estados_Evitar.EsperarComando;
					}					
				}
			
				break;
		
			case EnviarComando:
			
				if(estadoActual == Estados_Evitar.EnviarComando)
				{
					EnviarComando();					
				}
				
				if(estadoActual == Estados_Evitar.EnviarComando)
				{
					estadoActual = Estados_Evitar.EsperarComando;					
				}
			
				break;

			case EsperarComando:
				
				EsperarTempoComando();

				if(estadoActual == Estados_Evitar.EsperarComando)
				{
					if(comando == numeroTotalComandos - 1)
					{
						estadoActual = Estados_Evitar.LerSensor;					
					}
					else
					{
						estadoActual = Estados_Evitar.EnviarComando;
					}
				}
				
				break;
				
			default:
				
				break;
		}
		
		
	}
	
	private void ObterSensorResposta()
	{
		comando = numeroTotalComandos - 1;
		
		respostaSensor = robot.SensorToque(RobotLegoEV3.S_1);
	}
	
	private void EnviarComando()
	{
		switch(comando)
		{
			case 0:		
				robot.Parar(true);
				gui.debugMode("Parar - Sincrono: 1");
				break;
		
			case 1:
				
				distancia = -15;
				
				robot.Reta(distancia);
				
				gui.debugMode("Reta - Distancia: " + distancia);
				
				break;
			
			case 2:
				
				raio = 0;
				angulo = 90;
				
				robot.Parar(false);
				robot.CurvarEsquerda(raio, angulo);
				
				gui.debugMode("Curvar Esquerda - Raio: " + raio + " | Angulo: " + angulo);
				
				break;
			
			case 3:
				robot.Parar(false);
				gui.debugMode("Parar - Sincrono: 0");
				
				
				break;
				
				
			case 4:
				RetomarTarefas();
				
				break;
			default:
				
				break;
		}
	}
	
	private void EsperarTempoComando()
	{
		long tempo = 200;
		
		switch(comando)
		{
			case 0:
				
				tempo = 100;
				comando++;
				
				break;
				
			case 1:
				//tempo = (long) (-distancia / 30. * 1000);
				tempo = 200;
				comando++;
				
				break;
			
			case 2:
				//tempo = (long)((float) Math.toRadians(angulo * raio)/ (float) 30 * 1000);
				tempo = 100;
				comando++;
				
				break;
				
			case 3:
				tempo = 0;
				comando++;
				
				break;
			
			case 4:
				
				tempo = 0;
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
	
	public void PararTarefas()
	{
		System.out.println("EVITAR parar tarefas");
		fugir.Parar();
		vaguear.Parar();
	}
	
	public void RetomarTarefas()
	{
		System.out.println("EVITAR RETOMAR tarefas");
		fugir.Retomar();
		vaguear.Retomar();
	}
	
	@Override
	public void funcionar()
	{
		estadoActual = Estados_Evitar.LerSensor;
		comando = numeroTotalComandos - 1;
		super.funcionar();
	}
	@Override
	public void setRobot(RobotLego robot)
	{
		super.setRobot(robot);
		gui.setRobo(robot);
	}
	

}
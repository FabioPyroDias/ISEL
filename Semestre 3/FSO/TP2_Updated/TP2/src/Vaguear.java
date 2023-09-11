import java.util.concurrent.Semaphore;

public class Vaguear extends Tarefa{
	
	private enum Estados_Vaguear
	{
		GerarComando,
		EnviarComando,
		EsperarComando,
		Parar
	}
	
	private Estados_Vaguear estadoActual;
	
	private GUI_Vaguear gui;
	
	private Semaphore semaforo;
	
	private int tipo, distancia, angulo, sincrono;
	private float raio;
	
	public Vaguear(Semaphore semaforo)
	{
		super(semaforo);
		
		gui = new GUI_Vaguear();
		
		estadoActual = Estados_Vaguear.GerarComando;
	}
	
	public Vaguear()
	{	
		gui = new GUI_Vaguear();
		
		estadoActual = Estados_Vaguear.GerarComando;
		
		semaforo = new Semaphore(1);
	}
	
	@Override
	public void funcao()
	{
		System.out.println("estado atual " + estadoActual);
		switch (estadoActual) {
		
			case Parar:
					robot.Parar(true);
				
					try {
						gui.debugMode("Vaguear parado por semáforo");
						semaforo.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				
					
					break;
			
			case GerarComando:

				if(estadoActual == Estados_Vaguear.GerarComando) {
					GerarComandoAleatorio();				
					estadoActual = Estados_Vaguear.EnviarComando;	
				}
				break;

			case EnviarComando:
				
				if(estadoActual == Estados_Vaguear.EnviarComando) {
					EnviarComando(); // Pode perder o processo aqui
				}
				
				// O estado Parar é colocado por outro processo, e por isso temos de validar outravez antes de mudar o estado
				if(estadoActual == Estados_Vaguear.EnviarComando) {
						estadoActual = Estados_Vaguear.EsperarComando;
					
				}
				break;

			case EsperarComando:
				
				if(estadoActual == Estados_Vaguear.EsperarComando) {
					EsperarTempoComando(); // Pode perder o processo aqui
				}
				
				// O estado Parar é colocado por outro processo, e por isso temos de validar outravez antes de mudar o estado
				if(estadoActual == Estados_Vaguear.EsperarComando) {
					estadoActual = Estados_Vaguear.GerarComando;
					
				}
				
				break;
				
		}
	}
	
	private int GerarValores(int minimumValue, int maximumValue)
	{	
		return (int) ((Math.random() * (maximumValue - minimumValue)) + minimumValue);
	}
	
	private void GerarComandoAleatorio()
	{
		tipo = GerarValores(1, 4);
		switch(tipo)
		{
			case 1:
		
				distancia = GerarValores(5, 50);
			
				return;
				
			case 2:				
			case 3:
		
				raio = GerarValores(0, 40);
				angulo = GerarValores(20, 90);
		
				return;
			
			case 4:

				sincrono = GerarValores(0, 1);
				
				return;
				
			default:
				
				break;
		}
	}
	
	private void EnviarComando()
	{
		switch(tipo)
		{
			case 1:
				
				robot.Reta(distancia);
		
				gui.debugMode("Reta - Distancia: " + distancia);
				
				break;
				
			case 2:
				
				robot.CurvarEsquerda(raio, angulo);
			
				gui.debugMode("Curvar Esquerda - Raio: " + raio + " | Angulo: " + angulo);
				
				break;
			
			case 3:
				
				robot.CurvarDireita(raio, angulo);
			
				gui.debugMode("Curvar Direita - Raio: " + raio + " | Angulo: " + angulo);
				
				break;
			
			case 4:
				
				robot.Parar((sincrono == 1) ? true : false);
				
				gui.debugMode("Parar - Sincrono: " + sincrono);
				
				break;
				
			default:
				
				break;
		}
	}
	
	private void EsperarTempoComando()
	{
		long tempo = 0;
		
		switch(tipo)
		{
			case 1:
				
				tempo = (long) (distancia / 30. * 1000);
				
				break;
			
			case 2:
			case 3:
				
				tempo = (long)((float) Math.toRadians(angulo * raio)/ 30. * 1000);
				
				break;
				
			case 4:
				
				tempo = 1;
				
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
	}
	
	public void Parar()
	{
		estadoActual = Estados_Vaguear.Parar;
		
		// Estado Parar não está ir até ao semáforo
		/*try {
			// semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/	
	
	
	}
	
	public void Retomar()
	{
		
		estadoActual = Estados_Vaguear.GerarComando;
		semaforo.release();
		gui.debugMode("Vaguear  - semaforo libertado");
	}
	
	@Override
	public void funcionar()
	{
		estadoActual = Estados_Vaguear.GerarComando;
		
		super.funcionar();
	}
}
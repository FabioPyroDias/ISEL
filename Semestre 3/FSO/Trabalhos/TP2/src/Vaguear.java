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
		
		semaforo = new Semaphore(0);
	}
	
	@Override
	public void funcao()
	{
		switch (estadoActual) {
		
			case GerarComando:
				
				GerarComandoAleatorio();
				
				if(estadoActual == Estados_Vaguear.GerarComando)
				{
					estadoActual = Estados_Vaguear.EnviarComando;					
				}
				
				break;

			case EnviarComando:
				
				EnviarComando();
				
				estadoActual = Estados_Vaguear.EsperarComando;
				
				break;

			case EsperarComando:
				
				EsperarTempoComando();
				
				estadoActual = Estados_Vaguear.GerarComando;
				
				break;
				
			case Parar:
				
				try {
					semaforo.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
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
			//TODO Remover linha abaixo
			tempo = 3000;
			gui.debugMode("Dormir: " + tempo + " milisegundos");
			gui.debugMode("");
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println("Não foi possível dormir");
		}
	}
	
	public void Parar()
	{
		estadoActual = Estados_Vaguear.Parar;
	}
	
	public void Retomar()
	{
		semaforo.release();
		
		estadoActual = Estados_Vaguear.GerarComando;
	}
	
	@Override
	public void funcionar()
	{
		estadoActual = Estados_Vaguear.GerarComando;
		
		super.funcionar();
	}
}
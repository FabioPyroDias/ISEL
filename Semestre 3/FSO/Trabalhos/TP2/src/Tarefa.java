import java.util.concurrent.Semaphore;

public abstract class Tarefa extends Thread implements ITarefa{
	
	protected RobotLego robot;
	
	protected Semaphore haTrabalho;
	protected int estado;
	
	//TODO Este semáforo passado como argumento vai ser o semáforo haTrabalho ou será outro?
	public Tarefa(Semaphore semaphore)
	{
		haTrabalho = new Semaphore(0);
		estado = NAO_FAZ_NADA;
	}
	
	public Tarefa()
	{
		haTrabalho = new Semaphore(0);
		estado = NAO_FAZ_NADA;
	}

	public void run()
	{
		while(estado != TERMINAR)
		{
			switch(estado)
			{
				case NAO_FAZ_NADA:
					
					try {
						haTrabalho.acquire();
					} catch (InterruptedException e) {
						System.out.println("Não foi capaz de obter o semáforo Ha Trabalho");
						e.printStackTrace();
					}
					
					break;
					
				case FUNCIONAR:
					
					funcao();
					
					break;
			}
		}
	}
	
	public void funcionar()
	{
		estado = FUNCIONAR;	
		haTrabalho.release();
	}
	
	public void parar()
	{
		estado = NAO_FAZ_NADA;
		
		haTrabalho.drainPermits();
	}
	
	public void setRobot(RobotLego robot)
	{
		this.robot = robot;
	}
	
	public abstract void funcao();	
}
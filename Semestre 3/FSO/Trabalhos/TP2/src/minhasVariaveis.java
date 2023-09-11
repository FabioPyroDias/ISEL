import robot.*;

public class minhasVariaveis {
	
	private String nomeRobot, consola;
	private int raio, angulo, distancia;
	private boolean debug, power, vaguear, evitar, fugir;
	private RobotLego robot;
	
	public minhasVariaveis()
	{
		nomeRobot = "EVB";
		raio = 10;
		angulo = 90;
		distancia = 30;
		debug = true;
		power = false;
		vaguear = false;
		evitar = false;
		fugir = false;
		robot = new RobotLegoEV3Simulado();
	}
	
	public String getNomeRobot() 
	{
		return nomeRobot;
	}
	
	public void setNomeRobot(String nomeRobot) 
	{
		this.nomeRobot = nomeRobot;
	}
	
	public String getConsola() 
	{
		return consola;
	}
	
	public void setConsola(String consola) 
	{
		this.consola = consola;
	}
	
	public int getRaio() 
	{
		return raio;
	}
	
	public void setRaio(int raio) 
	{
		this.raio = raio;
	}
	
	public int getAngulo() 
	{
		return angulo;
	}
	
	public void setAngulo(int angulo) 
	{
		this.angulo = angulo;
	}
	
	public int getDistancia() 
	{
		return distancia;
	}
	
	public void setDistancia(int distancia) 
	{
		this.distancia = distancia;
	}
	
	public boolean isDebug() 
	{
		return debug;
	}
	
	public void setDebug(boolean debug) 
	{
		this.debug = debug;
	}
	
	public boolean isPower() 
	{
		return power;
	}
	
	public void setPower(boolean power) 
	{
		this.power = power;
	}
	
	public boolean isVaguear() 
	{
		return vaguear;
	}
	
	public void setVaguear(boolean vaguear) 
	{
		this.vaguear = vaguear;
	}
	
	public boolean isEvitar() 
	{
		return evitar;
	}
	
	public void setEvitar(boolean evitar) 
	{
		this.evitar = evitar;
	}
	
	public boolean isFugir() 
	{
		return fugir;
	}
	
	public void setFugir(boolean fugir) 
	{
		this.fugir = fugir;
	}
	
	
	public RobotLego getRobot()
	{
		return robot;
	}
	
	public void setRobot(RobotLego robot)
	{
		this.robot = robot;
	}
	
	/* Open - Read/Write - Close
	 * Open : boolean OpenEV3(String nomeRobot)
	 * Read/Write : Comandos do Robot
	 * Close : void CloseEV3()
	 */
}
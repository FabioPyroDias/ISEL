public class MensagemCurvar extends Mensagem{

	private int raio;
	private int angulo;
	
	public MensagemCurvar(int identificador, int tipo, int raio, int angulo) {
		super(identificador, tipo);
		this.raio = raio;
		this.angulo = angulo;
	}

	public int getRaio() {
		return raio;
	}

	public int getAngulo() {
		return angulo;
	}
	
	@Override
	public void printMensagem()
	{
		super.printMensagem();
		System.out.println(" | Raio: " + raio + " | Angulo: " + angulo);
	}
	
	@Override
	public String getInfo()
	{
		return super.getInfo() + " | Raio: " + raio + " | Angulo: " + angulo;
	}
}
public class MensagemReta extends Mensagem{

	private int distancia;
	
	public MensagemReta(int identificador, int tipo, int distancia) {
		super(identificador, tipo);
		this.distancia = distancia;
	}

	public int getDistancia()
	{
		return distancia;
	}	
	
	@Override
	public void printMensagem()
	{
		super.printMensagem();
		System.out.println(" | Distancia: " + distancia);
	}
	
	@Override
	public String getInfo()
	{
		return super.getInfo() + " | Distancia: " + distancia;
	}
}
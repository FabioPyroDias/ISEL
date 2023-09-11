public class MensagemParar extends Mensagem{

	private int sincrono;
	
	public MensagemParar(int identificador, int tipo, int sincrono) {
		super(identificador, tipo);
		
		this.sincrono = sincrono;
	}

	public int getSincrono() {
		return sincrono;
	}
	
	@Override
	public void printMensagem()
	{
		super.printMensagem();
		System.out.println(" | Sincrono: " + sincrono);
	}
	
	@Override
	public String getInfo()
	{
		return super.getInfo() + " | Sincrono: " + sincrono;
	}
}
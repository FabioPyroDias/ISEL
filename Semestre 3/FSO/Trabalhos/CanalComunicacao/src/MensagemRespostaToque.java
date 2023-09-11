public class MensagemRespostaToque extends Mensagem{

	private int resposta;
	
	public MensagemRespostaToque(int identificador, int tipo, int resposta) {
		super(identificador, tipo);
		this.resposta = resposta;
	}

	public int getResposta()
	{
		return resposta;
	}
	
	@Override
	public void printMensagem()
	{
		super.printMensagem();
		System.out.println(" | Resposta: " + resposta);
	}
	
	@Override
	public String getInfo()
	{
		return super.getInfo() + " | Resposta: " + resposta;
	}
}
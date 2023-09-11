public class MensagemPrioridade extends Mensagem{

	private int inicioPrioridade;
	
	public MensagemPrioridade(int identificador, int tipo, int inicioPrioridade) {
		super(identificador, tipo);
		this.inicioPrioridade = inicioPrioridade;
	}

	public int getPrioridade() {
		return inicioPrioridade;
	}

	@Override
	public void printMensagem()
	{
		super.printMensagem();
		System.out.println(" | Prioridade: " + (inicioPrioridade == 1 ? "Inicio" : "Fim"));
	}
	
	@Override
	public String getInfo()
	{
		return super.getInfo() + " | Prioridade: " + (inicioPrioridade == 1 ? "Inicio" : "Fim");
	}
}
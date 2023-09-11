public class Mensagem implements IMensagem{

	protected int identificador;
	protected int tipo;
	
	public Mensagem(int identificador, int tipo)
	{
		this.identificador = identificador; 
		this.tipo = tipo;
	}
	
	public int getIdentificador()
	{
		return identificador;
	}
	
	public int getTipo()
	{
		return tipo;
	}
	
	public void printMensagem()
	{
		System.out.print("MENSAGEM -> ID: " + identificador + " | Tipo: " + tipo);
	}
	
	public String getInfo()
	{
		return "ID: " + identificador + " | Tipo: " + tipo;
	}
}
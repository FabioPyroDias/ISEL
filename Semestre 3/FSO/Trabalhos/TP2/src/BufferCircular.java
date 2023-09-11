public class BufferCircular {
	private int putBuffer, getBuffer;
	//private Mensagem[] buffer;
	private String[] buffer;
	protected final int MAX = 16;
	
	public BufferCircular()
	{
		buffer = new String[MAX];
		putBuffer = getBuffer = 0;
	}
	
	public void inserir(String s)
	{
		buffer[putBuffer] = new String(s);
		putBuffer = ++putBuffer % MAX;
	}
	
	public String remover()
	{
		String s = new String(buffer[getBuffer]);
		getBuffer = ++getBuffer % MAX;
		return s;
	}
}
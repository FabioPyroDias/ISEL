import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CanalComunicacao
{
	private File ficheiro;
	protected FileChannel canal;
	private MappedByteBuffer bufferCircular;

	final int DIMENSAO_MENSAGEM = 16; //Em bytes
	final int NUMERO_GRUPO = 3;
	final int BUFFER_MAX = (NUMERO_GRUPO + 1) * DIMENSAO_MENSAGEM;

	protected int putBuffer;
	protected int getBuffer;
	
	public CanalComunicacao()
	{
		ficheiro = null;
		canal = null;
		bufferCircular = null;
		
		putBuffer = 0;
		getBuffer = 0;
	}
	
	public boolean abrirCanal(String nomeFicheiro, boolean init)
	{
		ficheiro = new File(nomeFicheiro + ".txt");
		
		try
		{
			canal = new RandomAccessFile(ficheiro, "rw").getChannel();
		}
		catch(FileNotFoundException e)
		{
			return false;
		}
		
		try
		{
			bufferCircular = canal.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_MAX);
			
			putBuffer = 0;
			getBuffer = 0;
			
			//� isto?
			if(init)
			{
				initialize();
			}
			
		}
		catch(IOException e)
		{
			return false;
		}
		
		return true;
	}
	
	public Mensagem receberMensagem()
	{
		Mensagem mensagem = null;
		
		bufferCircular.position(getBuffer * DIMENSAO_MENSAGEM);
		
		int identificador = Integer.valueOf(bufferCircular.getInt());
		int tipo = Integer.valueOf(bufferCircular.getInt());
		
		//Parametros
		switch(tipo)
		{
			case Mensagem.VAZIO:
				
				mensagem = new MensagemVazio(identificador, tipo);
		
				break;
				
			case Mensagem.RETA:
		
				mensagem = new MensagemReta(identificador, tipo, bufferCircular.getInt());
			
				break;
				
			case Mensagem.CURVAR_DIREITA:
			case Mensagem.CURVAR_ESQUERDA:
			
				mensagem = new MensagemCurvar(identificador, tipo, bufferCircular.getInt(), bufferCircular.getInt());
			
				break;
				
			case Mensagem.PARAR:
			
				mensagem = new MensagemParar(identificador, tipo, bufferCircular.getInt());
				
				break;
				
			case Mensagem.SENSOR_PEDIDO:
			
				mensagem = new MensagemPedidoToque(identificador, tipo);
			
				break;
				
			case Mensagem.SENSOR_RESPOSTA:
				
				mensagem = new MensagemRespostaToque(identificador, tipo, bufferCircular.getInt());
		
				break;
				
			case Mensagem.PRIORIDADE:
			case Mensagem.FIM_PRIORIDADE:
		
				mensagem = new MensagemPrioridade(identificador, tipo, bufferCircular.getInt());
				
				break;
		}
		
		if(mensagem == null)
		{
			return null;
		}
		else
		{
			getBuffer = (getBuffer + 1) % (NUMERO_GRUPO + 1);
			return mensagem;
		}
	}
	
	public void enviarMensagem(Mensagem msg)
	{
		int identificador = msg.getIdentificador();
		int tipo = msg.getTipo();
		
		bufferCircular.position(putBuffer * DIMENSAO_MENSAGEM);
		
		//Identificador
		bufferCircular.putInt(identificador);
		
		//Tipo
		bufferCircular.putInt(tipo);
		
		//Parametros
		switch(tipo)
		{
			case Mensagem.VAZIO:
				break;
		
			case Mensagem.RETA:
				bufferCircular.putInt(((MensagemReta) msg).getDistancia());
				
				break;
			
			case Mensagem.CURVAR_DIREITA:
			case Mensagem.CURVAR_ESQUERDA:
				bufferCircular.putInt(((MensagemCurvar) msg).getRaio());
				bufferCircular.putInt(((MensagemCurvar) msg).getAngulo());
	
				break;
			
			case Mensagem.PARAR:
				bufferCircular.putInt(((MensagemParar) msg).getSincrono());
				
				break;
				
			case Mensagem.SENSOR_PEDIDO:
				
				break;
			
			case Mensagem.SENSOR_RESPOSTA:
				bufferCircular.putInt(((MensagemRespostaToque) msg).getResposta());
				
				break;
		}
		
		putBuffer = (putBuffer + 1) % (NUMERO_GRUPO + 1);
	}

	
	public void fecharCanal()
	{
		if(canal != null)
		{
			try
			{
				canal.close();
			}
			catch(IOException e)
			{
				canal = null;
			}
		}
	}
	
	private void initialize()
	{
		
		for(int index = 0; index < BUFFER_MAX; index += DIMENSAO_MENSAGEM)
		{
			MensagemVazio mensagemVazio = new MensagemVazio(0, Mensagem.VAZIO);
			
			bufferCircular.position(index);
			bufferCircular.putInt(mensagemVazio.getIdentificador());
			bufferCircular.putInt(mensagemVazio.getTipo());
			bufferCircular.putInt(0);
			bufferCircular.putInt(0);
		}
	}
	
	//Debug Methods
	
	public void DebugBuffer()
	{
		for(int index = 0; index < BUFFER_MAX; index += DIMENSAO_MENSAGEM)
		{
			bufferCircular.position(index);
			System.out.print("ID : " + bufferCircular.getInt());
			System.out.print(" | Tipo : " + bufferCircular.getInt());
			System.out.print(" | Argumento 1 : " + bufferCircular.getInt());
			System.out.println(" | Argumento 2 : " + bufferCircular.getInt());
		}
	}
	
}
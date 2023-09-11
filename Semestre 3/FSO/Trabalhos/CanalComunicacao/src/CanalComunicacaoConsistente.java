import java.io.IOException;
import java.nio.channels.FileLock;

public class CanalComunicacaoConsistente extends CanalComunicacao{
	
	public boolean GetAndSetCliente(Mensagem mensagem)
	{
		boolean enviouMensagem = false;
		
		try 
		{
			FileLock fl = canal.lock();
			
			if(testarMensagemCliente(receberMensagem()))
			{
				enviarMensagem(mensagem);
				enviouMensagem = true;
			}
			
			fl.release();	
		} 
		catch (IOException e1) 
		{
			System.out.println("Não foi possível enviar mensagem");
			enviouMensagem = false;
		}
		
		return enviouMensagem;
	}
	
	private boolean testarMensagemCliente(Mensagem mensagem)
	{
		return mensagem.getTipo() == Mensagem.VAZIO;
	}
	
	/*
	public static void main(String[] args)
	{
		CanalComunicacao canal = new CanalComunicacao();
		canal.abrirCanal("teste");
		
		MensagemCurvar msg = new MensagemCurvar(50, 3, 0, 90);
		
		canal.enviarMensagem(msg);
		Mensagem m = canal.receberMensagem();
		
		System.out.println(m.getIdentificador());
		System.out.println(m.getTipo());
		
		System.out.println(((MensagemCurvar) m).getRaio());
		System.out.println(((MensagemCurvar) m).getAngulo());
	}
	*/	
	
	public Mensagem GetAndSetServidor()
	{
		try 
		{
			FileLock fl = canal.lock();
			
			Mensagem msg = receberMensagem();
			
			if(testarMensagemServidor(msg))
			{
				enviarMensagem(new MensagemVazio(0, Mensagem.VAZIO));
			}
			
			fl.release();
			
			return msg;
			
		} 
		catch (IOException e1) 
		{
			System.out.println("Não foi possível enviar mensagem");
		}
		
		return null;
	}
	
	private boolean testarMensagemServidor(Mensagem mensagem)
	{
		return mensagem.getTipo() != Mensagem.VAZIO;
	}
}
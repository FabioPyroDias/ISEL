import java.util.concurrent.Semaphore;

public class BufferCircularMT extends BufferCircular{
	Semaphore acessoBuffer, posicoesVazias, posicoesOcupadas;
	
	public BufferCircularMT()
	{
		super();
		acessoBuffer = new Semaphore(1);
		posicoesVazias = new Semaphore(MAX);
		posicoesOcupadas = new Semaphore(0);
	}
	
	public void inserirMT(String s)
	{
		try 
		{
			posicoesVazias.acquire();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("N�o foi capaz de obter o sem�foro Posicoes Vazias");
		}
		
		try 
		{
			acessoBuffer.acquire();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("N�o foi capaz de obter o sem�foro Acesso Buffer");
		}
		
		inserir(s);
		acessoBuffer.release();
		posicoesOcupadas.release();
	}
	
	public String removerMT()
	{
		String s;
		
		try 
		{
			posicoesOcupadas.acquire();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("N�o foi capaz de obter o sem�foro Posicoes Ocupadas");
		}
		
		try 
		{
			acessoBuffer.acquire();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("N�o foi capaz de obter o sem�foro Acesso Buffer");
		}
		
		s = remover();
		acessoBuffer.release();
		posicoesVazias.release();
		
		return s;
	}
}
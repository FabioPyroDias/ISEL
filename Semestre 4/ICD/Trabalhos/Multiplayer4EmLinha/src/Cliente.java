import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	//Informações do Cliente
	private String nome;
	private int jogosJogados;
	private int jogosGanhos;
	
	//Variáveis de Conecção, Escrita e Leitura
	private Socket socket;
	private BufferedReader socketReader;
	private PrintWriter socketWriter;

	//Podemos adicionar um sistema de Pontos para desbloquear novas "peças" para o 4 em linha
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Socket getSocket()
	{
		return socket;
	}
	
	public void setSocket(Socket socket)
	{
		this.socket = socket;
	}
	
	public PrintWriter getSocketWriter()
	{
		return socketWriter;
	}
	
	public void setSocketWriter(PrintWriter inputStreamer)
	{
		this.socketWriter = inputStreamer;
	}
	
	public BufferedReader getSocketReader()
	{
		return socketReader;
	}
	
	public void setSocketReader(BufferedReader outputStream)
	{
		this.socketReader = outputStream;
	}
}
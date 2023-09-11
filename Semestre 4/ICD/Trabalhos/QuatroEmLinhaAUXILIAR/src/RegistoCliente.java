import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RegistoCliente {

	//Informações do Cliente
	private String nome;
	private String password;
	private String nacionalidade;
	private int idade;
	private String fotografia; //TODO Acredito que vá ser gravada como String.
	private int jogosJogados;
	private int jogosGanhos;
	private int jogosPerdidos;
	private float tempoJogado;
	
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

	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getNacionalidade()
	{
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade)
	{
		this.nacionalidade = nacionalidade;
	}
	
	public int getIdade()
	{
		return idade;
	}
	
	public void setIdade(int idade)
	{
		this.idade = idade;
	}
	
	public String getFotografia()
	{
		return fotografia;
	}
	
	public void setFotografia(String fotografia)
	{
		this.fotografia = fotografia;
	}

	public int getJogosJogados()
	{
		return jogosJogados;
	}
	
	public void setJogosJogados(int jogosJogados)
	{
		this.jogosJogados = jogosJogados;
	}
	
	public int getJogosGanhos()
	{
		return jogosGanhos;
	}
	
	public void setJogosGanhos(int jogosGanhos)
	{
		this.jogosGanhos = jogosGanhos;
	}
	
	public int getJogosPerdidos()
	{
		return jogosPerdidos;
	}
	
	public void setJogosPerdidos(int jogosPerdidos)
	{
		this.jogosPerdidos = jogosPerdidos;
	}
	
	public float getTempoJogado()
	{
		return tempoJogado;
	}
	
	public void setTempoJogado(float tempoJogado)
	{
		this.tempoJogado = tempoJogado;
	}
	
	//TODO Coneccao
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
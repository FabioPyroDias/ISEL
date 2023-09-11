import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Cliente {

	private String host;
	private int port;
	
	private String nomeCliente;
	private Socket socket;
	private BufferedReader socketReader;
	private PrintWriter socketWriter;
	
	private ArrayList<RegistoCliente> clientes;
	private String simbolo;
	
	private ClienteUI clienteUI;
	private ClientState state;
	
	public Cliente(String defaultHost, int defaultPort, String[] args)
	{
		this.host = defaultHost;
		this.port = defaultPort;
		
		if (args.length > 0) {
            host = args[0];
        }
        
        if (args.length > 1) {
            try {
                int portInArgument = Integer.parseInt(args[1]);
                if (portInArgument >= 1 || portInArgument <= 65535) port = portInArgument;
            }
            catch (NumberFormatException e) {
                System.err.println("Erro no porto indicado");
            }
        }
		
		try {
            socket = new Socket(host, port);

            // Mostrar os parametros da ligação
            System.out.println("Ligação: " + socket);

            // Stream para escrita no socket
            socketWriter = new PrintWriter(socket.getOutputStream(), true); 

            // Stream para leitura do socket
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ThreadCliente thread = new ThreadCliente(this, socketReader);
            thread.start();
            
            state = ClientState.Online;
            
            System.out.println("Conexão Estabelecida");
		}
		catch (IOException e) {
            System.err.println("Erro na ligação " + e.getMessage());   
        }
	}	

	public void definirNome(String nome)
	{
		this.nomeCliente = nome;
	}
	
	public void definirSimbolo(String simbolo)
	{
		this.simbolo = simbolo;
	}
	
	public String getNome()
	{
		return nomeCliente;
	}
	
	public void analisarMensagem(String message)
	{
		String[] parameters = Mensagem.analiseMessage(message);
		System.out.println("Cliente , analisarMensagem - parameters[0] : " + parameters[0]);
		switch(parameters[0])
    	{
    		case "LoginAnswer":
    			
    			System.out.println("Cliente -> analisarMensagem - LoginAnswer");
    			
    			if(parameters[1].equals("false"))
    			{
    				//Levantar erro com popup 
    			}
    			else
    			{
    				System.out.println("Cliente -> analisarMensagem - LoginAnswer - parameters[1] true");
    				
    				int informationOffset = 4;
    				
    				for(int player = 0; player < Integer.parseInt(parameters[2]); player++)
    				{
    					System.out.println("Cliente -> analisarMensagem - LoginAnswer - playerIndex " + player);
        				System.out.println("Cliente -> analisarMensagem - LoginAnswer - " + parameters[player * informationOffset + 3].equals(nomeCliente));
        				
    					if(!parameters[player * informationOffset + 3].equals(nomeCliente))
    					{
    						clienteUI.addPlayer(parameters[player * informationOffset + 3]);
    					}
    				}
    			}
    			
    			break;
    			
    		case "AddPlayer":
    			
    			//Para ser alterado
    			clienteUI.addPlayer(parameters[1]);
    			
    			break;
    		
    		case "RemovePlayer":
    			
    			clienteUI.removePlayer(parameters[1]);
    			
    			break;
    			
    		case "Challenged":
    			
    			if(state != ClientState.Online)
    			{
    				
    			}
    			
    			break;
    			
    		case "ChallengePlayerAnswer":
    			
    			if(parameters[1].equals("true"))
    			{
    				System.out.println("Aceitou");
    			}
    			else
    			{
    				System.out.println("Rejeitou");
    			}
    			
    			break;
    	}
	}
	
	public void setClienteUI(ClienteUI clienteUI)
	{
		this.clienteUI = clienteUI;
	}
	
	//TODO Métodos de Envio
	public void RegistarNaListaDeClientes(String nomeCliente, String password)
	{
		definirNome(nomeCliente);
		socketWriter.println(Mensagem.SignIn(nomeCliente, password));
	}
	
	public void Login(String nomeCliente, String password)
	{
		definirNome(nomeCliente);
		socketWriter.println(Mensagem.Login(nomeCliente, password));
	}
	
	public void enviarJogada(String coluna)
	{
		socketWriter.println(Mensagem.PlayColumn(nomeCliente, coluna));
	}
}

enum ClientState
{
	Online,
	Challenged,
	InGame
}
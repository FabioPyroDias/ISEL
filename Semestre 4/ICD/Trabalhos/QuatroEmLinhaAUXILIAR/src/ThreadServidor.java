import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class ThreadServidor extends Thread {

	//Podemos guardar aqui contra quem o jogador está a jogar
	private String opponentName;
	private PrintWriter opponentSocketWriter;
	
	private RegistoCliente eu;
	private Dados dados;

	private Socket connection;
    private BufferedReader socketReader;
    private PrintWriter socketWriter;

    public ThreadServidor(Socket connection, Dados dados) {
        this.connection = connection;
        this.dados = dados;
    }

    public void run() {

        try {
            socketReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            socketWriter = new PrintWriter(connection.getOutputStream(), true);
            
            for(;;)
            {
            	String inputLine = socketReader.readLine();
            	AnaliseMessage(inputLine);           	
            }
            
        }
        catch (IOException e) {
            System.err.println("erro na ligaçao " + connection + ": " + e.getMessage());
        }
        finally {
            // garantir que o socket é fechado
            try {
                if (socketReader != null) socketReader.close();  
                if (socketWriter != null) socketWriter.close();

                if (connection != null) connection.close();                    
            } catch (IOException e) { } 
        }
        
    } // end run
    
    private void AnaliseMessage(String message)
    {
    	System.out.println("Recebi Mensagem!");
    	System.out.println(message);
    	
    	if(!Mensagem.ValidateXMLMessage(message))
    	{
    		System.out.println("Mensagem Inválida");
    		return;
    		//TODO Se o XSD não validar o XML recebido, posso fechar a coneccao. Mas como?
    	}
    	
    	String[] parameters = Mensagem.analiseMessage(message);
    	
    	switch(parameters[0])
    	{
    		case "SignIn":
    			if(dados.verifyPlayer(parameters[1]) == null)
    			{
    				registarCliente(parameters[1], parameters[2], true);
    				enviarListaClientes(true);
    				atualizarListaDosOutrosClientes();
    			}
    			else
    			{
    				//Enviar mensagem a informar que o jogador já existe.
    				System.out.println("O jogador já existe");
    			}
    			
    			break;
    			
    		case "Login":
    			if(dados.verifyPlayer(parameters[1]) == null)
    			{
    				//Enviar mensagem a informar que o jogador não existe.
    				System.out.println("O jogador não existe");
    			}
    			else
    			{
    				if(dados.verifyPassword(parameters[1], parameters[2]))
    				{
    					System.out.println("Password Correcta");
    					registarCliente(parameters[1], parameters[2], false);
    					enviarListaClientes(true);
    					atualizarListaDosOutrosClientes();
    					
    					dados.createGame(parameters[1]);
    				}
    				else
    				{
    					System.out.println("Password Errada");
    					socketWriter.println("NO NO NO");
    					//Enviar mensagem a informar que a password está errada.
    				}
    			}
    			
    			break;
    			
    		case "PlayColumn":
    			
    			System.out.println("ThreadServidor, AnaliseMessage, PlayColumn");
    			Jogo jogo = dados.getGame(parameters[1]);
    			
    			if(jogo != null)
    			{
    				if(jogo.makePlay(eu.getNome(), parameters[2]))
    				{
    					if(jogo.checkVictory(eu.getNome()))
    					{
    						//Informar ambos os clientes que o jogador ganhou.
    					}
    					else if(jogo.checkGameOver())
    					{
    						//Já não existem espaços jogáveis.
    					}
    					else
    					{
    						String[][] board = jogo.getBoard();
    						String[] singleLineBoard = new String[board.length * board[0].length];
    						int index = 0;
    						
    						for(int row = 0; row < board.length; row++)
    						{
    							for(int col = 0; col < board[0].length; col++)
    							{
    								singleLineBoard[index] = board[row][col];
    								index++;
    							}	
    						}
    						
    						socketWriter.println(Mensagem.UpdatedBoard(singleLineBoard, opponentName));
    						opponentSocketWriter.println(Mensagem.UpdatedBoard(singleLineBoard, opponentName));
    					}
    				}
    				else
    				{
    					//Jogada ilegal
    					//Desligar Cliente.
    				}
    			}
    			
    			break;
    	}
    }
    
    private void registarCliente(String playerName, String password, boolean addPlayerInDatabase)
    {
    	eu = new RegistoCliente();
        eu.setNome(playerName);
        eu.setSocket(connection);
        eu.setSocketReader(socketReader);
        eu.setSocketWriter(socketWriter);
        
        dados.listaClientes.add(eu);
    
        if(addPlayerInDatabase)
        {
        	dados.registerPlayer(playerName, password);        	
        }
        else
        {
        	String[] info = dados.loadPlayer(playerName);
        	
        	eu.setJogosPerdidos(Integer.parseInt(info[0]));
        	eu.setJogosJogados(Integer.parseInt(info[1]));
        	eu.setJogosGanhos(Integer.parseInt(info[2]));
        	eu.setNacionalidade(info[3]);
        	eu.setIdade(info[4] == "" ? 0 : Integer.parseInt(info[4]));
        	eu.setFotografia(info[5]);
        }
    }
    
    private void enviarListaClientes(boolean validate)
    {
    	if(!validate)
    	{
    		eu.getSocketWriter().println(Mensagem.LoginAnswer(false, 0, null));
    		return;
    	}
    	
    	int clientsLength = dados.listaClientes.size();
    	int clientInfoOffset = 4;
    	String[] playersInfo = new String[clientsLength * clientInfoOffset];
    	
    	for(int clientIndex = 0; clientIndex < clientsLength; clientIndex++)
    	{
    		RegistoCliente client = dados.listaClientes.get(clientIndex);
    		
    		playersInfo[clientIndex * clientInfoOffset] = client.getNome();
    		playersInfo[clientIndex * clientInfoOffset + 1] = Integer.toString(client.getJogosJogados());
    		playersInfo[clientIndex * clientInfoOffset + 2] = Integer.toString(client.getJogosGanhos());
    		playersInfo[clientIndex * clientInfoOffset + 3] = Integer.toString(client.getJogosPerdidos());
    	}
    	
    	System.out.println("ThreadServidor - enviarListaClientes");
    	eu.getSocketWriter().println(Mensagem.LoginAnswer(true, clientsLength, playersInfo));
    }

    private void atualizarListaDosOutrosClientes()
    {
    	for(RegistoCliente cliente : dados.listaClientes)
    	{
    		if(cliente.getNome() != eu.getNome())
    		{
    			cliente.getSocketWriter().println(Mensagem.AddPlayer(eu.getNome(), eu.getJogosJogados(), eu.getJogosGanhos(), eu.getJogosPerdidos()));
    		}
    	}
    }
    
    private void executarJogada(String coluna, String simbolo)
    {
    	//Inserir peça no Tabuleiro.
    	
    }
    
    private void actualizarTurno(String jogadorQueEfectuouJogada)
    {
    	
    }
    
    /*//TODO NOTAS:
     * -> Atualização da Lista de Clientes
     * Sempre que um jogador se registar, a ThreadServidor vai ter de atualizar a 
     * representação visual da lista de clientes dos outros Clientes, o lobby.
     * Para tal, vai ter de existir um método que volta a enviar a lista atualizada
     * de clientes e, na ThreadCliente, quando receber essa mensagem, informa a classe
     * base Cliente que, por sua vez, pega nessa mensagem e atualiza a representação
     * visual com base nessa mensagem.
     * Assim, acredito que a classe ClienteUI também vai ter de ser passada como
     * parametro para a classe Cliente.
     * 
     *
     */
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class ServidorJogo extends Thread implements ProtocoloComunicacao{

	private ArrayList<Cliente> listaClientes;

	private Socket connection;
    private BufferedReader socketReader;
    private PrintWriter socketWriter;

    
    public ServidorJogo(Socket connection, ArrayList<Cliente> listaClientes) {
        this.connection = connection;
        this.listaClientes = listaClientes;
    }


    public void run() {

        try {
            socketReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            socketWriter = new PrintWriter(connection.getOutputStream(), true);

            for(;;)
            {
            	String inputLine = socketReader.readLine();
            	AnaliseMessage(inputLine); 
            	
            	System.out.println("Recebi -> " + inputLine);            	
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
    	String[] parameters = message.split(" ");
  
    	switch(parameters[0])
    	{
    		case LOGIN:
    			RegistarCliente(parameters[1]);
    			
    			break;
    	}
    	
    }
    
    private void RegistarCliente(String nome)
    {
    	Cliente eu = new Cliente();
        eu.setNome(nome);
        eu.setSocket(connection);
        eu.setSocketReader(socketReader);
        eu.setSocketWriter(socketWriter);
    }
    
} // end HandleConnectionThread
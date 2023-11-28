import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class User {
	
	private String host;
	private int port;
	
	private Socket socket;
	private BufferedReader socketReader;
	private PrintWriter socketWriter;
	
	public User(String defaultHost, int defaultPort, String[] args)
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

            // Mostrar os parametros da liga��o
            System.out.println("Liga��o: " + socket);

            // Stream para escrita no socket
            socketWriter = new PrintWriter(socket.getOutputStream(), true); 

            // Stream para leitura do socket
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //ThreadCliente thread = new ThreadCliente(this, socketReader);
            //thread.start();
            
            //state = ClientState.Online;
            
            System.out.println("Conex�o Estabelecida");
		}
		catch (IOException e) {
            System.err.println("Erro na liga��o " + e.getMessage());   
        }
	}	
}
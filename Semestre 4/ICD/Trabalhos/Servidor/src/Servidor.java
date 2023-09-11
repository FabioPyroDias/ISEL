import java.io.*;
import java.net.*;

public class Servidor {
	
	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;
		int port = 5025; 
		PrintWriter outputSocket = null;
		BufferedReader inputSocket = null;
		
		try {
			 serverSocket = new ServerSocket(port);
			
			for( ; ; ) {
				System.out.println("Servidor aguarda ligacao no porto " + port + "...");
				Socket socket = serverSocket.accept(); //Espera Connect do Cliente
				
				//Circuito Virtual Estabelecido: Socket Cliente <==> socket 
				inputSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				outputSocket = new PrintWriter(socket.getOutputStream(), true);
				String inputLine = inputSocket.readLine(); 
				System.out.println("Recebi -> " + inputLine);
				outputSocket.println( "Olá para ti também!!");
				//os.flush();
				inputSocket.close();
				outputSocket.close();
				socket.close();
			}
		} catch (Exception e) {
			System.err.println("Erro na execução do servidor principal: " + e.getMessage());
		}
	}
}
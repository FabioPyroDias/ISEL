import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args)
	{
		Socket socketClient = null;
		PrintWriter outputSocket = null;
		BufferedReader inputSocket = null;
		String host = "localhost";
		int port = 5025;
		
		try
		{
			socketClient = new Socket(host, port);
			//Parâmetros de Ligação
			System.out.println("Endereço de Servidor: " + socketClient.getInetAddress() + " | Porto: " + socketClient.getPort());
			System.out.println("Endereço Local: " + socketClient.getLocalAddress() + " | Porto: " + socketClient.getLocalPort());
			outputSocket = new PrintWriter(socketClient.getOutputStream(), true); //Escrita
			inputSocket = new BufferedReader(new InputStreamReader(socketClient.getInputStream())); //Leitura
		
			outputSocket.println("Enviar Dados"); //Escreve no Socket
			System.out.println("Cliente - Recebi: " + inputSocket.readLine()); //Mostra o que recebeu do Socket
		
			outputSocket.close();
			inputSocket.close();
			socketClient.close();
		}
		catch(Exception e)
		{
			System.out.println("Erro no Estabelecimento da Ligação");
		}
	}
}
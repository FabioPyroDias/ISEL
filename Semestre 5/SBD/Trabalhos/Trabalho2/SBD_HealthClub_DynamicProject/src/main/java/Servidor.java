import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor{

    public final static int DEFAULT_PORT = 50000; 

    public static void main(String[] args) 
    {
        int port = DEFAULT_PORT; 

        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                System.err.println("Erro no porto indicado");
            }
        }
        
    	//Load XSD (Protocol)
        Mensagem.LoadXSD();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            Socket newSock = null;

            for( ; ; ) {
                System.out.println("Servidor TCP concorrente aguarda ligacao no porto " + port + "..." );

                newSock = serverSocket.accept(); 

                //Thread th = new ServidorJogo(newSock, listaClientes);
                //th.start();
            }
        } 
        catch (IOException e) {
            System.err.println("Excep��o no servidor: " + e);
        }
    }

}
package somadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClienteSomadorTCP {

    public final static String DEFAULT_HOSTNAME = "localhost";
    
    public final static int DEFAULT_PORT = 5025; 
    
    
    public static void main(String[] args) {

        String host = DEFAULT_HOSTNAME;  // M�quina onde reside a aplica��o servidora
        int    port = DEFAULT_PORT;      // Porto da aplica��o servidora

        
        if (args.length > 0) {
            host = args[0];
        }
        
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]);
                if (port < 1 || port > 65535) port = DEFAULT_PORT;
            }
            catch (NumberFormatException e) {
                System.err.println("Erro no porto indicado");
            }
        }
        
        
        System.out.println("-> " + host + ":" + port );
        
        
        Socket socket     = null;
        BufferedReader br = null;
        PrintWriter    pw = null;
        
        try {
            socket = new Socket(host, port);

            // Mostrar os parametros da liga��o
            System.out.println("Liga��o: " + socket);

            // Stream para escrita no socket
            pw = new PrintWriter(socket.getOutputStream(), true); 

            // Stream para leitura do socket
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            
            HandleClientResponsesThread thread = new HandleClientResponsesThread(br);
            thread.start();
            
            
            BufferedReader brConsola = new BufferedReader(new InputStreamReader(System.in));
            for(;;) {
    			System.out.println();
    			System.out.println("**** Calculadora Somadora ****");
    			System.out.println("escreva os n�meros a somar separados por espa�os");

    			 String argumentos = brConsola.readLine();
	            // Escreve no socket
	        			 
	            pw.println(argumentos);
	            System.out.println("Enviei -> " + argumentos);
	           
            }
            
            
        } 
        catch (IOException e) {
            System.err.println("Erro na liga��o " + e.getMessage());   
        }
        finally {
            // No fim de tudo, fechar os streams e o socket
            try {
                if (pw != null) pw.close();
                if (br != null) br.close();
                if (socket != null ) socket.close();
            }
            catch (IOException e) { 
                // if an I/O error occurs when closing this socket
            }
        } // end finally


    } // end main

} // end ClienteSimplesTCP




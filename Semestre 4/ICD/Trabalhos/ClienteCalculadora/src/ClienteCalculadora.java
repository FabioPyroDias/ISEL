import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClienteCalculadora {

    //public final static String DEFAULT_HOSTNAME = "localhost";
    public final static String DEFAULT_HOSTNAME = "194.210.197.185";
    
    public final static int DEFAULT_PORT = 5025; 
    
    
    public static void main(String[] args) {

        String host = DEFAULT_HOSTNAME;  // Máquina onde reside a aplicação servidora
        int    port = DEFAULT_PORT;      // Porto da aplicação servidora

        
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
        BufferedReader is = null;
        PrintWriter    os = null;
        
        try {
            socket = new Socket(host, port);

            // Mostrar os parametros da ligação
            System.out.println("Ligação: " + socket);

            // Stream para escrita no socket
            os = new PrintWriter(socket.getOutputStream(), true); 

            // Stream para leitura do socket
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            ThreadClienteCalculadora threadResposta = new ThreadClienteCalculadora(socket, is);
            
            
            
            for(;;)
            {
            	String operacao = "";
            	
            	System.out.print("Inserir primeiro número: ");
            	operacao += scanner.nextLine();
            	
            	boolean op = false;
            	while(!op)
            	{
            		System.out.print("Inserir Operação: ");
            		String input = scanner.nextLine();
            		
            		switch(input)
            		{
            			case "+":
            			case "-":
            			case "*":
            			case "/":
            				operacao += " " + input + " ";
            				op = true;
            				break;
            			default:
            				System.out.println("Input Inválido");
            				System.out.println();
            		}
            	}
            	
            	System.out.print("Inserir segundo número: ");
            	operacao += scanner.nextLine();
            	
                // Escreve no socket
                os.println(operacao);
            }            
        } 
        catch (IOException e) {
            System.err.println("Erro na ligação " + e.getMessage());   
        }
        finally {
            // No fim de tudo, fechar os streams e o socket
            try {
                if (os != null) os.close();
                if (is != null) is.close();
                if (socket != null ) socket.close();
            }
            catch (IOException e) { 
                // if an I/O error occurs when closing this socket
            }
        } // end finally


    } // end main

} // end ClienteSimplesTCP
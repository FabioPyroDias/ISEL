package somadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class HandleConnectionThread extends Thread {

    private Socket connection;
    ArrayList<Cliente> listaClientes;
    

    public HandleConnectionThread(Socket connection, ArrayList<Cliente> listaClientes) {
        this.connection = connection;
        this.listaClientes = listaClientes;
    }


    public void run() {

        BufferedReader br = null;
        PrintWriter pw    = null;

        try {
            // circuito virtual estabelecido: socket cliente na variavel newSock
            System.out.println("Thread " + this.getId() + ": " + connection.getRemoteSocketAddress());

            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            pw = new PrintWriter(connection.getOutputStream(), true);

            // Criar Cliente com a minha informação e adicionar à lista global
            Cliente eu = new Cliente();
            eu.setNome("Cli-" + this.getId());
            eu.setSock(connection);
            eu.setPw(pw);
            eu.setBr(br);
            
            listaClientes.add(eu);
            
            
            for(;;) {
	            String inputLine = br.readLine(); 
	            int result = 0;
	
	            System.out.println("Recebi -> " + inputLine.trim().split(" +"));
	            String[] args = inputLine.trim().split(" +");
	            for(int iter=0; iter<args.length; iter++) {
	            	result +=  Integer.parseInt(args[iter]);
	            }
	            
	            String resultString = eu.getNome() + ": +(" + inputLine + ") = " + result;
	            System.out.println("Respondi -> "+ resultString);
	            
	            // Vamos enviar mensagem para todos os clientes
	            for (Cliente c : listaClientes) {
					c.getPw().println(resultString);
				}
	            
            }
        }
        catch (IOException e) {
            System.err.println("erro na ligaçao " + connection + ": " + e.getMessage());
        }
        finally {
            // garantir que o socket é fechado
            try {
                if (br != null) br.close();  
                if (pw != null) pw.close();

                if (connection != null) connection.close();                    
            } catch (IOException e) { } 
        }
    } // end run

} // end HandleConnectionThread
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ThreadClienteCalculadora {

	Socket socket;
	BufferedReader is;
	
	public ThreadClienteCalculadora(Socket socket, BufferedReader is)
	{
		this.socket = socket;
		this.is = is;
	}
	
    public void run() {
        
    	try {
	    	for(;;)
	        {
	            String inputLine = is.readLine();
				System.out.println("Recebi -> " + inputLine);
				
			}
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
    }
}
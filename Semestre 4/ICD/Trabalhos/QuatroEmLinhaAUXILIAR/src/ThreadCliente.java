import java.io.BufferedReader;
import java.io.IOException;

public class ThreadCliente extends Thread {

	private Cliente cliente;
	private BufferedReader socketReader;

	public ThreadCliente(Cliente cliente, BufferedReader socketReader) {
		this.cliente = cliente;
		this.socketReader = socketReader;
	}

	@Override
	public void run() {

		try {
			// cliclo infinito a receber mensagens e a tratar
			for(;;) {
				// Mostrar o que se recebe do socket
				String response = socketReader.readLine();
				System.out.println("Thread Cliente , Recebi -> " + response);
				cliente.analisarMensagem(response);
				// tratar resposta
				//System.out.println("Recebi -> " + response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
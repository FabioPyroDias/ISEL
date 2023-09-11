package somadora;

import java.io.BufferedReader;
import java.io.IOException;

public class HandleClientResponsesThread extends Thread {

	BufferedReader br;

	public HandleClientResponsesThread(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		super.run();

		try {
			// cliclo infinito a receber mensagens e a tratar
			for(;;) {
				// Mostrar o que se recebe do socket
				String response = br.readLine();
				// tratar resposta
				System.out.println("Recebi -> " + response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}

}

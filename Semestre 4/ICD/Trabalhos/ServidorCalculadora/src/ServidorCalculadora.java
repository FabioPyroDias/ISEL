import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculadora {
    public static final int DEFAULT_PORT = 5025;

    public static void main(String[] args) {
        int port = 5025;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException var6) {
                System.err.println("Erro no porto indicado");
            }
        }

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            Socket newSock = null;

            while(true) {
                System.out.println("Servidor TCP concorrente aguarda ligacao no porto " + port + "...");
                newSock = serverSocket.accept();
                Thread th = new ThreadServidorCalculadora(newSock);
                th.start();
            }
        } catch (IOException var5) {
            System.err.println("Excepção no servidor: " + var5);
        }
    }
}
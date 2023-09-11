import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServidorCalculadora extends Thread {
    private Socket connection;

    public ThreadServidorCalculadora(Socket connection) {
        this.connection = connection;
    }

    public void run() {
        BufferedReader is = null;
        PrintWriter os = null;

        try {
            System.out.println("Thread " + this.getId() + ": " + this.connection.getRemoteSocketAddress());
            is = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
            os = new PrintWriter(this.connection.getOutputStream(), true);

            while (true) {
                String inputLine = is.readLine();
                System.out.println("Recebi -> " + inputLine);

                String[] nums = inputLine.split(" ");

                int res = switch (nums[1]) {
                    case "+" -> Integer.parseInt(nums[0]) + Integer.parseInt(nums[2]);
                    case "*" -> Integer.parseInt(nums[0]) * Integer.parseInt(nums[2]);
                    case "/" -> Integer.parseInt(nums[0]) / Integer.parseInt(nums[2]);
                    case "-" -> Integer.parseInt(nums[0]) - Integer.parseInt(nums[2]);
                    default -> 0;
                };

                os.println("não sabes fazer contas burro: " + res);
            }

        } catch (IOException var12) {
            System.err.println("erro na ligaçao " + this.connection + ": " + var12.getMessage());
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (os != null) {
                    os.close();
                }

                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (IOException var11) {
            }

        }

    }
}
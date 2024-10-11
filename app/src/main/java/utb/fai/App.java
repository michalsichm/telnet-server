package utb.fai;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        int max_threads = Integer.parseInt(args[1]);    

        // Implement input parameter processing
        
        // Implementation of the main server loop
        ExecutorService executor = Executors.newFixedThreadPool(max_threads);
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server started");
        int clients = 0;
        while (true) {
            if (clients == max_threads) break;
            ClientThread client = new ClientThread(serverSocket.accept());
            executor.execute(client);
        }
    }
}

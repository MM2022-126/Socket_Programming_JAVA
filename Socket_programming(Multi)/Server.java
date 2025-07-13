import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {
        // Create a server socket that listens on port 1234
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        // Infinite loop to accept multiple client connections
        while (true) {
            Socket soc = ss.accept();  // Accept client connection
            RequestHandler rh = new RequestHandler(soc);  // Handle client request
            rh.start();  // Start a new thread to handle the request
        }
    }
}

import java.io.*;
import java.net.*;

/**
 * The server program echoes anything sent from the client in reversed form.
 * This server is single-threaded.
 */
public class ReverseServer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ReverseServer <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String text;

                do {
                    text = reader.readLine();
                    if (text != null) {
                        String reverseText = new StringBuilder(text).reverse().toString();
                        writer.println("Server: " + reverseText);
                    }
                } while (text != null && !text.equals("bye"));

                socket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

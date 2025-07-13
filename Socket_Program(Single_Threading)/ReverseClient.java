import java.net.*;
import java.io.*;

/**
 * This program demonstrates a simple TCP/IP socket client that reads input
 * from the user and prints the echoed message from the server.
 */
public class ReverseClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ReverseClient <hostname> <port>");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Console console = System.console();
            if (console == null) {
                System.out.println("No console available");
                return;
            }

            String text;

            do {
                text = console.readLine("Enter text: ");
                writer.println(text);

                String response = reader.readLine();
                if (response != null) {
                    System.out.println(response);
                }
            } while (!text.equals("bye"));

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}

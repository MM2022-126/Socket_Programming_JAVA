import java.io.*;
import java.net.*;

public class RequestHandler extends Thread {
    static Socket soc;

    // Constructor that accepts the client socket
    public RequestHandler(Socket soc) {
        this.soc = soc;
    }

    // Run method to handle the client's request
    public void run() {
        try {
            // Create data streams to receive and send data from the client
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());

            // Read the input string and the search word from the client
            String inputString = dis.readUTF();
            String searchString = dis.readUTF();

            // Perform the search to check if the input string contains the search word
            boolean isFound = inputString.contains(searchString);

            // Send the result back to the client
            if (isFound) {
                dos.writeUTF("Found");
            } else {
                dos.writeUTF("Not Found");
            }

            // Close the socket
            soc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

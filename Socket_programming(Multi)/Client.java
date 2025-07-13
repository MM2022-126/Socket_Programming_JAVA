import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket soc = new Socket(InetAddress.getByName("localhost"), 1234);
            System.out.println("Connected to server...");

            // Create data streams for sending and receiving data
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());

            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);

            // Ask user for the string to search in
            System.out.print("Enter the string to search in: ");
            String inputString = scanner.nextLine();

            // Ask user for the search word
            System.out.print("Enter the word or character to search for: ");
            String searchString = scanner.nextLine();

            // Send both the input string and the search word to the server
            dos.writeUTF(inputString);
            dos.writeUTF(searchString);

            // Receive the result from the server
            String result = dis.readUTF();
            System.out.println("Search Result: " + result);

            // Close the socket
            soc.close();

            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

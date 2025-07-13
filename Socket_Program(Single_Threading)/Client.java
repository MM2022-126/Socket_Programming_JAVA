import java.io.*;
import java.net.*;
import java.util.*;
;public class Client {
    public static void main(String[] args) {
        try {
            Socket soc = new Socket(InetAddress.getByName("localhost"), 1234);
            System.out.println("Connected to server...");

            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
//  dos.write for sending
//  dis.read get output            
            
            
        // Make changes here
            //Send the values
 /*           dos.writeDouble(100);
            dos.writeDouble(200);
//Take the ouput
            double input = dis.readDouble();
            System.out.println("The sum of two numbers: " + input);
*/
///////////////// Upto here ////////

//                       2
/* -----------------Inverting a String
         // Send a string to the server
            String stringToInvert = "HelloWorld";
            dos.writeUTF(stringToInvert);

            // Receive the inverted string from the server
            String invertedString = dis.readUTF();
            System.out.println("Inverted String: " + invertedString);

 */

            //            3

//               Finding the Vowels                    /////////
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the String=");
            
            String inputstring = sc.nextLine();
            dos.writeUTF(inputstring);
            
            while (true) {
                char vowel = dis.readChar();  // Read the vowel
                int position = dis.readInt(); // Read the position
                if (position == 0) break; // Exit condition if no vowels are left

                System.out.println("Vowel: " + vowel + " found at position: " + position);
            }
            soc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

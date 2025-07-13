import java.io.*;
import java.net.Socket;

public class RequestHandler extends Thread {
    private Socket soc;

    public RequestHandler(Socket soc) {
        this.soc = soc;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
/*
//// ----------------- Changes Start from Here -----------
            double a = dis.readDouble();
            double b = dis.readDouble();
            double c = a + b;

            dos.writeDouble(c);
*/
// ---- dos. will be same after dot function changes -------
////// ------------- Upto Here --------------------
   
//                           2
            
/* ----------Inverting a String --------------------           
         // Read a string from the client
            String inputString = dis.readUTF();

            // Invert the string
            String invertedString = new StringBuilder(inputString).reverse().toString();

            // Send the inverted string back to the client
            dos.writeUTF(invertedString);
*/
//                          3 
            
//                 Finding Vowels                   
            
           String inputString= dis.readUTF(); 
           String lowerString= inputString.toLowerCase();
           
           boolean [] found= new boolean[5];
           char[] vowels = {'a','e','i','o','u'};
           
           for (int i=0; i<lowerString .length();i++) {
        	   
        	   char ch = lowerString.charAt(i);
        	   
        	   for(int j=0; j<vowels.length;j++) {
        		   if(ch == vowels[j]) {
        			   found[j]=true;
        			   
        			   dos.writeChar(ch);
        			   
        			   dos.writeInt(i+1);
        			   
        			   
        	//		   System.out.println("Vowel"+ch+" found at "+ i+1);
        		   }
        	   }
           }
           
           
            
            
            
            soc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

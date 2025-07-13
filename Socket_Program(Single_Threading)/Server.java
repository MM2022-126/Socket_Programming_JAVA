import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1234); // 1234 is Port number
        System.out.println("Server is running...");
        while (true) {
            Socket soc = ss.accept();
            System.out.println("Client connected.");
            RequestHandler rh = new RequestHandler(soc);
            rh.start();
        }
    }
}

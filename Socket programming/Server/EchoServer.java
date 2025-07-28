import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1111);
             Socket s = ss.accept()) {

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream out = new PrintStream(s.getOutputStream());

            String msg = in.readLine();
          
            out.println("Hello " + msg);

        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}

import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9999);
             Socket s = ss.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader kb = new BufferedReader(new InputStreamReader(System.in))) {

            String msg;
            while (!(msg = in.readLine()).equalsIgnoreCase("bye")) {
                System.out.println("Client: " + msg);
                System.out.print("You: ");
                out.println(kb.readLine());
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}

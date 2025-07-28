import java.net.*; 
import java.io.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 9999);
             BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {

            String msg;
            while (true) {
                System.out.print("You: ");
                msg = kb.readLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) break;
                System.out.println("Server: " + in.readLine());
            }

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}

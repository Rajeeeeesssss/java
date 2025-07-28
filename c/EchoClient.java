import java.net.*; 
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 1111);
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
             PrintStream out = new PrintStream(s.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {

            System.out.print("Enter your name: ");
            out.println(stdin.readLine());
            System.out.println("Server: " + in.readLine());

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}

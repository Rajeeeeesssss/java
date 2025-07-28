import java.net.*; 
import java.io.*; 

public class DateClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 1111);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
             PrintStream out = new PrintStream(s.getOutputStream())) {

            System.out.print("Enter your name to echo: ");
            String str = stdin.readLine();
            out.println(str);
            System.out.println("Client got from server: " + in.readLine());

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}

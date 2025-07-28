import java.net.*; import java.io.*; import java.util.*;

public class AddClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter two numbers (e.g., 10,20): ");
            out.println(sc.nextLine());
            System.out.println("Server: " + in.readLine());

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}

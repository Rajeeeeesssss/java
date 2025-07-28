import java.net.*; 
import java.io.*;

public class AddServer {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(12345)) {
            while (true) {
                try (Socket s = ss.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                    String[] parts = in.readLine().split(",");
                    int a = Integer.parseInt(parts[0].trim()), b = Integer.parseInt(parts[1].trim());
                    out.println("Sum = " + (a + b));
                } catch (Exception e) {
                    System.out.println("Client Error: " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}

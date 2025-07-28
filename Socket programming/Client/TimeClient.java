import java.net.*; import java.io.*;

public class TimeClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
            System.out.println("Server time: " + in.readLine());
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}

import java.net.*; 
import java.io.*;
import java.util.*;

public class TimeServer {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(12345)) {
            while (true) {
                try (Socket s = ss.accept()) {
                    new PrintWriter(s.getOutputStream(), true).println(new Date().toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}

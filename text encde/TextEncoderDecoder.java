import java.util.Scanner;

public class TextEncoderDecoder {

    // Method to encode text
    public static String encode(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                // Shift uppercase letters
                char encoded = (char) ((ch - 'A' + shift) % 26 + 'A');
                result.append(encoded);
            } else if (Character.isLowerCase(ch)) {
                // Shift lowercase letters
                char encoded = (char) ((ch - 'a' + shift) % 26 + 'a');
                result.append(encoded);
            } else {
                // Keep non-alphabetic characters unchanged
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Method to decode text
    public static String decode(String text, int shift) {
        // Decoding is just encoding with reverse shift
        return encode(text, 26 - (shift % 26));
    }

    // Method to display menu
    public static void displayMenu() {
        System.out.println("Encoder & Decoder");
        System.out.println("1. Encode a message");
        System.out.println("2. Decode a message");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = -1;

            // Input validation for menu choice
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter 1, 2, or 3.");
                continue;
            }

            switch (choice) {
                case 1: // Encode
                    System.out.print("Enter message to encode: ");
                    String encodeMsg = sc.nextLine();
                    System.out.print("Enter shift value (number): ");
                    int encodeShift = Integer.parseInt(sc.nextLine());
                    String encoded = encode(encodeMsg, encodeShift);
                    System.out.println("Encoded Message: " + encoded);
                    break;

                case 2: // Decode
                    System.out.print("Enter message to decode: ");
                    String decodeMsg = sc.nextLine();
                    System.out.print("Enter shift value (number): ");
                    int decodeShift = Integer.parseInt(sc.nextLine());
                    String decoded = decode(decodeMsg, decodeShift);
                    System.out.println("Decoded Message: " + decoded);
                    break;

                case 3: // Exit
                    System.out.println("Exiting program....!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice......!");
            }
        }
        sc.close();
    }
}

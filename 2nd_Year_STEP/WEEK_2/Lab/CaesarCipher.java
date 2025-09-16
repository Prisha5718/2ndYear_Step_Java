import java.util.*;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char c = (char) (((ch - 'A' + shift) % 26 + 26) % 26 + 'A');
                result.append(c);
            } else if (ch >= 'a' && ch <= 'z') {
                char c = (char) (((ch - 'a' + shift) % 26 + 26) % 26 + 'a');
                result.append(c);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void displayAscii(String label, String text) {
        System.out.print(label + ": ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print((int) text.charAt(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(input, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("\nOriginal Text: " + input);
        displayAscii("Original ASCII", input);

        System.out.println("Encrypted Text: " + encrypted);
        displayAscii("Encrypted ASCII", encrypted);

        System.out.println("Decrypted Text: " + decrypted);
        displayAscii("Decrypted ASCII", decrypted);

        System.out.println("Decryption Valid? " + input.equals(decrypted));

        sc.close();
    }
}

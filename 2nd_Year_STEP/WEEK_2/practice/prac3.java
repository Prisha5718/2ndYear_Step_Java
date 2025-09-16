import java.util.*;

public class ASCIIDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);

        int asciiValue = (int) ch;
        System.out.println("ASCII value of '" + ch + "' = " + asciiValue);

        System.out.println("Character type: " + classifyCharacter(ch));

        if (Character.isLetter(ch)) {
            char upper = Character.toUpperCase(ch);
            char lower = Character.toLowerCase(ch);
            System.out.println("Uppercase: " + upper + ", Lowercase: " + lower);
        }

        if (Character.isLetter(ch)) {
            int diff = Math.abs(Character.toUpperCase(ch) - Character.toLowerCase(ch));
            System.out.println("Difference between cases: " + diff);
        }

        System.out.println("\nASCII Art using '*' character:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        scanner.nextLine(); 
        System.out.print("\nEnter a text for Caesar Cipher: ");
        String text = scanner.nextLine();
        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();
        System.out.println("Ciphered text: " + caesarCipher(text, shift));

        System.out.println("\nASCII Table from 65 to 90:");
        displayASCIITable(65, 90);

        System.out.println("\nASCII values of string: " + Arrays.toString(stringToASCIIArray(text)));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char)(ch + 32);
        else if (Character.isLowerCase(ch)) return (char)(ch - 32);
        else return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char)i);
        }
    }

    public static int[] stringToASCIIArray(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = (int) text.charAt(i);
        }
        return arr;
    }
}

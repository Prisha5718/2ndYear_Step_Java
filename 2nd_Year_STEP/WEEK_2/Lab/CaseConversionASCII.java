import java.util.*;

public class CaseConversionASCII {

    public static char toUpper(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char)(ch - 32);
        }
        return ch;
    }

    public static char toLower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char)(ch + 32);
        }
        return ch;
    }

    public static String convertToUpper(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(toUpper(text.charAt(i)));
        }
        return sb.toString();
    }

    public static String convertToLower(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(toLower(text.charAt(i)));
        }
        return sb.toString();
    }

    public static String convertToTitleCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                sb.append(ch);
                newWord = true;
            } else {
                if (newWord) {
                    sb.append(toUpper(ch));
                    newWord = false;
                } else {
                    sb.append(toLower(ch));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String manualUpper = convertToUpper(input);
        String manualLower = convertToLower(input);
        String manualTitle = convertToTitleCase(input);

        String builtinUpper = input.toUpperCase();
        String builtinLower = input.toLowerCase();

        System.out.println("\n---------------------------------------------------");
        System.out.printf("%-20s %-20s\n", "Manual Conversion", "Built-in Conversion");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-20s %-20s\n", manualUpper, builtinUpper);
        System.out.printf("%-20s %-20s\n", manualLower, builtinLower);
        System.out.printf("%-20s %-20s\n", manualTitle, "N/A");
        System.out.println("---------------------------------------------------");

        sc.close();
    }
}

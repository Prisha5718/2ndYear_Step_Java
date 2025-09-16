import java.util.Scanner;

public class StringInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter favorite programming language: ");
        String language = scanner.nextLine();

        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = scanner.nextLine();

        String firstName = fullName.split(" ")[0];
        String lastName = fullName.split(" ")[1];
        int charCount = sentence.replace(" ", "").length();
        String upperLang = language.toUpperCase();

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Character count (no spaces): " + charCount);
        System.out.println("Language in uppercase: " + upperLang);

        scanner.close();
    }
}

import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence with mixed formatting: ");
        String input = scanner.nextLine();

        String trimmed = input.trim();
        System.out.println("\nTrimmed: " + trimmed);

        String replacedSpaces = trimmed.replace(" ", "_");
        System.out.println("Spaces replaced with underscores: " + replacedSpaces);

        String noDigits = trimmed.replaceAll("[0-9]", "");
        System.out.println("Removed digits: " + noDigits);

        String[] words = trimmed.split("\\s+");
        System.out.println("Split words: " + Arrays.toString(words));
		
        String joined = String.join(" | ", words);
        System.out.println("Joined with | : " + joined);
		
        System.out.println("\nAfter removing punctuation: " + removePunctuation(trimmed));
        System.out.println("After capitalizing each word: " + capitalizeWords(trimmed));
        System.out.println("Reversed word order: " + reverseWords(trimmed));
        System.out.println("Word frequencies: " + countWordFrequency(trimmed));

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", ""); 
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWords(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static Map<String, Integer> countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            word = word.replaceAll("\\p{Punct}", ""); 
            if (!word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        return freq;
    }
}

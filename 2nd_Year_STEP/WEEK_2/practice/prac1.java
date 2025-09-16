public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = "  Java Programming is Fun and Challenging!  ";
		
        System.out.println("Original length: " + sampleText.length());

        String trimmed = sampleText.trim();
        System.out.println("Trimmed length: " + trimmed.length());

        System.out.println("Character at index 5: " + sampleText.charAt(5));
		
        String sub = trimmed.substring(5, 16); 
        System.out.println("Substring: " + sub);
    }
}

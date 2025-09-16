import java.util.*;

public class TextFormatter {

    public static List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            words.add(text.substring(start));
        }
        return words;
    }

    public static List<String> justifyText(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.size()) {
            int count = words.get(index).length();
            int last = index + 1;
            while (last < words.size()) {
                if (count + 1 + words.get(last).length() > width) break;
                count += 1 + words.get(last).length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int gapCount = last - index - 1;
            if (last == words.size() || gapCount == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words.get(i)).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < width) sb.append(" ");
            } else {
                int spaces = (width - count) / gapCount;
                int extra = (width - count) % gapCount;
                for (int i = index; i < last - 1; i++) {
                    sb.append(words.get(i)).append(" ");
                    for (int j = 0; j < spaces; j++) sb.append(" ");
                    if (extra-- > 0) sb.append(" ");
                }
                sb.append(words.get(last - 1));
            }
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }

    public static List<String> centerAlign(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.size()) {
            int count = words.get(index).length();
            int last = index + 1;
            while (last < words.size()) {
                if (count + 1 + words.get(last).length() > width) break;
                count += 1 + words.get(last).length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = index; i < last; i++) {
                sb.append(words.get(i));
                if (i < last - 1) sb.append(" ");
            }
            int padding = width - sb.length();
            int leftPad = padding / 2;
            int rightPad = padding - leftPad;
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < leftPad; i++) line.append(" ");
            line.append(sb);
            for (int i = 0; i < rightPad; i++) line.append(" ");
            lines.add(line.toString());
            index = last;
        }
        return lines;
    }

    public static long performanceWithString(List<String> words, int width) {
        long start = System.nanoTime();
        String result = "";
        for (String w : words) {
            result += w + " ";
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long performanceWithBuilder(List<String> words, int width) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append(" ");
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void display(List<String> lines) {
        int lineNum = 1;
        for (String line : lines) {
            System.out.printf("%2d | %-50s | %d\n", lineNum++, line, line.length());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        List<String> words = extractWords(text);

        List<String> justified = justifyText(words, width);
        List<String> centered = centerAlign(words, width);

        System.out.println("\nOriginal Text:\n" + text);
        System.out.println("\nJustified Text:");
        display(justified);
        System.out.println("\nCenter Aligned Text:");
        display(centered);

        long timeString = performanceWithString(words, width);
        long timeBuilder = performanceWithBuilder(words, width);
        System.out.println("\nPerformance Comparison:");
        System.out.println("Using String Concatenation: " + timeString + " ns");
        System.out.println("Using StringBuilder: " + timeBuilder + " ns");

        sc.close();
    }
}

import java.util.*;

public class FindAndReplaceManual {

    public static List<Integer> findOccurrences(String text, String find) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(find);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(find, index + find.length());
        }
        return positions;
    }

    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareWithBuiltIn(String text, String find, String replace) {
        String manual = manualReplace(text, find, replace);
        String builtin = text.replace(find, replace);
        return manual.equals(builtin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main text: ");
        String text = sc.nextLine();

        System.out.print("Enter the substring to find: ");
        String find = sc.nextLine();

        System.out.print("Enter the replacement substring: ");
        String replace = sc.nextLine();

        List<Integer> positions = findOccurrences(text, find);
        System.out.println("\nOccurrences at positions: " + positions);

        String manualResult = manualReplace(text, find, replace);
        System.out.println("Manual Replace Result: " + manualResult);

        String builtinResult = text.replace(find, replace);
        System.out.println("Built-in Replace Result: " + builtinResult);

        boolean isSame = compareWithBuiltIn(text, find, replace);
        System.out.println("Manual and Built-in results are same? " + isSame);

        sc.close();
    }
}

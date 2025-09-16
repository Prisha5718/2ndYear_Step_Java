
public class StringArray {
    public static String LongestName(String[] names) {
        String longest = names[0];
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    public static int Names(String[] names, char letter) {
        int count = 0;
        for (String name : names) {
            if (name.toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
                count++;
            }
        }
        return count;
    }

    public static String[] formatNames(String[] names) {
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            formatted[i] = parts[1] + ", " + parts[0];
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};
        System.out.println("Longest Name: " + LongestName(students));
        System.out.println("Names starting with 'A': " + Names(students, 'A'));
        String[] formatted = formatNames(students);
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}
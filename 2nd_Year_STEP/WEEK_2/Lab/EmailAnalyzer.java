import java.util.*;

public class EmailAnalyzer {

    public static boolean isValid(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        if (at == -1 || at != lastAt) return false;
        int dot = email.indexOf('.', at);
        if (dot == -1) return false;
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        if (username.isEmpty() || domain.isEmpty()) return false;
        return true;
    }

    public static Map<String, String> extractParts(String email) {
        Map<String, String> parts = new HashMap<>();
        int at = email.indexOf('@');
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        int dot = domain.lastIndexOf('.');
        String domainName = dot != -1 ? domain.substring(0, dot) : domain;
        String extension = dot != -1 ? domain.substring(dot + 1) : "";
        parts.put("username", username);
        parts.put("domain", domain);
        parts.put("domainName", domainName);
        parts.put("extension", extension);
        return parts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();
        System.out.print("Enter number of emails: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter email " + (i + 1) + ": ");
            emails.add(sc.nextLine());
        }

        int validCount = 0, invalidCount = 0, totalUsernameLength = 0;
        Map<String, Integer> domainCount = new HashMap<>();

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.printf("%-25s %-15s %-20s %-20s %-10s %-10s\n", "Email", "Username", "Domain", "Domain Name", "Ext", "Valid");
        System.out.println("--------------------------------------------------------------------------------------");

        for (String email : emails) {
            boolean valid = isValid(email);
            if (valid) {
                validCount++;
                Map<String, String> parts = extractParts(email);
                String username = parts.get("username");
                String domain = parts.get("domain");
                String domainName = parts.get("domainName");
                String extension = parts.get("extension");
                totalUsernameLength += username.length();
                domainCount.put(domainName, domainCount.getOrDefault(domainName, 0) + 1);
                System.out.printf("%-25s %-15s %-20s %-20s %-10s %-10s\n", email, username, domain, domainName, extension, "Yes");
            } else {
                invalidCount++;
                System.out.printf("%-25s %-15s %-20s %-20s %-10s %-10s\n", email, "-", "-", "-", "-", "No");
            }
        }

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Valid Emails: " + validCount);
        System.out.println("Invalid Emails: " + invalidCount);
        if (validCount > 0) {
            String mostCommonDomain = Collections.max(domainCount.entrySet(), Map.Entry.comparingByValue()).getKey();
            double avgUsernameLength = (double) totalUsernameLength / validCount;
            System.out.println("Most Common Domain: " + mostCommonDomain);
            System.out.println("Average Username Length: " + avgUsernameLength);
        }

        sc.close();
    }
}

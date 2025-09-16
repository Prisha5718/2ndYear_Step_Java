import java.util.Random;
import java.util.Scanner;


public class lab4 {


   
    public static int[] generateRandomAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }


   
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            results[i][0] = String.valueOf(age);
            if (age < 0) {
                results[i][1] = "false";
            } else if (age >= 18) {
                results[i][1] = "true";
            } else {
                results[i][1] = "false";
            }
        }
        return results;
    }


   
    public static void displayResults(String[][] data) {
        System.out.printf("%-10s %-10s\n", "Age", "Can Vote");
        System.out.println("----------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s\n", row[0], row[1]);
        }
    }


   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();


       
        int[] ages = generateRandomAges(n);
       
        String[][] results = checkVotingEligibility(ages);
        displayResults(results);
    }
}

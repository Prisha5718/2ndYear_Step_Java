import java.util.*;

public class lab9 {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("scissors") && computer.equals("paper")) ||
            (user.equals("paper") && computer.equals("rock"))) {
            return "user";
        }
        return "computer";
    }

    public static String[][] calculateStats(int userWins, int compWins, int games) {
        String[][] stats = new String[2][3];
        double userPercent = (userWins * 100.0) / games;
        double compPercent = (compWins * 100.0) / games;

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f%%", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f%%", compPercent);

        return stats;
    }

    public static void displayResults(List<String[]> gameResults, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.printf("%-10s %-12s %-12s %-10s\n", "Game", "Player Choice", "Computer Choice", "Winner");
        for (String[] result : gameResults) {
            System.out.printf("%-10s %-12s %-12s %-10s\n", result[0], result[1], result[2], result[3]);
        }

        System.out.println("\nFinal Stats:");
        System.out.printf("%-10s %-12s %-12s\n", "Name", "Wins", "Win %");
        for (String[] row : stats) {
            System.out.printf("%-10s %-12s %-12s\n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();

        int userWins = 0, compWins = 0;
        List<String[]> gameResults = new ArrayList<>();

        for (int i = 1; i <= games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.nextLine().toLowerCase();
            String compChoice = getComputerChoice();
            String winner = findWinner(userChoice, compChoice);

            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) compWins++;

            gameResults.add(new String[]{String.valueOf(i), userChoice, compChoice, winner});
        }

        String[][] stats = calculateStats(userWins, compWins, games);
        displayResults(gameResults, stats);

        sc.close();
    }
}

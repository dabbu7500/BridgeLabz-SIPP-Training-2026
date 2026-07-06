import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) {
            return "rock";
        }
        if (choice == 1) {
            return "paper";
        }
        return "scissors";
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Draw";
        }
        if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
                || (userChoice.equals("paper") && computerChoice.equals("rock"))
                || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        String[][] stats = new String[3][3];
        stats[0] = new String[] {"User", String.valueOf(userWins), String.format("%.2f", userWins * 100.0 / totalGames)};
        stats[1] = new String[] {"Computer", String.valueOf(computerWins), String.format("%.2f", computerWins * 100.0 / totalGames)};
        stats[2] = new String[] {"Draw", String.valueOf(draws), String.format("%.2f", draws * 100.0 / totalGames)};
        return stats;
    }

    public static void displayGameResults(String[][] games, String[][] stats) {
        System.out.printf("%-8s %-12s %-12s %-10s%n", "Game", "User", "Computer", "Winner");
        System.out.println("---------------------------------------------");
        for (String[] game : games) {
            System.out.printf("%-8s %-12s %-12s %-10s%n", game[0], game[1], game[2], game[3]);
        }

        System.out.println();
        System.out.printf("%-12s %-8s %-12s%n", "Player", "Wins", "Win %");
        System.out.println("--------------------------------");
        for (String[] row : stats) {
            System.out.printf("%-12s %-8s %-12s%n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int totalGames = scanner.nextInt();
        scanner.nextLine();
        if (totalGames <= 0) {
            System.out.println("Number of games must be positive.");
            scanner.close();
            return;
        }

        String[][] games = new String[totalGames][4];
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int index = 0; index < totalGames; index++) {
            System.out.print("Enter choice for game " + (index + 1) + " (rock/paper/scissors): ");
            String userChoice = scanner.nextLine().trim().toLowerCase();
            while (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.print("Invalid choice. Enter rock, paper, or scissors: ");
                userChoice = scanner.nextLine().trim().toLowerCase();
            }

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);
            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }

            games[index] = new String[] {String.valueOf(index + 1), userChoice, computerChoice, winner};
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, totalGames);
        displayGameResults(games, stats);
        scanner.close();
    }
}

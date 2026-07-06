import java.util.Scanner;

public class VotingEligibility {
    public static int[] generateRandomAges(int studentCount) {
        int[] ages = new int[studentCount];
        for (int index = 0; index < studentCount; index++) {
            ages[index] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }

    public static String[][] findVotingEligibility(int[] ages) {
        String[][] eligibility = new String[ages.length][2];
        for (int index = 0; index < ages.length; index++) {
            eligibility[index][0] = String.valueOf(ages[index]);
            eligibility[index][1] = String.valueOf(ages[index] >= 18);
        }
        return eligibility;
    }

    public static void displayTable(String[][] eligibility) {
        System.out.printf("%-10s %-15s%n", "Age", "Can Vote");
        System.out.println("------------------------");
        for (String[] row : eligibility) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();
        if (studentCount <= 0) {
            System.out.println("Number of students must be positive.");
            scanner.close();
            return;
        }

        int[] ages = generateRandomAges(studentCount);
        String[][] eligibility = findVotingEligibility(ages);
        displayTable(eligibility);
        scanner.close();
    }
}

import java.util.Scanner;

public class StudentScorecard {
    public static int[][] generateRandomScores(int studentCount) {
        int[][] scores = new int[studentCount][3];
        for (int student = 0; student < studentCount; student++) {
            for (int subject = 0; subject < 3; subject++) {
                scores[student][subject] = 10 + (int) (Math.random() * 90);
            }
        }
        return scores;
    }

    public static double[][] calculateStudentResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int student = 0; student < scores.length; student++) {
            double total = scores[student][0] + scores[student][1] + scores[student][2];
            double average = total / 3.0;
            double percentage = total / 300.0 * 100.0;
            results[student][0] = roundToTwoDigits(total);
            results[student][1] = roundToTwoDigits(average);
            results[student][2] = roundToTwoDigits(percentage);
        }
        return results;
    }

    public static double roundToTwoDigits(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static String[][] calculateGrades(double[][] results) {
        String[][] grades = new String[results.length][2];
        for (int student = 0; student < results.length; student++) {
            double percentage = results[student][2];
            grades[student][0] = findGrade(percentage);
            grades[student][1] = findRemarks(percentage);
        }
        return grades;
    }

    public static String findGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        }
        if (percentage >= 70) {
            return "B";
        }
        if (percentage >= 60) {
            return "C";
        }
        if (percentage >= 50) {
            return "D";
        }
        if (percentage >= 40) {
            return "E";
        }
        return "R";
    }

    public static String findRemarks(double percentage) {
        if (percentage >= 80) {
            return "Level 4, above agency-normalized standards";
        }
        if (percentage >= 70) {
            return "Level 3, at agency-normalized standards";
        }
        if (percentage >= 60) {
            return "Level 2, below but approaching agency-normalized standards";
        }
        if (percentage >= 50) {
            return "Level 1, well below agency-normalized standards";
        }
        if (percentage >= 40) {
            return "Level 1-, too below agency-normalized standards";
        }
        return "Remedial standards";
    }

    public static void displayScorecard(int[][] scores, double[][] results, String[][] grades) {
        System.out.printf("%-8s %-8s %-10s %-8s %-8s %-8s %-12s %-6s %-60s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade", "Remarks");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        for (int student = 0; student < scores.length; student++) {
            System.out.printf("%-8d %-8d %-10d %-8d %-8.2f %-8.2f %-12.2f %-6s %-60s%n",
                    student + 1,
                    scores[student][0],
                    scores[student][1],
                    scores[student][2],
                    results[student][0],
                    results[student][1],
                    results[student][2],
                    grades[student][0],
                    grades[student][1]);
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

        int[][] scores = generateRandomScores(studentCount);
        double[][] results = calculateStudentResults(scores);
        String[][] grades = calculateGrades(results);
        displayScorecard(scores, results, grades);
        scanner.close();
    }
}

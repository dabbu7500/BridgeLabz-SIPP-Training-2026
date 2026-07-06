import java.util.Scanner;

class BmiCalculator {
    static final int TEAM_SIZE = 10;

    public static String findBmiStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        }
        return "Obese";
    }

    public static String[] findBmiAndStatus(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);

        String[] result = new String[2];
        result[0] = String.format("%.2f", bmi);
        result[1] = findBmiStatus(bmi);
        return result;
    }

    public static String[][] prepareBmiReport(double[][] weightAndHeight) {
        String[][] report = new String[weightAndHeight.length][4];

        for (int i = 0; i < weightAndHeight.length; i++) {
            double weight = weightAndHeight[i][0];
            double height = weightAndHeight[i][1];
            String[] bmiDetails = findBmiAndStatus(weight, height);

            report[i][0] = String.format("%.2f", height);
            report[i][1] = String.format("%.2f", weight);
            report[i][2] = bmiDetails[0];
            report[i][3] = bmiDetails[1];
        }

        return report;
    }

    public static void displayBmiReport(String[][] report) {
        System.out.printf("%-8s %-12s %-12s %-10s %-15s%n", "Person", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < report.length; i++) {
            System.out.printf("%-8d %-12s %-12s %-10s %-15s%n",
                    i + 1, report[i][0], report[i][1], report[i][2], report[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] weightAndHeight = new double[TEAM_SIZE][2];

        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Weight in kg: ");
            weightAndHeight[i][0] = scanner.nextDouble();
            System.out.print("Height in cm: ");
            weightAndHeight[i][1] = scanner.nextDouble();

            if (weightAndHeight[i][0] <= 0 || weightAndHeight[i][1] <= 0) {
                System.out.println("Weight and height must be positive. Please restart and enter valid values.");
                return;
            }
        }

        String[][] report = prepareBmiReport(weightAndHeight);
        displayBmiReport(report);
    }
}

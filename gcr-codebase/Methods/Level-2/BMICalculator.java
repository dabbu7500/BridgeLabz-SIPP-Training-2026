import java.util.Scanner;

public class BMICalculator {

    public static double calculateBMI(double weight, double heightCm) {

        double heightM = heightCm / 100.0;

        return weight / (heightM * heightM);
    }

    public static String getBMIStatus(double bmi) {

        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][3];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {

            System.out.println("Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter Height (cm): ");
            data[i][1] = sc.nextDouble();

            data[i][2] = calculateBMI(data[i][0], data[i][1]);

            status[i] = getBMIStatus(data[i][2]);
        }

        System.out.println("\nWeight\tHeight\tBMI\tStatus");

        for (int i = 0; i < 10; i++) {

            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n",
                    data[i][0],
                    data[i][1],
                    data[i][2],
                    status[i]);
        }
    }
}
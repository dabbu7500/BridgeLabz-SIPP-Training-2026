import java.util.*;

public class SmartParkingSlotManager {

    static ArrayList<String> vehicles = new ArrayList<>();

    static void addVehicle(String number) {

        vehicles.add(number);
        System.out.println("Vehicle Entered.");
    }

    static void removeVehicle(String number) {

        if (vehicles.remove(number))
            System.out.println("Vehicle Exited.");
        else
            System.out.println("Vehicle Not Found.");
    }

    static void searchVehicle(String number) {

        if (vehicles.contains(number))
            System.out.println("Vehicle is Parked.");
        else
            System.out.println("Vehicle Not Present.");
    }

    static void displayVehicles() {

        System.out.println("\nParked Vehicles:");

        for (String v : vehicles)
            System.out.println(v);

        System.out.println("Occupied Slots : " + vehicles.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Vehicle Entry");
            System.out.println("2.Vehicle Exit");
            System.out.println("3.Search");
            System.out.println("4.Display");
            System.out.println("5.Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Registration Number : ");
                    addVehicle(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Registration Number : ");
                    removeVehicle(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Registration Number : ");
                    searchVehicle(sc.nextLine());
                    break;

                case 4:
                    displayVehicles();
                    break;

                case 5:
                    return;
            }
        }
    }
}
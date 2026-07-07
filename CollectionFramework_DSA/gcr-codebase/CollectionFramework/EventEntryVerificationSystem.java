import java.util.*;

public class EventEntryVerificationSystem {

    static HashSet<String> participants = new HashSet<>();

    static void register(String email) {

        if (participants.add(email))
            System.out.println("Registration Successful.");
        else
            System.out.println("Duplicate Registration Rejected.");
    }

    static void display() {

        System.out.println("\nRegistered Participants:");

        for (String email : participants)
            System.out.println(email);

        System.out.println("Total Attendees : " + participants.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Register");
            System.out.println("2.Display");
            System.out.println("3.Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Email : ");
                    register(sc.nextLine());
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    return;
            }
        }
    }
}
import java.util.*;

public class SmartClassroomAttendanceTracker {

    static HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    static void markAttendance(String subject, String student) {

        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (students.contains(student))
            System.out.println("Attendance Already Marked.");
        else {
            students.add(student);
            System.out.println("Attendance Marked.");
        }
    }

    static void displayAttendance() {

        for (String subject : attendance.keySet()) {

            System.out.println("\nSubject : " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String s : students)
                System.out.println(s);

            System.out.println("Total Present : " + students.size());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Mark Attendance");
            System.out.println("2.Display Attendance");
            System.out.println("3.Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Subject : ");
                    String subject = sc.nextLine();

                    System.out.print("Student Name : ");
                    String student = sc.nextLine();

                    markAttendance(subject, student);
                    break;

                case 2:
                    displayAttendance();
                    break;

                case 3:
                    return;
            }
        }
    }
}
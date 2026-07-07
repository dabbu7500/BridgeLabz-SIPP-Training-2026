import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name : " + name +
                "\nPhone : " + phone +
                "\nEmail : " + email;
    }
}

public class AddressBookApp {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static HashMap<String, Contact> map = new HashMap<>();
    static HashSet<String> phoneSet = new HashSet<>();

    static void addContact(String name, String phone, String email) {

        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number not allowed.");
            return;
        }

        Contact c = new Contact(name, phone, email);

        contacts.add(c);
        map.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact Added Successfully.");
    }

    static void search(String name) {

        if (map.containsKey(name))
            System.out.println(map.get(name));
        else
            System.out.println("Contact Not Found");
    }

    static void delete(String name) {

        if (!map.containsKey(name)) {
            System.out.println("Contact Not Found");
            return;
        }

        Contact c = map.remove(name);
        contacts.remove(c);
        phoneSet.remove(c.phone);

        System.out.println("Contact Deleted.");
    }

    static void display() {

        Collections.sort(contacts, (a, b) -> a.name.compareToIgnoreCase(b.name));

        for (Contact c : contacts) {
            System.out.println(c);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Add");
            System.out.println("2.Search");
            System.out.println("3.Delete");
            System.out.println("4.Display");
            System.out.println("5.Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Name : ");
                    String name = sc.nextLine();

                    System.out.print("Phone : ");
                    String phone = sc.nextLine();

                    System.out.print("Email : ");
                    String email = sc.nextLine();

                    addContact(name, phone, email);
                    break;

                case 2:
                    System.out.print("Enter Name : ");
                    search(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Name : ");
                    delete(sc.nextLine());
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

public class Drone {
    String droneId;
    double battryPercentage;
    static String companyName="drone logistic";
    Drone(String droneId,double battryPercentage){
        this.droneId=droneId;
        this.battryPercentage=battryPercentage;

    }
    void startDelivery()
    {
        if (battryPercentage >= 20) {
            System.out.println(droneId + " started delivery");
        } else {
            System.out.println(droneId + " has low battery. Delivery cannot start.");
        }
    } 
    void displayStatus() {
        System.out.println("Drone ID: " + droneId);
        System.out.println("Battery: " + battryPercentage + "%");
        System.out.println("Company: " + companyName);
        System.out.println();
    }  
    public static void main(String[] args) {

        Drone d1 = new Drone("D101", 80);
        Drone d2 = new Drone("D102", 15);
        Drone d3 = new Drone("D103", 60);

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        System.out.println();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}

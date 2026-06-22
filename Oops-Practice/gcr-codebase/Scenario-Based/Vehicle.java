class Vehicle {

    String vehicleNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " " + v.ownerName);
            }
        }
    }

    static void displayBikes(Vehicle[] vehicles) {
        System.out.println("\nBikes:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("UP81A101", "Himanshu", "Car");
        vehicles[1] = new Vehicle("UP81B102", "Rahul", "Bike");
        vehicles[2] = new Vehicle("UP81A103", "Aman", "Car");
        vehicles[3] = new Vehicle("UP81B104", "Rohit", "Bike");
        vehicles[4] = new Vehicle("UP81A105", "Ankit", "Car");
        vehicles[5] = new Vehicle("UP81B106", "Mohit", "Bike");
        vehicles[6] = new Vehicle("UP81A107", "Karan", "Car");
        vehicles[7] = new Vehicle("UP81B108", "Sumit", "Bike");
        vehicles[8] = new Vehicle("UP81A109", "Deepak", "Car");
        vehicles[9] = new Vehicle("UP81B110", "Vikas", "Bike");

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}
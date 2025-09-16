class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;

    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int rentalDays = 0;

    public Vehicle(String vehicleId, String brand, String model, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    public double rentVehicle(int days) {
        if (!isAvailable) {
            System.out.println(vehicleId + " is not available for rent.");
            return 0;
        }
        double rent = calculateRent(days);
        isAvailable = false;
        System.out.println(vehicleId + " rented for " + days + " days. Rent: " + rent);
        return rent;
    }

    public void returnVehicle() {
        if (isAvailable) {
            System.out.println(vehicleId + " was not rented.");
        } else {
            isAvailable = true;
            System.out.println(vehicleId + " returned and available for rent again.");
        }
    }

    private double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        rentalDays += days;
        return rent;
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rent per Day: " + rentPerDay);
        System.out.println("Available: " + isAvailable);
        System.out.println();
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        if (rentalDays == 0) return 0;
        return totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Average Rent Per Day: " + getAverageRentPerDay());
        System.out.println();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("ZoomCars");

        Vehicle v1 = new Vehicle("V101", "Toyota", "Innova", 2000);
        Vehicle v2 = new Vehicle("V102", "Honda", "City", 1500);
        Vehicle v3 = new Vehicle("V103", "Suzuki", "Swift", 1000);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        v1.rentVehicle(3);
        v2.rentVehicle(2);

        v1.returnVehicle();
        v3.rentVehicle(4);

        Vehicle.displayCompanyStats();
    }
}

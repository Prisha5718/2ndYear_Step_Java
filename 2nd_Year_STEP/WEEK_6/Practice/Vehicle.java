class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 2000;
        this.engineType = "Petrol";
        this.registrationNumber = "REG123";
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = "REG" + (int)(Math.random() * 1000);
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
               ", Engine: " + engineType + ", RegNo: " + registrationNumber;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs → " + getVehicleInfo());
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType,
               int doors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = doors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car-specific checks completed. Car is ready to drive.");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car Specs → Doors: " + numberOfDoors + ", Fuel: " + fuelType +
                           ", Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] args) {
        System.out.println("\n--- Creating Car with default constructor ---");
        Car car1 = new Car();
        car1.start();
        car1.displaySpecs();
        car1.openTrunk();
        car1.stop();

        System.out.println("\n--- Creating Car with parameterized constructor ---");
        Car car2 = new Car("Toyota", "Camry", 2023, "Hybrid", 4, "Petrol", "Automatic");
        car2.start();
        car2.playRadio();
        car2.displaySpecs();
        car2.stop();
    }
}

// Vehicle.java
public abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();
}

// Maintainable.java
public interface Maintainable {
    void serviceInfo();
}

// Car.java
public class Car extends Vehicle implements Maintainable {
    private String model;

    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println("Car " + model + " engine started. Speed: " + speed + " km/h, Fuel: " + fuelType);
    }

    @Override
    public void serviceInfo() {
        System.out.println("Car " + model + " requires regular service every 5000 km.");
    }
}

// VehicleTest.java
public class VehicleTest {
    public static void main(String[] args) {
        Car myCar = new Car(120, "Petrol", "Sedan");
        myCar.startEngine();
        myCar.serviceInfo();
    }
}

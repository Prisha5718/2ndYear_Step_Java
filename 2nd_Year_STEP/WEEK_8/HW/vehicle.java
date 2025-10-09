// Vehicle.java
public abstract class Vehicle {
    public abstract void start();

    public void stop() {
        System.out.println("Vehicle stopped.");
    }
}

// Fuel.java
public interface Fuel {
    void refuel();
}

// Car.java
public class Car extends Vehicle implements Fuel {
    @Override
    public void start() {
        System.out.println("Car started with key.");
    }

    @Override
    public void refuel() {
        System.out.println("Car refueled with petrol.");
    }
}

// VehicleTest.java
public class VehicleTest {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.stop();
        myCar.refuel();
    }
}

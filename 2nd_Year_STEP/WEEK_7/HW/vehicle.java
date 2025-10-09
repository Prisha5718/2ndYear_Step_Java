class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void dispatch() {
        System.out.println("Dispatching vehicle: " + name);
    }
}

class Bus extends Vehicle {
    private int passengerCapacity;
    private String route;

    public Bus(String name, int passengerCapacity, String route) {
        super(name);
        this.passengerCapacity = passengerCapacity;
        this.route = route;
    }

    @Override
    public void dispatch() {
        System.out.println("Bus " + name + " on route " + route + " with capacity " + passengerCapacity + " passengers");
    }
}

class Taxi extends Vehicle {
    private double farePerKm;
    private double distance;

    public Taxi(String name, double farePerKm, double distance) {
        super(name);
        this.farePerKm = farePerKm;
        this.distance = distance;
    }

    @Override
    public void dispatch() {
        System.out.println("Taxi " + name + " providing door-to-door service. Fare: $" + (farePerKm * distance));
    }
}

class Train extends Vehicle {
    private int carCount;
    private String schedule;

    public Train(String name, int carCount, String schedule) {
        super(name);
        this.carCount = carCount;
        this.schedule = schedule;
    }

    @Override
    public void dispatch() {
        System.out.println("Train " + name + " with " + carCount + " cars operating on schedule: " + schedule);
    }
}

class Bike extends Vehicle {
    private boolean ecoFriendly;

    public Bike(String name, boolean ecoFriendly) {
        super(name);
        this.ecoFriendly = ecoFriendly;
    }

    @Override
    public void dispatch() {
        System.out.println("Bike " + name + (ecoFriendly ? " for short-distance eco-friendly trips" : ""));
    }
}

public class FleetManagementDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Bus("City Bus", 50, "Downtown Loop"),
            new Taxi("Yellow Cab", 2.5, 15),
            new Train("Express Train", 10, "09:00 AM"),
            new Bike("Eco Bike", true)
        };

        for (Vehicle v : fleet) {
            v.dispatch();
        }
    }
}

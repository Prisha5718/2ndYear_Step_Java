public class Assignment7 {
    static class Vehicle {
        String vehicleId;
        String brand;
        String model;
        int year;
        double mileage;
        String fuelType;
        String currentStatus;
        public Vehicle(String vehicleId,String brand,String model,int year,double mileage,String fuelType,String currentStatus) {
            this.vehicleId=vehicleId; this.brand=brand; this.model=model; this.year=year; this.mileage=mileage; this.fuelType=fuelType; this.currentStatus=currentStatus;
        }
        public double calculateRunningCost(double fuelPricePerLitre,double avgKmPerLitre,double km) {
            if (avgKmPerLitre<=0) return 0;
            return (km/avgKmPerLitre) * fuelPricePerLitre;
        }
        public void updateMileage(double km) { this.mileage += km; }
        public boolean checkServiceDue(double lastServiceKm) { return this.mileage - lastServiceKm >= 10000; }
    }

    static class Car extends Vehicle {
        int seatingCapacity;
        public Car(String id,String brand,String model,int year,double mileage,String fuelType,String status,int seatingCapacity) {
            super(id,brand,model,year,mileage,fuelType,status); this.seatingCapacity=seatingCapacity;
        }
    }

    static class Bus extends Vehicle {
        int seatingCapacity;
        public Bus(String id,String brand,String model,int year,double mileage,String fuelType,String status,int seatingCapacity) {
            super(id,brand,model,year,mileage,fuelType,status); this.seatingCapacity=seatingCapacity;
        }
    }

    static class Truck extends Vehicle {
        double loadCapacity;
        public Truck(String id,String brand,String model,int year,double mileage,String fuelType,String status,double loadCapacity) {
            super(id,brand,model,year,mileage,fuelType,status); this.loadCapacity=loadCapacity;
        }
    }

    static class Driver {
        String driverId;
        String driverName;
        String licenseType;
        Vehicle assignedVehicle;
        int totalTrips;
        public Driver(String driverId,String driverName,String licenseType) { this.driverId=driverId; this.driverName=driverName; this.licenseType=licenseType; }
        public void assignVehicle(Vehicle v) { this.assignedVehicle=v; }
    }

    static class FleetManager {
        List<Vehicle> vehicles = new ArrayList<>();
        List<Driver> drivers = new ArrayList<>();
        static int totalVehicles = 0;
        static double fleetValue = 0.0;
        static String companyName = "Atharv Transports";
        static double totalFuelConsumption = 0.0;

        public void addVehicle(Vehicle v,double value) { vehicles.add(v); totalVehicles++; fleetValue += value; }
        public void addDriver(Driver d) { drivers.add(d); }
        public void assignDriver(String driverId,String vehicleId) {
            Driver dr = findDriver(driverId); Vehicle v = findVehicle(vehicleId);
            if (dr!=null && v!=null) dr.assignVehicle(v);
        }
        public List<Vehicle> getVehiclesByType(Class<?> cls) {
            List<Vehicle> list = new ArrayList<>();
            for (Vehicle v: vehicles) if (cls.isInstance(v)) list.add(v);
            return list;
        }
        public double calculateTotalMaintenanceCost() {
            return vehicles.size() * 2000;
        }
        public double getFleetUtilization() {
            long inUse = vehicles.stream().filter(v->!"available".equalsIgnoreCase(v.currentStatus)).count();
            return vehicles.size()==0?0.0:(inUse*100.0)/vehicles.size();
        }
        private Driver findDriver(String id) { for(Driver d: drivers) if (d.driverId.equals(id)) return d; return null; }
        private Vehicle findVehicle(String id) { for(Vehicle v: vehicles) if (v.vehicleId.equals(id)) return v; return null; }
    }

    public static void main(String[] args) {
        FleetManager fm = new FleetManager();

        Car c1 = new Car("V001","Hyundai","i20",2021,25000,"Petrol","available",5);
        Bus b1 = new Bus("V002","Volvo","9700",2019,120000,"Diesel","in-service",50);
        Truck t1 = new Truck("V003","Tata","407",2018,90000,"Diesel","available",3000);

        fm.addVehicle(c1,600000);
        fm.addVehicle(b1,5000000);
        fm.addVehicle(t1,1800000);

        Driver d1 = new Driver("D001","Suresh","Commercial");
        Driver d2 = new Driver("D002","Meena","Commercial");
        fm.addDriver(d1); fm.addDriver(d2);

        fm.assignDriver("D001","V002");
        fm.assignDriver("D002","V001");

        c1.updateMileage(300);
        t1.updateMileage(500);

        System.out.println("Fleet Utilization: " + fm.getFleetUtilization() + "%");
        System.out.println("Total Maintenance Cost (estimate): " + fm.calculateTotalMaintenanceCost());
        System.out.println("Vehicles by type - Bus: " + fm.getVehiclesByType(Bus.class).size());
        System.out.println("Fleet Value: " + FleetManager.fleetValue);
    }
}
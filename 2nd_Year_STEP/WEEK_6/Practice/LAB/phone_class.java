class Phone {
    String brand;
    String model;

    Phone() {
        System.out.println("Phone default constructor");
    }

    Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone parameterized constructor");
    }
}

class SmartPhone extends Phone {
    String operatingSystem;

    SmartPhone() {
        super();
        System.out.println("SmartPhone default constructor");
    }

    SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone parameterized constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone();
        SmartPhone s2 = new SmartPhone("Samsung", "S24", "Android");
    }
}

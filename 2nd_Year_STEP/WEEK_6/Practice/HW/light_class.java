class Light {
    String type;
    int power;

    Light() {
        this("Generic", 0);
        System.out.println("Light default constructor");
    }

    Light(String type) {
        this(type, 60);
        System.out.println("Light single parameter constructor");
    }

    Light(String type, int power) {
        this.type = type;
        this.power = power;
        System.out.println("Light two parameter constructor");
    }
}

class LED extends Light {
    String color;

    LED() {
        this("LED", 10, "White");
        System.out.println("LED default constructor");
    }

    LED(String type, int power, String color) {
        super(type, power);
        this.color = color;
        System.out.println("LED three parameter constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        LED l1 = new LED();
        LED l2 = new LED("LED", 15, "Blue");
    }
}

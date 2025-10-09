class BasicMath {
    int calculate(int a, int b) {
        return a + b;
    }

    double calculate(double a, double b) {
        return a * b;
    }

    int calculate(int a) {
        return a * a;
    }
}

class AdvancedMath extends BasicMath {
    double calculate(double a, double b, double c) {
        return a + b + c;
    }

    int calculate(int a, int b, int c) {
        return a * b * c;
    }
}

public class Main {
    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();

        System.out.println(am.calculate(2, 3));
        System.out.println(am.calculate(2.0, 3.0));
        System.out.println(am.calculate(4));
        System.out.println(am.calculate(1, 2, 3));
        System.out.println(am.calculate(1.5, 2.5, 3.5));
    }
}

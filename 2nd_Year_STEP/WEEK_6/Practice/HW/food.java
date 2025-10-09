abstract class Food {
    final void prepare() {
        wash();
        cook();
        serve();
    }

    abstract void wash();
    abstract void cook();
    abstract void serve();
}

class Pizza extends Food {
    @Override
    void wash() {
        System.out.println("Washing ingredients for pizza");
    }

    @Override
    void cook() {
        System.out.println("Baking pizza in oven");
    }

    @Override
    void serve() {
        System.out.println("Serving pizza on plate");
    }
}

class Soup extends Food {
    @Override
    void wash() {
        System.out.println("Washing vegetables for soup");
    }

    @Override
    void cook() {
        System.out.println("Boiling soup");
    }

    @Override
    void serve() {
        System.out.println("Serving soup in bowl");
    }
}

public class Main {
    public static void main(String[] args) {
        Food f1 = new Pizza();
        Food f2 = new Soup();

        f1.prepare();
        f2.prepare();
    }
}

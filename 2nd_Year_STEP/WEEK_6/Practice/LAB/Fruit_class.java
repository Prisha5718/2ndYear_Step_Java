class Fruit {
    protected String color;
    protected String taste;
}

class Apple extends Fruit {
    String variety;

    Apple(String color, String taste, String variety) {
        this.color = color;
        this.taste = taste;
        this.variety = variety;
    }

    void display() {
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
        System.out.println("Variety: " + variety);
    }
}

public class Main {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.display();
    }
}

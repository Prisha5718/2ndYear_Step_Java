// Fruit.java
public abstract class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public abstract void showDetails();
}

// Edible.java
public interface Edible {
    void nutrientsInfo();
}

// Apple.java
public class Apple extends Fruit implements Edible {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    public void showDetails() {
        System.out.println("Apple - Color: " + color + ", Taste: " + taste + ", Variety: " + variety);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Apple is rich in vitamins and fiber.");
    }
}

// FruitTest.java
public class FruitTest {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Honeycrisp");
        a.showDetails();
        a.nutrientsInfo();
    }
}

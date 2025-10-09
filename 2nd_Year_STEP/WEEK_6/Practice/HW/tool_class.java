class Tool {
    private String type;
    protected String material;
    public String brand;

    Tool(String type, String material, String brand) {
        this.type = type;
        this.material = material;
        this.brand = brand;
    }

    String getType() {
        return type;
    }
}

class Hammer extends Tool {
    int weight;

    Hammer(String type, String material, String brand, int weight) {
        super(type, material, brand);
        this.weight = weight;
    }

    void display() {
        System.out.println("Type: " + getType());
        System.out.println("Material: " + material);
        System.out.println("Brand: " + brand);
        System.out.println("Weight: " + weight);
    }
}

public class Main {
    public static void main(String[] args) {
        Hammer h = new Hammer("Hammer", "Steel", "Stanley", 5);
        h.display();
    }
}

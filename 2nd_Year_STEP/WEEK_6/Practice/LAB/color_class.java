class Color {
    String name;

    Color(String name) {
        this.name = name;
        System.out.println("Color constructor");
    }
}

class PrimaryColor extends Color {
    String intensity;

    PrimaryColor(String name, String intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor");
    }
}

class RedColor extends PrimaryColor {
    String shade;

    RedColor(String name, String intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor constructor");
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Intensity: " + intensity);
        System.out.println("Shade: " + shade);
    }
}

public class Main {
    public static void main(String[] args) {
        RedColor r = new RedColor("Red", "High", "Dark Red");
        r.display();
    }
}

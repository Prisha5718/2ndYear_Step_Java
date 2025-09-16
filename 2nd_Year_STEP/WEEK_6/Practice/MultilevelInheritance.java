class Animal {
    protected String species;

    public Animal(String species) {
        this.species = species;
        System.out.println("Animal constructor: Creating " + species);
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }
}

class Mammal extends Animal {
    protected String furColor;

    public Mammal(String species, String furColor) {
        super(species);
        this.furColor = furColor;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }
}

class Dog extends Mammal {
    private String breed;

    public Dog(String species, String furColor, String breed) {
        super(species, furColor);
        this.breed = breed;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is eating happily");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Dog shows loyalty to owner");
    }
}

public class MultilevelInheritance{
    public static void main(String[] args) {
        Dog dog = new Dog("Canine", "Brown", "Labrador");
        System.out.println();

        dog.eat();
        dog.sleep();
        dog.move();
        dog.nurse();
        dog.bark();
        dog.fetch();
        dog.showLoyalty();

        System.out.println("\nChecking IS-A relationships:");
        System.out.println(dog instanceof Dog);     // true
        System.out.println(dog instanceof Mammal);  // true
        System.out.println(dog instanceof Animal);  // true
    }
}

// Animal.java
public interface Animal {
    void eat();
}

// Pet.java
public interface Pet extends Animal {
    void play();
}

// Dog.java
public class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing.");
    }
}

// PetTest.java
public class PetTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.play();
    }
}

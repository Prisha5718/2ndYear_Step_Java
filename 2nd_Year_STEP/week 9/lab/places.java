class Address implements Cloneable {
    String city;
    String state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    protected Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    protected Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = address.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + "]";
    }
}

public class places {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Mumbai", "Maharashtra");
        Person p1 = new Person("Alice", addr);

        Person shallow = p1.shallowClone();
        Person deep = p1.deepClone();

        shallow.address.city = "Pune";
        deep.address.city = "Delhi";

        System.out.println("Original: " + p1);
        System.out.println("Shallow Clone: " + shallow);
        System.out.println("Deep Clone: " + deep);
    }
}
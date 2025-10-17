class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phone;
    }}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    protected Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) contact.clone(); // deep copy
        return cloned;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", " + contact;
    }}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo c1 = new ContactInfo("john@example.com", "9876543210");
        Student s1 = new Student("S101", "John", c1);
        Student shallowCopy = (Student) s1.clone();
        Student deepCopy = s1.deepClone();

        System.out.println("Before modification:");
        System.out.println("Original: " + s1);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);

        s1.contact.email = "changed@example.com";

        System.out.println("\nAfter modifying original contact email:");
        System.out.println("Original: " + s1);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);
    }}
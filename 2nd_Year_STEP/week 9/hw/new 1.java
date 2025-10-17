class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Alice", 50000);
        Employee e2 = new Employee(102, "Bob", 60000);
        Employee e3 = new Employee(103, "Charlie", 55000);

        System.out.println(e1.toString());
        System.out.println(e1.getClass().getName());

        System.out.println(e2.toString());
        System.out.println(e2.getClass().getName());

        System.out.println(e3.toString());
        System.out.println(e3.getClass().getName());
    }
}
// Employee.java
public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void calculateBonus();
}

// Payable.java
public interface Payable {
    void generatePaySlip();
}

// Manager.java
public class Manager extends Employee implements Payable {
    private double bonus;

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void calculateBonus() {
        bonus = salary * 0.10;
        System.out.println("Manager " + name + " Bonus: $" + bonus);
    }

    @Override
    public void generatePaySlip() {
        System.out.println("PaySlip for " + name + ": Salary: $" + salary + ", Bonus: $" + bonus);
    }
}

// PayrollTest.java
public class PayrollTest {
    public static void main(String[] args) {
        Manager m = new Manager("Alice", 8000);
        m.calculateBonus();
        m.generatePaySlip();
    }
}

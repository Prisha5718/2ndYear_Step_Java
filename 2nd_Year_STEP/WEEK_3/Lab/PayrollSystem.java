import java.util.*;

class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;

    Employee(String empId, String empName, String department, double baseSalary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        totalEmployees++;
    }

    Employee(String empId, String empName, String department, double hourlyRate, int hours) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseSalary = hourlyRate * hours;
        this.empType = "Part-Time";
        totalEmployees++;
    }

    Employee(String empId, String empName, String department, double contractAmount, boolean isContract) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseSalary = contractAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    double calculateSalary(double bonus) {
        return baseSalary + bonus;
    }

    double calculateSalary(int hours, double hourlyRate) {
        return hours * hourlyRate;
    }

    double calculateSalary() {
        return baseSalary;
    }

    double calculateTax(double salary) {
        return salary * 0.2;
    }

    double calculateTax(double salary, double rate) {
        return salary * rate;
    }

    void generatePaySlip(double salary) {
        double tax = empType.equals("Full-Time") ? calculateTax(salary) : empType.equals("Part-Time") ? calculateTax(salary, 0.1) : calculateTax(salary, 0.15);
        System.out.println("Pay Slip");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        System.out.println("Salary: " + salary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Pay: " + (salary - tax));
        System.out.println("---------------");
    }

    void displayEmployeeInfo() {
        System.out.println(empId + " | " + empName + " | " + department + " | " + empType);
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("E101", "Alice", "IT", 50000);
        Employee e2 = new Employee("E102", "Bob", "HR", 200, 80);
        Employee e3 = new Employee("E103", "Charlie", "Finance", 40000, true);

        double salary1 = e1.calculateSalary(5000);
        double salary2 = e2.calculateSalary(80, 200);
        double salary3 = e3.calculateSalary();

        e1.generatePaySlip(salary1);
        e2.generatePaySlip(salary2);
        e3.generatePaySlip(salary3);

        e1.displayEmployeeInfo();
        e2.displayEmployeeInfo();
        e3.displayEmployeeInfo();

        Employee.displayTotalEmployees();
    }
}

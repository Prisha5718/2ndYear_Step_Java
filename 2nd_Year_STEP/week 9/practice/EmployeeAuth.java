class Employee {
    private String empCode;
    private String name;

    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return this.empCode.equals(other.empCode);
    }

    @Override
    public int hashCode() {
        return empCode.hashCode();
    }

    @Override
    public String toString() {
        return "Employee Code: " + empCode + ", Name: " + name;
    }
}

public class EmployeeAuth {
    public static void main(String[] args) {
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");

        System.out.println("Using == : " + (e1 == e2));
        System.out.println("Using equals(): " + e1.equals(e2));

        System.out.println(e1);
        System.out.println(e2);

        HashSet<Employee> empSet = new HashSet<>();
        empSet.add(e1);
        empSet.add(e2);

        System.out.println("HashSet contents: " + empSet);
        System.out.println("Total unique employees: " + empSet.size());
    }
}
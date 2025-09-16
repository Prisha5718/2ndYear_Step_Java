import java.util.Date;

public class EmployeeBean {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}

    public EmployeeBean(String id, String fn, String ln, double sal, String dept, Date hd, boolean active) {
        employeeId = id;
        firstName = fn;
        lastName = ln;
        salary = sal;
        department = dept;
        hireDate = hd;
        isActive = active;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String id) { employeeId = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String fn) { firstName = fn; }

    public String getLastName() { return lastName; }
    public void setLastName(String ln) { lastName = ln; }

    public double getSalary() { return salary; }
    public void setSalary(double sal) { salary = sal; }

    public String getDepartment() { return department; }
    public void setDepartment(String dept) { department = dept; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hd) { hireDate = hd; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
	
    public String getFullName() { return firstName + " " + lastName; }

    @Override
    public String toString() {
        return employeeId + " - " + getFullName() + " - " + department;
    }

    public static void main(String[] args) {
        EmployeeBean emp = new EmployeeBean("E001", "John", "Doe", 50000, "IT", new Date(), true);
        System.out.println(emp);
        System.out.println("Full Name: " + emp.getFullName());
    }
}

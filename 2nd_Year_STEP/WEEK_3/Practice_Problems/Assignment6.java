public class Assignment6 {
    static abstract class Employee {
        String empId;
        String empName;
        String department;
        String designation;
        double baseSalary;
        String joinDate;
        boolean[] attendanceRecord;
        public Employee(String empId,String empName,String department,String designation,double baseSalary,String joinDate) {
            this.empId=empId; this.empName=empName; this.department=department; this.designation=designation; this.baseSalary=baseSalary; this.joinDate=joinDate;
            attendanceRecord = new boolean[30];
        }
        public void markAttendance(int day, boolean present) { if (day>=1 && day<=30) attendanceRecord[day-1]=present; }
        public abstract double calculateSalary();
        public double calculateBonus() { return calculateSalary()*0.10; }
        public String generatePaySlip() {
            return empId + " | " + empName + " | Salary: " + String.format("%.2f",calculateSalary()) + " | Bonus: " + String.format("%.2f",calculateBonus());
        }
    }

    static class FullTime extends Employee {
        public FullTime(String empId,String empName,String department,String designation,double baseSalary,String joinDate) { super(empId,empName,department,designation,baseSalary,joinDate); }
        public double calculateSalary() {
            int present=0; for(boolean b:attendanceRecord) if (b) present++;
            return baseSalary * (present/30.0);
        }
    }

    static class PartTime extends Employee {
        int hoursPerDay;
        double hourlyRate;
        public PartTime(String empId,String empName,String department,String designation,double hourlyRate,int hoursPerDay,String joinDate) {
            super(empId,empName,department,designation,0.0,joinDate);
            this.hoursPerDay=hoursPerDay; this.hourlyRate=hourlyRate;
        }
        public double calculateSalary() {
            int present=0; for(boolean b:attendanceRecord) if (b) present++;
            return present * hoursPerDay * hourlyRate;
        }
    }

    static class Contract extends Employee {
        double contractAmount;
        public Contract(String empId,String empName,String department,String designation,double contractAmount,String joinDate) {
            super(empId,empName,department,designation,contractAmount,joinDate);
            this.contractAmount = contractAmount;
        }
        public double calculateSalary() { return contractAmount; }
    }

    static class Department {
        String deptId;
        String deptName;
        Employee manager;
        List<Employee> employees = new ArrayList<>();
        double budget;
        public Department(String deptId,String deptName,Employee manager,double budget) { this.deptId=deptId; this.deptName=deptName; this.manager=manager; this.budget=budget; }
        public void addEmployee(Employee e) { employees.add(e); }
    }

    static class Company {
        static int totalEmployees = 0;
        static String companyName = "Atharv Solutions";
        static double totalSalaryExpense = 0.0;
        static int workingDaysPerMonth = 30;
        List<Department> departments = new ArrayList<>();

        public void addDepartment(Department d) { departments.add(d); }

        public static double calculateCompanyPayroll(Company c) {
            double total=0;
            for (Department d: c.departments) for (Employee e: d.employees) total += e.calculateSalary();
            totalSalaryExpense = total;
            return total;
        }

        public static Map<String,Double> getDepartmentWiseExpenses(Company c) {
            Map<String,Double> map = new HashMap<>();
            for (Department d: c.departments) {
                double tot=0; for (Employee e: d.employees) tot += e.calculateSalary();
                map.put(d.deptName, tot);
            }
            return map;
        }

        public static Map<String,Integer> getAttendanceReport(Company c) {
            Map<String,Integer> map = new HashMap<>();
            for (Department d: c.departments) for (Employee e: d.employees) {
                int present=0; for(boolean b:e.attendanceRecord) if (b) present++;
                map.put(e.empName, present);
            }
            return map;
        }
    }

    public static void main(String[] args) {
        FullTime e1 = new FullTime("E001","Arun","Engineering","SDE",60000,"2022-03-01");
        PartTime e2 = new PartTime("E002","Kavita","Support","SupportEng",200,4,"2023-01-15");
        Contract e3 = new Contract("E003","Sam","Engineering","Consultant",40000,"2025-02-01");

        for (int i=1;i<=22;i++) e1.markAttendance(i,true);
        for (int i=1;i<=20;i++) e2.markAttendance(i,true);
        for (int i=1;i<=30;i++) e3.markAttendance(i,true);

        Department eng = new Department("D01","Engineering",e1,500000);
        eng.addEmployee(e1); eng.addEmployee(e3);
        Department sup = new Department("D02","Support",e2,200000);
        sup.addEmployee(e2);

        Company comp = new Company();
        comp.addDepartment(eng); comp.addDepartment(sup);

        System.out.println(e1.generatePaySlip());
        System.out.println(e2.generatePaySlip());
        System.out.println(e3.generatePaySlip());

        System.out.println("Company Payroll: " + Company.calculateCompanyPayroll(comp));
        System.out.println("Department Expenses: " + Company.getDepartmentWiseExpenses(comp));
        System.out.println("Attendance Report: " + Company.getAttendanceReport(comp));
    }
}
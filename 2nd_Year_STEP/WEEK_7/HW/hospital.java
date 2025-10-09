class MedicalStaff {
    protected String name;
    protected int id;

    public MedicalStaff(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void scheduleShift() {
        System.out.println(name + " (ID: " + id + ") shift scheduled.");
    }

    public void accessIDCard() {
        System.out.println(name + " (ID: " + id + ") ID card access granted.");
    }

    public void processPayroll() {
        System.out.println(name + " (ID: " + id + ") payroll processed.");
    }
}

class Doctor extends MedicalStaff {
    public Doctor(String name, int id) {
        super(name, id);
    }

    public void diagnose() {
        System.out.println(name + " is diagnosing patients.");
    }

    public void prescribeMedicine() {
        System.out.println(name + " is prescribing medicine.");
    }

    public void performSurgery() {
        System.out.println(name + " is performing surgery.");
    }
}

class Nurse extends MedicalStaff {
    public Nurse(String name, int id) {
        super(name, id);
    }

    public void administerMedicine() {
        System.out.println(name + " is administering medicine.");
    }

    public void monitorPatients() {
        System.out.println(name + " is monitoring patients.");
    }

    public void assistProcedure() {
        System.out.println(name + " is assisting in procedure.");
    }
}

class Technician extends MedicalStaff {
    public Technician(String name, int id) {
        super(name, id);
    }

    public void operateEquipment() {
        System.out.println(name + " is operating equipment.");
    }

    public void runTests() {
        System.out.println(name + " is running tests.");
    }

    public void maintainInstruments() {
        System.out.println(name + " is maintaining instruments.");
    }
}

class Administrator extends MedicalStaff {
    public Administrator(String name, int id) {
        super(name, id);
    }

    public void scheduleAppointments() {
        System.out.println(name + " is scheduling appointments.");
    }

    public void manageRecords() {
        System.out.println(name + " is managing records.");
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        MedicalStaff[] staff = {
            new Doctor("Dr. Smith", 101),
            new Nurse("Nurse Amy", 102),
            new Technician("Tech John", 103),
            new Administrator("Admin Kate", 104)
        };

        for (MedicalStaff m : staff) {
            m.scheduleShift();
            m.accessIDCard();
            m.processPayroll();

            if (m instanceof Doctor d) {
                d.diagnose();
                d.prescribeMedicine();
                d.performSurgery();
            } else if (m instanceof Nurse n) {
                n.administerMedicine();
                n.monitorPatients();
                n.assistProcedure();
            } else if (m instanceof Technician t) {
                t.operateEquipment();
                t.runTests();
                t.maintainInstruments();
            } else if (m instanceof Administrator a) {
                a.scheduleAppointments();
                a.manageRecords();
            }

            System.out.println();
        }
    }
}

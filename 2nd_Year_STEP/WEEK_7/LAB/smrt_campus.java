class SmartDevice {
    protected String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void basicStatus() {
        System.out.println(deviceName + " is connected and operational.");
    }
}

class SmartClassroom extends SmartDevice {
    private boolean lightsOn;
    private boolean acOn;
    private boolean projectorOn;

    public SmartClassroom(String deviceName, boolean lightsOn, boolean acOn, boolean projectorOn) {
        super(deviceName);
        this.lightsOn = lightsOn;
        this.acOn = acOn;
        this.projectorOn = projectorOn;
    }

    public void controlClassroom() {
        System.out.println("Classroom " + deviceName + ": Lights " + (lightsOn ? "On" : "Off") + ", AC " + (acOn ? "On" : "Off") + ", Projector " + (projectorOn ? "On" : "Off"));
    }
}

class SmartLab extends SmartDevice {
    private boolean equipmentOn;
    private boolean safetyActive;

    public SmartLab(String deviceName, boolean equipmentOn, boolean safetyActive) {
        super(deviceName);
        this.equipmentOn = equipmentOn;
        this.safetyActive = safetyActive;
    }

    public void controlLab() {
        System.out.println("Lab " + deviceName + ": Equipment " + (equipmentOn ? "On" : "Off") + ", Safety Systems " + (safetyActive ? "Active" : "Inactive"));
    }
}

class SmartLibrary extends SmartDevice {
    private int occupancy;
    private int availableBooks;

    public SmartLibrary(String deviceName, int occupancy, int availableBooks) {
        super(deviceName);
        this.occupancy = occupancy;
        this.availableBooks = availableBooks;
    }

    public void controlLibrary() {
        System.out.println("Library " + deviceName + ": Occupancy " + occupancy + ", Books Available " + availableBooks);
    }
}

public class SmartCampusDemo {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("Room 101", true, true, false),
            new SmartLab("Chem Lab", true, true),
            new SmartLibrary("Central Library", 120, 5000)
        };

        for (SmartDevice d : devices) {
            d.basicStatus();

            if (d instanceof SmartClassroom sc) {
                sc.controlClassroom();
            } else if (d instanceof SmartLab sl) {
                sl.controlLab();
            } else if (d instanceof SmartLibrary slb) {
                slb.controlLibrary();
            }

            System.out.println();
        }
    }
}

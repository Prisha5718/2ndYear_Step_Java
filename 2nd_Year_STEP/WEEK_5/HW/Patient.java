public class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;

    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;

    private int roomNumber;
    private String attendingPhysician;

    public Patient(String patientId, MedicalRecord medicalRecord, String currentName, String emergencyContact, String insuranceInfo, int roomNumber, String attendingPhysician) {
        this.patientId = patientId;
        this.medicalRecord = medicalRecord;
        this.currentName = currentName;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
        this.roomNumber = roomNumber;
        this.attendingPhysician = attendingPhysician;
    }

    String getBasicInfo() {
        return "Name: " + currentName + ", Room: " + roomNumber + ", Physician: " + attendingPhysician;
    }

    public String getPublicInfo() {
        return "Name: " + currentName + ", Room: " + roomNumber;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(String attendingPhysician) {
        this.attendingPhysician = attendingPhysician;
    }

    public String getPatientId() {
        return patientId;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }
}

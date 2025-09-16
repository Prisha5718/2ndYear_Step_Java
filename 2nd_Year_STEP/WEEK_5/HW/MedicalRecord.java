import java.time.LocalDate;
import java.util.Arrays;

public final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies, String[] medicalHistory, LocalDate birthDate, String bloodType) {
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies.clone();           
        this.medicalHistory = medicalHistory.clone(); 
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getPatientDNA() {
        return patientDNA;
    }

    public String[] getAllergies() {
        return allergies.clone(); 
    }

    public String[] getMedicalHistory() {
        return medicalHistory.clone();  
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public final boolean isAllergicTo(String substance) {
        for (String allergy : allergies) {
            if (allergy.equalsIgnoreCase(substance)) {
                return true;
            }
        }
        return false;
    }
}

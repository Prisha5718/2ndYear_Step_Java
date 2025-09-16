public class Assignment8 {
    static class Patient {
        String patientId;
        String patientName;
        int age;
        String gender;
        String contactInfo;
        List<String> medicalHistory = new ArrayList<>();
        List<String> currentTreatments = new ArrayList<>();
        public Patient(String patientId,String patientName,int age,String gender,String contactInfo) {
            this.patientId=patientId; this.patientName=patientName; this.age=age; this.gender=gender; this.contactInfo=contactInfo;
        }
    }

    static class Doctor {
        String doctorId;
        String doctorName;
        String specialization;
        List<String> availableSlots = new ArrayList<>();
        int patientsHandled;
        double consultationFee;
        public Doctor(String doctorId,String doctorName,String specialization,double fee) {
            this.doctorId=doctorId; this.doctorName=doctorName; this.specialization=specialization; this.consultationFee=fee;
        }
    }

    static class Appointment {
        String appointmentId;
        Patient patient;
        Doctor doctor;
        String appointmentDate;
        String appointmentTime;
        String status;
        String type;
        public Appointment(String appointmentId, Patient patient, Doctor doctor, String date, String time, String type) {
            this.appointmentId=appointmentId; this.patient=patient; this.doctor=doctor; this.appointmentDate=date; this.appointmentTime=time; this.status="Scheduled"; this.type=type;
        }
    }

    static class Hospital {
        Map<String,Patient> patients = new HashMap<>();
        Map<String,Doctor> doctors = new HashMap<>();
        Map<String,Appointment> appointments = new HashMap<>();
        static int totalPatients = 0;
        static int totalAppointments = 0;
        static String hospitalName = "Atharv Hospital";
        static double totalRevenue = 0.0;

        public void addPatient(Patient p) { patients.put(p.patientId,p); totalPatients++; }
        public void addDoctor(Doctor d) { doctors.put(d.doctorId,d); }

        public Appointment scheduleAppointment(String pid, String did, String date, String time, String type) {
            Patient p = patients.get(pid); Doctor d = doctors.get(did);
            if (p==null || d==null) return null;
            String aid = "AP" + (totalAppointments+1);
            Appointment a = new Appointment(aid,p,d,date,time,type);
            appointments.put(aid,a);
            totalAppointments++;
            d.patientsHandled++;
            return a;
        }

        public boolean cancelAppointment(String appointmentId) {
            Appointment a = appointments.remove(appointmentId);
            if (a!=null) { totalAppointments = Math.max(0,totalAppointments-1); return true; }
            return false;
        }

        public double generateBill(String appointmentId) {
            Appointment a = appointments.get(appointmentId);
            if (a==null) return 0.0;
            double amt = a.doctor.consultationFee;
            if ("Emergency".equalsIgnoreCase(a.type)) amt *= 2;
            totalRevenue += amt;
            return amt;
        }

        public void updateTreatment(String patientId, String treatment) {
            Patient p = patients.get(patientId);
            if (p!=null) p.currentTreatments.add(treatment);
        }

        public void dischargePatient(String patientId) {
            patients.remove(patientId);
        }

        public static String generateHospitalReport(Hospital h) {
            return "Hospital: " + hospitalName + " | Total Patients: " + totalPatients + " | Total Appointments: " + totalAppointments + " | Revenue: " + totalRevenue;
        }

        public static Map<String,Integer> getDoctorUtilization(Hospital h) {
            Map<String,Integer> map = new HashMap<>();
            for (Doctor d: h.doctors.values()) map.put(d.doctorName, d.patientsHandled);
            return map;
        }

        public static Map<String,Integer> getPatientStatistics(Hospital h) {
            Map<String,Integer> map = new HashMap<>();
            map.put("RegisteredPatients", h.patients.size());
            map.put("Appointments", h.appointments.size());
            return map;
        }
    }

    public static void main(String[] args) {
        Hospital hosp = new Hospital();
        Doctor d1 = new Doctor("D001","Dr. Rao","Cardiology",1500);
        Doctor d2 = new Doctor("D002","Dr. Sen","General",800);
        hosp.addDoctor(d1); hosp.addDoctor(d2);

        Patient p1 = new Patient("P001","Sita",30,"F","9998887777");
        Patient p2 = new Patient("P002","Vikram",45,"M","8887776666");
        hosp.addPatient(p1); hosp.addPatient(p2);

        Appointment a1 = hosp.scheduleAppointment("P001","D001","2025-09-05","10:00","Consultation");
        Appointment a2 = hosp.scheduleAppointment("P002","D002","2025-09-05","11:00","Emergency");

        System.out.println("Appointment IDs: " + a1.appointmentId + ", " + a2.appointmentId);
        System.out.println("Bill for " + a1.appointmentId + ": " + hosp.generateBill(a1.appointmentId));
        System.out.println("Bill for " + a2.appointmentId + ": " + hosp.generateBill(a2.appointmentId));

        hosp.updateTreatment("P002","Stabilization");
        System.out.println(Hospital.generateHospitalReport(hosp));
        System.out.println("Doctor Utilization: " + Hospital.getDoctorUtilization(hosp));
        System.out.println("Patient Stats: " + Hospital.getPatientStatistics(hosp));
    }
}
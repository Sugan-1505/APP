package q2;

import q2.doctor.Doctor;
import q2.patient.Patient;

public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor(1, "Dr. Arun", "Cardiology", 600);
        Doctor d2 = new Doctor(2, "Dr. Priya", "Dermatology", 500);

        Patient p1 = new Patient(101, "Ravi", "Heart Pain", 45);
        Patient p2 = new Patient(102, "Meena", "Skin Allergy", 28);
        Patient p3 = new Patient(103, "Kumar", "High Blood Pressure", 52);

        Doctor[] assignedDoctors = {d1, d2, d1};
        Patient[] patients = {p1, p2, p3};
        int d1Count = 0, d2Count = 0;

        for (int i = 0; i < patients.length; i++) {
            System.out.println("\n--- Patient and Treating Doctor ---");
            patients[i].displayPatient();
            System.out.println("Treating Doctor:");
            assignedDoctors[i].displayDoctor();
            if (assignedDoctors[i].getDoctorId() == d1.getDoctorId()) d1Count++;
            else if (assignedDoctors[i].getDoctorId() == d2.getDoctorId()) d2Count++;
        }

        System.out.println("\n--- Total Consultation Fee Collected ---");
        System.out.println(d1.getName() + ": Rs." + (d1Count * d1.getConsultationFee()));
        System.out.println(d2.getName() + ": Rs." + (d2Count * d2.getConsultationFee()));
    }
}

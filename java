import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease;
    }
}

public class HospitalManagement {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static int patientIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    System.out.println("Exiting the system. Stay healthy!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter patient name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        System.out.print("Enter patient disease: ");
        scanner.nextLine(); // Consume newline
        String disease = scanner.nextLine();

        Patient newPatient = new Patient(patientIdCounter++, name, age, disease);
        patients.add(newPatient);
        System.out.println("Patient added successfully!");
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\n--- Patient List ---");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
}

package com.hospital;

import java.util.Scanner;
import com.hospital.dao.PatientDAO;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        while (true) {

            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Exit");

            System.out.print("\nEnter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();

                    System.out.print("Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("Blood Group: ");
                    String bloodGroup = sc.nextLine();

                    System.out.print("Disease: ");
                    String disease = sc.nextLine();

                    Patient patient = new Patient(
                            firstName,
                            lastName,
                            gender,
                            age,
                            phone,
                            address,
                            bloodGroup,
                            disease);

                    dao.addPatient(patient);
                    break;

                case 2:
                    dao.viewPatients();
                    break;

                case 3:

                    System.out.print("Enter Patient ID: ");
                    int searchId = sc.nextInt();

                    dao.searchPatient(searchId);
                    break;

                case 4:

                    System.out.print("Enter Patient ID: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    dao.updatePatient(updateId, newPhone);
                    break;

                case 5:

                    System.out.print("Enter Patient ID: ");
                    int deleteId = sc.nextInt();

                    dao.deletePatient(deleteId);
                    break;

                case 6:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");

            }

        }

    }
}
package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospital.Patient;
import com.hospital.config.DBConnection;

public class PatientDAO {

    public void addPatient(Patient patient) {

        String sql = "INSERT INTO patients(first_name,last_name,gender,age,phone,address,blood_group,disease) VALUES(?,?,?,?,?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getGender());
            ps.setInt(4, patient.getAge());
            ps.setString(5, patient.getPhone());
            ps.setString(6, patient.getAddress());
            ps.setString(7, patient.getBloodGroup());
            ps.setString(8, patient.getDisease());

            ps.executeUpdate();

            System.out.println("Patient Added Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void viewPatients() {

    String sql = "SELECT * FROM patients";

    try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
    ) {

        System.out.println("\n===== PATIENT LIST =====\n");

        while (rs.next()) {

            System.out.println("ID          : " + rs.getInt("patient_id"));
            System.out.println("Name        : " + rs.getString("first_name") + " " + rs.getString("last_name"));
            System.out.println("Gender      : " + rs.getString("gender"));
            System.out.println("Age         : " + rs.getInt("age"));
            System.out.println("Phone       : " + rs.getString("phone"));
            System.out.println("Address     : " + rs.getString("address"));
            System.out.println("Blood Group : " + rs.getString("blood_group"));
            System.out.println("Disease     : " + rs.getString("disease"));
            System.out.println("---------------------------------------");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void searchPatient(int patientId) {

    String sql = "SELECT * FROM patients WHERE patient_id = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
    ) {

        ps.setInt(1, patientId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("\n===== PATIENT FOUND =====");

            System.out.println("ID          : " + rs.getInt("patient_id"));
            System.out.println("Name        : " + rs.getString("first_name") + " " + rs.getString("last_name"));
            System.out.println("Gender      : " + rs.getString("gender"));
            System.out.println("Age         : " + rs.getInt("age"));
            System.out.println("Phone       : " + rs.getString("phone"));
            System.out.println("Address     : " + rs.getString("address"));
            System.out.println("Blood Group : " + rs.getString("blood_group"));
            System.out.println("Disease     : " + rs.getString("disease"));

        } else {

            System.out.println("Patient not found.");

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void updatePatient(int patientId, String newPhone) {

    String sql = "UPDATE patients SET phone = ? WHERE patient_id = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
    ) {

        ps.setString(1, newPhone);
        ps.setInt(2, patientId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Patient Updated Successfully!");
        } else {
            System.out.println("Patient Not Found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void deletePatient(int patientId) {

    String sql = "DELETE FROM patients WHERE patient_id = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
    ) {

        ps.setInt(1, patientId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Patient Deleted Successfully!");
        } else {
            System.out.println("Patient Not Found!");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
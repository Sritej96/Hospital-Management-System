USE hospital_management;

CREATE TABLE IF NOT EXISTS patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender ENUM('Male','Female','Other') NOT NULL,
    age INT NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(200),
    blood_group VARCHAR(5),
    disease VARCHAR(100),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
USE hospital_management;
SELECT * FROM patients;
DELETE FROM patients;
TRUNCATE TABLE patients;
SELECT * FROM patients;
SET SQL_SAFE_UPDATES = 0;




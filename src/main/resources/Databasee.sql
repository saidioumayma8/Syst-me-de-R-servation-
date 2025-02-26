CREATE DATABASE doctorrv;
USE doctorrv;

CREATE TABLE Patient (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(255),
                        Telephone VARCHAR(20)
);

CREATE TABLE doctor (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
);

CREATE TABLE reservation (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            datereserv DATE NOT NULL,
                            patientID INT,
                            doctorID INT,
                            FOREIGN KEY (patientID) REFERENCES Patient(id) ON DELETE CASCADE,
                            FOREIGN KEY (doctorID) REFERENCES Doctor(id) ON DELETE CASCADE
);
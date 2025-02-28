CREATE DATABASE doctorrv;
USE doctorrv;

CREATE TABLE doctor (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
);

CREATE TABLE reservation (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            date_reservation DATE NOT NULL,
                            patientID INT,
                            doctorID INT,
                            motif varchar(100),
                            status varchar(100),
                            FOREIGN KEY (patientID) REFERENCES Patient(id) ON DELETE CASCADE,
                            FOREIGN KEY (doctorID) REFERENCES Doctor(id) ON DELETE CASCADE
);
CREATE TABLE User (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      email VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      role_id INT,
                      FOREIGN KEY (role_id) REFERENCES Role(id) ON DELETE SET NULL
);

CREATE TABLE Role (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      role_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Patient (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         phone VARCHAR(20),
                         FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE
);

CREATE TABLE Doctor (
                        doctorID INT PRIMARY KEY AUTO_INCREMENT,
                        userID INT UNIQUE NOT NULL,
                        specialty VARCHAR(100),
                        FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE
);



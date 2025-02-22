package com.Model;

import java.util.Date;

public class Reservation{
    private int reservID;
    private int PatientID;
    private String Status;
    private String Motif;
    private Date dateReservation;
    private int medID;

    public Reservation() {
    }

    // Constructor
    public Reservation(int PatientID, String Status, String Motif, Date dateReservation) {
        this.PatientID = PatientID;
        this.Status = Status;
        this.Motif = Motif;
        this.dateReservation = dateReservation;
    }

    // Getters and setters
    public int getReservID() {
        return reservID;
    }
    public void setReservID(int reservID) {
        this.reservID = reservID;
    }

    public int getPatientID() {
        return PatientID;
    }
    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public String getStatus() {
        return Status;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getMotif() {
        return Motif;
    }
    public void setMotif(String Motif) {
        this.Motif = Motif;
    }

    public Date getDateReservation() {
        return dateReservation;
    }
    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getMedID() {
        return medID;
    }
    public void setMedID(int medID) {
        this.medID = medID;
    }

}

package models;

import utils.AppointmentFileHandler;
import models.Appointment;
import java.io.IOException;
import java.util.List;

public class Doctor extends User {
    private String location;
    private String specialization;
    private String contact;

    public Doctor(String name, String phoneNumber, String email, String userName, String password, String location) {
        super(name, phoneNumber, email, "Doctor", userName, password);
        this.location = location;
    }

    public Doctor(String username, String password, String name, String email) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.specialization = "";
        this.contact = "";
    }


    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public List<Appointment> getMyAppointments() {
        try {
            return AppointmentFileHandler.getAppointmentsByDoctorName(this.getName());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
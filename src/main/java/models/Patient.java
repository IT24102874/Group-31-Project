package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Patient extends User {

    private List<Appointment> appointments;

    public Patient(String name, String username, String password, String email, String role) {
        super();
        this.appointments = new ArrayList<>();
    }


    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }


    public boolean cancelAppointment(String doctor, String date, String time) {
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment a = iterator.next();
            if (a.getDoctor().equalsIgnoreCase(doctor)
                    && a.getDate().equalsIgnoreCase(date)
                    && a.getTime().equalsIgnoreCase(time)) {
                iterator.remove();
                System.out.println("Appointment cancelled: " + a.getDoctor() + " on " + a.getDate() + " at " + a.getTime());
                return true;
            }
        }
        System.out.println("No matching appointment found to cancel.");
        return false;
    }


    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("Appointments for " + getUserName() + ":");
            for (Appointment app : appointments) {
                System.out.println("- Doctor: " + app.getDoctor() +
                        ", Date: " + app.getDate() +
                        ", Time: " + app.getTime());
            }
        }
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }


    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}

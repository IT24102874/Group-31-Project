package dsa;

import models.Appointment;
import utils.AppointmentFileHandler;
import java.util.List;

public class PriorityQueueHeapTest {
    public static void main(String[] args) {

        PriorityQueueHeap pq = new PriorityQueueHeap();


        System.out.println("Loading the appointments from the file.");
        try {
            pq.loadFromFile();

        } catch (Exception e) {
            System.err.println("Error loading from file: " + e.getMessage());
            return;
        }


        System.out.println("Appointments after sorting them according to the urgency.");
        List<Appointment> sortedAppointments = pq.getSortedAppointments();
        if (sortedAppointments.isEmpty()) {
            System.out.println("No appointments found in the file.");
        } else {
            for (Appointment appt : sortedAppointments) {
                System.out.println("Name: " + appt.getName() + ", Urgency: " + appt.getUrgencyScore() +
                        ", Time: " + appt.getTime());
            }
        }


        System.out.println( "Dequeueing appointments");
        if (pq.isEmpty()) {
            System.out.println("Queue is empty, no appointments to dequeue.");
        } else {
            while (!pq.isEmpty()) {
                Appointment appt = pq.dequeue();
                System.out.println("Dequeued: " + appt.getName() + ", Urgency: " + appt.getUrgencyScore() +
                        ", Time: " + appt.getTime());
            }

        }
    }
}
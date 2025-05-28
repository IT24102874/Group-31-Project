package dsa;

import models.Appointment;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import utils.AppointmentFileHandler;

public class PriorityQueueHeap {
    private List<Appointment> heap;
    private int heapSize;

    public PriorityQueueHeap() {
        this.heap = new ArrayList<>();
        this.heapSize = 0;

        this.heap.add(null);
    }

    // HEAP_INSERT
    public void enqueue(Appointment appointment) {
        heapSize = heapSize + 1;
        heap.add(appointment);
        int i = heapSize;
        while (i > 1 && compareAppointments(appointment, heap.get(parent(i))) > 0) {
            heap.set(i, heap.get(parent(i)));
            i = parent(i);
        }
        heap.set(i, appointment);
    }

    // HEAP_EXTRACT_MAX
    public Appointment dequeue() {
        if (heapSize < 1) {
            return null;
        }
        Appointment max = heap.get(1);
        heap.set(1, heap.get(heapSize));
        heapSize = heapSize - 1;
        heap.remove(heapSize + 1);
        if (heapSize > 0) {
            maxHeapify(1);
        }
        return max;
    }

    // MAX_HEAPIFY
    private void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l <= heapSize && compareAppointments(heap.get(l), heap.get(i)) > 0) {
            largest = l;
        }
        if (r <= heapSize && compareAppointments(heap.get(r), heap.get(largest)) > 0) {
            largest = r;
        }
        if (largest != i) {

            Appointment temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            maxHeapify(largest);
        }
    }


    public boolean isEmpty() {
        return heapSize == 0;
    }


    public int size() {
        return heapSize;
    }


    public List<Appointment> getSortedAppointments() {
        List<Appointment> sorted = new ArrayList<>();
        PriorityQueueHeap temp = new PriorityQueueHeap();


        for (int i = 1; i <= heapSize; i++) {
            temp.enqueue(heap.get(i));
        }


        while (!temp.isEmpty()) {
            sorted.add(temp.dequeue());
        }


        bubbleSortByTime(sorted);

        return sorted;
    }


    private void bubbleSortByTime(List<Appointment> appointments) {
        int n = appointments.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                Appointment a1 = appointments.get(j);
                Appointment a2 = appointments.get(j + 1);
                if (a1.getUrgencyScore() == a2.getUrgencyScore()) {
                    LocalTime time1 = LocalTime.parse(a1.getTime());
                    LocalTime time2 = LocalTime.parse(a2.getTime());
                    if (time1.isAfter(time2)) {
                        appointments.set(j, a2);
                        appointments.set(j + 1, a1);
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    private int compareAppointments(Appointment a1, Appointment a2) {
        if (a1 == null || a2 == null) return 0;
        if (a1.getUrgencyScore() != a2.getUrgencyScore()) {
            return a1.getUrgencyScore() - a2.getUrgencyScore();
        }

        LocalTime time1 = LocalTime.parse(a1.getTime());
        LocalTime time2 = LocalTime.parse(a2.getTime());
        return time1.compareTo(time2);
    }


    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {

        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }


    public void loadFromFile() throws Exception {
        List<Appointment> appointments = AppointmentFileHandler.readAppointmentsFromFile();
        for (Appointment appt : appointments) {
            enqueue(appt);
        }
    }
}
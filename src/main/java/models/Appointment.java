package models;

public class Appointment {
    private String username;  // NEW FIELD
    private String name;
    private int age;
    private String contact;
    private String gender;
    private String doctor;
    private String date;
    private String time;
    private String q1;
    private String q2;
    private String q3;
    private String status;


    public Appointment() {}

    public Appointment(String name, String doctor, String date, String time) {
        this.name = name;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getQ1() { return q1; }
    public void setQ1(String q1) { this.q1 = q1; }

    public String getQ2() { return q2; }
    public void setQ2(String q2) { this.q2 = q2; }

    public String getQ3() { return q3; }
    public void setQ3(String q3) { this.q3 = q3; }

    public String getStatus() { return "Pending"; }
    public void setStatus(String status) { this.status = status; }

}
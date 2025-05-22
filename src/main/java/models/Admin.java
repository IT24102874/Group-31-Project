package models;

import java.util.Date;

public class Admin {
    private int adminId;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String role;
    private Date lastLogin;
    private boolean isActive;

    // Default Constructor
    public Admin() {
        this.isActive = true;
    }

    // Parameterized Constructor
    public Admin(int adminId, String username, String password, String email, String fullName) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.role = "ADMIN";
        this.isActive = true;
        this.lastLogin = new Date();
    }

    // Getters and Setters
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Basic Admin Authentication Methods
    public boolean validateCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public boolean hasAdminPrivileges() {
        return "ADMIN".equals(this.role) && this.isActive;
    }

    // Appointment Management Methods
    public boolean canManageAppointments() {
        return hasAdminPrivileges();
    }

    public boolean canCancelAppointment() {
        return hasAdminPrivileges();
    }

    public boolean canRescheduleAppointment() {
        return hasAdminPrivileges();
    }

    // Doctor Management Methods
    public boolean canAddDoctor() {
        return hasAdminPrivileges();
    }

    public boolean canEditDoctor() {
        return hasAdminPrivileges();
    }

    public boolean canDeactivateDoctor() {
        return hasAdminPrivileges();
    }

    public boolean canManageDoctorSchedule() {
        return hasAdminPrivileges();
    }

    // Patient Management Methods
    public boolean canViewPatientRecords() {
        return hasAdminPrivileges();
    }

    public boolean canManagePatientAccounts() {
        return hasAdminPrivileges();
    }

    // System Management Methods
    public boolean canGenerateReports() {
        return hasAdminPrivileges();
    }

    public boolean canConfigureSystem() {
        return hasAdminPrivileges();
    }

    public boolean canManageAdminAccounts() {
        return hasAdminPrivileges();
    }

    // Activity Logging
    public void updateLastLogin() {
        this.lastLogin = new Date();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", lastLogin=" + lastLogin +
                ", isActive=" + isActive +
                '}';
    }
}

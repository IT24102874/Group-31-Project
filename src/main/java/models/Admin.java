package models;

import utils.FileHandler;
import utils.PaymentFileHandler;

import java.util.List;

public class Admin extends User {

    public Admin(String username, String email, String password) {
        super(username, email, password, "admin");
    }

    // Get all users
    public List<User> getAllUsers() {
        return FileHandler.readUsersFromFile();
    }

    // Delete a user by username
    public boolean deleteUser(String usernameToDelete) {
        List<User> users = FileHandler.readUsersFromFile();
        boolean removed = users.removeIf(user -> user.getUserName().equals(usernameToDelete));
        if (removed) {
            FileHandler.writeUsersToFile(users);
        }
        return removed;
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return PaymentFileHandler.readAllPayments();
    }

    // Update payment status (accept or reject)
    public boolean updatePaymentStatus(String referenceNumber, String newStatus) {
        return PaymentFileHandler.updatePaymentStatus(referenceNumber, newStatus);
    }
}
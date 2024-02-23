package org.eventPlaner;

public class UserService {
    // Method to register a user
    public static String registerUser(String email, String userName, String city, String phoneNumber, String password) {
        // Your registration logic here
        // For demonstration purposes, let's assume the registration is successful
        return "User registered successfully";
    }
    public static String login(String email, String password) {
        // Assuming some basic validation
        if (email.equals("Abdelrahman@gmail.com  ") && password.equals("123456")) {
            return "User logged in successfully";
        } else {
            return "Invalid email or password";
        }
    }
}

package org.eventPlaner;

public class Admin {
    public static String registerAdmin(String emailAdmin, String userName, String city, String adminPassword) {
        // Your registration logic here emailAdmin |userName |city|adminPassword
        // For demonstration purposes, let's assume the registration is successful
        return "User registered successfully";
    }
    public static String login(String emailAdmin, String adminPassword) {
        // Assuming some basic validation
        if (emailAdmin.equals("admin@admin.com ") && adminPassword.equals("123456")) {
            return "User logged in successfully";
        } else {
            return "Invalid email or password";
        }
    }
}

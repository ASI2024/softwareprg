package org.eventPlaner;

public class Admin {
    public static String registerAdmin(String emailAdmin, String userName, String city, String adminPassword) {
        // Your registration logic here emailAdmin |userName |city|adminPassword
        // For demonstration purposes, let's assume the registration is successful
        boolean test = emailAdmin.isEmpty()|userName.isEmpty()|city.isEmpty()|adminPassword.isEmpty();
        if(!test) {
            return "Admin registered successfully";
        }else{
            return "Admin registered failed";
        }
    }
    public static String login(String emailAdmin, String adminPassword) {
        // Assuming some basic validation
        if (emailAdmin.equals("admin@admin.com ") && adminPassword.equals("123456")) {
            return "Admin logged in successfully";
        } else {
            return "Invalid email or password";
        }
    }
}

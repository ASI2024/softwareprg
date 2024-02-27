/*package org.eventPlaner;

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

}*/

package org.eventPlaner;

import java.util.ArrayList;

public class Admin {
    // ArrayList to store requested registrations
    private static ArrayList<String> registrationRequests = new ArrayList<>();

    // Method to request the registration of a UserService
    public static void requestUserServiceRegistration(String email, String userName, String city, String phoneNumber, String password) {
        // Add the registration request to the list
        registrationRequests.add("UserService: " + email + ", " + userName + ", " + city + ", " + phoneNumber + ", " + password);
    }

    // Method to request the registration of a User
    public static void requestUserRegistration(String email, String userName, String city, String phoneNumber, String password) {
        // Add the registration request to the list
        registrationRequests.add("User: " + email + ", " + userName + ", " + city + ", " + phoneNumber + ", " + password);
    }

    // Method to handle the registration requests
    public static void processRegistrationRequests() {
        // Process each registration request
        for (String request : registrationRequests) {
            String[] parts = request.split(": ");
            String type = parts[0];
            String[] userInfo = parts[1].split(", ");
            String email = userInfo[0];
            String userName = userInfo[1];
            String city = userInfo[2];
            String phoneNumber = userInfo[3];
            String password = userInfo[4];

            // Register the user or service based on the type of request
            if (type.equals("UserService")) {
                String result = UserService.registerUser(email, userName, city, phoneNumber, password);
                System.out.println("UserService Registration Request: " + result);
            } else if (type.equals("User")) {
                String result = UserService.registerUser(email, userName, city, phoneNumber, password);
                System.out.println("User Registration Request: " + result);
            }
        }

        // Clear the registration requests after processing
        registrationRequests.clear();
    }

    // Method to simulate login
    public static String login(String emailAdmin, String adminPassword) {
        // Assuming some basic validation
        if (emailAdmin.equals("admin@admin.com") && adminPassword.equals("123456")) {
            return "Admin logged in successfully";
        } else {
            return "Invalid email or password";
        }
    }
}

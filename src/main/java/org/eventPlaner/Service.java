package org.eventPlaner;

public class Service {
    public static String registerService(String email, String userName, String city,String address,String serviceProvide, String phoneNum, String password) {
        // Your registration logic here email|userName|city|address|serviceProvide|phonenum |password
        // For demonstration purposes, let's assume the registration is successful
        return "User registered successfully";
    }
    public static String login(String email, String password) {
        // Assuming some basic validation
        if (email.equals("Abd@gm.com  ") && password.equals("123456")) {
            return "User logged in successfully";
        } else {
            return "Invalid email or password";
        }
    }
}

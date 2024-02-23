package org.eventPlaner;

public class Service {
    public static String registerService(String email, String userName, String city,String address,String serviceProvide, String phoneNum, String password) {
        // Your registration logic here email|userName|city|address|serviceProvide|phonenum |password
        // For demonstration purposes, let's assume the registration is successful
        boolean test = email.isEmpty()|userName.isEmpty()|city.isEmpty()
                |address.isEmpty()|serviceProvide.isEmpty()|phoneNum.isEmpty()|password.isEmpty();
        if(!test)
        return "Service registered successfully";
        else
            return "Service registered failed";
    }
    public static String login(String email, String password) {
        // Assuming some basic validation
        if (email.equals("Abd@gm.com") && password.equals("123456")) {
            return "Service logged in successfully";
        } else {
            return "Invalid email or password";
        }
    }
}

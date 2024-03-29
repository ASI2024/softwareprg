package org.eventPlaner;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public static List<ServiceProvider>ServiceProviders = new ArrayList<>();


    public static String registerService(String email, String userName, String city,String address,String status, String phoneNum, String password) {

        boolean test = email.isEmpty()|userName.isEmpty()|city.isEmpty()
                |address.isEmpty()|phoneNum.isEmpty()|password.isEmpty();
        if(!test){

            ServiceProvider S = new ServiceProvider(email,userName,city,address,status,phoneNum,password);
            ServiceProviders.add(S);
            return "Service registered successfully";
        }
        else
            return "Service registered failed";
    }
    public static String login(String email, String password) {

        for(ServiceProvider ServiceP :ServiceProviders){

            if(ServiceP.getEmail().equals(email)&&ServiceP.getPassword().equals(password)&&ServiceP.getStatus().equals("Acceptable"))
                return "Service logged in successfully";

        }
        return "Invalid email or password";
    }


}

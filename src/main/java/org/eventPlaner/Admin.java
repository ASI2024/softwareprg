package org.eventPlaner;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    public static List<AdminInf>Admin= new ArrayList<>();
    public static String registerAdmin(String emailAdmin, String userName, String city, String adminPassword,String status) {

        boolean test = emailAdmin.isEmpty()|userName.isEmpty()|city.isEmpty()|adminPassword.isEmpty();
        if(!test) {
            AdminInf A = new AdminInf(userName,adminPassword,emailAdmin,city,status);
            Admin.add(A);
            return "Admin registered successfully";
        }else{
            return "Admin registered failed";
        }
    }
    public static String login(String emailAdmin, String adminPassword) {

        for(AdminInf adminInf :Admin){

            if(adminInf.getEmail().equals(emailAdmin)&&adminInf.getPassword().equals(adminPassword)&&adminInf.getStatus().equals("Acceptable"))
                return "Admin logged in successfully";
        }

        return "Invalid email or password";
    }

}
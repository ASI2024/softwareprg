package org.eventPlaner;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<User>users =new ArrayList<>();

    public static String registerUser(String email, String userName, String city, String phoneNumber, String password) {

        boolean test = email.isEmpty()|userName.isEmpty()|city.isEmpty()|phoneNumber.isEmpty()|password.isEmpty();
        if(!test){
            User U = new User(userName,password,email,city,phoneNumber);
            users.add(U);
            return "User registered successfully";
        }else {
            return "User registered failed";
        }
    }
    public static String login(String email, String password) {

        for(User user : users){

            if(user.getEmail().equals(email) && user.getPassword().equals(password))
                return "User logged in successfully";
        }

        return "Invalid email or password";

    }


}

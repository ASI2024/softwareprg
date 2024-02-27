package org.eventPlaner;
import java.util.ArrayList;

public class UserService {
    // Method to register a user
    public static String registerUser(String email, String userName, String city, String phoneNumber, String password) {
        // Your registration logic here
        // For demonstration purposes, let's assume the registration is successful
        boolean test = email.isEmpty()|userName.isEmpty()|city.isEmpty()|phoneNumber.isEmpty()|password.isEmpty();
        if(!test){
            return "User registered successfully";
        }else {
            return "User registered failed";
        }
    }
    public static String login(String email, String password) {
        // Assuming some basic validation
        if (email.equals("Abdelrahman@gmail.com") && password.equals("123456")) {
            return "User logged in successfully";
        }else {
            return "Invalid email or password";
        }

    }
    public class UserPerson {
        private String email;
        private String userName;
        private String city;
        private String phoneNumber;
        private String password;

        public UserPerson(String email, String userName, String city, String phoneNumber, String password) {
            this.email = email;
            this.userName = userName;
            this.city = city;
            this.phoneNumber = phoneNumber;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public class UserPersonList {
        private ArrayList<UserPerson> userPersons;

        public UserPersonList() {
            userPersons = new ArrayList<>();
        }

        public void addUserPerson(UserPerson userPerson) {
            userPersons.add(userPerson);
        }

        public ArrayList<UserPerson> getUserPersons() {
            return userPersons;
        }
    }

}

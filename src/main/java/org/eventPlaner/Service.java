package org.eventPlaner;
import java.util.ArrayList;
import java.util.ArrayList;

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





    public class ServicePerson {
        private String email;
        private String userName;
        private String city;
        private String address;
        private String serviceProvide;
        private String phoneNum;
        private String password;

        public ServicePerson(String email, String userName, String city, String address, String serviceProvide, String phoneNum, String password) {
            this.email = email;
            this.userName = userName;
            this.city = city;
            this.address = address;
            this.serviceProvide = serviceProvide;
            this.phoneNum = phoneNum;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getServiceProvide() {
            return serviceProvide;
        }

        public void setServiceProvide(String serviceProvide) {
            this.serviceProvide = serviceProvide;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


    public class ServicePersonList {
        private ArrayList<ServicePerson> servicePersons;

        public ServicePersonList() {
            servicePersons = new ArrayList<>();
        }

        public void addServicePerson(ServicePerson servicePerson) {
            servicePersons.add(servicePerson);
        }

        public ArrayList<ServicePerson> getServicePersons() {
            return servicePersons;
        }
    }

}

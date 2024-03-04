package org.eventPlaner;

public class User {

    private String email;
    private String userName;
    private String city;
    private String phoneNumber;
    private String password;

    public User (String userName,String password , String email ,String city,String phoneNumber){

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
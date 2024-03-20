package org.eventPlaner;

public class ServiceProvider {

    private String email;
    private String userName;
    private String city;
    private String address;
    private String status;
    private String phoneNum;
    private String password;

    public ServiceProvider(String email, String userName, String city, String address, String status, String phoneNum, String password){

        this.email = email;
        this.userName = userName;
        this.city = city;
        this.address = address;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setServiceProvide(String status) {
        this.status = status;
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

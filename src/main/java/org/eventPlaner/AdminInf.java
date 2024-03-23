package org.eventPlaner;

public class AdminInf {

    private String email;
    private String userName;
    private String city;
    private String password;
    private String status;

    public AdminInf(String userName,String password , String email ,String city,String status){

        this.email = email;
        this.userName = userName;
        this.city = city;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

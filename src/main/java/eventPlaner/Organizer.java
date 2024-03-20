package eventPlaner;

public class Organizer {

    private String email;
    private String password;
    private String username;
    private String city;
    private String phoneNumber;
    private String status;

    public Organizer(String email,String password ,String username ,String city ,String phoneNumber,String status){

        this.email = email;
        this.password = password;
        this.username = username;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.status = status;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
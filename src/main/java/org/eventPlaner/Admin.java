package org.eventPlaner;
import eventPlaner.Organizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import static eventPlaner.OrganizerLogin.Organizers;
import static org.eventPlaner.Service.ServiceProviders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Admin {
private static final String STATUS_ACCEPTABLE = "Acceptable";
    private static final String STATUS_PENDING = "Pending";
    private static final String STATUS_REJECTED = "Rejected";
    private static final Logger logger = LoggerFactory.getLogger(Admin.class);

    public static List<AdminInf>AdminList= new ArrayList<>();
    public static HashMap<String, String> reasonRejection;
    private Admin() {
        
    }
    public static String registerAdmin(String emailAdmin, String userName, String city, String adminPassword,String status) {
        boolean test = emailAdmin.isEmpty()||userName.isEmpty()||city.isEmpty()||adminPassword.isEmpty();
        if(!test) {
            AdminInf A = new AdminInf(userName,adminPassword,emailAdmin,city,status);
            AdminList.add(A);
            return "Admin registered successfully";
        }else{
            return "Admin registered failed";
        }
    }
    public static String login(String emailAdmin, String adminPassword) {
        for(AdminInf adminInf :AdminList){
            if(adminInf.getEmail().equals(emailAdmin)&&adminInf.getPassword().equals(adminPassword)&&adminInf.getStatus().equals( STATUS_ACCEPTABLE))
                return "Admin logged in successfully";
        }
        return "Invalid email or password";
    }
    public static boolean setReasonRejection(String email ,String reason){
        for(AdminInf adminInf :AdminList){
            if(Objects.equals(adminInf.getEmail(), email) && Objects.equals(adminInf.getStatus(),  STATUS_PENDING)) {
                reasonRejection.put(email,reason);
                adminInf.setStatus(STATUS_REJECTED);
                return true;
            }
        }
        for(Organizer organizer :Organizers){
            if(Objects.equals(organizer.getEmail(), email) && Objects.equals(organizer.getStatus(),  STATUS_PENDING)) {
                reasonRejection.put(email,reason);
                organizer.setStatus(STATUS_REJECTED);
                return true;
            }
        }
        for(ServiceProvider serviceProvider :ServiceProviders){
            if(Objects.equals(serviceProvider.getEmail(), email) && Objects.equals(serviceProvider.getStatus(), STATUS_PENDING)) {
                reasonRejection.put(email,reason);
                serviceProvider.setServiceProvide(STATUS_REJECTED);
                return true;
            }
        }
        return false;
    } 
      public static void showRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAdmin Requests List\nEmail\t\t\t\tPassword\t\tUserName\t\tCity\n");

        for (AdminInf adminInf : AdminList) {
            if (STATUS_PENDING.equals(adminInf.getStatus())) {
                sb.append(String.format("%-20s\t%-20s\t%-20s\t%s\n",
                        adminInf.getEmail(),
                        adminInf.getPassword(),
                        adminInf.getUserName(),
                        adminInf.getCity()));
            }
            logger.info(sb.toString());
        }



        StringBuilder sb = new StringBuilder();
        sb.append("\nOrganizer Requests List\nEmail\t\t\t\tPassword\t\tUserName\t\tCity\t\tPhoneNumber\n");

        for (Organizer organizer : Organizers) {
            if (STATUS_PENDING.equals(organizer.getStatus())) {
                String formattedLine = String.format("%-20s\t%-20s\t%-20s\t%-20s\t%s",
                        organizer.getEmail(),
                        organizer.getPassword(),
                        organizer.getUsername(),
                        organizer.getCity(),
                        organizer.getPhoneNumber());

                sb.append(formattedLine).append("\n");
            }
            logger.info(sb.toString());
        }




    StringBuilder sb = new StringBuilder();
    sb.append("\nServiceProvider Requests List\nEmail\t\t\t\tPassword\t\tUserName\t\tCity\t\tPhoneNumber\t\tAddress\n");

    for(
    ServiceProvider serviceProvider :ServiceProviders)

    {
        if (STATUS_PENDING.equals(serviceProvider.getStatus())) {
            // Construct each service provider's details as a formatted string
            String formattedDetails = String.format("%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%s",
                    serviceProvider.getEmail(),
                    serviceProvider.getPassword(),
                    serviceProvider.getUserName(),
                    serviceProvider.getCity(),
                    serviceProvider.getPhoneNum(),
                    serviceProvider.getAddress());

            // Append the formatted details to the StringBuilder
            sb.append(formattedDetails).append("\n");
        }
        logger.info(sb.toString());
    }


 
}

    public static void AcceptAll(){

        for(AdminInf adminInf :AdminList){

            if(adminInf.getStatus().equals(STATUS_PENDING))
                adminInf.setStatus(STATUS_ACCEPTABLE);
        }

    }

    public static void Accept(String email){

        for(AdminInf adminInf :AdminList){

            if(adminInf.getStatus().equals(STATUS_PENDING)&&adminInf.getEmail().equals(email))
                adminInf.setStatus(STATUS_ACCEPTABLE);
        }

    }



}

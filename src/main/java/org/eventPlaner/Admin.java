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
     
    public static void showRequest(){
       logger.info("");
       logger.info("               Admin Requests List");
         logger.info("Email               Password     UserName     City");

        for(AdminInf adminInf :AdminList){

             if(adminInf.getStatus().equals(STATUS_PENDING)){

               logger.info("Admin Email : {}",adminInf.getEmail());
                 for(int i =0;i<20-adminInf.getEmail().length();i++)
                      logger.info("\t");
               logger.info("Admin Password : {}",adminInf.getPassword());
                 for(int i =0;i<13-adminInf.getPassword().length();i++)
                     logger.info("\t");
                logger.info("Admin UserName : {}",adminInf.getUserName());
                 for(int i =0;i<13-adminInf.getUserName().length();i++)
                     logger.info("\t");
                logger.info("Admin City: {}",adminInf.getCity());

             }

        }
        logger.info("");
        logger.info("                       Organizer Requests List");
        logger.info("Email               Password     UserName     City     PhoneNumber");
        for(Organizer organizer :Organizers){

            if(organizer.getStatus().equals(STATUS_PENDING)){

                  logger.info("Organizer Email: {}",organizer.getEmail());
                for(int i =0;i<20-organizer.getEmail().length();i++)
                     logger.info("\t");
                   logger.info("{}",organizer.getPassword());
                for(int i =0;i<13-organizer.getPassword().length();i++)
                     logger.info("\t");
                logger.info("Organizer username: {}", organizer.getUsername());
                for(int i =0;i<13-organizer.getUsername().length();i++)
                    logger.info("\t");
                logger.info("Organizer City: {}",organizer.getCity());
                for(int i =0;i<9-organizer.getCity().length();i++)
                     logger.info("\t");
                 logger.info("Organizer PhoneNumber: {}",organizer.getPhoneNumber());

            }

        }

        logger.info("");
        logger.info("                         ServiceProvider Requests List");
         logger.info("Email               Password     UserName     City     PhoneNumber     Address");
        for(ServiceProvider serviceProvider :ServiceProviders){

            if(serviceProvider.getStatus().equals(STATUS_PENDING)){

             logger.info("ServiceProvider Email :{}",serviceProvider.getEmail());
                for(int i =0;i<20-serviceProvider.getEmail().length();i++)
                    logger.info("\t");
              logger.info("ServiceProvider Password : {} ",serviceProvider.getPassword());
                for(int i =0;i<13-serviceProvider.getPassword().length();i++)
                    logger.info("\t");
                logger.info("ServiceProvider Username : {}",serviceProvider.getUserName());
                for(int i =0;i<13-serviceProvider.getUserName().length();i++)
                     logger.info("\t");
             logger.info("ServiceProvider City : {}",serviceProvider.getCity());
                for(int i =0;i<9-serviceProvider.getCity().length();i++)
                   logger.info("\t");
                logger.info("ServiceProvider PhoneNum : {}",serviceProvider.getPhoneNum());
                for(int i =0;i<16-serviceProvider.getPhoneNum().length();i++)
                    logger.info("\t");
             logger.info("ServiceProvider Address : {}",serviceProvider.getAddress());

            }

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

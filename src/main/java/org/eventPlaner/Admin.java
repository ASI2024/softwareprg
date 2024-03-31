package org.eventPlaner;
import eventPlaner.Organizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import static eventPlaner.OrganizerLogin.Organizers;
import static org.eventPlaner.Service.ServiceProviders;
public class Admin {
private static final String STATUS_ACCEPTABLE = "Acceptable";
    private static final String STATUS_PENDING = "Pending";
    private static final String STATUS_REJECTED = "Rejected";
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
        System.out.println("Admin Requests List");
        printAdminRequests();
        System.out.println("Organizer Requests List");
        printOrganizerRequests();
        System.out.println("ServiceProvider Requests List");
        printServiceProviderRequests();
    }

    private static void printAdminRequests() {
        System.out.println("Email\t\t\tPassword\tUserName\tCity");
        AdminList.stream()
            .filter(admin -> STATUS_PENDING.equals(admin.getStatus()))
            .forEach(Admin::printAdmin);
    }

    private static void printAdmin(AdminInf admin) {
        System.out.println(String.format("%-20s\t%-13s\t%-13s\t%s",
                admin.getEmail(), admin.getPassword(), admin.getUserName(), admin.getCity()));
    }

    private static void printOrganizerRequests() {
        System.out.println("Email\t\t\tPassword\tUserName\tCity\tPhoneNumber");
        Organizers.stream()
            .filter(org -> STATUS_PENDING.equals(org.getStatus()))
            .forEach(Admin::printOrganizer);
    }

    private static void printOrganizer(Organizer organizer) {
        System.out.println(String.format("%-20s\t%-13s\t%-13s\t%-9s\t%s",
                organizer.getEmail(), organizer.getPassword(), organizer.getUsername(), organizer.getCity(), organizer.getPhoneNumber()));
    }

    private static void printServiceProviderRequests() {
        System.out.println("Email\t\t\tPassword\tUserName\tCity\tPhoneNumber\tAddress");
        ServiceProviders.stream()
            .filter(sp -> STATUS_PENDING.equals(sp.getStatus()))
            .forEach(Admin::printServiceProvider);
    }

    private static void printServiceProvider(ServiceProvider serviceProvider) {
        System.out.println(String.format("%-20s\t%-13s\t%-13s\t%-9s\t%-16s\t%s",
                serviceProvider.getEmail(), serviceProvider.getPassword(), serviceProvider.getUserName(), serviceProvider.getCity(), serviceProvider.getPhoneNum(), serviceProvider.getAddress()));
    }
}

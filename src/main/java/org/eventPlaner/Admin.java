package org.eventPlaner;

import eventPlaner.Organizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static eventPlaner.OrganizerLogin.Organizers;
import static org.eventPlaner.Service.ServiceProviders;

public class Admin {
    public static List<AdminInf> AdminList = new ArrayList<>();
    public static HashMap<String, String> reasonRejection = new HashMap<>(); 
private static final String STATUS_ACCEPTABLE = "Acceptable";
    private static final String STATUS_PENDING = "Pending"; 
    private static final String STATUS_REJECTED = "Rejected";
    public static String registerAdmin(String emailAdmin, String userName, String city, String adminPassword, String status) {
       
        boolean test = emailAdmin.isEmpty() || userName.isEmpty() || city.isEmpty() || adminPassword.isEmpty();
        if (!test) {
            AdminInf A = new AdminInf(userName, adminPassword, emailAdmin, city, status);
            AdminList.add(A);
            return "Admin registered successfully";
        } else {
            return "Admin registration failed"; 
        }
    }
    public static String login(String emailAdmin, String adminPassword) {

        for(AdminInf adminInf :AdminList){

            if(adminInf.getEmail().equals(emailAdmin)&&adminInf.getPassword().equals(adminPassword)&&adminInf.getStatus().equals(STATUS_ACCEPTABLE))
                return "Admin logged in successfully";
        }

        return "Invalid email or password";
    }

    public static boolean setReasonRejection(String email ,String reason){

        for(AdminInf adminInf :AdminList){

            if(Objects.equals(adminInf.getEmail(), email) && Objects.equals(adminInf.getStatus(), STATUS_PENDING)) {

                reasonRejection.put(email,reason);
                adminInf.setStatus(STATUS_REJECTED);
                return true;
            }

        }

        for(Organizer organizer :Organizers){

            if(Objects.equals(organizer.getEmail(), email) && Objects.equals(organizer.getStatus(),STATUS_PENDING)) {

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
        System.out.println("\n               Admin Requests List");
        System.out.println("Email               Password     UserName     City");
        AdminList.stream()
                 .filter(adminInf -> PENDING_STATUS.equals(adminInf.getStatus()))
                 .forEach(YourClass::printAdminInfo);

        System.out.println("\n                       Organizer Requests List");
        System.out.println("Email               Password     UserName     City     PhoneNumber");
        Organizers.stream()
                  .filter(organizer -> PENDING_STATUS.equals(organizer.getStatus()))
                  .forEach(YourClass::printOrganizerInfo);

        System.out.println("\n                         ServiceProvider Requests List");
        System.out.println("Email               Password     UserName     City     PhoneNumber     Address");
        ServiceProviders.stream()
                        .filter(serviceProvider -> PENDING_STATUS.equals(serviceProvider.getStatus()))
                        .forEach(YourClass::printServiceProviderInfo);
    }

    private static void printAdminInfo(AdminInf adminInf) {
        System.out.println(formatString(adminInf.getEmail(), 20) + formatString(adminInf.getPassword(), 13) +
                           formatString(adminInf.getUserName(), 13) + adminInf.getCity());
    }

    private static void printOrganizerInfo(Organizer organizer) {
        System.out.println(formatString(organizer.getEmail(), 20) + formatString(organizer.getPassword(), 13) +
                           formatString(organizer.getUsername(), 13) + formatString(organizer.getCity(), 9) +
                           organizer.getPhoneNumber());
    }

    private static void printServiceProviderInfo(ServiceProvider serviceProvider) {
        System.out.println(formatString(serviceProvider.getEmail(), 20) + formatString(serviceProvider.getPassword(), 13) +
                           formatString(serviceProvider.getUserName(), 13) + formatString(serviceProvider.getCity(), 9) +
                           formatString(serviceProvider.getPhoneNum(), 16) + serviceProvider.getAddress());
    }

    private static String formatString(String str, int length) {
        return String.format("%-" + length + "s", str);
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




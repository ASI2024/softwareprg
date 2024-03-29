package org.eventPlaner;

import eventPlaner.Organizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static eventPlaner.OrganizerLogin.Organizers;
import static org.eventPlaner.Service.ServiceProviders;

public class Admin {

    public static List<AdminInf>AdminList= new ArrayList<>();
    public static HashMap<String, String> reasonRejection;
    public static String registerAdmin(String emailAdmin, String userName, String city, String adminPassword,String status) {

        boolean test = emailAdmin.isEmpty()|userName.isEmpty()|city.isEmpty()|adminPassword.isEmpty();
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

            if(adminInf.getEmail().equals(emailAdmin)&&adminInf.getPassword().equals(adminPassword)&&adminInf.getStatus().equals("Acceptable"))
                return "Admin logged in successfully";
        }

        return "Invalid email or password";
    }

    public static boolean setReasonRejection(String email ,String reason){

        for(AdminInf adminInf :AdminList){

            if(Objects.equals(adminInf.getEmail(), email) && Objects.equals(adminInf.getStatus(), "Pending")) {

                reasonRejection.put(email,reason);
                adminInf.setStatus("Rejected");
                return true;
            }

        }

        for(Organizer organizer :Organizers){

            if(Objects.equals(organizer.getEmail(), email) && Objects.equals(organizer.getStatus(), "Pending")) {

                reasonRejection.put(email,reason);
                organizer.setStatus("Rejected");
                return true;
            }

        }

        for(ServiceProvider serviceProvider :ServiceProviders){

            if(Objects.equals(serviceProvider.getEmail(), email) && Objects.equals(serviceProvider.getStatus(), "Pending")) {

                reasonRejection.put(email,reason);
                serviceProvider.setServiceProvide("Rejected");
                return true;
            }

        }
        return false;

    }

    public static void showRequest(){
        System.out.println();
        System.out.println("               Admin Requests List");
        System.out.println("Email               Password     UserName     City");

        for(AdminInf adminInf :AdminList){

             if(adminInf.getStatus().equals("Pending")){

                 System.out.print(adminInf.getEmail());
                 for(int i =0;i<20-adminInf.getEmail().length();i++)
                     System.out.print("\t");
                 System.out.print(adminInf.getPassword());
                 for(int i =0;i<13-adminInf.getPassword().length();i++)
                     System.out.print("\t");
                 System.out.print(adminInf.getUserName());
                 for(int i =0;i<13-adminInf.getUserName().length();i++)
                     System.out.print("\t");
                 System.out.println(adminInf.getCity());

             }

        }
        System.out.println();
        System.out.println("                       Organizer Requests List");
        System.out.println("Email               Password     UserName     City     PhoneNumber");
        for(Organizer organizer :Organizers){

            if(organizer.getStatus().equals("Pending")){

                System.out.print(organizer.getEmail());
                for(int i =0;i<20-organizer.getEmail().length();i++)
                    System.out.print("\t");
                System.out.print(organizer.getPassword());
                for(int i =0;i<13-organizer.getPassword().length();i++)
                    System.out.print("\t");
                System.out.print(organizer.getUsername());
                for(int i =0;i<13-organizer.getUsername().length();i++)
                    System.out.print("\t");
                System.out.println(organizer.getCity());
                for(int i =0;i<9-organizer.getCity().length();i++)
                    System.out.print("\t");
                System.out.println(organizer.getPhoneNumber());

            }

        }

        System.out.println();
        System.out.println("                         ServiceProvider Requests List");
        System.out.println("Email               Password     UserName     City     PhoneNumber     Address");
        for(ServiceProvider serviceProvider :ServiceProviders){

            if(serviceProvider.getStatus().equals("Pending")){

                System.out.print(serviceProvider.getEmail());
                for(int i =0;i<20-serviceProvider.getEmail().length();i++)
                    System.out.print("\t");
                System.out.print(serviceProvider.getPassword());
                for(int i =0;i<13-serviceProvider.getPassword().length();i++)
                    System.out.print("\t");
                System.out.print(serviceProvider.getUserName());
                for(int i =0;i<13-serviceProvider.getUserName().length();i++)
                    System.out.print("\t");
                System.out.println(serviceProvider.getCity());
                for(int i =0;i<9-serviceProvider.getCity().length();i++)
                    System.out.print("\t");
                System.out.println(serviceProvider.getPhoneNum());
                for(int i =0;i<16-serviceProvider.getPhoneNum().length();i++)
                    System.out.print("\t");
                System.out.println(serviceProvider.getAddress());

            }

        }
    }

    public static void AcceptAll(){

        for(AdminInf adminInf :AdminList){

            if(adminInf.getStatus().equals("Pending"))
                adminInf.setStatus("Acceptable");
        }

    }

    public static void Accept(String email){

        for(AdminInf adminInf :AdminList){

            if(adminInf.getStatus().equals("Pending")&&adminInf.getEmail().equals(email))
                adminInf.setStatus("Acceptable");
        }

    }



}




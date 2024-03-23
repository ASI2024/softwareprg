package org.example;

import eventPlaner.OrganizerLogin;
import eventPlaner.OrganizerManagement;
import org.eventPlaner.Admin;
import org.eventPlaner.Service;
import org.eventPlaner.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int sign;
        int choose;
        OrganizerLogin organizerLogin = new OrganizerLogin();


        while (true){

            System.out.println("1.Sign Up\n2.Sign In");
            sign =scanner1.nextInt();
            switch (sign){
                case 1:
                    while (true) {
                        System.out.println("Choose the account type:\n1.Admin\n2.Organizer\n3.Service Provider\n4.User");
                        choose = scanner1.nextInt();
                        switch (choose) {
                            case 1:
                                System.out.println("Enter Your Email:");
                                String email = scanner1.next();
                                System.out.println("Enter Your Username:");
                                String username = scanner1.next();
                                System.out.println("Enter Your City:");
                                String city = scanner1.next();
                                System.out.println("Enter Your Password:");
                                String password = scanner1.next();
                                Admin.registerAdmin(email, username, city, password, "Pending");
                                if (Admin.registerAdmin(email, username, city, password, "Pending").equals("Admin registered successfully")) {

                                    System.out.println("The request has been submitted successfully. Please wait for admin approval");
                                } else {

                                    System.out.println(Admin.registerAdmin(email, username, city, password, "Pending"));
                                }
                                break;

                            case 2:
                                System.out.println("Enter Your Email:");
                                String ema = scanner1.next();
                                System.out.println("Enter Your Username:");
                                String user = scanner1.next();
                                System.out.println("Enter Your City:");
                                String cit = scanner1.next();
                                System.out.println("Enter Your PhoneNumber:");
                                String phone = scanner1.next();
                                System.out.println("Enter Your Password:");
                                String pass = scanner1.next();
                                organizerLogin.Registration(ema, pass, user, cit, phone, "Pending");
                                System.out.println("The request has been submitted successfully. Please wait for admin approval");
                                break;
                            case 3:
                                System.out.println("Enter Your Email:");
                                String em = scanner1.next();
                                System.out.println("Enter Your Username:");
                                String use = scanner1.next();
                                System.out.println("Enter Your City:");
                                String ci = scanner1.next();
                                System.out.println("Enter Your Address:");
                                String address = scanner1.next();
                                System.out.println("Enter Your PhoneNumber:");
                                String pho = scanner1.next();
                                System.out.println("Enter Your Password:");
                                String pas = scanner1.next();
                                Service.registerService(em, use, ci, address, "Pending", pho, pas);
                                if (Service.registerService(em, use, ci, address, "Pending", pho, pas).equals("Service registered successfully")) {

                                    System.out.println("The request has been submitted successfully. Please wait for admin approval");
                                } else {

                                    System.out.println(Service.registerService(em, use, ci, address, "Pending", pho, pas));
                                }
                                break;
                            case 4:
                                System.out.println("Enter Your Email:");
                                String e = scanner1.next();
                                System.out.println("Enter Your Username:");
                                String us = scanner1.next();
                                System.out.println("Enter Your City:");
                                String c = scanner1.next();
                                System.out.println("Enter Your PhoneNumber:");
                                String ph = scanner1.next();
                                System.out.println("Enter Your Password:");
                                String pa = scanner1.next();
                                UserService.registerUser(e, us, c, ph, pa);
                                if (UserService.registerUser(e, us, c, ph, pa).equals("User registered successfully")) {

                                    System.out.println("Account successfully created");
                                } else {

                                    System.out.println(UserService.registerUser(e, us, c, ph, pa));
                                }
                                break;

                            default:
                                System.out.println("Invalid input pleas try again:");
                                break;
                        }
                        if(choose<=4)
                            break;
                    }

                case 2:
                    while (true){

                        System.out.println("Enter Email:");
                        String email=scanner2.next();
                        System.out.println("Enter Password:");
                        String password=scanner2.next();
                        int in=0;

                        if(Admin.login(email,password).equals("Admin logged in successfully")){

                            while (true){

                                System.out.println("1.Show EventList\n2.Show list of requests to create account\n" +
                                        "3.Accept all requests to create account\n4.Accept request to create account\n" +
                                        "5.Reject request to create account\n6.Exit");
                                 in=scanner2.nextInt();

                                switch (in){

                                    case 1:
                                        OrganizerManagement.ShowEventList();
                                        break;

                                    case 2:
                                        Admin.showRequest();
                                        break;

                                    case 3:
                                        Admin.AcceptAll();
                                        break;

                                    case 4:
                                        System.out.println("Enter email of the account you want to accept:");
                                        String ema=scanner2.next();
                                        Admin.Accept(ema);
                                        break;

                                    case 5:
                                        System.out.println("Enter email of the account you want to reject:");
                                        String em=scanner2.next();
                                        System.out.println("Enter the reason for rejection:");
                                        String reason=scanner2.next();
                                        if(Admin.setReasonRejection(em,reason)){
                                            System.out.println("Rejected successfully");
                                        }else{
                                            System.out.println("Email not found");
                                        }
                                        break;

                                    case 6:
                                        break;

                                    default:
                                        System.out.println("Invalid input pleas try again:\n");
                                        break;


                                }

                                if(in==6)
                                    break;

                            }
                        }else if(organizerLogin.Login(email,password)){

                            System.out.println("1.Show list of event requests\n2.Show requests for modification events\n" +
                                    "3.Show requests for deletion event\n4.Accept add event\n5.Reject add event\n" +
                                    "6.Accept modification for event\n7.Reject modification for event\n" +
                                    "8.Accept delet an event");
                        }

                        if (in==6)
                            break;

                    }


                default:
                    System.out.println("Invalid input pleas try again:\n");
                    break;
            }


        }

    }
}
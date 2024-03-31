package org.example;

import BudgetingandFinance.Hall;
import BudgetingandFinance.HallRepositoryImpl;
import VendorManagement.ContractNegotiation;
import VendorManagement.PackageRequest;
import VendorManagement.Vendor;
import VendorManagement.VendorDatabase;
import eventPlaner.*;
import newvenues.ExpenseTracker;
import newvenues.VenueSystem;
import org.eventPlaner.Admin;
import org.eventPlaner.Service;
import org.eventPlaner.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static final String INVALID_INPUT_MESSAGE = "Invalid input please try again:";
    private static final String ENTER_PHONE_NUMBER = "Enter Your PhoneNumber:";
    private static final String REQUEST_SUBMITTED_MESSAGE = "The request has been submitted successfully. Please wait for admin approval";
    private static final String STATUS_PENDING = "Pending";
    private static final String PROMPT_EMAIL = "Enter Your Email:";
    private static final String PROMPT_USERNAME = "Enter Your Username:";
    private static final String PROMPT_CITY = "Enter Your City:";
    private static final String PROMPT_PASSWORD = "Enter Your Password:";
    private static final String PROMPT_EVENT_NUMBER = "Enter event number: ";
    private static final String EDIT_ADDED_APPROVAL_MESSAGE = "The edit has been added. Please wait for the organizer’s approval";
    private static final String INVALID_DATE_FORMAT_MESSAGE = "Invalid date format. Please enter the date in the format yyyy-MM-dd.";
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    public static void main(String[] args) {
        Map<Integer, Hall> hallDatabase = new HashMap<>();


        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        Random random = new Random();
        int minValue = 100000;
        int maxValue = 999999;
        int sign;
        int choose;
        int in = 0;
        int in2 = 0;
        int in3 = 0;
        int in4 = 0;
        OrganizerLogin organizerLogin = new OrganizerLogin();
        OrganizerManagement organizerManagement = new OrganizerManagement();
        ExpenseTracker expenseTracker = new ExpenseTracker();
        VenueSystem venueSystem = new VenueSystem();
        Vendor vendor;
        Vendor vendor2 = new Vendor();
        VendorDatabase vendorDatabase = new VendorDatabase();
        ContractNegotiation contractNegotiation = new ContractNegotiation();
        Event event;
        EventManagement eventManagement = new EventManagement();


        while (true) {

            System.out.println("1.Sign Up\n2.Sign In");
            sign = scanner1.nextInt();
            switch (sign) {
                case 1:
                    while (true) {
                        System.out.println("Choose the account type:\n1.Admin\n2.Organizer\n3.Service Provider\n4.User\n");
                        choose = scanner1.nextInt();
                        switch (choose) {
                            case 1:
                                System.out.println(PROMPT_EMAIL);
                                String email = scanner1.next();
                                System.out.println(PROMPT_USERNAME);
                                String username = scanner1.next();
                                System.out.println(PROMPT_CITY);
                                String city = scanner1.next();
                                System.out.println(PROMPT_PASSWORD);
                                String password = scanner1.next();
                                Admin.registerAdmin(email, username, city, password, STATUS_PENDING);
                                if (Admin.registerAdmin(email, username, city, password, STATUS_PENDING).equals("Admin registered successfully")) {

                                    System.out.println(REQUEST_SUBMITTED_MESSAGE);
                                } else {

                                    System.out.println(Admin.registerAdmin(email, username, city, password, STATUS_PENDING));
                                }
                                break;

                            case 2:
                                System.out.println(PROMPT_EMAIL);
                                String ema = scanner1.next();
                                System.out.println(PROMPT_USERNAME);
                                String user = scanner1.next();
                                System.out.println(PROMPT_CITY);
                                String cit = scanner1.next();
                                System.out.println(ENTER_PHONE_NUMBER);
                                String phone = scanner1.next();
                                System.out.println(PROMPT_PASSWORD);
                                String pass = scanner1.next();
                                organizerLogin.Registration(ema, pass, user, cit, phone, STATUS_PENDING);
                                System.out.println(REQUEST_SUBMITTED_MESSAGE);
                                break;
                            case 3:
                                System.out.println(PROMPT_EMAIL);
                                String em = scanner1.next();
                                System.out.println(PROMPT_USERNAME);
                                String use = scanner1.next();
                                System.out.println(PROMPT_CITY);
                                String ci = scanner1.next();
                                System.out.println("Enter Your Address:");
                                String address = scanner1.next();
                                System.out.println(ENTER_PHONE_NUMBER);
                                String pho = scanner1.next();
                                System.out.println(PROMPT_PASSWORD);
                                String pas = scanner1.next();
                                Service.registerService(em, use, ci, address, STATUS_PENDING, pho, pas);
                                if (Service.registerService(em, use, ci, address, STATUS_PENDING, pho, pas).equals("Service registered successfully")) {

                                    System.out.println(REQUEST_SUBMITTED_MESSAGE);
                                } else {

                                    System.out.println(Service.registerService(em, use, ci, address, STATUS_PENDING, pho, pas));
                                }
                                break;
                            case 4:
                                System.out.println(PROMPT_EMAIL);
                                String e = scanner1.next();
                                System.out.println(PROMPT_USERNAME);
                                String us = scanner1.next();
                                System.out.println(PROMPT_CITY);
                                String c = scanner1.next();
                                System.out.println(ENTER_PHONE_NUMBER);
                                String ph = scanner1.next();
                                System.out.println(PROMPT_PASSWORD);
                                String pa = scanner1.next();
                                UserService.registerUser(e, us, c, ph, pa);
                                if (UserService.registerUser(e, us, c, ph, pa).equals("User registered successfully")) {

                                    System.out.println("Account successfully created");
                                } else {

                                    System.out.println(UserService.registerUser(e, us, c, ph, pa));
                                }
                                break;

                            default:
                                System.out.println(INVALID_INPUT_MESSAGE);
                                break;
                        }
                        if (choose <= 4)
                            break;
                    }

                    break;

                case 2:
                    while (in != 6 && in2 != 14 && in3 != 9 && in4 != 11) {

                        System.out.println("Enter Email:");
                        String email = scanner2.next();
                        System.out.println("Enter Password:");
                        String password = scanner2.next();


                        if (Admin.login(email, password).equals("Admin logged in successfully")) {

                            while (in != 6) {

                                System.out.println("1.Show EventList\n2.Show list of requests to create account\n" +
                                        "3.Accept all requests to create account\n4.Accept request to create account\n" +
                                        "5.Reject request to create account\n6.Exit");
                                in = scanner2.nextInt();

                                switch (in) {

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
                                        String ema = scanner2.next();
                                        Admin.Accept(ema);
                                        break;

                                    case 5:
                                        System.out.println("Enter email of the account you want to reject:");
                                        String em = scanner2.next();
                                        System.out.println("Enter the reason for rejection:");
                                        String reason = scanner2.next();
                                        if (Admin.setReasonRejection(em, reason)) {
                                            System.out.println("Rejected successfully");
                                        } else {
                                            System.out.println("Email not found");
                                        }
                                        break;

                                    case 6:
                                        break;

                                    default:
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                        break;


                                }

                            }
                        } else if (organizerLogin.Login(email, password)) {

                            while (in2 != 14) {

                                System.out.println("1.Show list of event requests\n2.Show requests for modification events\n" +
                                        "3.Show requests for deletion event\n4.Accept add event\n5.Reject add event\n" +
                                        "6.Accept modification for event\n7.Reject modification for event\n" +
                                        "8.Accept delet an event\n9.Add expense tracker\n10.Update expense tracker\n" +
                                        "11.Show all expenses\n12.Add new venue\n13.Delet venue\n14.Exit");
                                in2 = scanner3.nextInt();

                                switch (in2) {

                                    case 1:
                                        organizerManagement.reviewsThePendingEventAddition();
                                        break;

                                    case 2:
                                        organizerManagement.reviewsThePendingModification();
                                        break;

                                    case 3:
                                        organizerManagement.reviewsThePendingDeletion();
                                        break;

                                    case 4:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int eventNumber = scanner3.nextInt();
                                        System.out.println(organizerManagement.acceptAddEvent(eventNumber));
                                        break;

                                    case 5:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int ev = scanner3.nextInt();
                                        System.out.println("Enter the reason for rejection: ");
                                        String re = scanner3.next();
                                        System.out.println(organizerManagement.rejectAddEvent(ev, re));
                                        break;

                                    case 6:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int eve = scanner3.nextInt();
                                        System.out.println(organizerManagement.acceptModification(eve));
                                        break;

                                    case 7:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int e = scanner3.nextInt();
                                        System.out.println("Enter the reason for rejection: ");
                                        String res = scanner3.next();
                                        System.out.println(organizerManagement.rejectModification(e, res));
                                        break;

                                    case 8:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int even = scanner3.nextInt();
                                        System.out.println(organizerManagement.acceptDeletEvent(even));
                                        break;

                                    case 9:
                                        System.out.println("Enter amount of expense: ");
                                        double amount = scanner2.nextDouble();
                                        System.out.println("Enter category: ");
                                        String category = scanner3.next();
                                        System.out.println("Enter description: ");
                                        String des = scanner3.next();
                                        expenseTracker.addExpense(amount, category, des);
                                        System.out.println("Expense added successfully");
                                        break;

                                    case 10:
                                        System.out.println("Enter id of expense: ");
                                        int id = scanner3.nextInt();
                                        System.out.println("Enter amount of expense: ");
                                        double amo = scanner2.nextDouble();
                                        System.out.println("Enter category: ");
                                        String cate = scanner3.next();
                                        System.out.println("Enter description: ");
                                        String de = scanner3.next();
                                        if (expenseTracker.updateExpense(id, amo, cate, de))
                                            System.out.println("Expense updated successfully");
                                        else
                                            System.out.println("Expense not found");
                                        break;

                                    case 11:
                                        System.out.println(expenseTracker.getExpenses());
                                        break;

                                    case 12:
                                        System.out.println("Enter name of venue: ");
                                        String name = scanner3.next();
                                        System.out.println("Enter location of venue: ");
                                        String location = scanner3.next();
                                        System.out.println("Enter capacity of venue: ");
                                        int capacity = scanner3.nextInt();
                                        System.out.println("Enter amenities of venue: ");
                                        String amenities = scanner3.next();
                                        System.out.println("Enter pricing of venue: ");
                                        double pricing = scanner3.nextDouble();
                                        System.out.println(venueSystem.addVenue(name, location, capacity, amenities, pricing));
                                        break;

                                    case 13:
                                        System.out.println("Enter name of venue: ");
                                        String name1 = scanner3.next();
                                        System.out.println("Enter location of venue: ");
                                        String location1 = scanner3.next();
                                        if (venueSystem.deletVenue(name1, location1))
                                            System.out.println("Venue deleted successfully ");
                                        else
                                            System.out.println("Venue not found ");
                                        break;

                                    case 14:
                                        break;

                                    default:
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                        break;

                                }

                            }
                        } else if (Service.login(email, password).equals("Service logged in successfully")) {

                            while (in3 != 9) {

                                System.out.println("1.Add new vendor\n2.Show all vendor\n3.Filters vendors based on provided criteria\n" +
                                        "4.Package request\n5.Finalize the negotiation\n" +
                                        "6.Add new contract negotiation\n7.Show all package request\n" +
                                        "8.Show all Contract negotiation\n9.Exit");
                                in3 = scanner4.nextInt();

                                switch (in3) {

                                    case 1:
                                        System.out.println("Enter id of vendor:");
                                        String id = scanner4.next();
                                        System.out.println("Enter name of vendor:");
                                        String name = scanner4.next();
                                        System.out.println("Enter type of vendor:");
                                        String type = scanner4.next();
                                        System.out.println("Enter service of vendor:");
                                        String service = scanner4.next();
                                        System.out.println("Enter location of vendor:");
                                        String location = scanner4.next();
                                        System.out.println("Enter availability of vendor(true/false):");
                                        boolean availability = scanner4.nextBoolean();
                                        System.out.println("Enter the vendor's service price:");
                                        double price = scanner4.nextDouble();
                                        System.out.println("Enter review score of vendor:");
                                        double review = scanner4.nextDouble();
                                        vendor = new Vendor(id, name, type, service, location, availability, price, review);
                                        vendorDatabase.addVendor(vendor);
                                        System.out.println("Vendor added successfully");
                                        break;

                                    case 2:
                                        System.out.println(vendorDatabase.getAllVendors());
                                        break;

                                    case 3:
                                        System.out.println("Enter location:");
                                        String loc = scanner4.next();
                                        System.out.println("Enter availability(true/false):");
                                        boolean avail = scanner4.nextBoolean();
                                        System.out.println("Enter the price:");
                                        double pri = scanner4.nextDouble();
                                        System.out.println("Enter review score:");
                                        double rev = scanner4.nextDouble();
                                        System.out.println(vendorDatabase.filterVendors(loc, avail, pri, rev));
                                        break;

                                    case 4:
                                        System.out.println("Enter request id:");
                                        String re = scanner4.next();
                                        System.out.println("Enter vendor id:");
                                        String ve = scanner4.next();
                                        System.out.println("Enter details:");
                                        String de = scanner4.next();
                                        PackageRequest packageRequest = PackageRequest(re,ve,de);
                                        vendorDatabase.requestPackageFromVendor(ve, packageRequest);
                                        System.out.println("Requested successfully");
                                        break;

                                    case 5:
                                        System.out.println("Enter agreed(true/false):");
                                        boolean agreed = scanner4.nextBoolean();
                                        System.out.println("Enter update terms:");
                                        String ut = scanner4.next();
                                        contractNegotiation.finalizeNegotiation(agreed, ut);
                                        System.out.println("Finalized the negotiation successfully");
                                        break;

                                    case 6:
                                        System.out.println("Enter negotiation id:");
                                        String ne = scanner4.next();
                                        System.out.println("Enter vendor id:");
                                        String ven = scanner4.next();
                                        System.out.println("Enter agreed(true/false):");
                                        boolean ag = scanner4.nextBoolean();
                                        System.out.println("Enter terms:");
                                        String terms = scanner4.next();
                                        contractNegotiation = new ContractNegotiation(ne, ven, ag, terms);
                                        vendor2.negotiateContract(contractNegotiation);
                                        System.out.println("Contracted negotiation successfully");
                                        break;

                                    case 7:
                                        System.out.println(vendor2.getPackageRequests());
                                        break;

                                    case 8:
                                        System.out.println(vendor2.getContractNegotiations());
                                        break;

                                    case 9:
                                        break;

                                    default:
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                        break;


                                }


                            }

                        } else if (UserService.login(email, password).equals("User logged in successfully")) {

                            while (in4 != 11) {

                                System.out.println("1.Add new event\n2.Select category\n3.Edit your event date\n" +
                                        "4.Edit your event time\n5.Edit your event location\n" +
                                        "6.Edit your event theme\n7.Edit your event description\n" +
                                        "8.Delet your event\n9.Show calender for event\n" +
                                        "10.Request a package at a specific price\n11.Exit");
                                in4 = scanner5.nextInt();
                                DateTimeFormatter formatter;

                                switch (in4) {

                                    case 1:
                                        int eventNumber = random.nextInt(maxValue - minValue + 1) + minValue;
                                        System.out.println("Enter date(YYYY-MM-DD):");
                                        String Date = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
                                        LocalDate date = LocalDate.now();
                                        try {
                                            date = LocalDate.parse(Date, formatter);
                                        } catch (Exception e) {
                                            System.out.println(INVALID_DATE_FORMAT_MESSAGE);
                                        }
                                        System.out.println("Enter Time(HH:MM):");
                                        String Time = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern("HH:mm");
                                        LocalTime time = LocalTime.now();
                                        try {
                                            time = LocalTime.parse(Time, formatter);
                                        } catch (Exception e) {
                                            System.out.println("Invalid time format. Please enter the time in the format HH:mm.");
                                        }
                                        System.out.println("Enter location:");
                                        String location = scanner5.next();
                                        System.out.println("Enter theme:");
                                        String theme = scanner5.next();
                                        System.out.println("Enter description:");
                                        String de = scanner5.next();
                                        event = new Event(eventNumber, date, time, location, theme, de, null);
                                        eventManagement.AddEvent(event);
                                        System.out.println("Your event number: " + eventNumber);
                                        System.out.println("The event has been added. Please wait for the organizer’s approval");
                                        break;

                                    case 2:
                                        eventManagement.ShowCategory();
                                        System.out.println("Enter number of category:");
                                        int category = scanner5.nextInt();
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int e = scanner5.nextInt();
                                        eventManagement.SelectCategory(e, category);
                                        if (EventManagement.setCategoryFlag)
                                            System.out.println("Category selected successfully");
                                        else
                                            System.out.println("Event not found");
                                        break;

                                    case 3:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int ev = scanner5.nextInt();
                                        System.out.println("Enter new date(YYYY-MM-DD):");
                                        String DN = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
                                        LocalDate dn = LocalDate.now();
                                        try {
                                            dn = LocalDate.parse(DN, formatter);
                                        } catch (Exception ex) {
                                            System.out.println(INVALID_DATE_FORMAT_MESSAGE);
                                        }
                                        eventManagement.EditDate(ev, dn);
                                        System.out.println(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 4:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int eve = scanner5.nextInt();
                                        System.out.println("Enter Time(HH:MM):");
                                        String TN = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern("HH:mm");
                                        LocalTime tn = LocalTime.now();
                                        try {
                                            tn = LocalTime.parse(TN, formatter);
                                        } catch (Exception ex) {
                                            System.out.println(INVALID_DATE_FORMAT_MESSAGE);
                                        }
                                        eventManagement.EditTime(eve, tn);
                                        System.out.println(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;


                                    case 5:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int even = scanner5.nextInt();
                                        System.out.println("Enter new location:");
                                        String lo = scanner5.next();
                                        eventManagement.EditLocation(even, lo);
                                        System.out.println(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 6:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int eventN = scanner5.nextInt();
                                        System.out.println("Enter new theme:");
                                        String them = scanner5.next();
                                        eventManagement.EditLocation(eventN, them);
                                        System.out.println(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 7:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int eventNu = scanner5.nextInt();
                                        System.out.println("Enter new description:");
                                        String des = scanner5.next();
                                        eventManagement.EditLocation(eventNu, des);
                                        System.out.println(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 8:
                                        System.out.println(PROMPT_EVENT_NUMBER);
                                        int eventNum = scanner5.nextInt();
                                        eventManagement.DeletEvent(eventNum);
                                        System.out.println("The deletion request has been added. Please wait for the organizer’s approval");
                                        break;

                                    case 9:
                                        ShowCalendar showCalendar = new ShowCalendar();
                                        System.out.println("Enter month:");
                                        int month = scanner5.nextInt();
                                        System.out.println("Enter year:");
                                        int year = scanner5.nextInt();
                                        showCalendar.PrintCalender(month, year);
                                        System.out.println("Note:The days in red color are reserved.");
                                        break;

                                    case 10:
                                        System.out.println("Enter budget:");
                                        int budget = scanner5.nextInt();
                                        System.out.println("Enter new date(YYYY-MM-DD):");
                                        String d = scanner5.next();
                                        SimpleDateFormat formatter1 = new SimpleDateFormat(DATE_FORMAT_PATTERN);
                                        java.util.Date date1 = null;
                                        try {

                                            date1 = formatter1.parse(d);

                                        } catch (ParseException ee) {
                                            System.out.println("Invalid date format.");
                                        }

                                        HallRepositoryImpl hallRepository = new HallRepositoryImpl() {
                                            @Override
                                            public List<Hall> findHallsByCriteria(int budget, String eventType, java.util.Date date) {

                                                System.out.println("Searching for halls with budget <= " + budget + " and date == " + date);
                                                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PATTERN);
                                                List<Hall> matchingHalls = new ArrayList<>();
                                                for (Hall hall : hallDatabase.values()) {
                                                    System.out.println("Hall: " + hall.getName() + ", Rent: " + hall.getRent() + ", Date: " + hall.getAvailableDate());
                                                    if (hall.getRent() <= budget && hall.getAvailableDate().compareTo(date) == 0) {
                                                        matchingHalls.add(hall);
                                                    }
                                                }


                                                return matchingHalls;
                                            }

                                        };
                                        System.out.println(hallRepository.findHallsByCriteria(budget, date1));
                                        break;

                                    case 11:
                                        break;

                                    default:
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                        break;

                                }


                            }

                        } else {

                            System.out.println("Invalid email or password pleas try again:");
                            break;
                        }


                    }

                    break;

                default:
                    System.out.println(INVALID_INPUT_MESSAGE);
                    break;
            }

            break;
        }

    }
}

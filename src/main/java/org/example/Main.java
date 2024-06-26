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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.security.SecureRandom;
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
 private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Map<Integer, Hall> hallDatabase = new HashMap<>();


        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
     SecureRandom random = new SecureRandom(); 
byte bytes[] = new byte[20];
random.nextBytes(bytes);

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

            logger.info("1.Sign Up\n2.Sign In");
            sign = scanner1.nextInt();
            switch (sign) {
                case 1:
                    while (true) {
                       logger.info("Choose the account type:\n1.Admin\n2.Organizer\n3.Service Provider\n4.User\n");
                        choose = scanner1.nextInt();
                        switch (choose) {
                            case 1:
                                logger.info(PROMPT_EMAIL);
                                String email = scanner1.next();
                               logger.info(PROMPT_USERNAME);
                                String username = scanner1.next();
                                 logger.info(PROMPT_CITY);
                                String city = scanner1.next();
                              logger.info(PROMPT_PASSWORD);
                                String password = scanner1.next();
                                Admin.registerAdmin(email, username, city, password, STATUS_PENDING);
                                if (Admin.registerAdmin(email, username, city, password, STATUS_PENDING).equals("Admin registered successfully")) {

                                    logger.info(REQUEST_SUBMITTED_MESSAGE);
                                } else {

                                     if (logger.isInfoEnabled()) {
    String registrationResult = Admin.registerAdmin(email, username, city, password, STATUS_PENDING);
    logger.info(registrationResult);
}
                                }
                                break;

                            case 2:
                              logger.info(PROMPT_EMAIL);
                                String ema = scanner1.next();
                                 logger.info(PROMPT_USERNAME);
                                String user = scanner1.next();
                                logger.info(PROMPT_CITY);
                                String cit = scanner1.next();
                             logger.info(ENTER_PHONE_NUMBER);
                                String phone = scanner1.next();
                                  logger.info(PROMPT_PASSWORD);
                                String pass = scanner1.next();
                                organizerLogin.Registration(ema, pass, user, cit, phone, STATUS_PENDING);
                                logger.info(REQUEST_SUBMITTED_MESSAGE);
                                break;
                            case 3:
                              logger.info(PROMPT_EMAIL);
                                String em = scanner1.next();
                               logger.info(PROMPT_USERNAME);
                                String use = scanner1.next();
                                logger.info(PROMPT_CITY);
                                String ci = scanner1.next();
                             logger.info("Enter Your Address:");
                                String address = scanner1.next();
                                logger.info(ENTER_PHONE_NUMBER);
                                String pho = scanner1.next();
                              logger.info(PROMPT_PASSWORD);
                                String pas = scanner1.next();
                                Service.registerService(em, use, ci, address, STATUS_PENDING, pho, pas);
                                if (Service.registerService(em, use, ci, address, STATUS_PENDING, pho, pas).equals("Service registered successfully")) {

                                   logger.info(REQUEST_SUBMITTED_MESSAGE);
                                } else {

                                 if (logger.isInfoEnabled()) {
    String registrationResult = Service.registerService(em, use, ci, address, STATUS_PENDING, pho, pas);
    logger.info(registrationResult);
}

                                }
                                break;
                            case 4:
                               logger.info(PROMPT_EMAIL);
                                String e = scanner1.next();
                                logger.info(PROMPT_USERNAME);
                                String us = scanner1.next();
                                 logger.info(PROMPT_CITY);
                                String c = scanner1.next();
                              logger.info(ENTER_PHONE_NUMBER);
                                String ph = scanner1.next();
                                logger.info(PROMPT_PASSWORD);
                                String pa = scanner1.next();
                                UserService.registerUser(e, us, c, ph, pa);
                                if (UserService.registerUser(e, us, c, ph, pa).equals("User registered successfully")) {

                                     logger.info("Account successfully created");
                                } else {

                               if (logger.isInfoEnabled()) {
    String result = UserService.registerUser(e, us, c, ph, pa);
    logger.info(result);
}

                                }
                                break;

                            default:
                                logger.info(INVALID_INPUT_MESSAGE);
                                break;
                        }
                        if (choose <= 4)
                            break;
                    }

                    break;

                case 2:
                    while (in != 6 && in2 != 14 && in3 != 9 && in4 != 11) {

                       logger.info("Enter Email:");
                        String email = scanner2.next();
                       logger.info("Enter Password:");
                        String password = scanner2.next();


                        if (Admin.login(email, password).equals("Admin logged in successfully")) {

                            while (in != 6) {

                             logger.info("1.Show EventList\n2.Show list of requests to create account\n" +
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
                                      logger.info("Enter email of the account you want to accept:");
                                        String ema = scanner2.next();
                                        Admin.Accept(ema);
                                        break;

                                    case 5:
                                       logger.info("Enter email of the account you want to reject:");
                                        String em = scanner2.next();
                                      logger.info("Enter the reason for rejection:");
                                        String reason = scanner2.next();
                                        if (Admin.setReasonRejection(em, reason)) {
                                            logger.info("Rejected successfully");
                                        } else {
                                          logger.info("Email not found");
                                        }
                                        break;

                                    case 6:
                                        break;

                                    default:
                                        logger.info(INVALID_INPUT_MESSAGE);
                                        break;


                                }

                            }
                        } else if (organizerLogin.Login(email, password)) {

                            while (in2 != 14) {

                               logger.info("1.Show list of event requests\n2.Show requests for modification events\n" +
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
                                        logger.info(PROMPT_EVENT_NUMBER);
                                        int eventNumber = scanner3.nextInt();
                                  if (logger.isInfoEnabled()) {
    String addEventResult = organizerManagement.acceptAddEvent(eventNumber);
    logger.info(addEventResult);
}

                                        break;

                                    case 5:
                                        logger.info(PROMPT_EVENT_NUMBER);
                                        int ev = scanner3.nextInt();
                                        logger.info("Enter the reason for rejection: ");
                                        String re = scanner3.next();
                                      if (logger.isInfoEnabled()) {
    String result = organizerManagement.rejectAddEvent(ev, re);
    logger.info(result);
}
                                        break;

                                    case 6:
                                      logger.info(PROMPT_EVENT_NUMBER);
                                        int eve = scanner3.nextInt();
                                     if (logger.isInfoEnabled()) {
    String modificationResult = organizerManagement.acceptModification(eve);
    logger.info(modificationResult);
}
                                        break;

                                    case 7:
                                       logger.info(PROMPT_EVENT_NUMBER);
                                        int e = scanner3.nextInt();
                                       logger.info("Enter the reason for rejection: ");
                                        String res = scanner3.next();
                               if (logger.isInfoEnabled()) {
    String message = organizerManagement.rejectModification(e, res);
    logger.info("{}", message);
}

                                        break;

                                    case 8:
                                      logger.info(PROMPT_EVENT_NUMBER);
                                        int even = scanner3.nextInt();
                                        if (logger.isInfoEnabled()) {
    String result = organizerManagement.acceptDeletEvent(even);
    logger.info(result);
}

                                        break;

                                    case 9:
                                        logger.info("Enter amount of expense: ");
                                        double amount = scanner2.nextDouble();
                                        logger.info("Enter category: ");
                                        String category = scanner3.next();
                                        logger.info("Enter description: ");
                                        String des = scanner3.next();
                                        expenseTracker.addExpense(amount, category, des);
                                        logger.info("Expense added successfully");
                                        break;

                                    case 10:
                                        logger.info("Enter id of expense: ");
                                        int id = scanner3.nextInt();
                                        logger.info("Enter amount of expense: ");
                                        double amo = scanner2.nextDouble();
                                        logger.info("Enter category: ");
                                        String cate = scanner3.next();
                                       logger.info("Enter description: ");
                                        String de = scanner3.next();
                                        if (expenseTracker.updateExpense(id, amo, cate, de))
                                             logger.info("Expense updated successfully");
                                        else
                                             logger.info("Expense not found");
                                        break;

                                    case 11:
                                             logger.info("{}",expenseTracker.getExpenses());
                                        break;

                                    case 12:
                                         logger.info("Enter name of venue: ");
                                        String name = scanner3.next();
                                         logger.info("Enter location of venue: ");
                                        String location = scanner3.next();
                                        logger.info("Enter capacity of venue: ");
                                        int capacity = scanner3.nextInt();
                                        logger.info("Enter amenities of venue: ");
                                        String amenities = scanner3.next();
                                       logger.info("Enter pricing of venue: ");
                                        double pricing = scanner3.nextDouble();
if (logger.isInfoEnabled()) {
    logger.info("{}", venueSystem.addVenue(name, location, capacity, amenities, pricing));
}                                        break;

                                    case 13:
                                         logger.info("Enter name of venue: ");
                                        String name1 = scanner3.next();
                                       logger.info("Enter location of venue: ");
                                        String location1 = scanner3.next();
                                        if (venueSystem.deletVenue(name1, location1))
                                           logger.info("Venue deleted successfully ");
                                        else
                                           logger.info("Venue not found ");
                                        break;

                                    case 14:
                                        break;

                                    default:
                                         logger.info(INVALID_INPUT_MESSAGE);
                                        break;

                                }

                            }
                        } else if (Service.login(email, password).equals("Service logged in successfully")) {

                            while (in3 != 9) {

                                logger.info("1.Add new vendor\n2.Show all vendor\n3.Filters vendors based on provided criteria\n" +
                                        "4.Package request\n5.Finalize the negotiation\n" +
                                        "6.Add new contract negotiation\n7.Show all package request\n" +
                                        "8.Show all Contract negotiation\n9.Exit");
                                in3 = scanner4.nextInt();

                                switch (in3) {

                                    case 1:
                                        logger.info("Enter id of vendor:");
                                        String id = scanner4.next();
                                       logger.info("Enter name of vendor:");
                                        String name = scanner4.next();
                                        logger.info("Enter type of vendor:");
                                        String type = scanner4.next();
                                         logger.info("Enter service of vendor:");
                                        String service = scanner4.next();
                                         logger.info("Enter location of vendor:");
                                        String location = scanner4.next();
                                        logger.info("Enter availability of vendor(true/false):");
                                        boolean availability = scanner4.nextBoolean();
                                         logger.info("Enter the vendor's service price:");
                                        double price = scanner4.nextDouble();
                                        logger.info("Enter review score of vendor:");
                                        double review = scanner4.nextDouble();
                                        vendor = new Vendor(id, name, type, service, location, availability, price, review);
                                        vendorDatabase.addVendor(vendor);
                                         logger.info("Vendor added successfully");
                                        break;

                                    case 2:
                                           logger.info("{}",vendorDatabase.getAllVendors());
                                        break;

                                    case 3:
                                        logger.info("Enter location:");
                                        String loc = scanner4.next();
                                         logger.info("Enter availability(true/false):");
                                        boolean avail = scanner4.nextBoolean();
                                        logger.info("Enter the price:");
                                        double pri = scanner4.nextDouble();
                                        logger.info("Enter review score:");
                                        double rev = scanner4.nextDouble();
                                            logger.info("{}",vendorDatabase.filterVendors(loc, avail, pri, rev));
                                        break;

                                    case 4:
                                         logger.info("Enter request id:");
                                        String re = scanner4.next();
                                       logger.info("Enter vendor id:");
                                        String ve = scanner4.next();
                                       logger.info("Enter details:");
                                        String de = scanner4.next();
                                        PackageRequest packageRequest = new PackageRequest(re,ve,de);
                                        vendorDatabase.requestPackageFromVendor(ve, packageRequest);
                                       logger.info("Requested successfully");
                                        break;

                                    case 5:
                                       logger.info("Enter agreed(true/false):");
                                        boolean agreed = scanner4.nextBoolean();
                                         logger.info("Enter update terms:");
                                        String ut = scanner4.next();
                                        contractNegotiation.finalizeNegotiation(agreed, ut);
                                       logger.info("Finalized the negotiation successfully");
                                        break;

                                    case 6:
                                       logger.info("Enter negotiation id:");
                                        String ne = scanner4.next();
                                      logger.info("Enter vendor id:");
                                        String ven = scanner4.next();
                                     logger.info("Enter agreed(true/false):");
                                        boolean ag = scanner4.nextBoolean();
                                        logger.info("Enter terms:");
                                        String terms = scanner4.next();
                                        contractNegotiation = new ContractNegotiation(ne, ven, ag, terms);
                                        vendor2.negotiateContract(contractNegotiation);
                                         logger.info("Contracted negotiation successfully");
                                        break;

                                    case 7:
                                             logger.info("{}",vendor2.getPackageRequests());
                                        break;

                                    case 8:
                                         logger.info("{}",vendor2.getContractNegotiations());
                                        break;

                                    case 9:
                                        break;

                                    default:
                                        logger.info(INVALID_INPUT_MESSAGE);
                                        break;


                                }


                            }

                        } else if (UserService.login(email, password).equals("User logged in successfully")) {

                            while (in4 != 11) {

                                logger.info("1.Add new event\n2.Select category\n3.Edit your event date\n" +
                                        "4.Edit your event time\n5.Edit your event location\n" +
                                        "6.Edit your event theme\n7.Edit your event description\n" +
                                        "8.Delet your event\n9.Show calender for event\n" +
                                        "10.Request a package at a specific price\n11.Exit");
                                in4 = scanner5.nextInt();
                                DateTimeFormatter formatter;

                                switch (in4) {

                                    case 1:
                                        int eventNumber = random.nextInt(maxValue - minValue + 1) + minValue;
                                       logger.info("Enter date(YYYY-MM-DD):");
                                        String Date = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
                                        LocalDate date = LocalDate.now();
                                        try {
                                            date = LocalDate.parse(Date, formatter);
                                        } catch (Exception e) {
                                          logger.info(INVALID_DATE_FORMAT_MESSAGE);
                                        }
                                        logger.info("Enter Time(HH:MM):");
                                        String Time = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern("HH:mm");
                                        LocalTime time = LocalTime.now();
                                        try {
                                            time = LocalTime.parse(Time, formatter);
                                        } catch (Exception e) {
                                           logger.info("Invalid time format. Please enter the time in the format HH:mm.");
                                        }
                                      logger.info("Enter location:");
                                        String location = scanner5.next();
                                        logger.info("Enter theme:");
                                        String theme = scanner5.next();
                                      logger.info("Enter description:");
                                        String de = scanner5.next();
                                        event = new Event(eventNumber, date, time, location, theme, de, null);
                                        EventManagement.AddEvent(event);
                                       logger.info("Your event number: {}", eventNumber);

                                      logger.info("The event has been added. Please wait for the organizer’s approval");
                                        break;

                                    case 2:
                                        eventManagement.ShowCategory();
                                      logger.info("Enter number of category:");
                                        int category = scanner5.nextInt();
                                      logger.info(PROMPT_EVENT_NUMBER);
                                        int e = scanner5.nextInt();
                                        EventManagement.SelectCategory(e, category);
                                        if (EventManagement.setCategoryFlag)
                                          logger.info("Category selected successfully");
                                        else
                                            logger.info("Event not found");
                                        break;

                                    case 3:
                                        logger.info(PROMPT_EVENT_NUMBER);
                                        int ev = scanner5.nextInt();
                                     logger.info("Enter new date(YYYY-MM-DD):");
                                        String DN = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
                                        LocalDate dn = LocalDate.now();
                                        try {
                                            dn = LocalDate.parse(DN, formatter);
                                        } catch (Exception ex) {
                                           logger.info(INVALID_DATE_FORMAT_MESSAGE);
                                        }
                                        EventManagement.EditDate(ev, dn);
                                      logger.info(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 4:
                                     logger.info(PROMPT_EVENT_NUMBER);
                                        int eve = scanner5.nextInt();
                                        logger.info("Enter Time(HH:MM):");
                                        String TN = scanner5.next();
                                        formatter = DateTimeFormatter.ofPattern("HH:mm");
                                        LocalTime tn = LocalTime.now();
                                        try {
                                            tn = LocalTime.parse(TN, formatter);
                                        } catch (Exception ex) {
                                           logger.info(INVALID_DATE_FORMAT_MESSAGE);
                                        }
                                        EventManagement.EditTime(eve, tn);
                                        logger.info(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;


                                    case 5:
                                     logger.info(PROMPT_EVENT_NUMBER);
                                        int even = scanner5.nextInt();
                                       logger.info("Enter new location:");
                                        String lo = scanner5.next();
                                        EventManagement.EditLocation(even, lo);
                                      logger.info(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 6:
                                     logger.info(PROMPT_EVENT_NUMBER);
                                        int eventN = scanner5.nextInt();
                                       logger.info("Enter new theme:");
                                        String them = scanner5.next();
                                        EventManagement.EditLocation(eventN, them);
                                       logger.info(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 7:
                                      logger.info(PROMPT_EVENT_NUMBER);
                                        int eventNu = scanner5.nextInt();
                                      logger.info("Enter new description:");
                                        String des = scanner5.next();
                                       EventManagement.EditLocation(eventNu, des);
                                        logger.info(EDIT_ADDED_APPROVAL_MESSAGE);
                                        break;

                                    case 8:
                                       logger.info(PROMPT_EVENT_NUMBER);
                                        int eventNum = scanner5.nextInt();
                                        EventManagement.DeletEvent(eventNum);
                                     logger.info("The deletion request has been added. Please wait for the organizer’s approval");
                                        break;

                                    case 9:
                                        ShowCalendar showCalendar = new ShowCalendar();
                                        logger.info("Enter month:");
                                        int month = scanner5.nextInt();
                                        logger.info("Enter year:");
                                        int year = scanner5.nextInt();
                                        showCalendar.PrintCalender(month, year);
                                        logger.info("Note:The days in red color are reserved.");
                                        break;

                                    case 10:
                                      logger.info("Enter budget:");
                                        int budget = scanner5.nextInt();
                                       logger.info("Enter new date(YYYY-MM-DD):");
                                        String d = scanner5.next();
                                        SimpleDateFormat formatter1 = new SimpleDateFormat(DATE_FORMAT_PATTERN);
                                        java.util.Date date1 = null;
                                        try {

                                            date1 = formatter1.parse(d);

                                        } catch (ParseException ee) {
                                           logger.info("Invalid date format.");
                                        }

                                        HallRepositoryImpl hallRepository = new HallRepositoryImpl() {
                                            @Override
                                            public List<Hall> findHallsByCriteria(int budget, String eventType, java.util.Date date) {

if (logger.isInfoEnabled()) {
    String formattedDate = new SimpleDateFormat(DATE_FORMAT_PATTERN).format(date);
    logger.info("Searching for halls with budget <= {} and date == {}", budget, formattedDate);
}

                                                List<Hall> matchingHalls = new ArrayList<>();
                                                for (Hall hall : hallDatabase.values()) {
logger.info("Hall: {}, Rent: {}, Date: {}", hall.getName(), hall.getRent(), hall.getAvailableDate());
                                                    if (hall.getRent() <= budget && hall.getAvailableDate().compareTo(date) == 0) {
                                                        matchingHalls.add(hall);
                                                    }
                                                }


                                                return matchingHalls;
                                            }

                                        };
                                            logger.info("{}",hallRepository.findHallsByCriteria(budget,date1));
                                        break;

                                    case 11:
                                        break;

                                    default:
                                       logger.info(INVALID_INPUT_MESSAGE);
                                        break;

                                }


                            }

                        } else {

                             logger.info("Invalid email or password pleas try again:");
                            break;
                        }


                    }

                    break;

                default:
                    logger.info(INVALID_INPUT_MESSAGE);
                    break;
            }
break;
        }

    }
}

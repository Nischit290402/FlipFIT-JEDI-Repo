package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.BookingService;
import com.flipkart.business.CustomerService;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the menu interface for customers to manage their profiles, bookings,
 * and other customer-related activities in the Flipfit system.
 */
public class CustomerFlipfitMenu {

    private Scanner scanner = new Scanner(System.in);

    // UserService instance to handle user-related operations
    private UserService userServiceInterface;

    // CustomerService instance to handle customer-related operations
    private CustomerService customerService = new CustomerService();
     private GymOwnerService gymOwnerService=new GymOwnerService();

    /**
     * Constructor initializes the scanner and user service interface.
     *
     * @param scanner Scanner instance for user input
     */
    public CustomerFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.userServiceInterface = new UserService();
    }

    /**
     * Registers a new customer by taking input details from the user.
     *
     * @param scanner Scanner instance for user input
     */
    public void registerCustomer(Scanner scanner) {
        System.out.println("Enter your Username");
        String username = scanner.nextLine();
        System.out.println("Enter your Password");
        String password = scanner.nextLine();
        System.out.println("Enter your Name");
        String name = scanner.nextLine();
        System.out.println("Enter your Phone");
        String phone = scanner.nextLine();
        System.out.println("Enter your Email");
        String mail = scanner.nextLine();
        System.out.println("Enter your Age");
        int age = Integer.parseInt(scanner.nextLine());

        // Create a new customer using the provided details
        customerService.createCustomer(username, name, mail, phone, age, password);
    }

    /**
     * Displays the customer menu and handles customer choices.
     *
     * @param user the logged-in customer user
     */

    public void addbookings(User user) {
        System.out.println("Enter City: ");
        String city=scanner.nextLine();
        int c=1;
        List<GymCenter> gc=gymOwnerService.getCityGymcenters().get(city);
        for(GymCenter gcc :gc){
            System.out.println(c + ". " + gcc.getGymName());
            c++;
        }
        System.out.println("Enter Gym Name: ");
        String gn=scanner.nextLine();
        if(gymOwnerService.searchcitygc(gn, city)!=null){
            System.out.println("Enter year(yyyy): ");
            int year=scanner.nextInt();
            System.out.println("Enter month(mm): ");
            int month=scanner.nextInt();
            System.out.println("Enter date(dd): ");
            int date=scanner.nextInt();
            System.out.println("Enter hour according to 24hrs clock: ");
            int hr=scanner.nextInt();
            LocalDateTime st=LocalDateTime.of(year, month, date, hr, 0, 0);
            BookingService bookingService=new BookingService();
            if(bookingService.bookSlot(user.getUserid(), gymOwnerService.searchcitygc(gn, city), st)){
                return;
            }
            else{
                System.out.println("Slot is already full.");
                CustomerService customerService=new CustomerService();
                Customer customer=customerService.customers.get(user.getUserid());
                int f=0;
                pair<Booking, Boolean> oldbk=null;
                for(pair<Booking, Boolean> bk:customer.getBookings()){
                    if(bk.getFirst().getStarttime()==st){
                        oldbk=bk;
                        if(bk.getSecond()){
                            f=1;
                        }
                    }
                }
                if(f==1){
                    System.out.println("You already have confirmed booking for this time slot "+st+" at "+oldbk.getFirst().getGymCenter().getGymName()+".");
                    System.out.println("Note: If you wish to book slot you will loose previous confirmed booking.");
                }
                System.out.println("Do you still want to book slot in waitlist?");
                System.out.println("Enter choice: ");
                System.out.println("1. YES");
                System.out.println("2. NO");
                String ch=scanner.nextLine();
                switch (ch){
                    case "1":
                        List<Slot> slots=gymOwnerService.searchcitygc(gn, city).getSlots();
                        Slot slot = null;
                        for (Slot sl:slots){
                            if(sl.getStarttime()==st){
                                slot=sl;
                                break;
                            }
                        }
                        String bkid="0"+slot.getBookings().size()+1;
                        Booking newbooking = new Booking(user.getUserid(), bkid, gymOwnerService.searchcitygc(gn, city), st);
                        bookingService.cancelslotbooking(user.getUserid(), oldbk.getFirst().getGymCenter(), st);
                        slot.getWaitings().add(newbooking);
                        customer.getBookings().add(new pair<>(newbooking,false));
                        if(f==1){
                            System.out.println("Previous overlapping booking is cancelled.");
                        }
                        System.out.println("Booking on the waitlist at "+gymOwnerService.searchcitygc(gn, city).getGymName()+" "+st+".");
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
        else{
            System.out.println("Invalid Gym Name.");
        }
    }

    public void cancelbookings(String userId) {
        System.out.println("Enter City: ");
        String city=scanner.nextLine();
        int c=1;
        List<GymCenter> gc=gymOwnerService.getCityGymcenters().get(city);
        for(GymCenter gcc :gc){
            System.out.println(c + ". " + gcc.getGymName());
            c++;
        }
        System.out.println("Enter Gym Name: ");
        String gn=scanner.nextLine();
        if(gymOwnerService.searchcitygc(gn, city)!=null){
            System.out.println("Enter year(yyyy): ");
            int year=scanner.nextInt();
            System.out.println("Enter month(mm): ");
            int month=scanner.nextInt();
            System.out.println("Enter date(dd): ");
            int date=scanner.nextInt();
            System.out.println("Enter hour according to 24hrs clock: ");
            int hr=scanner.nextInt();
            LocalDateTime st=LocalDateTime.of(year, month, date, hr, 0, 0);
            BookingService bookingService=new BookingService();
            bookingService.cancelslotbooking(userId, gymOwnerService.searchcitygc(gn, city), st);
            System.out.println("Booking cancelled successfully.");
        }
        else{
            System.out.println("Invalid Gym Name.");
        }
    }

    public void editProfile(User user) {

        Customer customer = customerService.customers.get(user.getUserid());

        if (customer != null) {

            boolean updating = true;

            while (updating) {
                System.out.println("Choose the field to update:");
                System.out.println("1. Username");
                System.out.println("2. Name");
                System.out.println("3. Email");
                System.out.println("4. Phone");
                System.out.println("5. Age");
                System.out.println("6. Password");
                System.out.println("7. Exit");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter new username:");
                        customer.setUsername(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new name:");
                        customer.setName(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new email:");
                        customer.setEmail(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new phone:");
                        customer.setPhone(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new age:");
                        customer.setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 6:
                        System.out.println("Enter new password:");
                        customer.setPassword(scanner.nextLine());
                        break;
                    case 7:
                        updating = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            System.out.println("Customer profile updated.");
        } else {
            System.out.println("Customer not found.");
        }

    }

    public void showMenu(User user) {
        int userChoice = -1;

        // Loop until the customer chooses to exit
        while (userChoice != 6) {
            // Display customer menu options
            System.out.println("Customer Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Book Slot");
            System.out.println("4. View Bookings");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Change Password");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            // Handle customer's choice
            switch (userChoice) {
                case 1:
                    customerService.showProfile(user.getUserid());
                    break;
                case 2:
                    editProfile(user);
                    break;
                case 3:
                    addbookings(user);
                    break;
                case 4:
                    customerService.viewbookings(user.getUserid());
                    break;
                case 5:
                    cancelbookings(user.getUserid());
                    break;
                case 6:
                    changePassword(user);
                    break;
                case 7:
                    System.out.println("Logging Out!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Allows the customer to change their password.
     *
     * @param user the logged-in customer user
     */
    public void changePassword(User user) {
        System.out.println("Enter your Old Password");
        String password = scanner.nextLine();
        boolean flag = userServiceInterface.validatePassword(user, password);
        if (flag) {
            System.out.println("Enter your New Password");
            String newPassword = scanner.nextLine();
            System.out.println("Confirm your Password");
            String confirmPassword = scanner.nextLine();
            userServiceInterface.confirmPassword(user, newPassword, confirmPassword);
        } else {
            System.out.println("Wrong Old Password.");
        }
    }
}

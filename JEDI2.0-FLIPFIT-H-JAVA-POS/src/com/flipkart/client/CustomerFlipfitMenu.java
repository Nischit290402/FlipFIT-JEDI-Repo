package com.flipkart.client;

import com.flipkart.business.CustomerService;
import com.flipkart.bean.User;
import com.flipkart.business.UserService;

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
                    customerService.editProfile(user);
                    break;
                case 3:
                    // Code for booking slot should be added here
                    break;
                case 4:
                    customerService.viewbookings(user.getUserid());
                    break;
                case 5:
                    customerService.cancelbookings(user.getUserid());
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

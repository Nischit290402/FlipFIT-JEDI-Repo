package com.flipkart.client;

import com.flipkart.business.CustomerService;
import com.flipkart.bean.User;
import com.flipkart.business.UserService;

import java.util.Scanner;

public class CustomerFlipfitMenu {
    private Scanner scanner = new Scanner(System.in);
    private UserService userServiceInterface;

    public CustomerFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.userServiceInterface = new UserService();
    }
    CustomerService customerService = new CustomerService();

    public void registerCustomer(Scanner scanner){
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

        customerService.createCustomer(username, name, mail, phone, age, password);
    }

    public void showMenu(User user) {
        int userChoice = -1;

        while (userChoice != 6) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Bookings");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            CustomerService customerService = new CustomerService();
            switch (userChoice) {
                case 1:
                    customerService.showProfile(user.getUserid());
                    break;
                case 2:
                	customerService.editProfile(user);
                    break;
                case 3:
                	customerService.viewBookings(user.getUserid());
                    break;
                case 4:
                    customerService.cancelBookings(user.getUserid());
                    break;
                
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void changePassword(User user) {
        System.out.println("Enter your Old Password");
        String password = scanner.nextLine();
        boolean flag = userServiceInterface.validatePassword(user, password);
        if(flag){
            System.out.println("Enter your New Password");
            String newPassword = scanner.nextLine();
            System.out.println("Confirm your Password");
            String confirmPassword = scanner.nextLine();
            userServiceInterface.confirmPassword(user, newPassword, confirmPassword);
//            System.out.println("Password changed successfully.");
        }
        else{
            System.out.println("Wrong Old Password.");
        }
    }
}
package com.flipkart.client;

import com.flipkart.business.CustomerServiceInterface;
import com.flipkart.bean.User;

import java.util.Scanner;

public class CustomerFlipfitMenu {
    private Scanner scanner = new Scanner(System.in);
    public CustomerFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void registerCustomer(Scanner scanner){
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

        CustomerServiceInterface.createCustomer(username, name, mail, phone, age, password);
    }

    public void showMenu(User user) {
        int userChoice = -1;

        while (userChoice != 6) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. View Bookings");
            
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (userChoice) {
                case 1:
                    CustomerServiceInterface.showProfile(user.getID());
                    break;
                case 2:
                	CustomerServiceInterface.editProfile(user);
                    break;
                case 3:
                	CustomerServiceInterface.viewBookings();
                    break;
                
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
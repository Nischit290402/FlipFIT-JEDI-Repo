package com.flipkart.client;


import com.flipkart.bean.User;
import com.flipkart.business.UserServiceInterface;


import java.util.Scanner;

public class FlipfitApplication {
    public static AdminFlipfitMenu adminFlipfitMenu;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        adminFlipfitMenu = new AdminFlipfitMenu(scanner);

        System.out.println("Welcome to Flipfit");
//        AdminFlipfitMenu adminMenu = new AdminFlipfitMenu(scanner);

        int choice = -1;

        while (choice != 5) {
            System.out.println("Welcome to the Flipfit Application:");
            System.out.println("1. Login");
            System.out.println("2. Registration of the GYM Customer");
            System.out.println("3. Registration of the GYM Owner");
            System.out.println("4. Change Password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    // Call the Handle login file
                    handleLogin();
                    break;
                case 2:
                    CustomerFlipfitMenu.registerCustomer(scanner);
                    System.out.println("Customer Registered");
                    break;
                 case 3:
                    GymOwnerFlipfitMenu.registerGymOwner(scanner);
                    System.out.println("Gym Owner Registered");
                    break;
                case 4:
                    // Call the change password method
                    ForgotPasswordMenu.forgotpassword(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void handleLogin(){
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for email and password
//        System.out.print("Enter email: ");
//        String email = scanner.nextLine();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = UserServiceInterface.Login(username, password);
        if (user != null) {
            System.out.println("Logged in successfully.");
            char role = user.getID().charAt(0);
            switch (role) {
                case 'A':
                    System.out.println("Welcome Admin !!!");
                    adminFlipfitMenu.showMenu();
                    break;
                case 'B':
                    System.out.println("Welcome GymOwner !!!");
                    GymOwnerFlipfitMenu gymOwnerFlipfitMenu = new GymOwnerFlipfitMenu(scanner);
                    gymOwnerFlipfitMenu.showMenu();
                    break;
                case 'C':
                    System.out.println("Welcome Customer !!!");
                    CustomerFlipfitMenu customerFlipfitMenu = new CustomerFlipfitMenu(scanner);
                    customerFlipfitMenu.showMenu();
                    break;
                default: System.out.println("Invalid choice. Please try again.");

            }
        }
    }


}


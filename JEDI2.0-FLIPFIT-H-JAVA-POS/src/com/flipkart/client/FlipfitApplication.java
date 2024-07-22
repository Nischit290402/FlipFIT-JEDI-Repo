package com.flipkart.client;


import com.flipkart.bean.Role;
import com.flipkart.bean.User;
import com.flipkart.business.UserService;
import com.flipkart.exception.InvalidLogin;


import java.util.Scanner;

public class FlipfitApplication {
    static AdminFlipfitMenu adminFlipfitMenu = new AdminFlipfitMenu();
    public static void main(String[] args) throws InvalidLogin {
        Scanner scanner = new Scanner(System.in);
        FlipfitApplication app = new FlipfitApplication();
        CustomerFlipfitMenu customerFlipfitMenu = new CustomerFlipfitMenu(scanner);
        ForgotPasswordMenu forgotPasswordMenu = new ForgotPasswordMenu(scanner);
        GymOwnerFlipfitMenu gymOwnerFlipfitMenu = new GymOwnerFlipfitMenu(scanner);

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
                    customerFlipfitMenu.registerCustomer(scanner);
                    System.out.println("Customer Registered");
                    break;
                 case 3:
                     gymOwnerFlipfitMenu.registerGymOwner(scanner);
                    System.out.println("Gym Owner Registered");
                    break;
                case 4:
                    // Call the change password method
                    forgotPasswordMenu.forgotpassword(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void handleLogin() throws InvalidLogin {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for email and password
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        UserService userService=new UserService();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("Logged in successfully.");
            String id = user.getUserid();
            String roleId = user.getRoleId();
            switch (roleId) {
                case "A":
                    System.out.println("Welcome Admin !!!");
                    adminFlipfitMenu.showMenu(user);
                    break;
                case "B":
                    System.out.println("Welcome GymOwner !!!");
                    GymOwnerFlipfitMenu gymOwnerFlipfitMenu = new GymOwnerFlipfitMenu(scanner);
                    gymOwnerFlipfitMenu.showMenu(user);
                    break;
                case "C":
                    System.out.println("Welcome Customer !!!");
                    CustomerFlipfitMenu customerFlipfitMenu = new CustomerFlipfitMenu(scanner);
                    customerFlipfitMenu.showMenu(user);
                    break;
                default: System.out.println("Invalid choice. Please try again.");

            }
        }
    }


}

package com.flipkart.client;

import java.util.Scanner;

public class FlipfitApplication {

//    private static AuthenticationService authService = new AuthenticationService();
//    private static CustomerService customerService = new CustomerService();
//    private static OwnerService ownerService = new OwnerService();
//    private static AdminService adminService = new AdminService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    break;
                case 2:
                    // Call the registration method for Gym Customer
                    break;
                case 3:
                    // Call the registration method for Gym Owner
                    break;
                case 4:
                    // Call the change password method
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


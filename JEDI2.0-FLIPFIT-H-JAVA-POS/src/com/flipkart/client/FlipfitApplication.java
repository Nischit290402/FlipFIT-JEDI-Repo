package com.flipkart.client;


import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.client.GymOwnerFlipfitMenu;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlipfitApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Flipfit");
        System.out.println("Welcome to Admin Menu");

        AdminFlipfitMenu adminMenu = new AdminFlipfitMenu(scanner);
        adminMenu.showMenu();
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
                    GymOwnerFlipfitMenu.registerGymOwner();
                    System.out.println("Gym Owner Registered");
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


package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.client.GymOwnerFlipfitMenu;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlipfitApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to Flipfit");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("Welcome to the Flipfit Application:");
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to register as GYM Customer");
        System.out.println("Press 3 to register as GYM Owner");
        System.out.println("Press 4 to Change Password");
        System.out.println("Press 5 to Exit");
        System.out.print("Enter your choice:");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Call handle login
                break;
            case 2:
//                Map<String, Customer> customers = new HashMap<>();
//                registerGymCustomer(customers);
//                saveCustomersToFile(customers);
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


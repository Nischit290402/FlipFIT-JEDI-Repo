package com.flipkart.client;

import com.flipkart.business.CustomerServiceInterface;

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

    public void showMenu() {
        int userChoice = -1;

        while (userChoice != 6) {
            System.out.println("Customer Menu:");
            System.out.println("1. Approve Gym Center");
            System.out.println("2. Approve Gym Owner");
            System.out.println("3. List Gym Owners");
            System.out.println("4. List Gym Centers");
            System.out.println("5. List Users");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (userChoice) {
                case 1:
//                    gymOwnerBusiness.approveGymCenter();
                    break;
                case 2:
//                    gymOwnerBusiness.approveGymOwner();
                    break;
                case 3:
//                    gymOwnerBusiness.listGymOwners();
                    break;
                case 4:
//                    gymOwnerBusiness.listGymCenters();
                    break;
                case 5:
//                    gymOwnerBusiness.listUsers();
                    break;
                case 6:
//                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
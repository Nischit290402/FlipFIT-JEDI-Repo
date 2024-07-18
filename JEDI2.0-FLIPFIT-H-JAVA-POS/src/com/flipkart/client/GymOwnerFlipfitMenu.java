package com.flipkart.client;

import com.flipkart.business.GymOwnerServiceInterface;

import java.util.Scanner;

public class GymOwnerFlipfitMenu {
    private Scanner scanner;
    private GymOwnerServiceInterface gymOwnerServiceInterface;

    public GymOwnerFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.gymOwnerServiceInterface = new GymOwnerServiceInterface();
    }

    public static void registerGymOwner(Scanner scanner) {
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

        GymOwnerServiceInterface.createGymOwner(username,name, mail, phone, age, password);
    }
    public static void showGymOwnerList() {
        GymOwnerServiceInterface.listGymOwners();
    }

    public void showMenu(){
        int adminChoice = -1;

        while (adminChoice != 6) {
            System.out.println("Admin Menu:");
            System.out.println("1. Approve Gym Center");
            System.out.println("2. Approve Gym Owner");
            System.out.println("3. List Gym Owners");
            System.out.println("4. List Gym Centers");
            System.out.println("5. List Users");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            adminChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (adminChoice) {
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

package com.flipkart.client;

import com.flipkart.business.AdminBusiness;
import java.util.Scanner;

public class AdminFlipfitMenu {
    private Scanner scanner;
    private AdminBusiness adminBusiness;

    public AdminFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.adminBusiness = new AdminBusiness();
    }

    public void showMenu() {
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
                    adminBusiness.approveGymCenter();
                    break;
                case 2:
                    adminBusiness.approveGymOwner();
                    break;
                case 3:
                    adminBusiness.listGymOwners();
                    break;
                case 4:
                    adminBusiness.listGymCenters();
                    break;
                case 5:
                    adminBusiness.listUsers();
                    break;
                case 6:
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

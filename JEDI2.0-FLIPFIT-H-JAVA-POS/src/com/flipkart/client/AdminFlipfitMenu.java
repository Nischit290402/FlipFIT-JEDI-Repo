package com.flipkart.client;

import com.flipkart.business.AdminService;
import java.util.Scanner;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public class AdminFlipfitMenu {
    private Scanner scanner;
    private AdminService adminServiceInterface;

    public AdminFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.adminServiceInterface = new AdminService();
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
                    showApproveGymCenterMenu();
                    break;
                case 2:
                    showApproveGymOwnerMenu();
                    break;
                case 3:
                    adminServiceInterface.listGymOwners();
                    break;
                case 4:
                    adminServiceInterface.listGymCenters();
                    break;
                case 5:
                    adminServiceInterface.listUsers();
                    break;
                case 6:
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void showApproveGymCenterMenu() {
        int approveChoice = -1;

        while (approveChoice != 3) {
            System.out.println("Approve Gym Center:");
            System.out.println("1. Approve All Gym Centers");
            System.out.println("2. Approve Gym Center by ID");
            System.out.println("3. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            approveChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (approveChoice) {
                case 1:
                    adminServiceInterface.approveAllGymCenters();
                    break;
                case 2:
                    System.out.print("Enter Gym Center ID: ");
                    String centerId = scanner.nextLine();
                    adminServiceInterface.approveGymCenterById(centerId);
                    break;
                case 3:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void showApproveGymOwnerMenu() {
        int approveChoice = -1;

        while (approveChoice != 3) {
            System.out.println("Approve Gym Owner:");
            System.out.println("1. Approve All Gym Owners");
            System.out.println("2. Approve Gym Owner by ID");
            System.out.println("3. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            approveChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (approveChoice) {
                case 1:
                    adminServiceInterface.approveAllGymOwners();
                    break;
                case 2:
                    System.out.print("Enter Gym Owner ID: ");
                    String Id = scanner.nextLine();
                    adminServiceInterface.approveGymOwnerById(Id);
                    break;
                case 3:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

package com.flipkart.client;

import com.flipkart.business.CustomerServiceInterface;
import com.flipkart.business.UserServiceInterface;

import java.util.Scanner;
import com.flipkart.bean.User;

public class CustomerFlipfitMenu {
    private Scanner scanner = new Scanner(System.in);
    private UserServiceInterface userServiceInterface;
    public CustomerFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.userServiceInterface = new UserServiceInterface();
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
            System.out.println("1. Approve Gym Center");
            System.out.println("2. Approve Gym Owner");
            System.out.println("3. List Gym Owners");
            System.out.println("4. List Gym Centers");
            System.out.println("5. List Users");
            System.out.println("6. Change Password");
            System.out.println("7. Logout");
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
                      changePassword(user);
                case 7:
//                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void changePassword(User user) {
        System.out.println("Enter your Old Password");
        String password = scanner.nextLine();
        boolean flag = userServiceInterface.validatePassword(user, password);
        if(flag){
            System.out.println("Enter your New Password");
            String newPassword = scanner.nextLine();
            System.out.println("Confirm your Password");
            String confirmPassword = scanner.nextLine();
            userServiceInterface.confirmPassword(user, newPassword, confirmPassword);
//            System.out.println("Password changed successfully.");
        }
        else{
            System.out.println("Wrong Old Password.");
        }
    }
}
package com.flipkart.client;

import com.flipkart.business.GymOwnerService;
import com.flipkart.business.UserService;
import com.flipkart.bean.User;
import java.util.Scanner;

public class GymOwnerFlipfitMenu {
    private Scanner scanner;
    private GymOwnerService gymOwnerServiceInterface;
    private UserService userServiceInterface;

    public GymOwnerFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.gymOwnerServiceInterface = new GymOwnerService();
        this.userServiceInterface = new UserService();
    }

    public void registerGymOwner(Scanner scanner) {
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

        gymOwnerServiceInterface.createGymOwner(username,name, mail, phone, age, password);
    }
//    public void showGymOwnerList() {
//        gymOwnerServiceInterface.listGymOwners();
//    }

    public void showMenu(User user){
        int gymOwnerChoice = -1;

        while (gymOwnerChoice != 6) {
            System.out.println("Gym Owner Menu:");
            System.out.println("1. View all Gym Center");
            System.out.println("2. Add New Gym Center");
            System.out.println("3. Edit Gym Slots");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            gymOwnerChoice = scanner.nextInt();
            scanner.nextLine();

            switch (gymOwnerChoice) {
                case 1:
                    gymOwnerServiceInterface.showGymCenters(user);
                    break;
                case 2:
                    gymOwnerServiceInterface.addGymCenter(user);
                    break;
                case 3:
                    gymOwnerServiceInterface.editSlots(user);
                    break;
                case 4:
                    System.out.println("Logging out.!");
                    FlipfitApplication.homePage();
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

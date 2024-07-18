package com.flipkart.client;

import com.flipkart.business.GymOwnerServiceInterface;
import com.flipkart.business.UserServiceInterface;
import com.flipkart.bean.User;
import java.util.Scanner;

public class GymOwnerFlipfitMenu {
    private Scanner scanner;
    private GymOwnerServiceInterface gymOwnerServiceInterface;
    private UserServiceInterface userServiceInterface;

    public GymOwnerFlipfitMenu(Scanner scanner) {
        this.scanner = scanner;
        this.gymOwnerServiceInterface = new GymOwnerServiceInterface();
        this.userServiceInterface = new UserServiceInterface();
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
                    GymOwnerServiceInterface.showGymCenters(user);
                    break;
                case 2:
                    GymOwnerServiceInterface.addGymCenter(user);
                    break;
                case 3:
                    GymOwnerServiceInterface.editSlots(user);
                    break;
                case 4:
//                    GymOwnerServiceInterface.logout();
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

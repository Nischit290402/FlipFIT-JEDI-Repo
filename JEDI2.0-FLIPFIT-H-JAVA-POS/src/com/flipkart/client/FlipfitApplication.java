package com.flipkart.client;

import java.util.Scanner;

public class FlipfitApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Flipfit");
        System.out.println("Welcome to Admin Menu");

        AdminFlipfitMenu adminMenu = new AdminFlipfitMenu(scanner);
        adminMenu.showMenu();

        scanner.close(); // Optionally close the scanner when done
    }
}


//    private static void handleLogin(Scanner scanner) {
//        System.out.println("Enter username: ");
//        String username = scanner.nextLine();
//        System.out.println("Enter password: ");
//        String password = scanner.nextLine();
//
//        // Simulate authentication logic
//        boolean isAuthenticated = username.equals("admin") && password.equals("password");
//
//        if (isAuthenticated) {
//            System.out.println("Login successful.");
//            AdminMenu adminMenu = new AdminMenu(scanner);
//            adminMenu.showMenu();
//        } else {
//            System.out.println("Login failed. Please try again.");
//        }
//    }


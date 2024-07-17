package com.flipkart.client;

import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerBusiness;

import java.util.HashMap;
import java.util.Scanner;

public class GymOwnerFlipfitMenu {
public static void registerGymOwner() {
    Scanner scanner = new Scanner(System.in);
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

    GymOwnerBusiness.createGymOwner(username,name, mail, phone, age, password);
}
public static void showGymOwnerList() {
        GymOwnerBusiness.listGymOwners();
}

}

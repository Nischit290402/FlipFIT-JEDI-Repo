package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


import com.flipkart.business.UserService;


public class GymOwnerService implements  GymOwnerServiceInterface{
    private static int cnt = 1;
    UserService userService = new UserService();
    public static HashMap<String, GymOwner> GymOwnerMap  = new HashMap<String,GymOwner>();
    public void createGymOwner(String username, String name, String mail, String phone, int age, String password) {
        System.out.println("Registering Gym Owner");
        String id = "0" + cnt++;
        Role role=new Role("B", "GymOwner");
        GymOwner gymOwner = new GymOwner(username,name, mail, phone, age, password, id, role);
        GymOwnerMap.put(mail, gymOwner);
        User user = new User(username, password, id, role);
        addUser(user);

        System.out.println("Gym Owner registered successfully");
    }

    private void addUser(User user) {
    }

    public void addGymCenter(User user) {
//        String gymID, String gymName, String address, String city
//        String id = user.getUserid();
        GymOwner tempGymOwner = GymOwnerMap.get(user.getUserid());
        System.out.println("Registering Gym Center");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Gym Centre Name: ");
        String gymName = scanner.nextLine();
        System.out.println("Enter Gym Centre Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Gym Centre City: ");
        String city = scanner.nextLine();
        String id = "GC" + tempGymOwner.gymCenters.size()+1;
        GymCenter gymCenter = new GymCenter(id, gymName, address, city);
        tempGymOwner.gymCenters.add(gymCenter);
        GymOwnerMap.put(user.getUserid(), tempGymOwner);
        System.out.println("Gym Center added successfully");
    }

    public void showGymCenters(User user) {
        GymOwner gymOwner = GymOwnerMap.get(user.getUserid());
        System.out.println(gymOwner.gymCenters.get(gymOwner.gymCenters.size()-1));
//        print all gym centers

        for (GymCenter element : gymOwner.gymCenters) {
            System.out.println(element);
            }
    }
    public void editSlots(User user){
        System.out.println("Enter Gym Centre Name: ");
    }
    public boolean updateGymOwner(int gymOwnerId) {
        System.out.println("Updating Gym Owner --> " + gymOwnerId);
        return true;
    }

    public boolean deleteGymOwner(int gymOwnerId) {
        System.out.println("Deleting Gym Owner --> " + gymOwnerId);
        return true;
    }

    public void listGymOwners() {
        System.out.println("Listing Gym Owners");
//       list gym owners
        Iterator<GymOwner> gymOwnerIterator = GymOwnerMap.values().iterator();
        while (gymOwnerIterator.hasNext()) {
            GymOwner gymOwner = gymOwnerIterator.next();
            System.out.println(gymOwner);
        };
    }


}


package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class GymOwnerBusiness {
    private static int cnt = 1;
    public static HashMap<String, GymOwner> GymOwnerMap  = new HashMap<String,GymOwner>();
    public static void createGymOwner(String username, String name, String mail, String phone, int age, String password) {
        System.out.println("Creating Gym Owner");
        String id = "B" + cnt++;
        GymOwner gymOwner = new GymOwner(username,name, mail, phone, age, password,id);
        GymOwnerMap.put(mail, gymOwner);
        System.out.println("Gym Owner created");
    }

    public boolean updateGymOwner(int gymOwnerId) {
        System.out.println("Updating Gym Owner --> " + gymOwnerId);
        return true;
    }

    public boolean deleteGymOwner(int gymOwnerId) {
        System.out.println("Deleting Gym Owner --> " + gymOwnerId);
        return true;
    }

    public static void listGymOwners() {
        System.out.println("Listing Gym Owners");
//       list gym owners
        Iterator<GymOwner> gymOwnerIterator = GymOwnerMap.values().iterator();
        while (gymOwnerIterator.hasNext()) {
            GymOwner gymOwner = gymOwnerIterator.next();
            System.out.println(gymOwner);
        };

    }
}


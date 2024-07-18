package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;

import java.util.HashMap;
import java.util.Iterator;

import static com.flipkart.business.UserServiceInterface.addUser;


public class GymOwnerServiceInterface {
    private static int cnt = 1;
    public static HashMap<String, GymOwner> GymOwnerMap  = new HashMap<String,GymOwner>();
    public static void createGymOwner(String username, String name, String mail, String phone, int age, String password) {
        System.out.println("Registering Gym Owner");
        String id = "0" + cnt++;
        Role role=new Role("B", "GymOwner");
        GymOwner gymOwner = new GymOwner(username,name, mail, phone, age, password, id, role);
        GymOwnerMap.put(mail, gymOwner);
        User user = new User(username, password, id, role);
        addUser(user);

        System.out.println("Gym Owner registered successfully");
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


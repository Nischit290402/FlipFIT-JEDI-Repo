package com.flipkart.business;

import com.flipkart.bean.GymOwner;

public class GymOwnerBusiness {
    public void createGymOwner() {
        System.out.println("Creating Gym Owner");
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
    }
}

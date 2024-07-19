package com.flipkart.business;

import com.flipkart.bean.User;

public interface GymOwnerServiceInterface {
    public void createGymOwner(String username, String name, String mail, String phone, int age, String password);
    public void addGymCenter(User user);
    public void showGymCenters(User user);
    public void editSlots(User user);
    public boolean updateGymOwner(int gymOwnerId);
    public boolean deleteGymOwner(int gymOwnerId);
    public void listGymOwners();
}

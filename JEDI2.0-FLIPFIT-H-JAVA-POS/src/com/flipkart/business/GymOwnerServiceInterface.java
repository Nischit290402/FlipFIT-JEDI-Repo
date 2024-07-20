package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;

public interface GymOwnerServiceInterface {
    public void createGymOwner(String username, String name, String mail, String phone, int age, String password);
    public void addGymCenter(User user);
    public void showGymCenters(User user);
    public void editSlots(User user);
}


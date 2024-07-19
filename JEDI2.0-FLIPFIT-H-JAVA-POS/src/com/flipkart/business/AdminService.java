package com.flipkart.business;

import java.util.HashMap;
import com.flipkart.bean.Admin;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.UserService;

public class AdminService implements AdminServiceInterface {
    public AdminService(){
        initializeAdmin();
    }
    UserService userService = new UserService();
    private void initializeAdmin() {
        Admin admin = new Admin("bean", "BeanAdmin", "bean@gmail.com", "1234567890", 0, "bean@1234", "A_0", new Role("A","ADMIN"));
        User user = new User(admin.getUsername(), admin.getPassword(), admin.getUserid(), admin.getRole());
        userService.addUser(user);
    }

    @Override
    public void approveGymCenterById(String gymID) {
        System.out.println("Approving gym center " + gymID);
    }

    @Override
    public void approveGymOwnerById(String ID) {
        System.out.println("Approving gym owner " + ID);
        GymOwner tempGymOwner = GymOwnerService.PendingGymOwnerMap.get(ID);
        GymOwnerService.GymOwnerMap.put(ID, tempGymOwner);
        GymOwnerService.PendingGymOwnerMap.remove(ID);
        System.out.println("Approved gym owner " + tempGymOwner);
    }

    @Override
    public void approveAllGymCenters() {
        System.out.println("Approving all gym centers");
    }

    @Override
    public void approveAllGymOwners() {
        System.out.println("Approving all gym owners");
        for (String id : GymOwnerService.PendingGymOwnerMap.keySet()) {
            GymOwner gymOwner = GymOwnerService.PendingGymOwnerMap.get(id);
            System.out.println(id + ": " + gymOwner + " approved");
            GymOwnerService.GymOwnerMap.put(id, gymOwner);
            GymOwnerService.PendingGymOwnerMap.remove(id);
        }
        System.out.println("All gym owners approved");
    }

    @Override
    public void listPendingGymCenters() {
        System.out.println("Listing all pending gym centers");
    }

    @Override
    public void listPendingGymOwners() {
        System.out.println("Listing all pending gym owners");
    }

    @Override
    public void listGymCenters() {
        System.out.println("Listing all gym centers");
    }

    @Override
    public void listGymOwners() {
        System.out.println("Listing all gym owners");
        GymOwnerService.GymOwnerMap.forEach((id, gymOwner) -> {
            System.out.println(id + ": " + gymOwner);
        });
    }

    @Override
    public void listUsers() {
        System.out.println("Listing all users");
    }
}



package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;

import static com.flipkart.business.UserServiceInterface.addUser;

public class AdminService implements AdminServiceInterface {
    public AdminService(){
        initializeAdmin();
    }

    private void initializeAdmin() {
        Admin admin = new Admin("bean", "BeanAdmin", "bean@gmail.com", "1234567890", 0, "bean@1234", "A_0", new Role("0","ADMIN"));
        User user = new User(admin.getUsername(), admin.getPassword(), admin.getUserid(), admin.getRole());
        addUser(user);
    }

    @Override
    public void approveGymCenterById(String gymID) {
        System.out.println("Approving gym center " + gymID);
    }

    @Override
    public void approveGymOwnerById(String ID) {
        System.out.println("Approving gym owner " + ID);
    }

    @Override
    public void approveAllGymCenters() {
        System.out.println("Approving all gym centers");
    }

    @Override
    public void approveAllGymOwners() {
        System.out.println("Approving all gym owners");
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
    }

    @Override
    public void listUsers() {
        System.out.println("Listing all users");
    }
}



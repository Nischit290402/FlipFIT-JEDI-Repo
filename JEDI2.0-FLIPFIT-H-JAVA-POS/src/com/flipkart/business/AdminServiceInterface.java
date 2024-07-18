package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.User;

import static com.flipkart.business.UserServiceInterface.addUser;

public class AdminServiceInterface {
    public AdminServiceInterface(){
        initializeAdmin();
    }

    private void initializeAdmin() {
        Admin admin = new Admin("bean", "BeanAdmin", "bean@gmail.com", "1234567890", 0, "bean@1234", "A_0");
        User user = new User(admin.getUsername(), admin.getName(), admin.getEmail(), admin.getContactNo(), admin.getAge(), admin.getPassword(), admin.getID());
        addUser(user);
    }

    public void approveGymCenter() {
        System.out.println("Gym center approved");
    }

    public void approveGymOwner() {
        System.out.println("Gym owner approved");
    }

    public void listGymOwners() {
        System.out.println("This is the list of gym owners");
    }

    public void listGymCenters() {
        System.out.println("This is the list of gym centers");
    }

    public void listUsers() {
        System.out.println("This is the list of users");
    }
}



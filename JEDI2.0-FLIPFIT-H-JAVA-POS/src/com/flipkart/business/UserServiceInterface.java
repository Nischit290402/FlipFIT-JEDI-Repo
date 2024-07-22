package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exception.InvalidLogin;

public interface UserServiceInterface {
    public void addUser(User user);

    public User login(String username, String password) throws InvalidLogin;

    public boolean validatePassword(User user, String oldPassword);
    public User Login(String username, String password);
    public void confirmPassword(User user,String newPassword, String confirmPassword);
    public boolean registerGymOwner(GymOwner gymOwner);
    public boolean registerCustomer(Customer customer);
}

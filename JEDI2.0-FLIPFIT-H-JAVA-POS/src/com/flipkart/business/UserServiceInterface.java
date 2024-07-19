package com.flipkart.business;

import com.flipkart.bean.User;

public interface UserServiceInterface {
    public void addUser(User user);
    public boolean validatePassword(User user, String oldPassword);
    public User Login(String username, String password);
    public void confirmPassword(User user,String newPassword, String confirmPassword);
}

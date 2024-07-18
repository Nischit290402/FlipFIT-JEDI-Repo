
package com.flipkart.business;

import com.flipkart.bean.User;

import java.util.HashMap;

public class UserServiceInterface {
    public static HashMap<String, User> UsersMap  = new HashMap<String,User>();
    public static void addUser(User user) {
        UsersMap.put(user.getUsername(), user);
    }

    public static User Login(String username, String password) {
        User user = UsersMap.get(username);
        if(user != null) {
            if(user.getPassword().equals(password)) return user;
            else return null;
        }
        return null;
    }
    
}

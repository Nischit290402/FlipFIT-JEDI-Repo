
package com.flipkart.business;

import com.flipkart.bean.User;

import java.util.HashMap;
import java.util.Scanner;

public class UserServiceInterface {
//    private Scanner scanner = new Scanner(System.in);
//    public UserServiceInterface(Scanner scanner) {
//        this.scanner = scanner;
//    }
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

    public boolean validatePassword(User user, String oldPassword){
        String valPassword = user.getPassword();

        if(oldPassword.equals(valPassword)) {
            return true;
        }
        else{
            return false;
        }
    }

    public void confirmPassword(User user,String newPassword, String confirmPassword){
        if(newPassword.equals(confirmPassword)) {
            System.out.println("Password Changed Successfully");
            user.setPassword(newPassword);
            UsersMap.put(user.getUsername(), user);
        }
        else{
            System.out.println("Password did not match");
        }
    }

}

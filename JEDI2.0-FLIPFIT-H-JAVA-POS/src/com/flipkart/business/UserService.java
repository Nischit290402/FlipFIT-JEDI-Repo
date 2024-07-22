//
//package com.flipkart.business;
//
//import com.flipkart.bean.User;
//
//import java.util.HashMap;
//
//public class UserService implements UserServiceInterface{
//    public static HashMap<String, User> UsersMap  = new HashMap<>();
//    public void addUser(User user) {
//        UsersMap.put(user.getUsername(), user);
//    }
//
//    public User Login(String username, String password) {
//        User = UsersMap.get(username);
//        if(user != null) {
//            if(user.getPassword().equals(password)) return user;
//            else return null;
//        }
//        return null;
//    }
//
//    public boolean validatePassword(User user, String oldPassword){
//        String valPassword = user.getPassword();
//
//        return oldPassword.equals(valPassword);
//    }
//
//    public void confirmPassword(User user,String newPassword, String confirmPassword){
//        if(newPassword.equals(confirmPassword)) {
//            System.out.println("Password Changed Successfully");
//            user.setPassword(newPassword);
//            UsersMap.put(user.getUsername(), user);
//        }
//        else{
//            System.out.println("Password did not match");
//        }
//    }
//
//}

package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;
import com.flipkart.dao.UserDAO;
import com.flipkart.dao.UserDAOImpl;
import com.flipkart.exception.InvalidLogin;

import java.util.HashMap;

public class UserService implements UserServiceInterface {
    static HashMap<String, User> UsersMap = new HashMap<>();
    private UserDAO userDAO;

//    public UserService() {
//        this.userDAO = new UserDAOImpl();
//        // Add admin user
//        Role role = new Role();
//        UsersMap.put("admin", new User("admin", "admin@domain.com", "admin", ));
//    }

    @Override
    public void addUser(User user) {
        UsersMap.put(user.getUsername(), user);
    }

    @Override
    public User login(String username, String password) throws InvalidLogin {
//        User user = UsersMap.get(username);
        User user = UserDAOImpl.validateUser(username, password);
        if (user!=null) {
//            if (user.getPassword().equals(password)) {
//                return user;
//            } else {
//                throw new InvalidLogin("Incorrect password.");
//            }
            return user;
        } else {
            throw new InvalidLogin("Username not found.");
        }
    }

    @Override
    public boolean validatePassword(User user, String oldPassword) {
        return user.getPassword().equals(oldPassword);
    }

    @Override
    public User Login(String username, String password) {
        return null;
    }

    @Override
    public void confirmPassword(User user, String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            System.out.println("Password Changed Successfully");
            user.setPassword(newPassword);
            UsersMap.put(user.getUsername(), user);
        } else {
            System.out.println("Password did not match");
        }
    }

    @Override
    public boolean registerGymOwner(GymOwner gymOwner) {
        return userDAO.registerGymOwner(gymOwner);
    }

    @Override
    public boolean registerCustomer(Customer customer) {
        return userDAO.registerCustomer(customer);
    }
}


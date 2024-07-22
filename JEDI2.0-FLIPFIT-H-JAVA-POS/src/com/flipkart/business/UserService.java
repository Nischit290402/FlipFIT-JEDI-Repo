// Package declaration
        package com.flipkart.business;

// Import necessary classes
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.UserDAO;
import com.flipkart.exception.InvalidLogin;

import java.util.HashMap;

/**
 * This class implements the UserServiceInterface and provides methods
 * to manage user-related operations such as adding a user, logging in,
 * validating passwords, confirming password changes, and registering
 * gym owners and customers.
 */
public class UserService implements UserServiceInterface {
    // HashMap to store users with their usernames as keys
    static HashMap<String, User> UsersMap = new HashMap<>();
    // UserDAO instance to interact with the data access layer
    private UserDAO userDAO;

    /**
     * Adds a user to the UsersMap
     */
    @Override
    public void addUser(User user) {
        UsersMap.put(user.getUsername(), user);
    }

    /**
     * Logs in a user by validating the username and password.
     */
    @Override
    public User login(String username, String password) throws InvalidLogin {
        // Fetch the user from UsersMap based on the provided username
        User user = UsersMap.get(username);
        if (user != null) {
            // If the user is found, check the password
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new InvalidLogin("Incorrect password.");
            }
        } else {
            throw new InvalidLogin("Username not found.");
        }
    }

    /**
     * Validates if the given old password matches the user's current password.
     */
    @Override
    public boolean validatePassword(User user, String oldPassword) {
        return user.getPassword().equals(oldPassword);
    }

    /**
     * Placeholder method for login, not implemented
     */
    @Override
    public User Login(String username, String password) {
        return null;
    }

    /**
     * Confirms and updates the user's password if the new password and confirm password match.
     */
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

    /**
     * Registers a gym owner
     */
    @Override
    public boolean registerGymOwner(GymOwner gymOwner) {
        return userDAO.registerGymOwner(gymOwner);
    }

    /**
     * Registers a customer
     */
    @Override
    public boolean registerCustomer(Customer customer) {
        return userDAO.registerCustomer(customer);
    }
}
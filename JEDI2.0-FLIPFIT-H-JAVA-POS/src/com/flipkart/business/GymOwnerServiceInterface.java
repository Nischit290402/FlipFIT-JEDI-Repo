// Package declaration
package com.flipkart.business;

// Import necessary classes
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;

/**
 * This interface defines the operations related to gym owners.
 * This includes creating a gym owner, adding gym centers, showing gym centers,
 * and editing slots for gym centers.
 */
public interface GymOwnerServiceInterface {

    /**
     * Creates a new gym owner with the provided details.
     */
    public void createGymOwner(String username, String name, String mail, String phone, int age, String password);

    /**
     * Adds a gym center associated with the given user.
     */
    public void addGymCenter(User user);

    /**
     * Displays the gym centers associated with the given user.
     */
    public void showGymCenters(User user);

    /**
     * Edits the slots for the gym centers associated with the given user.
     */
    public void editSlots(User user);
}

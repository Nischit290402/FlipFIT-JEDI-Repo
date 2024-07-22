package com.flipkart.business;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.dao.UserDAOImpl;
import com.flipkart.utils.sharedState;

public class AdminService implements AdminServiceInterface {
    public AdminService(){
        initializeAdmin();
    }
    UserService userService = new UserService();
    UserDAOImpl userDAO = new UserDAOImpl();

    public static Map<String, GymCenter> gymCenters = new HashMap<>();
    public static Map<String, GymCenter> pendingCenters = new HashMap<>();
    private void initializeAdmin() {
        Role role = new Role("A","ADMIN");
        Admin admin = new Admin("bean", "BeanAdmin", "bean@gmail.com", "1234567890", 0, "bean@1234", "00", role.getRoleID());
        User user = new User(admin.getUsername(), admin.getPassword(), admin.getUserid(), admin.getRoleId());
        userService.addUser(user);
//        sharedState.incrementCntUsers();
        if(userDAO.addUser(user)) {
            System.out.println("User added successfully");
        }
    }

    @Override
    public void approveGymCenterById(String gymID) { 
        GymCenter pendingGym = pendingCenters.get(gymID);
        
        if (pendingGym != null) {
            pendingCenters.remove(gymID);
            gymCenters.put(gymID,pendingGym);
            
            System.out.println("Gym center approved: " + pendingGym.getGymName());
        } else {
            System.out.println("GymId is not exist");
        }
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
    public void approveAllGymCenters() {   //done
    	for (String key: pendingCenters.keySet()) {
    		gymCenters.put(key,pendingCenters.get(key));
    	} 
    	pendingCenters.clear();
    	System.out.println("Approved all gym Centres");
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
    public void listPendingGymCenters() {  // view 
    	System.out.println("Listing all pending gym centers");
        for (Map.Entry<String, GymCenter> entry :pendingCenters.entrySet()) {
            listGymCenterDetails(entry);
        }
    }

    private void listGymCenterDetails(Map.Entry<String, GymCenter> entry) {
        GymCenter gym = entry.getValue();
        System.out.println("Gym ID: " + gym.getGymID());
        System.out.println("Gym Name: " + gym.getGymName());
        System.out.println("Address: " + gym.getAddress());
        System.out.println("City: " + gym.getCity());
        System.out.println();
    }

    @Override
    public void listPendingGymOwners() {
        System.out.println("Listing all pending gym owners");
        GymOwnerService.PendingGymOwnerMap.forEach((id, gymOwner) -> {
            System.out.println(id + ": " + gymOwner);
        });
    }

    @Override
    public void listGymCenters() {    // view 
        System.out.println("Listing all gym centers");
        for (Map.Entry<String, GymCenter> entry :gymCenters.entrySet()) {
            listGymCenterDetails(entry);
        }
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



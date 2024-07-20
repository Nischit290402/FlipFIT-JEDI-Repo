package com.flipkart.business;
import java.util.*;

import java.util.HashMap;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.UserService;
import com.flipkart.business.GymOwnerServiceInterface;

import static com.flipkart.business.UserServiceInterface.addUser;
 
public class AdminService implements AdminServiceInterface {
    public AdminService(){
        initializeAdmin();
    }

    private void initializeAdmin() {
        Admin admin = new Admin("bean", "BeanAdmin", "bean@gmail.com", "1234567890", 0, "bean@1234", "A_0", new Role("A","ADMIN"));
        User user = new User(admin.getUsername(), admin.getPassword(), admin.getUserid(), admin.getRole());
        addUser(user);
    }

    @Override
    public void approveGymCenterById(String gymID) { 
    	GymCenter gymCenter = null;  //
        GymCenter pendingGym = gymCenter.getPendingGyms().get(gymID);
        
        if (pendingGym != null) {
                gymCenter.getPendingGyms().remove(gymID);
//
//            // Add to approved gyms
            gymCenter.getApprovedGyms().put(gymID,pendingGym);
            
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
    	GymCenter gymCenter = null;  //
        Map<String, GymCenter>AllPendingList = gymCenter.getPendingGyms();
    	for (String key: AllPendingList.keySet()) {
    		gymCenter.getApprovedGyms().put(key,AllPendingList.get(key)); 
    	} 
    	gymCenter.getPendingGyms().clear(); 
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
    	GymCenter gymCenter = null;  //
        Map<String, GymCenter>AllPendingList = gymCenter.getPendingGyms();
        for (Map.Entry<String, GymCenter> entry :AllPendingList.entrySet()) {
            GymCenter gym = entry.getValue();
            System.out.println("Gym ID: " + gym.getGymID());
            System.out.println("Gym Name: " + gym.getGymName());
            System.out.println("Address: " + gym.getAddress());
            System.out.println("City: " + gym.getCity());
            System.out.println();
        }
    } 

    @Override
    public void listPendingGymOwners() {
        System.out.println("Listing all pending gym owners");
    }

    @Override
    public void listGymCenters() {    // view 
        System.out.println("Listing all gym centers"); 
    	GymCenter gymCenter = null;  //
        Map<String, GymCenter>AllPendingList = gymCenter.getApprovedGyms();
        for (Map.Entry<String, GymCenter> entry :AllPendingList.entrySet()) {
            GymCenter gym = entry.getValue();
            System.out.println("Gym ID: " + gym.getGymID());
            System.out.println("Gym Name: " + gym.getGymName());
            System.out.println("Address: " + gym.getAddress());
            System.out.println("City: " + gym.getCity());
            System.out.println();
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



package com.flipkart.business;
import java.util.*;

import com.flipkart.bean.*;
 
public class AdminService implements AdminServiceInterface {
    public AdminService(){
        initializeAdmin();
    }
    UserService userService = new UserService();
    public static Map<String, GymCenter> gymCenters = new HashMap<>();
    public static Map<String, GymCenter> pendingCenters = new HashMap<>();
    private void initializeAdmin() {
        Admin admin = new Admin("bean", "BeanAdmin", "bean@gmail.com", "1234567890", 0, "bean@1234", "A_0", new Role("A","ADMIN"));
        User user = new User(admin.getUsername(), admin.getPassword(), admin.getUserid(), admin.getRole());
        userService.addUser(user);
    }

    @Override
    public void approveGymCenterById(String gymID) {
        try{
            GymCenter pendingGym = pendingCenters.get(gymID);

            if (pendingGym != null) {
                pendingCenters.remove(gymID);
                gymCenters.put(gymID,pendingGym);

                System.out.println("Gym center approved: " + pendingGym.getGymName());
            } else {
                System.out.println("GymId is not exist");
            }
        } catch(Exception e){
            System.out.println("Error approving gym center: "+ e.getMessage());
        }

    }
    @Override
    public void approveGymOwnerById(String ID) {
        try{
            System.out.println("Approving gym owner " + ID);
            GymOwner tempGymOwner = GymOwnerService.PendingGymOwnerMap.get(ID);
            GymOwnerService.GymOwnerMap.put(ID, tempGymOwner);
            GymOwnerService.PendingGymOwnerMap.remove(ID);
            System.out.println("Approved gym owner " + tempGymOwner);
        }catch(Exception e){
            System.out.println("Error approving gym owner: "+e.getMessage());
        }
    }

    @Override
    public void approveAllGymCenters() {   //done
        try{

            for (String key: pendingCenters.keySet()) {
                gymCenters.put(key,pendingCenters.get(key));
            }
            pendingCenters.clear();
            System.out.println("Approved all gym Centres");
        }catch(Exception e){
            System.out.println("Error approving all gym centers: "+e.getMessage());
        }
    }

    @Override
    public void approveAllGymOwners() {
        try{

            System.out.println("Approving all gym owners");
            for (String id : GymOwnerService.PendingGymOwnerMap.keySet()) {
                GymOwner gymOwner = GymOwnerService.PendingGymOwnerMap.get(id);
                System.out.println(id + ": " + gymOwner + " approved");
                GymOwnerService.GymOwnerMap.put(id, gymOwner);
                GymOwnerService.PendingGymOwnerMap.remove(id);
            }
            System.out.println("All gym owners approved");
        }catch(Exception e){
            System.out.println("Error approving all gym owners: "+e.getMessage());
        }
    }

    @Override
    public void listPendingGymCenters() {  // view
        try{

            System.out.println("Listing all pending gym centers");
            for (Map.Entry<String, GymCenter> entry :pendingCenters.entrySet()) {
                listGymCenterDetails(entry);
            }
        }catch(Exception e){
            System.out.println("Error listing pending gym centers: "+e.getMessage());
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
        try{

            System.out.println("Listing all pending gym owners");
            GymOwnerService.PendingGymOwnerMap.forEach((id, gymOwner) -> {
                System.out.println(id + ": " + gymOwner);
            });
        }catch (Exception e){
            System.out.println("Error listing pending gym owners: "+e.getMessage());
        }
    }

    @Override
    public void listGymCenters() {    // view
        try{

            System.out.println("Listing all gym centers");
            for (Map.Entry<String, GymCenter> entry :gymCenters.entrySet()) {
                listGymCenterDetails(entry);
            }
        }catch(Exception e){
            System.out.println("Error listing gym centers: "+e.getMessage());
        }
    }

    @Override
    public void listGymOwners() {
        try{

            System.out.println("Listing all gym owners");
            GymOwnerService.GymOwnerMap.forEach((id, gymOwner) -> {
                System.out.println(id + ": " + gymOwner);
            });
        }catch(Exception e){
            System.out.println("Error listing gym owners: "+e.getMessage());
        }
    }

    @Override
    public void listUsers() {
        System.out.println("Listing all users");
    }
}



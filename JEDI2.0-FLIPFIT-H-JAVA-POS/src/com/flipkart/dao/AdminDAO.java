package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

public interface AdminDAO {
    public List<GymOwner> getAllGymOwners();

    public List<GymCenter> getAllGyms();

    public List<GymOwner> getPendingGymOwnerRequests();

    public List<GymCenter> getPendingGymRequests();

    public void approveSingleOwnerRequest(String gymOwnerEmail);

    public void approveAllOwnerRequest();

    public void approveSingleGymRequest(String gymId);

    public void approveAllGymRequest();
}
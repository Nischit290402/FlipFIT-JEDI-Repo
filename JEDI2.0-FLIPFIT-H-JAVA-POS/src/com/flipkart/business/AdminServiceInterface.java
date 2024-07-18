package com.flipkart.business;

public interface AdminServiceInterface {
    public void approveGymCenterById(String gymCenterId);
    public void approveGymOwnerById(String gymOwnerId);
    public void approveAllGymCenters();
    public void approveAllGymOwners();
    public void listPendingGymCenters();
    public void listPendingGymOwners();
    public void listGymCenters();
    public void listGymOwners();
    public void listUsers();
}

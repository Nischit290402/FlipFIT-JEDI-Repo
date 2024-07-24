package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.flipkart.business.*;
import com.flipkart.bean.User;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminGymFlipFITController {

    private final AdminServiceInterface adminServiceInterface;
    private final UserService userServiceInterface;

    public AdminGymFlipFITController() {
        this.adminServiceInterface = new AdminService();
        this.userServiceInterface = new UserService();
    }

    @GET
    @Path("/hello")
    public String sayHello() {
        return "Hello, Flipkart!";
    }

    @GET
    @Path("/gym-owners/pending")
    public Response listPendingGymOwners() {
        return Response.ok(adminServiceInterface.listPendingGymOwners()).build();
    }
//
    @GET
    @Path("/gym-centers/pending")
    public Response listPendingGymCenters() {
        return Response.ok(adminServiceInterface.listPendingGymCenters()).build();
    }

    @POST
    @Path("/gym-centers/approve/all")
    public Response approveAllGymCenters() {
        return Response.ok(adminServiceInterface.approveAllGymCenters()).build();
    }

    @POST
    @Path("/gym-centers/approve/{id}")
    public Response approveGymCenterById(@PathParam("id") String centerId) {
        adminServiceInterface.approveGymCenterById(centerId);
        return Response.ok().build();
    }

    @POST
    @Path("/gym-owners/approve/all")
    public Response approveAllGymOwners() {
        return Response.ok(adminServiceInterface.approveAllGymOwners()).build();
    }

    @POST
    @Path("/gym-owners/approve/{id}")
    public Response approveGymOwnerById(@PathParam("id") String ownerId) {
        adminServiceInterface.approveGymOwnerById(ownerId);
        return Response.ok().build();
    }

    @GET
    @Path("/gym-owners")
    public Response listGymOwners() {
        return Response.ok(adminServiceInterface.listGymOwners()).build();
    }

    @GET
    @Path("/gym-centers")
    public Response listGymCenters() {
        return Response.ok(adminServiceInterface.listGymCenters()).build();
    }

    @GET
    @Path("/users")
    public Response listUsers() {
        return Response.ok(adminServiceInterface.listUsers()).build();
    }

//    @POST
//    @Path("/change-password")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response changePassword(ChangePasswordRequest request) {
//        User = userServiceInterface.getUserById(request.getUserId());
//        boolean flag = userServiceInterface.validatePassword(user, request.getOldPassword());
//        if (flag) {
//            userServiceInterface.confirmPassword(user, request.getNewPassword(), request.getConfirmPassword());
//            return Response.ok().build();
//        } else {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Wrong Old Password").build();
//        }
//    }

    // DTO for changing password

}

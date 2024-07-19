package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.exception.DAOException;
import com.flipkart.utils.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl {
    Connection connection;
//    public List<GymOwner> getAllGymOwners() {
//        List<GymOwner> gymOwners = new ArrayList<GymOwner>();
//        String query = "select name, email, contactNo, age from gymOwner";
//        try {connection = dbutils.getConnection();
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            System.out.println();
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                GymOwner gymOwner = new GymOwner();
//                gymOwner.setEmail(rs.getString("email"));
//                gymOwner.setName(rs.getString("name"));
//                gymOwner.setPhoneNumber(rs.getString("phoneNum"));
//                gymOwner.setAadharNumber(rs.getString("aadharNum"));
//                gymOwner.setPanNumber(rs.getString("panNum"));
//                gymOwner.setVerified(rs.getBoolean("isVerified"));
//                gymOwners.add(gymOwner);
////	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        // Step 4: try-with-resource statement will auto close the connection.
//        return gymOwners;
//    }

    public List<Customer> getAllCustomers() throws DAOException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";

        try{
            connection = dbutils.getConnection();
            PreparedStatement prep = connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Error fetching gym owners: " + e.getMessage());
            throw new DAOException("Error fetching gym owners", e);
        } finally {
            dbutils.closeConnection();
        }

        return customers;
    }


}

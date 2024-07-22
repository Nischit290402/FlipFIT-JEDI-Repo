package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.utils.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymOwnerDAOImpl implements GymOwnerDAO {
    public boolean addGymCenter(GymCenter gymCenter) {
        String sql = "INSERT INTO gym_center (gymID,gymName,address,city,gymOwnerID) VALUES (?,?,?,?,?)";
//        String sql = "INSERT INTO Customeromers (username, name, email, contactNo, age, password, ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbutils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, gymCenter.getGymID());
            statement.setString(2, gymCenter.getGymName());
            statement.setString(3, gymCenter.getAddress());
            statement.setString(4, gymCenter.getCity());
            statement.setString(5, gymCenter.getGymOwnerID());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<GymCenter> getGymCenters(String userid) {
        List<GymCenter> gymCenters = new ArrayList<>();
        String sql = "SELECT * FROM gym_center WHERE gymOwnerID = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, userid); // Assuming user.getId() gives the gymOwnerID

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymID = resultSet.getString("gymID");
                String gymName = resultSet.getString("gymName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String gymOwnerID = resultSet.getString("gymOwnerID");
                List<Slot> slots=new ArrayList<>();
                GymCenter gymCenter = new GymCenter(gymID, gymName, address, city,slots, gymOwnerID);
                gymCenters.add(gymCenter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }

//    public void addSlots()
//    public List<GymCenter> getGymCenters(User user) {
//        List<GymCenter> gymCenters = new ArrayList<>();
//        String sql = "SELECT * FROM gym_center WHERE gymOwnerID = ?";
//
//
//
//    }
}

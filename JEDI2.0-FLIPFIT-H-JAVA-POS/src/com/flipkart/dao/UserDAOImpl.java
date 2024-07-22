package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;
import com.flipkart.utils.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public User validateUser(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                    User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("userid"), rs.getString("roleId"));
                    return user;
                }
                else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean registerGymOwner(GymOwner gymOwner) {
        String sql = "INSERT INTO GymOwners (username, name, email, contactNo, age, password, ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gymOwner.getUsername());
            statement.setString(2, gymOwner.getName());
            statement.setString(3, gymOwner.getEmail());
            statement.setString(4, gymOwner.getContactNo());
            statement.setInt(5, gymOwner.getAge());
            statement.setString(6, gymOwner.getPassword());
            statement.setString(7, gymOwner.getUserid());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean registerCustomer(Customer customer) {
        String sql = "INSERT INTO Customers (username, name, email, contactNo, age, password, ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setInt(5, customer.getAge());
            statement.setString(6, customer.getPassword());
            statement.setString(7, customer.getUserid());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

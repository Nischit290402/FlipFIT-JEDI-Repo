package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.City;
import com.flipkart.utils.dbutils;


public class CityDAOImpl implements CityDAO{
    @Override
    public boolean cityExists(String cityName) {
        String sql = "SELECT 1 FROM city WHERE cityName = ?";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cityName);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public City getCity(String cityName) {
        return null;
    }

    // Method to add a city
    @Override
    public boolean addCity(City city) {
        String sql = "INSERT INTO city (cityID, cityName) VALUES (?, ?)";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            String cityID = "C" + System.currentTimeMillis(); // Generate a unique city ID
            statement.setString(1, city.getCityID());
            statement.setString(2, city.getCityName());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

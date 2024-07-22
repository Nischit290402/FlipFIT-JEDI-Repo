package com.flipkart.dao;

import com.flipkart.bean.City;

public interface CityDAO {
    public boolean cityExists(String cityName);
    public City getCity(String cityName);
    public boolean addCity(City city);
}

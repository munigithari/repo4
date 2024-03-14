/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.geohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.geohub.repository.*;
import com.example.geohub.model.*;

@Service
public class CityJpaService implements CityRepository {

    @Autowired
    private CityJpaRepository repository;

    @Override
    public ArrayList<City> getCitys() {
        List<City> list = repository.findAll();
        ArrayList<City> citys = new ArrayList<>(list);
        return citys;
    }

    @Override
    public City getCityById(int cityId) {
        try {
            City citys = repository.findById(cityId).get();
            return citys;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City addCity(City city) {
        repository.save(city);
        return city;
    }

    @Override
    public City updateCity(int countryId, City city) {
        try {
            City citys = repository.findById(countryId).get();

            if (city.getCityName() != null) {
                citys.setCityName(city.getCityName());
            }
            if (city.getPopulation() != 0) {
                citys.setPopulation(city.getPopulation());
            }
            if (city.getLatitude() != null) {
                citys.setLatitude(city.getLatitude());
            }
            if (city.getLongitude() != null) {
                citys.setLongitude(city.getLongitude());
            }

            repository.save(citys);
            return citys;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCity(int cityId) {
        try {
            repository.deleteById(cityId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

    @Override
    public Country getCountryCity(int cityId) {
        try {
            City city = repository.findById(cityId).get();
            return city.getCountry();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
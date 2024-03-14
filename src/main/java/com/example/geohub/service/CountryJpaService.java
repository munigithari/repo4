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
public class CountryJpaService implements CountryRepository {

    @Autowired
    private CountryJpaRepository repository;

    @Override
    public ArrayList<Country> getCountrys() {
        List<Country> list = repository.findAll();
        ArrayList<Country> countrys = new ArrayList<>(list);
        return countrys;
    }

    @Override
    public Country getCountryById(int cityId) {
        try {
            Country citys = repository.findById(cityId).get();
            return citys;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country addCountry(Country country) {
        repository.save(country);
        return country;
    }

    @Override
    public Country updateCountry(int countryId, Country country) {
        try {
            Country countrys = repository.findById(countryId).get();
            if (country.getCountryName() != null) {
                countrys.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                countrys.setCurrency(country.getCurrency());
            }
            if (country.getPopulation() != 0) {
                countrys.setPopulation(country.getPopulation());
            }
            if (country.getLatitude() != null) {
                countrys.setLatitude(country.getLatitude());
            }
            if (country.getLongitude() != null) {
                countrys.setLongitude(country.getLongitude());
            }

            repository.save(countrys);
            return countrys;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCountry(int countryId) {
        try {
            repository.deleteById(countryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }
}
/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.geohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.geohub.service.*;
import com.example.geohub.model.*;

import com.example.geohub.service.*;

@RestController
public class CityController {
    @Autowired
    private CityJpaService service;

    @GetMapping("/countries/cities")
    public ArrayList<City> getCitys() {
        return service.getCitys();
    }

    @GetMapping("/countries/cities/{cityId}")
    public City getCityById(@PathVariable("cityId") int cityId) {
        return service.getCityById(cityId);
    }

    @PostMapping("/countries/cities")
    public City addCity(@RequestBody City city) {
        return service.addCity(city);
    }

    @PutMapping("/countries/cities/{cityId}")
    public City updateCity(@PathVariable("cityId") int cityId, @RequestBody City city) {
        return service.updateCity(cityId, city);
    }

    @DeleteMapping("/countries/cities/{cityId}")
    public void deleteCity(@PathVariable("cityId") int cityId) {
        service.deleteCity(cityId);
    }

    @GetMapping("/cities/{cityId}/country")
    public Country getCountyCity(@PathVariable("cityId") int cityId) {
        return service.getCountryCity(cityId);
    }
}
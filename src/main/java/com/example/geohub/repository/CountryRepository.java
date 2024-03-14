/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.geohub.repository;

import java.util.*;
import com.example.geohub.model.Country;

public interface CountryRepository {
    ArrayList<Country> getCountrys();

    Country getCountryById(int countryId);

    Country addCountry(Country country);

    Country updateCountry(int countryid, Country country);

    void deleteCountry(int countryId);

}
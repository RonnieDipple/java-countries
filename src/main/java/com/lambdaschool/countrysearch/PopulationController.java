package com.lambdaschool.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

/*  /population/size/{people}
 * return the countries that have a population equal to or greater than the given population
 * /population/min
 * return the country with the smallest population
 * /population/max
 * return the country with the largest population
 * Stretch Goal
 * /population/median
 * return the country with the median population*/
@RestController
@RequestMapping("/population")
public class PopulationController {

    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesPopulationEqualToOrGreater(@PathVariable long number) {

        ArrayList<Country> rtnCntry = CountrySearchApplication.ourCountryList
                .findCountries(c -> (int)c.getPopulation() >= number);

        return new ResponseEntity<>(rtnCntry, HttpStatus.OK);

    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getLargestPopulationCountry() {
        Country smallestPopulationCountry = CountrySearchApplication.ourCountryList.countryList.get(0);

        for (Country cCountry: CountrySearchApplication.ourCountryList.countryList ){
            if (smallestPopulationCountry.getPopulation() >= cCountry.getPopulation()){

                smallestPopulationCountry = cCountry;
            }

        }
        return new ResponseEntity<>(smallestPopulationCountry, HttpStatus.OK);

    }


    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getSmallestPopulationCountry() {
        Country largestPopulationCountry = CountrySearchApplication.ourCountryList.countryList.get(0);

        for (Country cCountry: CountrySearchApplication.ourCountryList.countryList ){
            if (largestPopulationCountry.getPopulation() <= cCountry.getPopulation()){

                largestPopulationCountry = cCountry;
            }

        }
        return new ResponseEntity<>(largestPopulationCountry, HttpStatus.OK);

    }

}

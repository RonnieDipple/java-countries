package com.lambdaschool.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/*/age/age/{age}
 * return the countries that have a median age equal to or greater than the given age
 * /age/min
 * return the country with the smallest median age
 * /age/max
 * return the country the the greatest median age
 * Stretch Goal
 * /age/median
 * return the country with the median median age
 */
@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesAgeEqualToOrGreater(@PathVariable int number) {

        ArrayList<Country> rtnCntry = CountrySearchApplication.ourCountryList
                .findCountries(c -> c.getMedianAge() >= number);

        return new ResponseEntity<>(rtnCntry, HttpStatus.OK);

    }

    @GetMapping(value = "/age/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestMedianAgeCountry() {
        Country smallestMedianAgeCountry = CountrySearchApplication.ourCountryList.countryList.get(0);

        for (Country cCountry: CountrySearchApplication.ourCountryList.countryList ){
            if (smallestMedianAgeCountry.getMedianAge() <= cCountry.getMedianAge()){

                smallestMedianAgeCountry = cCountry;
            }

        }
        return new ResponseEntity<>(smallestMedianAgeCountry, HttpStatus.OK);

    }

    @GetMapping(value = "/age/max", produces = {"application/json"})
    public ResponseEntity<?> getLargestMedianAgeCountry() {
        Country largestMedianAgeCountry = CountrySearchApplication.ourCountryList.countryList.get(0);

        for (Country cCountry: CountrySearchApplication.ourCountryList.countryList ){
            if (largestMedianAgeCountry.getMedianAge() >= cCountry.getMedianAge()){

                largestMedianAgeCountry = cCountry;
            }

        }
        return new ResponseEntity<>(largestMedianAgeCountry, HttpStatus.OK);

    }
}

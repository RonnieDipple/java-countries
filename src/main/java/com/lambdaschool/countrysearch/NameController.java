package com.lambdaschool.countrysearch;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/* /names/all
 * return the names of all the countries alphabetically
 * /names/start/{letter}
 * return the countries alphabetically that begin with the given letter
 * /names/size/{number}
 * return the countries alphabetically that have a name equal to or longer than the given length*/
@RestController
@RequestMapping("/names")
public class NameController {

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?>getAllCountries(){
        CountrySearchApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getcName().compareToIgnoreCase(c2.getcName()));
        return new ResponseEntity<>(CountrySearchApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter){
        ArrayList<Country> rtnCntry = CountrySearchApplication.ourCountryList.findCountries(
                c -> c.getcName().toUpperCase().charAt(0) == Character.toUpperCase(letter)
        );

        return new ResponseEntity<>(rtnCntry, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesEqualToOrLonger(@PathVariable int number) {

        ArrayList<Country> rtnCntry = CountrySearchApplication.ourCountryList
                .findCountries(c -> c.getcName().length() >= number);
        rtnCntry.sort((c1, c2) -> c1.getcName().compareToIgnoreCase(c2.getcName()));
       return new ResponseEntity<>(rtnCntry, HttpStatus.OK);

    }

}

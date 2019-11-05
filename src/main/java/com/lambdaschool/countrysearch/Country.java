package com.lambdaschool.countrysearch;

/*# Project Country Search

A student that completes this project shows that they can:
* use Maven including reading and modifying the pom.xml.
* use Spring and Spring Boot to build a REST API service.
* use Tomcat.

# Introduction

The countries of the world have many different defining attributes including land size, population, and median age. Below is a list of countries to include in your data. As most people do their research using websites, we are going to create webservices to help search this data. We will be returning JSON objects. Nothing fancy for now!

# Instruction

* Create an array list for country objects
    * Each country object will contain
      * a country name, population, land mass size, and median age
      * should contain the standard getter and setters

      Note: the country in suggested layout is found at the end of this document

      Note: the sort method must work with `int` - so not `long`. the solution - type casting! See the code snippet below:
      `.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()))`

      Note: to calculate median for stretch goals - if the list contains an odd number of items, pick the the middle one. If the list contains an even number of items, pick either of the two items that lie in the middle.

* The following URLs should return the requested data given the parameters
    * /names/all
      * return the names of all the countries alphabetically
    * /names/start/{letter}
      * return the countries alphabetically that begin with the given letter
    * /names/size/{number}
      * return the countries alphabetically that have a name equal to or longer than the given length

    * /population/size/{people}
      * return the countries that have a population equal to or greater than the given population
    * /population/min
      * return the country with the smallest population
    * /population/max
      * return the country with the largest population
    * Stretch Goal
      * /population/median
      * return the country with the median population

    * /age/age/{age}
      * return the countries that have a median age equal to or greater than the given age
    * /age/min
      * return the country with the smallest median age
    * /age/max
      * return the country the the greatest median age
    * Stretch Goal
      * /age/median
      * return the country with the median median age

*/

public class Country {

    private String cName;
    private long population;
    private int landMassSize;
    private int medianAge;


    public Country(String cName,
            long population,
            int landMassSize,
            int medianAge){
        this.cName = cName;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(int landMassSize) {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}

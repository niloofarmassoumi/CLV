package com.example.niloofar.countrylist;

import java.util.jar.Attributes;

public class country {

    private String Name;
    private long Population;

    public country(String name,long population) {

        Name=name;
        Population=population;

    }

    public String getName() {
        return Name;
    }

    public long getPopulation() {
        return Population;
    }
}

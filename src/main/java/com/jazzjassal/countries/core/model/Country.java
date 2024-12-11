package com.jazzjassal.countries.core.model;

import java.util.List;

public record Country(String countryName, List<String> currencies) {

    public static Country of(String countryName, String currency) {
        return new Country(countryName, List.of(currency));
    }

    public static Country of(String countryName, List<String> currencies) {
        return new Country(countryName, currencies);
    }
}

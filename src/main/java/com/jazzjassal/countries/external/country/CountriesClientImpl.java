package com.jazzjassal.countries.external.country;

import com.jazzjassal.countries.core.model.Country;
import com.jazzjassal.countries.core.model.Currency;
import com.jazzjassal.countries.external.country.model.CountryRs;
import com.jazzjassal.countries.util.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@AllArgsConstructor @Component
public class CountriesClientImpl implements CountriesClient {

    private final RestTemplate restTemplate;

    @Override
    public List<Country> allCountries() {
        var countries = restTemplate.getForObject("https://restcountries.com/v3.1/all?fields=name,currencies", CountryRs[].class);

        return Arrays.asList(countries).stream()
                .map(c -> new Country(c.name().common(), new TreeSet<>(c.currencies().keySet()).stream().toList()))
                .sorted(Comparator.comparing(Country::countryName))
                .toList();
    }

    @Override
    public List<Currency> allCurrencies() {
        return currencyCountriesAsMap().entrySet().stream().map(Currency::of).toList();
    }

    /**
     * @return all currencies as keys, and corresponding countries as the list-value.
     */
    private HashMap<String, List<String>> currencyCountriesAsMap() {
        var map = new HashMap<String, List<String>>();
        allCountries().forEach(country -> populate(country, map));
        return map;
    }

    /**
     * Populate the map with given Country
     */
    private void populate(Country c, HashMap<String, List<String>> map) {
        c.currencies().forEach(currency -> map.merge(currency, List.of(c.countryName()), Lists::mergeLists));
    }
}

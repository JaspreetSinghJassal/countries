package com.jazzjassal.countries.core.model;

import com.jazzjassal.countries.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Currency(String name, List<String> countries) {

    public Currency {
        countries = Lists.sort(new ArrayList<>((countries)));
    }

    public static Currency of(Map.Entry<String, List<String>> mapEntry) {
        return new Currency(mapEntry.getKey(), mapEntry.getValue());
    }

    public static Currency of(String name, String... countries) {
        return new Currency(name, List.of(countries));
    }
}

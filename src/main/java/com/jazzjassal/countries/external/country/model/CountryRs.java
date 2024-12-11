package com.jazzjassal.countries.external.country.model;

import java.util.Map;

public record CountryRs(CountryNameRs name, Map<String, CurrencyRs> currencies) {

    public record CountryNameRs(String common) {}

    public record CurrencyRs(String name, String symbol) {}
}

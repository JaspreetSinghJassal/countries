package com.jazzjassal.countries.external.country;

import com.jazzjassal.countries.core.model.Country;
import com.jazzjassal.countries.core.model.Currency;

import java.util.List;

public interface CountriesClient {

    public List<Country> allCountries();

    public List<Currency> allCurrencies();

}

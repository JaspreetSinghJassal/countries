package com.jazzjassal.countries.external;

import com.jazzjassal.countries.BaseIntegrationTest;
import com.jazzjassal.countries.core.model.Country;
import com.jazzjassal.countries.core.model.Currency;
import com.jazzjassal.countries.external.country.CountriesClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CountriesClientExternalResourceTest extends BaseIntegrationTest {

    @Autowired CountriesClient client;

    @Test public void allCountries_shouldIncludeAll250CountriesOnAscendingNames() {
        var allCountries = client.allCountries();

        assertThat(allCountries).hasSize(250);
        assertThat(allCountries).first().isEqualTo(Country.of("Afghanistan", "AFN"));
        assertThat(allCountries).last().isEqualTo(Country.of("Åland Islands", "EUR"));
    }

    @Test public void allCountries_shouldHaveSortedCurrencies() {
        assertThat(client.allCountries()).contains(
                Country.of("Kiribati", List.of("AUD", "KID")),
                Country.of("Bhutan", List.of("BTN", "INR")),
                Country.of("Bahamas", List.of("BSD", "USD")),
                Country.of("Norway", List.of("NOK"))
        );
    }

    @Test public void allCurrencies_shouldReturn162Currencies() {
        var allCurrencies = client.allCurrencies();
        
        assertThat(allCurrencies).hasSize(162);
    }

    @Test public void allCurrencies_shouldIncludeCurrenciesWithSortedCountries() {
        var allCurrencies = client.allCurrencies();

        assertThat(allCurrencies).contains(
                Currency.of("NOK", "Norway", "Svalbard and Jan Mayen"),
                Currency.of("ZAR", "Eswatini", "Lesotho", "Namibia", "South Africa")
        );
    }
}
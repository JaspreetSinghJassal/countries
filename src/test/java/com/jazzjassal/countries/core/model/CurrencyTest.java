package com.jazzjassal.countries.core.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyTest {

    @Test public void currency_countriesShouldBeOrderedAscending() {
        var zar = Currency.of("ZAR", "Eswatini", "South Africa", "Namibia", "Lesotho");

        assertThat(zar.name()).isEqualTo("ZAR");
        assertThat(zar.countries()).containsExactly("Eswatini", "Lesotho", "Namibia", "South Africa");
    }
}
package com.digitalinnovation.citiesapi.repositories;

import com.digitalinnovation.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

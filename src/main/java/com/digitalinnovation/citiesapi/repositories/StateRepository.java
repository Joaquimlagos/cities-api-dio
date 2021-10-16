package com.digitalinnovation.citiesapi.repositories;

import com.digitalinnovation.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository <State , Long> {
}

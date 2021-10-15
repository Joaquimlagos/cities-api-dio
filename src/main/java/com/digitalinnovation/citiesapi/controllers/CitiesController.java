package com.digitalinnovation.citiesapi.controllers;


import java.util.List;
import java.util.Optional;

import com.digitalinnovation.citiesapi.entities.Country;
import com.digitalinnovation.citiesapi.entities.State;
import com.digitalinnovation.citiesapi.repositories.CountryRepository;
import com.digitalinnovation.citiesapi.repositories.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CitiesController {

  private final CountryRepository repositoryCountry;
  private final StateRepository repositoryState;

  @GetMapping("/countries")
  public Page<Country> cities(Pageable page) {
    return repositoryCountry.findAll(page);
  }

  @GetMapping("/countries/{id}")
  public ResponseEntity oneCoutry(@PathVariable Long id) {
    Optional<Country> optional = repositoryCountry.findById(id);

    if (optional.isPresent())
      return ResponseEntity.ok().body(optional.get());
    else
      return ResponseEntity.notFound().build();
  }

  @GetMapping("/states")
  public List<State> staties() {
    return repositoryState.findAll();
  }
}
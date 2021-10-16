package com.digitalinnovation.citiesapi.controllers;


import java.util.List;
import java.util.Optional;

import com.digitalinnovation.citiesapi.entities.City;
import com.digitalinnovation.citiesapi.entities.Country;
import com.digitalinnovation.citiesapi.entities.State;
import com.digitalinnovation.citiesapi.repositories.CityRepository;
import com.digitalinnovation.citiesapi.repositories.CountryRepository;
import com.digitalinnovation.citiesapi.repositories.StateRepository;
import com.digitalinnovation.citiesapi.services.DistanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CitiesController {

  private final CountryRepository repositoryCountry;
  private final StateRepository repositoryState;
  private final CityRepository repositoryCity;
  private final DistanceService service;

  @GetMapping("/countries")
  public Page<Country> countries(Pageable page) {
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

  @GetMapping("/cities")
  public Page<City> cities(final Pageable page) {
    return repositoryCity.findAll(page);
  }

  @GetMapping("/by-points")
  public ResponseEntity byPoints(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
    return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
  }
  @GetMapping("/by-cube")
  public ResponseEntity byCube(@RequestParam(name = "from") final Long city1,
                       @RequestParam(name = "to") final Long city2) {
    return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
  }
}
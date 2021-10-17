package com.digitalinnovation.citiesapi.controllers;

import com.digitalinnovation.citiesapi.entities.City;
import com.digitalinnovation.citiesapi.entities.Country;
import com.digitalinnovation.citiesapi.entities.State;
import com.digitalinnovation.citiesapi.repositories.CityRepository;
import com.digitalinnovation.citiesapi.repositories.CountryRepository;
import com.digitalinnovation.citiesapi.repositories.StateRepository;
import com.digitalinnovation.citiesapi.services.CitiesService;
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
  private final CitiesService service;

  @GetMapping("/countries")
  public Page<Country> countries(Pageable page) {
    return service.findAllCoutries(page);
  }

  @GetMapping("/countries/{id}")
  public ResponseEntity oneCoutry(@PathVariable Long id) {
   return  service.findCountryById(id);
  }

  @GetMapping("/states")
  public Page<State> staties(Pageable page) {
    return service.findAllStates(page);
  }

  @GetMapping("/states/{id}")
  public ResponseEntity oneState(@PathVariable Long id) {
    return service.findStateById(id);
  }

  @GetMapping("/cities")
  public Page<City> cities(final Pageable page) {
    return service.findAllCities(page);
  }

  @GetMapping("/cities/{id}")
  public ResponseEntity oneCity(@PathVariable Long id) {
    return service.findCityById(id);
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
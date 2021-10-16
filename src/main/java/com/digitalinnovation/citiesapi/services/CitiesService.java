package com.digitalinnovation.citiesapi.services;

import com.digitalinnovation.citiesapi.entities.City;
import com.digitalinnovation.citiesapi.entities.Country;
import com.digitalinnovation.citiesapi.entities.State;
import com.digitalinnovation.citiesapi.repositories.CityRepository;
import com.digitalinnovation.citiesapi.repositories.CountryRepository;
import com.digitalinnovation.citiesapi.repositories.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CitiesService {
  private final CityRepository cityRepository;
  private final CountryRepository countryRepository;
  private final StateRepository stateRepository;

   public Page<Country> findAllCoutries(Pageable page) {
      return countryRepository.findAll(page);
    }

  public ResponseEntity findCountryById(Long id){
    Optional<Country> optional = countryRepository.findById(id);
    if (optional.isPresent())
      return ResponseEntity.ok().body(optional.get());
    else
      return ResponseEntity.notFound().build();
  }

  public Page<State> findAllStates(Pageable page) {
    return stateRepository.findAll(page);
  }

  public ResponseEntity findStateById(Long id){
    Optional<State> optional = stateRepository.findById(id);
    if (optional.isPresent())
      return ResponseEntity.ok().body(optional.get());
    else
      return ResponseEntity.notFound().build();
  }

  public Page<City> findAllCities(Pageable page) {
    return cityRepository.findAll(page);
  }

  public ResponseEntity findCityById(Long id){
    Optional<City> optional = cityRepository.findById(id);
    if (optional.isPresent())
      return ResponseEntity.ok().body(optional.get());
    else
      return ResponseEntity.notFound().build();
  }

  public Double distanceByPointsInMiles(final Long city1, final Long city2) {
    return cityRepository.distanceByPoints(city1, city2);
  }

  public Double distanceByCubeInMeters(Long city1, Long city2) {
    final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

    Point p1 = cities.get(0).getLocation();
    Point p2 = cities.get(1).getLocation();

    return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }
}

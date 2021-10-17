package com.digitalinnovation.citiesapi.controller;

import com.digitalinnovation.citiesapi.builder.CityBuilder;
import com.digitalinnovation.citiesapi.builder.CountryBuild;
import com.digitalinnovation.citiesapi.builder.StateBuilder;
import com.digitalinnovation.citiesapi.controllers.CitiesController;
import com.digitalinnovation.citiesapi.entities.City;
import com.digitalinnovation.citiesapi.entities.Country;
import com.digitalinnovation.citiesapi.entities.State;
import com.digitalinnovation.citiesapi.services.CitiesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class CitiesControllerTest {

  private static final String CITY_API_URL_PATH = "/";
  private MockMvc mockMvc;

  @Mock
  @Autowired
  private CitiesService service;

  @InjectMocks
  private CitiesController citiesController;

  @BeforeEach
  void setUp() {
            mockMvc = MockMvcBuilders.standaloneSetup(citiesController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
            .build();
  }
  @Test
  void whenGetByIdCityIsCalledItMustReturnAllFieldsFilledIn() throws Exception {
    City city = CityBuilder.builder().build().cities();

    Mockito.when(service.findCityById(city.getId())).thenReturn(ResponseEntity.ok().body(Optional.of(city)));

    mockMvc.perform(MockMvcRequestBuilders.get( CITY_API_URL_PATH + "cities/" + city.getId())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(city.getName())))
            .andExpect(jsonPath("$.uf", is(city.getUf())))
            .andExpect(jsonPath("$.ibge", is(city.getIbge())))
            .andExpect(jsonPath("$.geolocation", is(city.getGeolocation())));
  }

  @Test
  void whenGetByIdCountryIsCalledItMustReturnAllFieldsFilledIn() throws Exception {
    Country country = CountryBuild.builder().build().countries();

    Mockito.when(service.findCountryById(country.getId())).thenReturn(ResponseEntity.ok().body(Optional.of(country)));

    mockMvc.perform(MockMvcRequestBuilders.get( CITY_API_URL_PATH + "countries/" + country.getId())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(country.getName())))
            .andExpect(jsonPath("$.portugueseName", is(country.getPortugueseName())))
            .andExpect(jsonPath("$.code", is(country.getCode())))
            .andExpect(jsonPath("$.bacen", is(country.getBacen())));
  }

  @Test
  void whenGetByIdStateIsCalledItMustReturnAllFieldsFilledIn() throws Exception {
    State state = StateBuilder.builder().build().state();

    Mockito.when(service.findStateById(state.getId())).thenReturn(ResponseEntity.ok().body(Optional.of(state)));

    mockMvc.perform(MockMvcRequestBuilders.get( CITY_API_URL_PATH + "states/" + state.getId())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(state.getName())))
            .andExpect(jsonPath("$.uf", is(state.getUf())))
            .andExpect(jsonPath("$.ibge", is(state.getIbge())))
            .andExpect(jsonPath("$.ddd", is(state.getDdd())));
  }

}


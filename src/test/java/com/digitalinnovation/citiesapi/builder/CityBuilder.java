package com.digitalinnovation.citiesapi.builder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.digitalinnovation.citiesapi.entities.City;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;


@Builder
public class CityBuilder {

  @Builder.Default
  private Long id = 4500L;

  @Builder.Default
  private String name = "Florianópolis";

  @Builder.Default
  private Integer uf = 24;

  @Builder.Default
  private Integer ibge = 4205407;

  @Builder.Default
  private String geolocation = "(-27.5944995880127,-48.5476989746094)";

  @Builder.Default
  private Point location = new Point(27.5944995880127, -48.5476989746094);

  public City cities() {
    return new City(id,
            name,
            uf,
            ibge,
            geolocation,
            location) {
    };
  }
}

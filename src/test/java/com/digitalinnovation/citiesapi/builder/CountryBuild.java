package com.digitalinnovation.citiesapi.builder;

import com.digitalinnovation.citiesapi.entities.City;
import com.digitalinnovation.citiesapi.entities.Country;
import lombok.Builder;
import org.springframework.data.geo.Point;


@Builder
public class CountryBuild {

  @Builder.Default
  private Long id = 1L;

  @Builder.Default
  private String name = "Brazil";

  @Builder.Default
  private String portugueseName = "Brasil";

  @Builder.Default
  private String code = "BR";

  @Builder.Default
  private Integer bacen = 1058;

  public Country countries() {
    return new Country(id,
            name,
            portugueseName,
            code,
            bacen
            ) {
    };
  }
}

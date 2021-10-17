package com.digitalinnovation.citiesapi.builder;

import com.digitalinnovation.citiesapi.entities.Country;
import com.digitalinnovation.citiesapi.entities.State;
import lombok.Builder;
import org.springframework.data.geo.Point;

import java.util.*;


@Builder
public class StateBuilder {

  @Builder.Default
  private Long id = 4500L;

  @Builder.Default
  private String name = "Santa Catarina";

  @Builder.Default
  private String uf = "SC";

  @Builder.Default
  private Integer ibge = 42;

 @Builder.Default
 private Country country = new Country(1L,"Brazil", "Brasil","BR", 1058);

  @Builder.Default
  List<Integer> ddd =Arrays.asList(68);

  public State state() {
    return new State(id,
            name,
            uf,
            ibge,
            country,
            ddd
            ) {
    };
  }
}

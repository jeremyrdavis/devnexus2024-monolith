package io.arrogantprogrammer.swapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.util.List;

public record VehicleRecord(

    String name,
    String model,
    String manufacturer,
    String costInCredits,
    double length,
    String maxAtmospheringSpeed,
    String crew,
    String passengers,
    String cargoCapacity,
    String consumables,
    String vehicleClass,

    List<String> pilots,
    @JsonProperty("films")
    List<String> filmURIs,
    String created,
    String edited,
    @JsonProperty("url")
    URI uri){}

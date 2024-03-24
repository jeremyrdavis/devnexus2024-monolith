package io.arrogantprogrammer.swapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.Instant;
import java.util.List;

public record PersonRecord(
        String name,
        String height,
        String mass,
        String hairColor,
        String skinColor,
        String eyeColor,
        String birthYear,
        String gender,
        String homeworld,
        List<String> filmURIs,
        List<String> speciesURIs,
        List<String> vehicleURIs,
        List<String> starshipURIs,
        Instant created,
        Instant edited,
        URI url) {}

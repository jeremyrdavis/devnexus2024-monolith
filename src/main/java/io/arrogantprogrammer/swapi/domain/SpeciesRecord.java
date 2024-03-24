package io.arrogantprogrammer.swapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.util.List;

public record SpeciesRecord(
        String name,
        String classification,
        String designation,
        String averageHeight,
        String skinColors,
        String hairColors,
        String eyeColors,
        String averageLifespan,
        @JsonProperty("homeworld")
        String homeworldURI,
        String language,
        @JsonProperty("people")
        List<String> peopleURIs,
        @JsonProperty("films")
        List<String> filmURIs,
        String created,
        String edited,
        @JsonProperty("url")
        URI uri
) {
}

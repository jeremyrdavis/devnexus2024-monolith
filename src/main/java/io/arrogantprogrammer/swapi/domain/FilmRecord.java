package io.arrogantprogrammer.swapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.Instant;
import java.util.List;

public record FilmRecord(
        String title,

        int episodeId,

        String openingCrawl,

        String director,

        String producer,

        String releaseDate,

        @JsonProperty("characters")
        List<String> peopleURIs,

        @JsonProperty("planets")
        List<String> planetURIs,

        @JsonProperty("starships")
        List<String> starshipURIs,

        @JsonProperty("vehicles")
        List<String> vehicleURIs,

        @JsonProperty("species")
        List<String> speciesURIs,

        Instant created,

        @JsonProperty("url")
        URI uri
) {
}

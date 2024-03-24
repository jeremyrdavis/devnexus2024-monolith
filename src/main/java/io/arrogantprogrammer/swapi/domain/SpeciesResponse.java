package io.arrogantprogrammer.swapi.domain;

public record SpeciesResponse(
        int count,
        String next,
        String previous,
        SpeciesRecord[] results
) {
}

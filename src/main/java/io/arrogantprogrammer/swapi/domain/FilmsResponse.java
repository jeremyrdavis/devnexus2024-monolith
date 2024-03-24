package io.arrogantprogrammer.swapi.domain;

/**
 * Models the Response from the SWAPI API for Films: /api/films/
 *
 * @param count
 * @param next
 * @param previous
 * @param results
 */
public record FilmsResponse(
        int count,
        String next,
        String previous,
        FilmRecord[] results) {}

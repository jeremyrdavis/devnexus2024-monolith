package io.arrogantprogrammer.swapi.domain;

public record PeopleResponse(int count, String next, String previous, PersonRecord[] results) {
}

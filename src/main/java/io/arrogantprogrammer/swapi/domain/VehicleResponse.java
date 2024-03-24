package io.arrogantprogrammer.swapi.domain;

public record VehicleResponse(int count, String next, String previous, VehicleRecord[] results) {
}

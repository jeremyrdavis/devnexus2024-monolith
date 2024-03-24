package io.arrogantprogrammer.swapi.infrastructure;

import io.arrogantprogrammer.swapi.domain.*;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class SwapiClientTest {

    private static final Logger LOGGER = getLogger(SwapiClientTest.class);

    @RestClient
    SwapiClient swapiClient;

    @Test
    public void testFilmsResponse() {
        FilmsResponse allFilms = swapiClient.getAllFilms();
        assertNotNull(allFilms);
        assertEquals(6, allFilms.count());
    }

    @Test
    public void testFilmRecord() {

        var filmRecord = swapiClient.getFilm(1);
        LOGGER.info("Film record: {}", filmRecord);
        assertNotNull(filmRecord);
        assertEquals("A New Hope", filmRecord.title());
        assertEquals(4, filmRecord.episodeId());
        assertEquals("https://swapi.dev/api/films/1/", filmRecord.uri().toString());
        assertEquals("George Lucas", filmRecord.director());
        assertEquals("Gary Kurtz, Rick McCallum", filmRecord.producer());
        assertEquals("1977-05-25", filmRecord.releaseDate());
        assertEquals(3, filmRecord.peopleURIs().size());
        assertEquals(3, filmRecord.planetURIs().size());
        assertEquals(3, filmRecord.starshipURIs().size());
        assertEquals(2, filmRecord.vehicleURIs().size());
        assertEquals(5, filmRecord.speciesURIs().size());
        assertTrue(filmRecord.openingCrawl().contains("It is a period of civil war."));
    }
    @Test
    public void testPersonRecord() {

        PersonRecord personRecord = swapiClient.getPerson(1);
        assertNotNull(personRecord);
        assertEquals("Luke Skywalker", personRecord.name());
        assertEquals("172", personRecord.height());
        assertEquals("https://swapi.dev/api/people/1/", personRecord.url().toString());
        assertEquals("77", personRecord.mass());
        assertEquals("blond", personRecord.hairColor());
        assertEquals("fair", personRecord.skinColor());
        assertEquals("blue", personRecord.eyeColor());
        assertEquals("19BBY", personRecord.birthYear());
    }

    @Test
    public void testPersonResponse() {
        PeopleResponse peopleResponse = swapiClient.getAllPeople();
        assertNotNull(peopleResponse);
        assertEquals(82, peopleResponse.count());
    }

    @Test
    public void testVehicleResponse() {
        VehicleResponse vehicleResponse = swapiClient.getAllVehicles();
        assertNotNull(vehicleResponse);
        assertEquals(39, vehicleResponse.count());
    }

    @Test
    public void testVehicleRecord() {

        VehicleRecord vehicleRecord = swapiClient.getVehicle(4);
        LOGGER.info("Vehicle record: {}", vehicleRecord);
        assertNotNull(vehicleRecord);
        assertEquals("Sand Crawler", vehicleRecord.name());
        assertEquals("https://swapi.dev/api/vehicles/4/", vehicleRecord.uri().toString());
        assertEquals(36.8, vehicleRecord.length());
        assertEquals("https://swapi.dev/api/films/1/", vehicleRecord.filmURIs().get(0));
        assertEquals("https://swapi.dev/api/films/5/", vehicleRecord.filmURIs().get(1));
        assertEquals("150000", vehicleRecord.costInCredits());
        assertEquals("30", vehicleRecord.maxAtmospheringSpeed());
    }
}

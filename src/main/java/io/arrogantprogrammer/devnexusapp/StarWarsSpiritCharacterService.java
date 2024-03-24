package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacter;
import io.arrogantprogrammer.swapi.domain.PersonRecord;
import io.arrogantprogrammer.swapi.infrastructure.SwapiClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class StarWarsSpiritCharacterService {

    private static final Logger LOGGER = getLogger(StarWarsSpiritCharacterService.class);

    int count;

    @RestClient
    SwapiClient swapiClient;

    public StarWarsSpiritCharacter getRandomStarWarsCharacter() {
        if(count == 0) {
            LOGGER.info("Running getRandomStarWarsCharacter");
            count = swapiClient.getAllPeople().count();
        }
        PersonRecord personRecord = swapiClient.getPerson((int) (Math.random() * (count - 1)) + 1);
        return new StarWarsSpiritCharacter(personRecord.name());
    }
}

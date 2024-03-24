package io.arrogantprogrammer.devnexusapp;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/devnexus2024")
public class DevnexusApiResource {

    private static final Logger LOGGER = getLogger(DevnexusApiResource.class);

    int count;
    @Inject
    StarWarsSpiritCharacterService starWarsSpiritCharacterService;

    @GET
    @Path("/{name}")
    public String assignSpiritAnimal(String name) {
        starWarsSpiritCharacterService.getRandomStarWarsCharacter();
        return "Hello, %s!  Your Star Wars Spirit character is %s.".formatted(name, starWarsSpiritCharacterService.getRandomStarWarsCharacter().getName());
    }
}

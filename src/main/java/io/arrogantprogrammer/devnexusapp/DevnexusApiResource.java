package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
    public String assignSpiritCharacter(String name) {
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = starWarsSpiritCharacterService.assignSpiritCharacter(name);
        return "Hello, %s!  Your Star Wars Spirit character is %s.".formatted(name, starWarsSpiritCharacterAssignment.characterName());
    }

    @GET
    @Path("/whoIsSpiritCharacter/{character}")
    public String whoIsSpiritCharacter(@PathParam("character") String character) {
        return starWarsSpiritCharacterService.whoIs(character);
    }

    @GET
    @Path("/aPoemAbout/{character}")
    public String aPoemAbout(@PathParam("character") String character) {
        return starWarsSpiritCharacterService.aPoemAbout(character);
    }

    @GET
    @Path("/addToPoem/{id}")
    public String addToPoem(@PathParam("id") int id) {
        return "Added to poem";
    }


}

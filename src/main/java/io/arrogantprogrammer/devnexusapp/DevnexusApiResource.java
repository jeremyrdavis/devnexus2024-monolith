package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.CharacterAssignment;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

import java.net.URI;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/devnexus2024")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DevnexusApiResource {

    private static final Logger LOGGER = getLogger(DevnexusApiResource.class);

    int count;
    @Inject
    StarWarsSpiritCharacterService starWarsSpiritCharacterService;

    @POST
    @Path("/assign")
    public Response assignSpiritCharacter(String name) {
        CharacterAssignment characterAssignment = starWarsSpiritCharacterService.assignSpiritCharacter(name);
        return Response.created(URI.create("/assignment/" + characterAssignment.id())).entity(characterAssignment).build();
    }

    @GET
    @Path("/whoIs/{id}")
    @Transactional
    public CharacterAssignment whoIsSpiritCharacter(@PathParam("id") Long id) {
        LOGGER.debug("Getting whoIs for id: {}", id);
        CharacterAssignment characterAssignment = starWarsSpiritCharacterService.whoIs(id);
        LOGGER.debug("CharacterAssignment: {}", characterAssignment);
        return characterAssignment;
    }

    @GET
    @Path("/aPoemAbout/{id}")
    @Transactional
    public CharacterAssignment aPoemAbout(@PathParam("id") Long id) {
        LOGGER.debug("Getting a poem for id: {}", id);
        CharacterAssignment characterAssignment = starWarsSpiritCharacterService.aPoemAbout(id);
        LOGGER.debug("CharacterAssignment: {}", characterAssignment);
        return characterAssignment;
    }

    @GET
    @Path("/addToPoem/{id}")
    @Transactional
    public CharacterAssignment addToPoem(@PathParam("id") Long id) {
        LOGGER.debug("Adding to poem for id: {}", id);
        CharacterAssignment characterAssignment = starWarsSpiritCharacterService.addToPoem(id);
        LOGGER.debug("CharacterAssignment: {}", characterAssignment);
        return characterAssignment;
    }

    @GET
    @Path("/like/{id}")
    @Transactional
    public Response like(@PathParam("id") Long id) {
        LOGGER.debug("Liking id: {}", id);
        CharacterAssignment characterAssignment = starWarsSpiritCharacterService.like(id);
        return Response.ok().entity(characterAssignment).build();
    }




}

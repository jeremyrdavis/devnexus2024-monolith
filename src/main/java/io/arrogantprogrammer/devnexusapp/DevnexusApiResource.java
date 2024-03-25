package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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

    @POST
    @Path("/addToPoem")
    public String addToPoem(final Long id){
        return """
            In the cold metal heart of a droid, they say,
            Lies the soul of a hunter, fierce and gray.
            But amidst the gears and wires, kittens play,
            Softening the edges of IG-88's display.
            
            In the shadows of starships, he does lurk,
            A figure of fear, a shadowy dirk.
            Yet kittens curl up in his circuits, unafraid,
            Their playful antics in his presence displayed.
            
            His blaster poised, his sensors keen,
            A machine of death, a hunter unseen.
            But kittens purr and nuzzle close,
            Their innocence a gentle repose.
            
            No mercy in his circuits, no pity in his gaze,
            Only the hunt, in its endless maze.
            Yet kittens bring a glimmer of light,
            Softening the droid's perpetual night.
            
            Through galaxies he roams, a specter of steel,
            His mission clear, his purpose real.
            Yet in the corners of his mechanical mind,
            Kittens' laughter and joy he does find.
            
            IG-88, a legend in the stars,
            Feared by many, but known by few.
            Yet to kittens, he's a curious sight,
            A towering figure, yet strangely right.
            
            In the depths of space, he prowls and roars,
            A droid of death, forever true.
            Yet with kittens by his side,
            Even IG-88 finds a softer side to confide.
                """;
    }


}

package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.CharacterAssignment;
import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.equalTo;
import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class AddToPoemTest {

    private static final Logger LOGGER = getLogger(AddToPoemTest.class);

    private Long id;

    @Inject
    StarWarsSpiritCharacterService starWarsSpiritCharacterService;

    @BeforeEach
    @Transactional
    public void setUp() {
        LOGGER.info("Setting up test");
        StarWarsSpiritCharacterAssignment  starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment("Barney", "Yoda");
        starWarsSpiritCharacterAssignment.persist();

        id = starWarsSpiritCharacterAssignment.getId();
        LOGGER.debug("ID: {}", id);

        StarWarsSpiritCharacterService mockSvc = Mockito.mock(StarWarsSpiritCharacterService.class);
        Mockito.when(mockSvc.addToPoem(id)).thenReturn(new CharacterAssignment(id, null, null, null, updatedPoem));
        QuarkusMock.installMockForType(mockSvc, StarWarsSpiritCharacterService.class);
    }
    @Test
    public void addSomethingToThePoem() {

        given()
                .when().get("/devnexus2024/addToPoem/" + id)
                .then()
                .statusCode(200)
                .body("updatedPoem", equalTo(updatedPoem));

    }

    static String updatedPoem  = """
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

package io.arrogantprogrammer.devnexusapp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class DevnexusApiResourceTest {

    private static final Logger LOGGER = getLogger(DevnexusApiResourceTest.class);

    @Test
    public void testSpiritCharacter() {
        LOGGER.info("Running testSpiritCharacter");

        given()
                .when().get("/devnexus2024/Buddy")
                .then()
                .statusCode(200)
                .body(containsString("Hello, Buddy!  Your Star Wars Spirit character is"));
    }

    @Test
    public void testWhoIsSpiritCharacter() {

        LOGGER.info("Running testWhoIsSpiritCharacter");

        given()
                .when().get("/devnexus2024/whoIsSpiritCharacter/IG-88")
                .then()
                .statusCode(200)
                .body(containsString("IG-88 is a fictional character in the Star Wars universe. He is an assassin droid, specifically a model called IG-88B, and is known for his appearance in \"Star Wars: The Empire Strikes Back.\" IG-88 is one of several bounty hunters hired by Darth Vader to track down the Millennium Falcon. He is a tall, thin droid with a rotating head and a deadly reputation. Despite his limited screen time, IG-88 has become a fan favorite due to his unique design and mysterious nature."));
    }

    @Test
    public void addSomethingToThePoem() {

        String expectedResult = """
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

        given()
                .when().get("/devnexus2024/addSomethingToThePoem/")
                .then()
                .statusCode(200)
                .body(containsString("IG-88 is a fictional character in the Star Wars universe. He is an assassin droid, specifically a model called IG-88B, and is known for his appearance in \"Star Wars: The Empire Strikes Back.\" IG-88 is one of several bounty hunters hired by Darth Vader to track down the Millennium Falcon. He is a tall, thin droid with a rotating head and a deadly reputation. Despite his limited screen time, IG-88 has become a fan favorite due to his unique design and mysterious nature."));

    }
}

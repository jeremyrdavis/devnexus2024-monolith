package io.arrogantprogrammer.devnexusapp;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class ApiWhoIsCharacterTest {

    private static final Logger LOGGER = getLogger(ApiWhoIsCharacterTest.class);

    @Inject
    StarWarsSpiritCharacterService starWarsSpiritCharacterService;

    String characterName = "IG-88";
    String whoIsText = """
            IG-88 is a fictional character in the Star Wars universe. He is an assassin droid, specifically a model called IG-88B, and is known for his appearance in \\"Star Wars: The Empire Strikes Back.\\" IG-88 is one of several bounty hunters hired by Darth Vader to track down the Millennium Falcon. He is a tall, thin droid with a rotating head and a deadly reputation. Despite his limited screen time, IG-88 has become a fan favorite due to his unique design and mysterious nature.
            """; // This is the expected text that should be returned when the whoIs method is called with the character name "IG-88"
    @BeforeEach
    public void setUp() {
        StarWarsSpiritCharacterService mockStarWarsSpiritCharacterService = Mockito.mock(StarWarsSpiritCharacterService.class);
        Mockito.when(mockStarWarsSpiritCharacterService.whoIs(characterName)).thenReturn(whoIsText);
        QuarkusMock.installMockForType(mockStarWarsSpiritCharacterService, StarWarsSpiritCharacterService.class);
    }

    @Test
    public void testWhoIsSpiritCharacter() {

        LOGGER.info("Running testWhoIsSpiritCharacter");

        given()
                .when().get("/devnexus2024/whoIsSpiritCharacter/IG-88")
                .then()
                .statusCode(200)
                .body(equalTo(whoIsText));
    }

}

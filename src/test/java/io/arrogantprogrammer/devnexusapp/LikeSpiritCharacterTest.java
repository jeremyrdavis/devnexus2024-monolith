package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class LikeSpiritCharacterTest extends ResourceTest{

    @BeforeEach @Transactional
    public void setUp() {
        LOGGER.info("Setting up test");
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment(name, charachter);
        starWarsSpiritCharacterAssignment.persist();

        id = starWarsSpiritCharacterAssignment.getId();
        LOGGER.debug("ID: {}", id);
    }

    @Test
    public void testLikeCharacter() {
        LOGGER.info("Running testLikeCharacter");
        given()
                .when().get("/devnexus2024/like/" + id)
                .then()
                .statusCode(200)
                .body("isLiked", equalTo(true));
    }

}

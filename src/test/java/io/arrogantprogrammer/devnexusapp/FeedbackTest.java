package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.Feedback;
import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.HEAD;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class FeedbackTest extends ResourceTest{

    @BeforeEach @Transactional
    public void setup() {
        LOGGER.info("Setting up test");
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment(name, charachter);
        starWarsSpiritCharacterAssignment.setLiked(true);
        starWarsSpiritCharacterAssignment.persist();

        id = starWarsSpiritCharacterAssignment.getId();
        LOGGER.debug("ID: {}", id);
    }

    @Test
    public void testAddingFeedback() {
        given()
                .with()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("{\"id\":" + id + ",\"value\":\"I loved it!\"}")
                .when().post("/devnexus2024/feedback/")
                .then()
                .statusCode(201);

        assertEquals(1, Feedback.count());
    }
}

package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.CharacterAssignment;
import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class PoemTest extends ResourceTest{

    @BeforeEach @Transactional
    public void setUp() {
        LOGGER.info("Setting up test");
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment(name, charachter);
        starWarsSpiritCharacterAssignment.persist();

        id = starWarsSpiritCharacterAssignment.getId();
        LOGGER.debug("ID: {}", id);

        StarWarsSpiritCharacterService mockSvc = Mockito.mock(StarWarsSpiritCharacterService.class);
        Mockito.when(mockSvc.aPoemAbout(id)).thenReturn(new CharacterAssignment(id, name, charachter, whoIs, poem));
        QuarkusMock.installMockForType(mockSvc, StarWarsSpiritCharacterService.class);
    }

    @Test
    public void testPoem() {
        LOGGER.info("Running testPoem");
        given()
                .when().get("/devnexus2024/aPoemAbout/" + id)
                .then()
                .statusCode(200)
                .body("poem", equalTo(poem));
    }
}

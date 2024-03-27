package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.CharacterAssignment;
import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
public class AssignCharacterTest extends ResourceTest {

    @Inject
    StarWarsSpiritCharacterService starWarsSpiritCharacterService;
    @BeforeEach @Transactional
    public void setUp() {

        LOGGER.info("Setting up test");
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment(name, charachter);
        starWarsSpiritCharacterAssignment.persist();

        id = starWarsSpiritCharacterAssignment.getId();
        LOGGER.debug("ID: {}", id);

        StarWarsSpiritCharacterService mockSvc = Mockito.mock(StarWarsSpiritCharacterService.class);
        Mockito.when(mockSvc.assignSpiritCharacter(name)).thenReturn(new CharacterAssignment(id, name, charachter));
        QuarkusMock.installMockForType(mockSvc, StarWarsSpiritCharacterService.class);
    }
    @Test
    public void assignSpiritCharacterTest() {

        LOGGER.info("Running assignSpiritCharacterTest");

        given()
                .with().body("Barney")
                .with().contentType("application/json")
                .when().post("/devnexus2024/assign")
                .then()
                .statusCode(201)
                .body("id", is(1))
                .body("name", is(name))
                .body("character", equalTo(charachter));
    }

}

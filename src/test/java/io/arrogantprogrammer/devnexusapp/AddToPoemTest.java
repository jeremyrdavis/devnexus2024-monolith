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
import org.slf4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class AddToPoemTest extends ResourceTest{

    @BeforeEach
    @Transactional
    public void setUp() {
        LOGGER.info("Setting up test");
        StarWarsSpiritCharacterAssignment  starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment(name, charachter);
        starWarsSpiritCharacterAssignment.persist();

        id = starWarsSpiritCharacterAssignment.getId();
        LOGGER.debug("ID: {}", id);

        StarWarsSpiritCharacterService mockSvc = Mockito.mock(StarWarsSpiritCharacterService.class);
        Mockito.when(mockSvc.addToPoem(id)).thenReturn(new CharacterAssignment(id, name, charachter, whoIs, poem, updatedPoem));
        QuarkusMock.installMockForType(mockSvc, StarWarsSpiritCharacterService.class);
    }
    @Test
    public void addSomethingToThePoem() {

        given()
                .when().get("/devnexus2024/addToPoem/" + id)
                .then()
                .statusCode(200)
                .body("updated_poem", equalTo(updatedPoem));
    }

}

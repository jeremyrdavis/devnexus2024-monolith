package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.CharacterAssignment;
import io.arrogantprogrammer.openapi.OpenApiService;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class StarWarsSpiritCharacterServiceTest {
    private static final Logger LOGGER = getLogger(StarWarsSpiritCharacterServiceTest.class);

    @Inject
    OpenApiService openApiService;

    @Inject
    StarWarsSpiritCharacterService starWarsSpiritCharacterService;

    String characterName = "Luke Skywalker";

    String response = """
                        Luke Skywalker is a fictional character from the Star Wars franchise created by George Lucas. He is a Jedi Knight who is one of the central protagonists in the original trilogy of films, portrayed by actor Mark Hamill. Luke is the son of Padmé Amidala and Anakin Skywalker (who becomes Darth Vader) and he is also the twin brother of Princess Leia Organa. Throughout the films, Luke embarks on a hero's journey to defeat the Galactic Empire and bring balance to the Force.
                    """;

    @BeforeEach
    public void setUp() {
        LOGGER.info("Setting up test");
        OpenApiService mockOpenApiService = Mockito.mock(OpenApiService.class);
        Mockito.when(mockOpenApiService.whoIsCharacter(characterName)).thenReturn(response);
        QuarkusMock.installMockForType(mockOpenApiService, OpenApiService.class);
    }

    @Test
    public void testWhoIsCharacter() {
        LOGGER.info("Running test");
//        CharacterAssignment characterAssignment = starWarsSpiritCharacterService.whoIs(id);
//        assert characterAssignment.name().n;
    }
}

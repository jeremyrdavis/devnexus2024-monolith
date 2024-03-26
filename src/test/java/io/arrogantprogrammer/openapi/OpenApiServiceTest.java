package io.arrogantprogrammer.openapi;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

@QuarkusTest
public class OpenApiServiceTest {
    private static final Logger LOGGER = getLogger(OpenApiServiceTest.class);

    @Inject
    OpenApiService openApiService;

    @Test
    public void testWhoIs() {
        LOGGER.info("Running testWhoIs");

        String result = openApiService.whoIsCharacter("Luke Skywalker");
        assertNotNull(result);
        assertTrue(result.contains("Luke Skywalker is a fictional character"));
    }
}

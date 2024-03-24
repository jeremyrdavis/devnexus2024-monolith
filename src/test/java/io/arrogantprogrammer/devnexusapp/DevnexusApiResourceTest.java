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
    public void testSpiritAnimal() {
        LOGGER.info("Running testSpiritAnimal");

        given()
                .when().get("/devnexus2024/Buddy")
                .then()
                .statusCode(200)
                .body(containsString("Hello, Buddy!  Your Star Wars Spirit character is"));

    }
}

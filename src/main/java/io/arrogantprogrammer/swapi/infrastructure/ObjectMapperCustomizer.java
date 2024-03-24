package io.arrogantprogrammer.swapi.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import jakarta.inject.Singleton;

@Singleton
public class ObjectMapperCustomizer implements io.quarkus.jackson.ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }

}

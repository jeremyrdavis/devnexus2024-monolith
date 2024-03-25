package io.arrogantprogrammer.openapi;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface OpenApiService {

    @UserMessage("""
                Who is {character}?
            """)
    String whoIsCharacter(final String character);
}

package io.arrogantprogrammer.openapi;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface OpenApiService {

    @UserMessage("""
                Who is {character}?
            """)
    String whoIsCharacter(final String character);

    @UserMessage("""
                Write a poem about {topic} in the style of {poet}.
            """)
    String writeAPoem(String topic, String poet);

    @UserMessage("""
                Add {topic} the the following poem: {poem}.
            """)
    String addThisToThePoem(String topic, String poem);
}

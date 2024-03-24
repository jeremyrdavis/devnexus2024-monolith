package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignment;
import io.arrogantprogrammer.devnexusapp.domain.StarWarsSpiritCharacterAssignmentRepository;
import io.arrogantprogrammer.swapi.domain.PersonRecord;
import io.arrogantprogrammer.swapi.infrastructure.SwapiClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class StarWarsSpiritCharacterService {

    private static final Logger LOGGER = getLogger(StarWarsSpiritCharacterService.class);

    int count;

    @RestClient
    SwapiClient swapiClient;

    @Inject
    StarWarsSpiritCharacterAssignmentRepository starWarsSpiritCharacterAssignmentRepository;

    @Transactional
    public StarWarsSpiritCharacterAssignment assignSpiritCharacter(final String name) {
        if(count == 0) {
            LOGGER.info("Running getRandomStarWarsCharacter");
            count = swapiClient.getAllPeople().count();
        }
        PersonRecord personRecord = swapiClient.getPerson((int) (Math.random() * (count - 1)) + 1);
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment(name, personRecord.name());
        starWarsSpiritCharacterAssignmentRepository.persist(starWarsSpiritCharacterAssignment);
        return starWarsSpiritCharacterAssignment;
    }

    public String whoIs(final String character) {
        return """
        IG-88 is a fictional character in the Star Wars universe. He is an assassin droid, specifically a model called IG-88B, and is known for his appearance in "Star Wars: The Empire Strikes Back." IG-88 is one of several bounty hunters hired by Darth Vader to track down the Millennium Falcon. He is a tall, thin droid with a rotating head and a deadly reputation. Despite his limited screen time, IG-88 has become a fan favorite due to his unique design and mysterious nature.
        """;
    }

    public String aPoemAbout(String character) {
        return """
                In the cold metal heart of a droid, they say,
                Lies the soul of a hunter, fierce and gray.
                IG-88, with eyes of gleaming red,
                A silent killer, a relentless dread.
                                
                In the shadows of starships, he does lurk,
                A figure of fear, a shadowy dirk.
                His blaster poised, his sensors keen,
                A machine of death, a hunter unseen.
                                
                No mercy in his circuits, no pity in his gaze,
                Only the hunt, in its endless maze.
                Through galaxies he roams, a specter of steel,
                His mission clear, his purpose real.
                                
                IG-88, a legend in the stars,
                Feared by many, but known by few.
                In the depths of space, he prowls and roars,
                A droid of death, forever true.
                """;
    }
}

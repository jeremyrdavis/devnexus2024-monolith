package io.arrogantprogrammer.devnexusapp;

import io.arrogantprogrammer.devnexusapp.domain.*;
import io.arrogantprogrammer.openapi.OpenApiService;
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
    OpenApiService openApiService;

    @Inject
    StarWarsSpiritCharacterAssignmentRepository repository;

    @Transactional
    public CharacterAssignment assignSpiritCharacter(final String name) {
        LOGGER.debug("Running assignSpiritCharacter");
        if(count == 0) {
            count = swapiClient.getAllPeople().count();
            LOGGER.debug("Count is {}", count);
        }
        PersonRecord personRecord = swapiClient.getPerson((int) (Math.random() * (count - 1)) + 1);
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = new StarWarsSpiritCharacterAssignment(name, personRecord.name());
        repository.persist(starWarsSpiritCharacterAssignment);
        CharacterAssignment characterAssignment = new CharacterAssignment(starWarsSpiritCharacterAssignment.getId(), starWarsSpiritCharacterAssignment.getName(), starWarsSpiritCharacterAssignment.getCharacterName());
        LOGGER.debug("CharacterAssignment: {}", characterAssignment);
        return characterAssignment; //new CharacterAssignment(starWarsSpiritCharacterAssignment.getId(), starWarsSpiritCharacterAssignment.getName(), starWarsSpiritCharacterAssignment.getCharacterName());
    }

    public CharacterAssignment whoIs(Long id) {
        LOGGER.debug("Getting whoIs for id: {}", id);
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = repository.findById(id);
        String whoIs = openApiService.whoIsCharacter(starWarsSpiritCharacterAssignment.getCharacterName());
        starWarsSpiritCharacterAssignment.setWhoIs(whoIs);
        repository.persist(starWarsSpiritCharacterAssignment);
        return new CharacterAssignment(starWarsSpiritCharacterAssignment.getId(), starWarsSpiritCharacterAssignment.getName(), starWarsSpiritCharacterAssignment.getCharacterName(), whoIs);
    }

    public CharacterAssignment aPoemAbout(Long id) {
        LOGGER.debug("Getting a poem for id: {}", id);
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = repository.findById(id);
        String poem  = openApiService.writeAPoem(starWarsSpiritCharacterAssignment.getCharacterName(), POET.randomPoet());
        starWarsSpiritCharacterAssignment.setPoem(poem);
        repository.persist(starWarsSpiritCharacterAssignment);
        return new CharacterAssignment(starWarsSpiritCharacterAssignment.getId(), starWarsSpiritCharacterAssignment.getName(), starWarsSpiritCharacterAssignment.getCharacterName(), starWarsSpiritCharacterAssignment.getWhoIs(), starWarsSpiritCharacterAssignment.getPoem());
    }

    public CharacterAssignment addToPoem(Long id) {
        LOGGER.debug("Adding to poem for id: {}", id);
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = repository.findById(id);
        String updatedPoem  = openApiService.addThisToThePoem(POETICADDITION.addition(), starWarsSpiritCharacterAssignment.getPoem());
        starWarsSpiritCharacterAssignment.setUpdatedPoem(updatedPoem);
        repository.persist(starWarsSpiritCharacterAssignment);
        return new CharacterAssignment(starWarsSpiritCharacterAssignment.getId(), starWarsSpiritCharacterAssignment.getName(), starWarsSpiritCharacterAssignment.getCharacterName(), starWarsSpiritCharacterAssignment.getWhoIs(), starWarsSpiritCharacterAssignment.getPoem(), starWarsSpiritCharacterAssignment.getUpdatedPoem());
    }

    public CharacterAssignment like(Long id) {
        LOGGER.debug("Liking id: {}", id);
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = repository.findById(id);
        starWarsSpiritCharacterAssignment.setLiked(true);
        starWarsSpiritCharacterAssignment.persist();
        return new CharacterAssignment(starWarsSpiritCharacterAssignment.getId(), starWarsSpiritCharacterAssignment.getName(), starWarsSpiritCharacterAssignment.getCharacterName(), starWarsSpiritCharacterAssignment.getWhoIs(), starWarsSpiritCharacterAssignment.getPoem(), starWarsSpiritCharacterAssignment.getUpdatedPoem(), starWarsSpiritCharacterAssignment.isLiked());
    }

    public void addFeedback(FeedbackRecord feedbackRecord) {
        LOGGER.debug("Adding feedback for id: {}", feedbackRecord.id());
        repository.recordFeedback(feedbackRecord);
    }
}

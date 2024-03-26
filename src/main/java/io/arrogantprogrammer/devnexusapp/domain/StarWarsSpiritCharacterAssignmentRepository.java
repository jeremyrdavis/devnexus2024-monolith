package io.arrogantprogrammer.devnexusapp.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class StarWarsSpiritCharacterAssignmentRepository implements PanacheRepository<StarWarsSpiritCharacterAssignment> {

    private static final Logger LOGGER = getLogger(StarWarsSpiritCharacterAssignmentRepository.class);
    public void recordFeedback(FeedbackRecord feedbackRecord) {
        StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment = findById(feedbackRecord.id());
        Feedback feedback = new Feedback(starWarsSpiritCharacterAssignment, feedbackRecord.value());
        feedback.persist();
        LOGGER.debug("Feedback recorded: {}", feedback);
    }
}

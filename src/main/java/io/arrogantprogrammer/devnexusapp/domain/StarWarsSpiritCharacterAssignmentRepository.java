package io.arrogantprogrammer.devnexusapp.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StarWarsSpiritCharacterAssignmentRepository implements PanacheRepository<StarWarsSpiritCharacterAssignment> {
}

package io.arrogantprogrammer.devnexusapp.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Feedback extends PanacheEntity {

    @OneToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment;
    String value;

    public Feedback() {
    }

    public Feedback(StarWarsSpiritCharacterAssignment starWarsSpiritCharacterAssignment, String value) {
        this.starWarsSpiritCharacterAssignment = starWarsSpiritCharacterAssignment;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "starWarsSpiritCharacterAssignment=" + starWarsSpiritCharacterAssignment +
                ", value='" + value + '\'' +
                ", id=" + id +
                '}';
    }
}

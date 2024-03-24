package io.arrogantprogrammer.devnexusapp.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class StarWarsSpiritCharacterAssignment extends PanacheEntity {

    String name;

    String characterName;

    public StarWarsSpiritCharacterAssignment() {
    }

    public StarWarsSpiritCharacterAssignment(String name, String characterName) {
        this.name = name;
        this.characterName = characterName;
    }

    public String name() {
        return name;
    }

    public String characterName() {
        return characterName;
    }

    @Override
    public String toString() {
        return "StarWarsSpiritCharacterAssignment{" +
                "name='" + name + '\'' +
                ", characterName='" + characterName + '\'' +
                ", id=" + id +
                '}';
    }
}

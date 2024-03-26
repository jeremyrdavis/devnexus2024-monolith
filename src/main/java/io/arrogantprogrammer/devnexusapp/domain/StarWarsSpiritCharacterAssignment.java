package io.arrogantprogrammer.devnexusapp.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

@Entity
public class StarWarsSpiritCharacterAssignment extends PanacheEntity {

    String name;

    String characterName;

    @Lob
    String whoIs;

    @Lob
    String poem;

    @Lob
    String updatedPoem;

    public StarWarsSpiritCharacterAssignment() {
    }

    public StarWarsSpiritCharacterAssignment(String name, String characterName) {
        this.name = name;
        this.characterName = characterName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPoem() {
        return poem;
    }

    public void setPoem(String poem) {
        this.poem = poem;
    }

    public String getUpdatedPoem() {
        return updatedPoem;
    }

    public void setUpdatedPoem(String updatedPoem) {
        this.updatedPoem = updatedPoem;
    }

    public String getWhoIs() {
        return whoIs;
    }

    public void setWhoIs(String whoIs) {
        this.whoIs = whoIs;
    }

    @Override
    public String toString() {
        return "StarWarsSpiritCharacterAssignment{" +
                "name='" + name + '\'' +
                ", characterName='" + characterName + '\'' +
                ", whoIs='" + whoIs + '\'' +
                ", poem='" + poem + '\'' +
                ", updatedPoem='" + updatedPoem + '\'' +
                ", id=" + id +
                '}';
    }
}

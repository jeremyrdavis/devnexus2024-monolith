package io.arrogantprogrammer.devnexusapp.domain;

public record CharacterAssignment(Long id, String name, String character, String whoIs, String poem, String updatedPoem) {

    public CharacterAssignment(Long id, String name, String character) {

        this(id, name, character, null, null, null);
    }

    public CharacterAssignment(Long id, String name, String characterName, String whoIs) {
        this(id, name, characterName, whoIs, null, null);
    }

    public CharacterAssignment(Long id, String name, String characterName, String whoIs, String poem) {
        this(id, name, characterName, whoIs, poem, null);
    }
}

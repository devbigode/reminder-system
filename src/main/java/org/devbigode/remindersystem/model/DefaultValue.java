package org.devbigode.remindersystem.model;

public enum DefaultValue {
    TITLE("Lembrete"),
    MESSAGE("Hora de beber água!"),
    POSITION("BOTTOM_RIGHT"),
    DURATION("5"),
    INTERVAL("60"),
    IMAGE("icons/water.png"),
    TYPE("INFO");

    private final String value;

    DefaultValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package org.devbigode.remindersystem.model;

public enum DefaultValue {
    TITLE("Lembrete"),
    MESSAGE("Hora de beber água!"),
    POSITION("BOTTOM_RIGHT"),
    DURATION("10"),
    INTERVAL("60"),
    IMAGE("icons/water.png");

    private final String value;

    DefaultValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

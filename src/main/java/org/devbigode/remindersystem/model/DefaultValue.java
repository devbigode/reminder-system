package org.devbigode.remindersystem.model;

public enum DefaultValue {
    TITLE("Lembrete"),
    MESSAGE("Aviso urgente! Mude a mensagem."),
    POSITION("BOTTOM_RIGHT"),
    DURATION("10"),
    INTERVAL("1"),
    IMAGE("icons/notification.png"),
    AUDIO("audios/pleasant-notification.wav");

    private final String value;

    DefaultValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

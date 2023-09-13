package io.github.tiagoadmstz.cm.entities;

public enum Zone {

    URBAN("Urban"), RURAL("Rural");

    private final String value;

    Zone(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

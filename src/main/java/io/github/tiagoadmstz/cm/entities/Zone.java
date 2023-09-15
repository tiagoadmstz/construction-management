package io.github.tiagoadmstz.cm.entities;

import org.springframework.util.StringUtils;

public enum Zone {

    URBAN("Urbano"), RURAL("Rural");

    private final String value;

    Zone(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static Zone parse(String value) {
        final String capitalized = StringUtils.capitalize(value.toLowerCase());
        return capitalized.equals(RURAL.value) ? RURAL : URBAN;
    }
}

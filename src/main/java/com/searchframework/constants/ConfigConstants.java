package com.searchframework.constants;

public final class ConfigConstants {

    private ConfigConstants() {
        throw new IllegalStateException("Config Constants Class");
    }

    public static final String APPLICATION_PROPERTIES_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\application.properties";
}

package com.github.avenderov.publisher.config;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ClasspathConfigLoader implements ConfigLoader {

    private static final String DEFAULT_CONFIG_FILE = "debezium.properties";

    private final String configFile;

    public ClasspathConfigLoader(String configFile) {
        this.configFile = configFile;
    }

    public static ConfigLoader defaultLoader() {
        return new ClasspathConfigLoader(DEFAULT_CONFIG_FILE);
    }

    @Override
    public Map<String, String> load() {
        final var input = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFile);
        if (input == null) {
            throw new IllegalStateException(String.format("Configuration file %s not found", configFile));
        }

        final var properties = new Properties();

        try (input) {
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(String.format("Error while reading from %s", configFile), e);
        }

        return properties
            .stringPropertyNames()
            .stream()
            .collect(Collectors.toMap(Function.identity(), properties::getProperty));
    }
}

package com.github.avenderov.publisher.config;

import io.debezium.connector.postgresql.PostgresConnectorConfig;

import java.util.HashMap;
import java.util.Map;

public final class SecretsLoader implements ConfigLoader {

    private static final String DB_USERNAME = "DB_USERNAME";
    private static final String DB_PASSWORD = "DB_PASSWORD";

    private final SecretProvider secretProvider;

    public SecretsLoader(SecretProvider secretProvider) {
        this.secretProvider = secretProvider;
    }

    /**
     * Loads secrets from the environment.
     */
    public static ConfigLoader defaultLoader() {
        return new SecretsLoader(SecretProvider.environment());
    }

    @Override
    public Map<String, String> load() {
        final var properties = new HashMap<String, String>();

        secretProvider.get(DB_USERNAME)
            .ifPresent(user -> properties.put(PostgresConnectorConfig.USER.name(), user));
        secretProvider.get(DB_PASSWORD)
            .ifPresent(password -> properties.put(PostgresConnectorConfig.PASSWORD.name(), password));

        return Map.copyOf(properties);
    }
}

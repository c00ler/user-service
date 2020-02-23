package com.github.avenderov.publisher.config;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class SecretsLoaderTest {

    @Test
    void shouldLoadSecretsFromProvider() {
        final var configLoader = new SecretsLoader(new SecretProvider() {

            private final Map<String, String> secrets =
                Map.of("DB_USERNAME", "username", "DB_PASSWORD", "password");

            @Override
            public Optional<String> get(String name) {
                return Optional.ofNullable(secrets.get(name));
            }
        });

        assertThat(configLoader.load())
            .containsOnly(entry("database.user", "username"), entry("database.password", "password"));
    }
}

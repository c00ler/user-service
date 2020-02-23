package com.github.avenderov.publisher.config;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class SecretProviderTest {

    @Test
    void shouldOverrideValueFromThePreviousLoader() {
        final var merged = ConfigLoader.merge(
            () -> Map.of("key", "value1"),
            () -> Map.of("key", "value2")
        );

        assertThat(merged).containsOnly(entry("key", "value2"));
    }
}

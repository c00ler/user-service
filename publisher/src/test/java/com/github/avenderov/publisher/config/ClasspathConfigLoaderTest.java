package com.github.avenderov.publisher.config;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class ClasspathConfigLoaderTest {

    @Test
    void shouldLoadConfigurationFile() {
        final var configLoader = ClasspathConfigLoader.defaultLoader();

        assertThat(configLoader.load()).contains(entry("name", "consumer-debezium-connector"));
    }
}

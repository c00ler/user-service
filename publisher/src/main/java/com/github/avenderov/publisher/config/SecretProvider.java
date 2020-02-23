package com.github.avenderov.publisher.config;

import java.util.Optional;

public interface SecretProvider {

    Optional<String> get(String name);

    static SecretProvider environment() {
        return name -> {
            final var value = System.getenv(name);
            if (value == null) {
                throw new IllegalStateException(String.format("Required environment variable %s is not set", name));
            }
            return Optional.of(value);
        };
    }
}

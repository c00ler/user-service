package com.github.avenderov.publisher.config;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public interface ConfigLoader {

    Map<String, String> load();

    static Map<String, String> merge(final ConfigLoader... configLoaders) {
        return Arrays.stream(configLoaders)
            .flatMap(configLoader -> configLoader.load().entrySet().stream())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (__, newValue) -> newValue));
    }
}

package com.github.avenderov.publisher;

import com.github.avenderov.publisher.config.ClasspathConfigLoader;
import com.github.avenderov.publisher.config.ConfigLoader;
import com.github.avenderov.publisher.config.SecretsLoader;

public final class Launcher {

    public static void main(String[] args) {
        final var config =
            ConfigLoader.merge(ClasspathConfigLoader.defaultLoader(), SecretsLoader.defaultLoader());

        System.out.println(config);
    }
}

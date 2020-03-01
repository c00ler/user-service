package com.github.avenderov.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static com.github.avenderov.TestData.anEmail;
import static org.assertj.core.api.Assertions.assertThat;

class EmailTest {

    @Test
    void differentInstancesShouldBeEqual() {
        final var name = RandomStringUtils.randomAlphabetic(10);

        assertThat(anEmail(name)).isEqualTo(anEmail(name));
    }
}

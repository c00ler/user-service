package com.github.avenderov.api.user;

import com.github.avenderov.api.user.events.UserCreatedEvent;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static com.github.avenderov.TestData.anEmail;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void shouldGenerateModelId() {
        final var password = RandomStringUtils.randomAlphabetic(10);
        final var email = anEmail();

        final var user =
            User.builder()
                .firstName("John")
                .lastName("Doe")
                .password(password)
                .email(email)
                .build();

        assertThat(user).satisfies(u -> {
            assertThat(u.id()).isNotNull();
            assertThat(u.email()).isEqualTo(email);
            assertThat(u.password()).isEqualTo(password);
            assertThat(u.firstName()).isEqualTo("John");
            assertThat(u.lastName()).isEqualTo("Doe");
        });
    }

    @Test
    void shouldHaveModelCreatedEvent() {
        final var user =
            User.builder()
                .firstName("John")
                .lastName("Doe")
                .password(RandomStringUtils.randomAlphabetic(10))
                .email(anEmail())
                .build();

        assertThat(user.events())
            .hasSize(1)
            .hasOnlyElementsOfType(UserCreatedEvent.class);
    }
}

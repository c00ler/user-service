package com.github.avenderov;

import com.github.avenderov.common.Email;
import org.apache.commons.lang3.RandomStringUtils;

public final class TestData {

    private static final String EMAIL_TEMPLATE = "%s@mail.com";

    private TestData() {
    }

    public static Email anEmail() {
        return anEmail(RandomStringUtils.randomAlphabetic(10));
    }

    public static Email anEmail(final String name) {
        return Email.of(String.format(EMAIL_TEMPLATE, name));
    }
}

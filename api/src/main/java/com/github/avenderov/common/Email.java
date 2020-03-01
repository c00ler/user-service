package com.github.avenderov.common;

import org.apache.commons.lang3.Validate;

public final class Email extends TinyType<String> {

    private Email(final String value) {
        super(value);
    }

    public static Email of(final String email) {
        Validate.notBlank(email);
        return new Email(email);
    }
}

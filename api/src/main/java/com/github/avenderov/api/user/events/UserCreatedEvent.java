package com.github.avenderov.api.user.events;

import com.github.avenderov.api.user.User;
import com.github.avenderov.common.Email;
import com.github.avenderov.common.ModelCreatedEvent;
import org.apache.commons.lang3.Validate;

import java.util.UUID;

public class UserCreatedEvent extends ModelCreatedEvent<UUID> {

    private final String firstName;
    private final String lastName;
    private final Email email;

    public UserCreatedEvent(User.UserBuilder builder) {
        super(builder.modelId());

        this.firstName = Validate.notBlank(builder.firstName());
        this.lastName = Validate.notBlank(builder.lastName());
        this.email = Validate.notNull(builder.email());
    }
}

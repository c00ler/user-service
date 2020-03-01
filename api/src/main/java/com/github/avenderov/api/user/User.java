package com.github.avenderov.api.user;

import com.github.avenderov.api.user.events.UserCreatedEvent;
import com.github.avenderov.common.AbstractModel;
import com.github.avenderov.common.Email;
import com.github.avenderov.common.ModelBuilder;
import com.github.avenderov.common.ModelCreatedEvent;
import org.apache.commons.lang3.Validate;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

public class User extends AbstractModel<UUID> {

    private final String firstName;
    private final String lastName;
    private final Email email;
    private final String password;

    private User(UserBuilder builder) {
        super(builder.modelId);

        this.firstName = Validate.notBlank(builder.firstName);
        this.lastName = Validate.notBlank(builder.lastName);
        this.email = Validate.notNull(builder.email);
        this.password = Validate.notBlank(builder.password);

        if (!builder.existing) {
            addEvent(builder.modelCreatedEvent());
        }
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public Email email() {
        return email;
    }

    public String password() {
        return password;
    }

    public User changeEmail(final Email newEmail) {
        Objects.requireNonNull(newEmail);
        if (newEmail.equals(this.email)) {
            return this;
        }
        return toBuilder()
            .email(newEmail)
            .build();
    }

    @Override
    protected final UserBuilder toBuilder() {
        return new UserBuilder(this);
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder extends ModelBuilder<UUID, User> {

        private String firstName;
        private String lastName;
        private Email email;
        private String password;

        private UserBuilder(final User user) {
            super(user);

            this.firstName = user.firstName();
            this.lastName = user.lastName();
            this.email = user.email();
            this.password = user.password();
        }

        private UserBuilder() {
        }

        public UserBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(final Email email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(final String password) {
            this.password = password;
            return this;
        }

        @Nullable
        public String firstName() {
            return firstName;
        }

        @Nullable
        public String lastName() {
            return lastName;
        }

        @Nullable
        public Email email() {
            return email;
        }

        @Nullable
        public String password() {
            return password;
        }

        @Override
        protected final UUID generateId() {
            return UUID.randomUUID();
        }

        @Override
        protected final ModelCreatedEvent<UUID> modelCreatedEvent() {
            Validate.isTrue(!this.existing);
            return new UserCreatedEvent(this);
        }

        @Override
        public User build() {
            return new User(this);
        }
    }
}

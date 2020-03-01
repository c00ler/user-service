package com.github.avenderov.common;

import java.util.Objects;

public abstract class TinyType<T> {

    private final T value;

    protected TinyType(final T value) {
        this.value = Objects.requireNonNull(value);
    }

    public final T value() {
        return value;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TinyType<?> tinyType = (TinyType<?>) o;
        return value.equals(tinyType.value);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(value);
    }
}

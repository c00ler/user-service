package com.github.avenderov.common;

import java.util.Objects;
import java.util.UUID;

public abstract class AbstractEvent<ModelId> implements Identifiable<UUID> {

    protected final UUID id;
    protected final ModelId modelId;

    protected AbstractEvent(final ModelId modelId) {
        this.id = UUID.randomUUID();
        this.modelId = Objects.requireNonNull(modelId);
    }

    @Override
    public final UUID id() {
        return id;
    }

    public final ModelId modelId() {
        return modelId;
    }
}

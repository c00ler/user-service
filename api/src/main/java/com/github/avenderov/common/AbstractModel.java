package com.github.avenderov.common;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractModel<ModelId> implements Identifiable<ModelId> {

    private final ModelId modelId;
    private final Set<AbstractEvent<ModelId>> events = new HashSet<>();

    protected AbstractModel(final ModelId modelId) {
        this.modelId = Objects.requireNonNull(modelId);
    }

    @Override
    public final ModelId id() {
        return modelId;
    }

    public Set<AbstractEvent<ModelId>> events() {
        return Set.copyOf(events);
    }

    protected final void addEvent(final AbstractEvent<ModelId> event) {
        Objects.requireNonNull(event);
        events.add(event);
    }

    protected ModelBuilder<ModelId, ? extends AbstractModel<ModelId>> toBuilder() {
        throw new UnsupportedOperationException("method is not supported");
    }
}

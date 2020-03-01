package com.github.avenderov.common;

public abstract class ModelBuilder<ModelId, M extends AbstractModel<ModelId>> {

    public final ModelId modelId;
    public final boolean existing;

    protected ModelBuilder(final M model) {
        this.modelId = model.id();
        this.existing = true;
    }

    protected ModelBuilder() {
        this.modelId = generateId();
        this.existing = false;
    }

    public final ModelId modelId() {
        return modelId;
    }

    public final boolean existing() {
        return existing;
    }

    protected abstract ModelId generateId();

    protected abstract ModelCreatedEvent<ModelId> modelCreatedEvent();

    public abstract M build();
}

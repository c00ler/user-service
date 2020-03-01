package com.github.avenderov.common;

public class ModelCreatedEvent<ModelId> extends AbstractEvent<ModelId> {

    protected ModelCreatedEvent(ModelId modelId) {
        super(modelId);
    }
}

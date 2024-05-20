package com.support.eng.notifier.data;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@MappedEntity
public record Post(
    @Id
    @NotNull
    @MappedProperty("id")
    UUID id,

    @NotNull
    @MappedProperty("title")
    String title,

    @NotNull
    @MappedProperty("content")
    String content,

    @NotNull
    @MappedProperty("user_id")
    UUID userId,

    @NotNull
    @MappedProperty("created_at")
    OffsetDateTime createdAt,

    @NotNull
    @MappedProperty("updated_at")
    OffsetDateTime updatedAt
) { }

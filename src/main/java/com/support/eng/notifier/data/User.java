package com.support.eng.notifier.data;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;


@MappedEntity
public record User(
    @Id
    @NotNull
    @MappedProperty("id")
    UUID id,

    @NotNull
    @MappedProperty("name")
    String name,

    @NotNull
    @MappedProperty("email")
    String email,

    @Nullable
    @MappedProperty("age")
    Integer age,

    @OneToMany(mappedBy = "userId")
    List<Post> posts,


    @NotNull
    @MappedProperty("created_at")
    OffsetDateTime createdAt,

    @NotNull
    @MappedProperty("updated_at")
    OffsetDateTime updatedAt
) { }

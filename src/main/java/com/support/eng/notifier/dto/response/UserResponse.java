package com.support.eng.notifier.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.micronaut.core.annotation.Introspected;
import org.immutables.value.Value;

@Introspected
@Value.Immutable
@JsonDeserialize(builder = ImmutableUserResponse.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class UserResponse {
    public abstract Integer id();
    public abstract String name();
    public abstract Integer age();
}

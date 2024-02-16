package com.support.eng.notifier.dto.request.record;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Introspected
@Serdeable
public record UserRequest(
    @Positive
    Integer age,

    @NotBlank
    @Size(min = 3)
    String name
) {
}

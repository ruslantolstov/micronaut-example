package com.support.eng.notifier.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Value;


@Introspected
@Serdeable
@Value
@Builder
@JsonInclude(JsonInclude.Include.ALWAYS)
public class UserV2Response {
    public Integer id;
    public String name;
    public Integer age;
}

package com.support.eng.notifier.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;


@Introspected
@Serdeable
@Value
@Builder
@JsonInclude(JsonInclude.Include.ALWAYS)
public class UserV2Response {
    public UUID id;
    public String name;
    public String email;
    public Integer age;
    public List<PostResponse> posts;
}

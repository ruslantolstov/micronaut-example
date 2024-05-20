package com.support.eng.notifier.dto.response;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Introspected
@Serdeable
@Value
@Builder
public class PostResponse {
  public UUID id;
  public String title;
}

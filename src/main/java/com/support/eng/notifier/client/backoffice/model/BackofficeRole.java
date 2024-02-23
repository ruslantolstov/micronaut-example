package com.support.eng.notifier.client.backoffice.model;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Value;

@Introspected
@Serdeable
@Value
public class BackofficeRole {
    String name;
}

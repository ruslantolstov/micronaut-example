package com.support.eng.notifier.client.backoffice.model;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Value;

import java.util.List;

@Introspected
@Serdeable
@Value
public class BackofficeUser {
    Integer id;
    String email;
    List<BackofficeRole> roles;
}

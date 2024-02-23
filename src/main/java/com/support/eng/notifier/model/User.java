package com.support.eng.notifier.model;


import com.support.eng.notifier.client.backoffice.model.BackofficeRole;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Introspected
@Serdeable
@Value
@Builder
public class User {
  Integer id;
  String name;
  Integer age;
  String email;
  List<BackofficeRole> roles;
  Integer locationId;
}

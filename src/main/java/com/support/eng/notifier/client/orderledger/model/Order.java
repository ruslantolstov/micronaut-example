package com.support.eng.notifier.client.orderledger.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Value;

@Introspected
@Serdeable
@Value
public class Order {
    Integer locationId;
}

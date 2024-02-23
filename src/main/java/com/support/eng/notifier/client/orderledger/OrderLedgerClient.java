package com.support.eng.notifier.client.orderledger;

import com.support.eng.notifier.client.orderledger.model.Order;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;

import java.util.UUID;

@Client(id = "order-ledger")
public interface OrderLedgerClient {
    @Get(value = "/api/v2/orders/{orderId}", processes = MediaType.APPLICATION_JSON)
    Order getOrder(@PathVariable UUID orderId);
}

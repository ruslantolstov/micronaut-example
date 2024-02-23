package com.support.eng.notifier.controller;
import com.support.eng.notifier.client.backoffice.BackofficeClient;
import com.support.eng.notifier.client.backoffice.model.BackofficeUser;
import com.support.eng.notifier.client.orderledger.OrderLedgerClient;
import com.support.eng.notifier.client.orderledger.model.Order;
import com.support.eng.notifier.dto.request.record.UserRequest;
import com.support.eng.notifier.dto.response.UserV2Response;
import com.support.eng.notifier.model.User;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@Controller("/api/users")
@Secured(SecurityRule.IS_ANONYMOUS)
public class UserController {
    @Inject
    BackofficeClient backofficeClient;

    @Inject
    OrderLedgerClient orderLedgerClient;

    @Get("/")
    @Produces("application/json")
    public List<User> index() {
        List<User> users = List.of(User.builder().id(2166339).name("Fred").build(), User.builder().id(2).build());
        return users;
    }

    @Get("/{id}")
    @Produces("application/json")
    @ExecuteOn(TaskExecutors.BLOCKING)
    public User show(Integer id) {
        BackofficeUser bUser = backofficeClient.getUser(2166339);
        Order order = orderLedgerClient.getOrder(UUID.fromString("544a3351-e2c1-4996-9803-365272d4f729"));
        User user = User.builder().id(2166339).name("Fred")
                .email(bUser.getEmail())
                .roles(bUser.getRoles())
                .locationId(order.getLocationId())
                .build();

        return user;
    }

    @Post("/")
    @Produces("application/json")
    public UserV2Response create(@Valid @Body UserRequest userRequest) {
        var user = User.builder().id(1).name(userRequest.name()).age(userRequest.age()).build();

        var response = UserV2Response.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();

        return response;
    }
}

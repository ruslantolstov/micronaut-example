package com.support.eng.notifier.controller;

import com.support.eng.notifier.client.backoffice.BackofficeClient;
import com.support.eng.notifier.client.backoffice.model.BackofficeUser;
import com.support.eng.notifier.client.orderledger.OrderLedgerClient;
import com.support.eng.notifier.client.orderledger.model.Order;
import com.support.eng.notifier.data.repository.UserRepository;
import com.support.eng.notifier.dto.request.record.UserRequest;
import com.support.eng.notifier.dto.response.PostResponse;
import com.support.eng.notifier.dto.response.UserV2Response;
import com.support.eng.notifier.model.User;
import com.support.eng.notifier.service.UserService;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import reactor.core.publisher.Mono;

@Controller("/api/users")
@Secured(SecurityRule.IS_ANONYMOUS)
public class UserController {

  @Inject
  BackofficeClient backofficeClient;

  @Inject
  OrderLedgerClient orderLedgerClient;

  @Inject
  UserService userService;

  @Inject
  ApplicationContext applicationContext;

  @Inject
  UserRepository userRepository;

  @Get("/")
  @Produces("application/json")
  public Mono<List<UserV2Response>> index() {
    return userRepository.findAll().map(user ->
                                            UserV2Response.builder()
                                                          .id(user.id())
                                                          .name(user.name())
                                                          .email(user.email())
                                                          .posts(user.posts().stream().map(post -> {
                                                            return PostResponse.builder()
                                                                               .id(post.id())
                                                                               .title(post.title())
                                                                               .build();
                                                          }).collect(Collectors.toList()))
                                                          .age(user.age())
                                                          .build()).collectList();
  }

  @Get("/{id}")
  @Produces("application/json")
  public Mono<UserV2Response> show(UUID id, @QueryValue("age") Integer age) {

    return userRepository.findByAgeOrId(age, id).map(user ->
                                                         UserV2Response.builder()
                                                                       .id(user.id())
                                                                       .name(user.name())
                                                                       .email(user.email())
                                                                       .age(user.age())
                                                                       .build());
  }

  @Post("/")
  @Produces("application/json")
  public UserV2Response create(@Valid @Body UserRequest userRequest) {
    var user = User.builder().id(1).name(userRequest.name()).age(userRequest.age()).build();

    var response = UserV2Response.builder()
                                 .id(UUID.randomUUID())
                                 .name(user.getName())
                                 .age(user.getAge())
                                 .build();

    return response;
  }
}

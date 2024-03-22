package com.support.eng.notifier.service;

import com.support.eng.notifier.model.User;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Replaces;
import java.util.List;


@Bean
//@Replaces(UserService.class)
public class User2Service extends UserService {
  public List<User> allUsers() {
    List<User> users = List.of(User.builder().id(123).name("Alex").build(), User.builder().id(3).build());
    return users;
  }
}

package com.support.eng.notifier.service;

import com.support.eng.notifier.factory.UserFactory;
import com.support.eng.notifier.lib.ThirdPartyUserClient;
import com.support.eng.notifier.model.User;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Infrastructure;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.runtime.context.scope.Refreshable;
import io.micronaut.runtime.http.scope.RequestScope;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import java.util.List;


//@Singleton
@Bean
//@Prototype
//@Context - scope indicates that the bean will be created at the same time as the ApplicationContext (eager initialization)
//@ThreadLocal - scope is a custom scope that associates a bean per thread via a ThreadLocal
//@Refreshable - scope is a custom scope that allows a bean’s state to be refreshed via the /refresh endpoint.
//@RequestScope - scope is a custom scope that indicates a new instance of the bean is created and associated with each HTTP request
//@Infrastructure - scope represents a bean that cannot be overridden or replaced using @Replaces
public class UserService {

  @Inject
  @Named("clientV1")
  ThirdPartyUserClient client;

  //private final ThirdPartyUserClient client;
  //
  //@Inject
  //public UserService(@Named("clientV1") ThirdPartyUserClient client) {
  //  this.client = client;
  //}

  public List<User> allUsers() {
    List<User> users = List.of(User.builder().id(2166339).name(client.getName()).build(), User.builder().id(2).build());
    return users;
  }

  @PostConstruct
  void init() {
    System.out.println("UserService is initialized");
  }

  @PreDestroy
  public void close() {
    System.out.println("UserService is destroyed");
  }
}

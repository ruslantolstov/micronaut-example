package com.support.eng.notifier.factory;

import com.support.eng.notifier.lib.ThirdPartyUserClient;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.annotation.Order;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;
import jakarta.inject.Singleton;

@Factory
public class UserFactory {

  @Singleton
  //@Order(2)
  @Named("clientV1")
  public ThirdPartyUserClient client() {
    return new ThirdPartyUserClient("Third Party User");
  }

  @Singleton
  //@Order(1)
  @Named("clientV2")
  public ThirdPartyUserClient clientV2() {
    return new ThirdPartyUserClient("Third Party User V2");
  }
}

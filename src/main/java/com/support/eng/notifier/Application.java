package com.support.eng.notifier;

import com.support.eng.notifier.service.UserService;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        var applicationContext = Micronaut.run(Application.class, args);
        //applicationContext.getBean(UserService.class).allUsers();
    }
}

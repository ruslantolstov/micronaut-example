package com.support.eng.notifier.controller;
import com.support.eng.notifier.model.User;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.util.List;

@Controller("/api/users")
public class UserController {
    @Get("/")
    @Produces("application/json")
    public List<User> index() {
        List<User> users = List.of(new User(1, "Fred"), new User(2));
        return users;
    }

    @Get("/{id}")
    @Produces("application/json")
    public User show(Integer id) {
        List<User> users = List.of(new User(1, "Fred"), new User(2));

        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}

package com.support.eng.notifier.controller;
import com.support.eng.notifier.dto.request.record.UserRequest;
import com.support.eng.notifier.dto.response.ImmutableUserResponse;
import com.support.eng.notifier.dto.response.UserResponse;
import com.support.eng.notifier.dto.response.UserV2Response;
import com.support.eng.notifier.model.User;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;

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

    @Post("/")
    @Produces("application/json")
    public UserV2Response create(@Valid @Body UserRequest userRequest) {
        var user = new User(1, userRequest.name(), userRequest.age());

        var response = UserV2Response.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();

        return response;
    }
}

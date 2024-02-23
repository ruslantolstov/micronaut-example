package com.support.eng.notifier.client.backoffice;


import com.support.eng.notifier.client.backoffice.model.BackofficeUser;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.constraints.NotNull;

@Client("backoffice")
public interface BackofficeClient {
    @Get(value = "/backoffice/api/users/{id}",  processes = MediaType.APPLICATION_JSON)
    @Header(name = "Authorization", value = "Token token=${micronaut.http.services.backoffice.auth-token}")
    BackofficeUser getUser(@NotNull @PathVariable Integer id);
}

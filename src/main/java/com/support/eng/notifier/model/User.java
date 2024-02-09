package com.support.eng.notifier.model;


import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class User {
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public User(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String name;
}

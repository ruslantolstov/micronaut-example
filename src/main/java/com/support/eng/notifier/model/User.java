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

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public User(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
}

package com.support.eng.notifier.reactivity._06_FlatMap;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.languages().flatMap(result -> main.toUpperCase(result)).subscribe(System.out::println);

        System.out.println("Finished!");
    }

    public Flux<String> languages() {
        return Flux.just("Ruby", "Java");
    }


    public Mono<String> toUpperCase(String value) {
        return Mono.just(value.toUpperCase());
    }
}

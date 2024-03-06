package com.support.eng.notifier.reactivity._07_Skip;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
//        main.languages().skip(1).subscribe(System.out::println);
//        main.languages().skipLast(1).subscribe(System.out::println);
        main.languages().flatMap(main::toUpperCase).skip(Duration.ofSeconds(1)).subscribe(System.out::println);

        System.out.println("Finished!");
    }

    public Mono<String> toUpperCase(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Mono.just(value.toUpperCase());
    }

    public Flux<String> languages() {
        return Flux.just("Ruby", "Java", "Go");
    }
}

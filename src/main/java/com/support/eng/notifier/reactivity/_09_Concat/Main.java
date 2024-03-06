package com.support.eng.notifier.reactivity._09_Concat;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

        Flux.concat(main.languages(), main.frameworks()).log().subscribe(System.out::println);

        Thread.sleep(10000);
        System.out.println("Finished!");
    }

    public Flux<String> languages() {
        return Flux.just("Ruby", "Java", "Go").delayElements(Duration.ofSeconds(1));
    }

    public Flux<String> frameworks() {
        return Flux.just("Rails", "Spring", "Micronaut", "Gin").delayElements(Duration.ofSeconds(1));
    }
}

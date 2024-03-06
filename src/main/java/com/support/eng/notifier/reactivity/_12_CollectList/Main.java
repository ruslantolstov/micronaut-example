package com.support.eng.notifier.reactivity._12_CollectList;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

        Mono<List<String>> result = Flux.merge(main.languages(), main.frameworks()).collectList();

        System.out.println(result.block());

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

package com.support.eng.notifier.reactivity._13_Buffer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

        Flux.merge(main.languages(), main.frameworks()).log().buffer(2).subscribe(
                (list) -> {
                    System.out.println(list);
                }
        );

        Thread.sleep(10000);
        System.out.println("Finished!");
    }

    public Flux<String> languages() {
        return Flux.just("Ruby", "Java", "Go");
    }

    public Flux<String> frameworks() {
        return Flux.just("Rails", "Spring", "Micronaut", "Gin");
    }
}

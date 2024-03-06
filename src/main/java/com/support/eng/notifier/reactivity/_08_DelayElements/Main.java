package com.support.eng.notifier.reactivity._08_DelayElements;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.languages().log().subscribe(System.out::println);

        Thread.sleep(10000);
        System.out.println("Finished!");
    }

    public Flux<String> languages() {
        return Flux.just("Ruby", "Java", "Go").delayElements(Duration.ofSeconds(1));
    }
}

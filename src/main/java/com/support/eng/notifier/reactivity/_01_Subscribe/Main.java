package com.support.eng.notifier.reactivity._01_Subscribe;

import reactor.core.publisher.Mono;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.hello().subscribe((result) -> {
            System.out.println(result);
        });
        System.out.println("Finished!");
    }

    public Mono<String> hello() {
        return Mono.just("Hello!");
    }

}

package com.support.eng.notifier.reactivity._05_Map;

import reactor.core.publisher.Flux;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.languages().map(result -> result.toUpperCase()).subscribe(System.out::println);

        System.out.println("Finished!");
    }

    public Flux<String> languages() {
        return Flux.just("Ruby", "Java");
    }

}

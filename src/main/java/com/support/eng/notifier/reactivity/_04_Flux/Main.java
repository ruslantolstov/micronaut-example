package com.support.eng.notifier.reactivity._04_Flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.languages().doOnNext((result) -> {
                    System.out.println(result);
                })
                .doOnError((error) -> {
                    System.out.println("Error: " + error);
                })
                .doOnComplete(() -> {
                    System.out.println("Completed");
                })
                .subscribe();

        System.out.println("Finished!");
    }

    public Flux<String> languages() {
        // List<String> list = List.of("Java", "Ruby");
        // return Flux.fromIterable(list);
        return Flux.just("Ruby", "Java");
    }

}

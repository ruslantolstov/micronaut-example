package com.support.eng.notifier.reactivity._03_Empty;

import reactor.core.publisher.Mono;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.hello().subscribe((result) -> {
            System.out.println(result);
        }, (error) -> {
            System.out.println("Error: " + error);
        }, () -> {
            System.out.println("Completed");
        });

        System.out.println("Finished!");
    }

    public Mono<String> hello() {
//        return  Mono.justOrEmpty(null);
        return Mono.empty();
    }

}

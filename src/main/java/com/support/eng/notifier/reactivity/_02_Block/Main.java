package com.support.eng.notifier.reactivity._02_Block;

import reactor.core.publisher.Mono;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        var result = main.hello().block();
        System.out.println(result);
        System.out.println("Finished!");
    }

    public Mono<String> hello() {
        return Mono.just("Hello!");
    }

}

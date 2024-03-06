package com.support.eng.notifier.reactivity._14_Error;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        var tasks = Flux.merge(main.hello(), main.world()).doOnSubscribe((subscription) -> {
            System.out.println("Subscribed");
        })
        .onErrorResume(error -> Mono.just("Recovered"))
        .doOnRequest((n) -> {
            System.out.println("Request: " + n);
        }).doOnNext((item) -> {
            System.out.println("Next: " + item);
        }).doOnComplete(() -> {
            System.out.println("Completed");
        }).doOnError((error) -> {
            System.out.println("Error: " + error);
        }).doOnCancel(() -> {
            System.out.println("Cancelled");
        }).doOnTerminate(() -> {
            System.out.println("Terminated");
        }).doFinally((result) -> {
            System.out.println("Finally");
        }).subscribe();

        System.out.println("Disposed!");
//        tasks.dispose();

        System.out.println("Finished!");
        Thread.sleep(2000);
    }

    public Mono<String> hello() {
//        return Mono.just("Hello");
//        return Mono.just("Hello").delaySubscription(Duration.ofSeconds(1));
        return Mono.error(new RuntimeException("Ooops!"));
    }

    public Mono<String> world() {
        return Mono.just("world");
    }
}

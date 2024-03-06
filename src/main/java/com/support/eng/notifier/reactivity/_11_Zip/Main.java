package com.support.eng.notifier.reactivity._11_Zip;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

        Mono.zip(main.language(), main.framework()).log().subscribe((tuple) ->  {
                    System.out.println(tuple.get(0) + " " + tuple.get(1));
//                    System.out.println(tuple.getT1() + " " + tuple.getT2());
                }
        );

        Thread.sleep(10000);
        System.out.println("Finished!");
    }

    public Mono<String> language() {
        return Mono.just("Ruby");
    }

    public Mono<String> framework() {
        return Mono.just("Rails");
    }
}

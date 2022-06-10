package com.operador.condicional;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Condicional {

    public void defaultIfEmpty(){
        Mono.empty()
                .defaultIfEmpty(new Persona(0, "DEFAULT", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void takeUntil(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .takeUntil(p -> p.getEdad() > 20)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeOut() throws InterruptedException {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));

        Thread.sleep(10000);
    }

}

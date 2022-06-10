package com.operador.controlDeErrores;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ErrorOp {

    public void retry(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .retry(1)
                .doOnNext(persona -> log.info(persona.toString()))
                .subscribe();
    }

    public void errorReturn(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorReturn(new Persona(0,"XYZ", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorResume(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorResume(e -> Mono.just(new Persona(0, "XYZ", 99)))
                .subscribe();
    }

    public void errorMap(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe();
    }

}

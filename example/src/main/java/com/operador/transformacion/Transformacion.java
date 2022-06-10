package com.operador.transformacion;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Transformacion {

    public void map(){
        /*List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .map(persona -> {
                    persona.setEdad(persona.getEdad() + 10);
                    return persona;
                })
                .subscribe(persona -> log.info(persona.toString()));*/

        Flux<Integer> fx = Flux.range(1, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> log.info("x: " + x));
    }

    public void flatMap(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .flatMap(persona -> {
                    persona.setEdad(persona.getEdad() + 10);
                    return Mono.just(persona);
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void groupBy(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(1, "Laura", 23));
        personas.add(new Persona(1, "Cristian", 20));

        Flux.fromIterable(personas)
                .groupBy(Persona::getId)
                .flatMap(Flux::collectList)
                .subscribe(p -> log.info(p.toString()));
    }

}

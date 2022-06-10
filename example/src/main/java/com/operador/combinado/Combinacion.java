package com.operador.combinado;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Combinacion {

    public void merge(){
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Julian", 20));
        personas1.add(new Persona(2, "Laura", 23));
        personas1.add(new Persona(3, "Cristian", 20));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "Simon", 20));
        personas2.add(new Persona(5, "Yenifer", 23));
        personas2.add(new Persona(6, "Osorio", 21));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);

        Flux.merge(fx1, fx2)
                .subscribe(persona -> log.info(persona.toString()));
    }

    public void zip(){
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Julian", 20));
        personas1.add(new Persona(2, "Laura", 23));
        personas1.add(new Persona(3, "Cristian", 20));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "Simon", 20));
        personas2.add(new Persona(5, "Yenifer", 23));
        personas2.add(new Persona(6, "Osorio", 21));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);

        Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(log::info);
    }

    public void zipWith(){
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Julian", 20));
        personas1.add(new Persona(2, "Laura", 23));
        personas1.add(new Persona(3, "Cristian", 20));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(4, "Simon", 20));
        personas2.add(new Persona(5, "Yenifer", 23));
        personas2.add(new Persona(6, "Osorio", 21));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);

        fx1.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(log::info);
    }

}

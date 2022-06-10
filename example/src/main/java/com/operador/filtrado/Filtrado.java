package com.operador.filtrado;

import com.example.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Filtrado {

    public void filter(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .filter(persona -> persona.getEdad() > 20)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinct(){
        Flux.fromIterable(Arrays.asList(1,1,2,2))
                .distinct()
                .subscribe(p -> log.info(p.toString()));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(1, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    public void take(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .take(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void takeLast(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .takeLast(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skip(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .skip(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skipLast(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .skipLast(1)
                .subscribe(p -> log.info(p.toString()));
    }

}

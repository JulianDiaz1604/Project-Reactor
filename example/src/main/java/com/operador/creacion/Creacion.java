package com.operador.creacion;

import com.example.model.Persona;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Creacion {

    public void justFrom(){
        Mono.just(new Persona(1, "Julian", 20));
        //flux.fromIterable(collection);
        //Observable.just(item);
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range(){
        Flux.range(1, 3)
                .doOnNext(i -> log.info("i: " + i))
                .subscribe();
    }

    public void repeat(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Julian", 20));
        personas.add(new Persona(2, "Laura", 23));
        personas.add(new Persona(3, "Cristian", 20));

        Flux.fromIterable(personas)
                .repeat()
                .subscribe(p -> log.info(p.toString()));
    }

}

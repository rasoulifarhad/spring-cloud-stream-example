package com.farhad.example.logging.consumer;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Sinks;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class LoggingConfig {
    
    Sinks.Many<String> sink =   Sinks.many().multicast().onBackpressureBuffer() ;

    @Bean
    public  Sinks.Many<String>  processor() {
        return sink;
    }
    @Bean
    public Supplier<Flux<String>> nameSupplier() {
        return () -> sink.asFlux();
    }

    @Bean
    public Function<String, Person> nameToPerson() {
        return it -> new Person(it.toUpperCase());
    }

    @Bean
    public Consumer<Person> log() {
        return person -> {
            if ("ALI".equals(person.name)) {
                throw new RuntimeException("cannot process: " + person);
            }
            System.out.println("Received: " + person);
        };
    }
}

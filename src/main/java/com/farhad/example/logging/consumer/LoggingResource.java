package com.farhad.example.logging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;

@RestController
public class LoggingResource {
    
    @Autowired
    private Sinks.Many<String>  processor ;

    @RequestMapping("/persons/{name}")
    public void accept(@PathVariable String name) {
        processor.emitNext(name, EmitFailureHandler.FAIL_FAST);
    }
}

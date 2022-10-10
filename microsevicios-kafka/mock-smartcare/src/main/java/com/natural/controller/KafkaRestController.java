package com.natural.controller;

import com.natural.model.Outage;
import com.natural.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaRestController {

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping(value = "/send/{message}")
    public void send(@PathVariable String message) {
        kafkaProducer.sendMessage(message);
    }

    @PostMapping(value = "/send")
    public void send(@RequestBody Outage outage) {
        kafkaProducer.sendMessage(outage);
    }

}

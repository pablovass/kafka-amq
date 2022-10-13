package com.natural.service;

import java.util.UUID;

import com.natural.client.OutageAlarm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.natural.model.Outage;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaProducerService {
    //@Autowired
    //private OutageAlarm outageAlarm;

    private static final String TOPIC = "outage";

    @Autowired
    private KafkaTemplate<String, Outage> kafkaTemplate;

    public void send(Outage outage) {
        log.info("Order object is {}", outage);
        kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), outage);
    }

}

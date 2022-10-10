package com.natural.consumer;

import com.natural.model.Outage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SpringBootKafkaConsumer {

    @KafkaListener(topics = "${topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Outage value){
        System.out.println("Message Received :: "+value.toString());
    }
}

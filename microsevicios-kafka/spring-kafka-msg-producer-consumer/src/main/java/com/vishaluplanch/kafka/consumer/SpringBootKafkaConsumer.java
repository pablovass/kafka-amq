package com.vishaluplanch.kafka.consumer;

import com.vishaluplanch.kafka.model.Outage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SpringBootKafkaConsumer {

    @KafkaListener(topics = "${topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Outage value){
        System.out.println("Message Received :: "+value.toString());
    }
}

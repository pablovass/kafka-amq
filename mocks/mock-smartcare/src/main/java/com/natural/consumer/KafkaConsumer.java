package com.natural.consumer;

import com.natural.model.Outage;
import com.natural.service.OutageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    OutageService outageService;

   public Outage createOutageBD(Outage outage) {
       return outageService.createOutage(outage);
   }

    @KafkaListener(topics = "${topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Outage value) {

       createOutageBD(value);

        System.out.println("Message Received :: " + value.toString());
    }
}

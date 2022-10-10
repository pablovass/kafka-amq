package com.natural.service;

import com.natural.pojo.Message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;



@EnableBinding(Source.class)
@Service
public class MessageService {
    private final KafkaTemplate kafkaTemplate;
    @Value("6axg0uqh-default")
    private String topic;
    @Autowired
    private Source source;

    public MessageService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @SendTo
    public boolean send(Message message){
        this.kafkaTemplate.send(topic, message.getMessage());
        return source.output().send(MessageBuilder.withPayload(message).build());
    }
}

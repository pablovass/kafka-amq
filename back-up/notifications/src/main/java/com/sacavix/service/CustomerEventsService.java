package com.sacavix.service;

import com.sacavix.entity.Outage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class
CustomerEventsService {

	@KafkaListener(
			topics = "${topic.outage.name:outage}",
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo1")
	public void consumer(Outage event) {
		if (event.getClass().isAssignableFrom(Outage.class)) {
			Outage outage = (Outage) event;
			log.info("Received Customer created event .... with Id={}, data={}",
					outage.getRAT(),
					outage.getCellName().toString());
		}

	}
	
	

}

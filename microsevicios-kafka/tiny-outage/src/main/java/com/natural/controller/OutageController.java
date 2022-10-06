package com.natural.controller;

import com.natural.model.Outage;
import com.natural.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutageController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@PostMapping("/outages")
	public void order(@RequestBody Outage outage) {
		kafkaProducerService.send(outage);
	}

}

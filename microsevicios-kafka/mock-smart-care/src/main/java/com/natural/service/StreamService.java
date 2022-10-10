package com.natural.service;

import com.natural.bindings.StreamBindings;
import com.natural.model.Outage;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@EnableBinding(StreamBindings.class)
@Service
@Log4j2
public class StreamService {



	@StreamListener("order-input-channel")
	@SendTo("order-outage-output-channel")
	public KStream<String, Outage> outageKStream(KStream<String, Outage> order) {
		log.info("Order object is {}", order);
		return order.filter((k,v)-> v.getRAT().equalsIgnoreCase("outage"));
	}

}

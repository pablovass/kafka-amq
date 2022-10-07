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
	@SendTo("order-takeaway-output-channel")
	public KStream<String, Outage> takeAway(KStream<String, Outage> order) {
		log.info("Order object is {}", order);
		return order.filter((k,v)-> v.getRAT().equalsIgnoreCase("takeaway"));
	}

	@StreamListener("order-input-channel")
	@SendTo("order-homedelivery-output-channel")
	public KStream<String, Outage> homeDelivery(KStream<String, Outage> order) {
		log.info("Order object is {}", order);
		return order.filter((k,v)-> v.getRAT().equalsIgnoreCase("homedelivery"));
	}
	@StreamListener("order-input-channel")
	@SendTo("order-user-output-channel")
	public KStream<String, Outage> user(KStream<String, Outage> outage) {
		log.info("Order object is {}", outage);
		return outage.filter((k,v)-> v.getRAT().equalsIgnoreCase("user"));
	}
}

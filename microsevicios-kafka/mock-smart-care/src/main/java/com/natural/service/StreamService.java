package com.natural.service;

import com.natural.bindings.StreamBindings;
import com.natural.model.Outage;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@EnableBinding(StreamBindings.class)
@Service
public class StreamService {

	@StreamListener("order-input-channel")
	@SendTo("order-takeaway-output-channel")
	public KStream<String, Outage> takeAway(KStream<String, Outage> order) {
		return order.filter((k,v)-> v.getId().equalsIgnoreCase("takeaway"));
	}

	@StreamListener("order-input-channel")
	@SendTo("order-homedelivery-output-channel")
	public KStream<String, Outage> homeDelivery(KStream<String, Outage> order) {
		return order.filter((k,v)-> v.getId().equalsIgnoreCase("homedelivery"));
	}

}

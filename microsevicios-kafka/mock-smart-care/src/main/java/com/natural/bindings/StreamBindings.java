package com.natural.bindings;

import com.natural.model.Outage;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface StreamBindings {

	@Input("order-input-channel")
	KStream<String, Outage> inputStream();

	@Output("order-takeaway-output-channel")
	KStream<String, Outage> takeAwayStream();

	@Output("order-homedelivery-output-channel")
	KStream<String, Outage> homeDeliveryStream();
	@Output("order-user-output-channel")
	KStream<String, Outage> userStream();
}
